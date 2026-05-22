import { Component, input, output, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { Alumno } from '../../../views/tablaAlumnos/service/alumnoServis';
import { Materia, PuntajeService } from '../../../views/tablaAlumnos/service/puntajesService';

@Component({
  selector: 'app-formulario-nota',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './formulario-nota.html',
  styleUrl: './formulario-nota.css',
})
export class FormularioNota implements OnInit {
  cerrar = output<void>();

  alumno = input<Alumno | null>(null);

  form: FormGroup;

  materias: Materia[] = [];

  error = '';

  constructor(
    private fb: FormBuilder,
    private puntajeService: PuntajeService
  ) {
    this.form = this.fb.group({
      materiaId: [''],
      valor: [''],
    });
  }

  ngOnInit() {
    this.cargarMaterias();
  }

  cargarMaterias() {
    this.puntajeService.obtenerMaterias().subscribe({
      next: (materias) => {
        this.materias = materias;
      },
      error: (error) => {
        console.error('Error al cargar materias:', error);
        this.error = 'No se pudieron cargar las materias.';
      }
    });
  }

  onCerrar() {
    this.cerrar.emit();
  }

  onSubmit() {
    this.error = '';

    const alumnoActual = this.alumno();

    if (!alumnoActual?.id) {
      this.error = 'No se encontró el alumno seleccionado.';
      return;
    }

    const materiaId = Number(this.form.value.materiaId);
    const valor = Number(String(this.form.value.valor).replace(',', '.'));

    if (!Number.isFinite(materiaId) || materiaId <= 0) {
      this.error = 'El ID de materia no es válido.';
      return;
    }

    if (!Number.isInteger(valor) || valor < 1 || valor > 10) {
      this.error = 'La nota debe ser un número entero entre 1 y 10.';
      return;
    }

    this.puntajeService.registrarPuntaje({
      estudianteId: alumnoActual.id,
      materiaId,
      valor,
    }).subscribe({
      next: () => {
        this.onCerrar();
      },
      error: (error) => {
        console.error('Error al cargar la nota:', error);
        this.error = 'No se pudo cargar la nota.';
      }
    });
  }
}