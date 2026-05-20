import { Component, input, output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { Alumno } from '../../../views/tablaAlumnos/service/alumnoServis';
import { PuntajeService } from '../../../views/tablaAlumnos/service/puntajesService';

@Component({
  selector: 'app-formulario-nota',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './formulario-nota.html',
  styleUrl: './formulario-nota.css',
})
export class FormularioNota {
  cerrar = output<void>();

  alumno = input<Alumno | null>(null);

  form: FormGroup;

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

    if (!Number.isFinite(valor) || valor < 0 || valor > 10) {
      this.error = 'La nota debe estar entre 0 y 10.';
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