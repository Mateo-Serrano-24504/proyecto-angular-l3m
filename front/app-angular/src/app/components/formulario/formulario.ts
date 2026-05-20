import { Component, effect, input, output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, FormGroup } from '@angular/forms';
import { Alumno, AlumnoService } from '../../views/tablaAlumnos/service/alumnoServis';

import { z } from 'zod';

const userSchema = z.object({
  nombre: z.string().min(3, 'Nombre inválido'),
  apellido: z.string().min(3, 'Apellido inválido'),
  email: z.email('Email inválido'),
  dni: z.string().regex(/^\d{8}$/, 'DNI inválido'),
});

@Component({
  selector: 'app-formulario',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './formulario.html',
  styleUrl: './formulario.css',
})
export class Formulario {
  errors: Record<string, string[]> = {};

  // Declaramos el evento de salida
  cerrar = output<void>();

  form!: FormGroup;

  alumno = input<Alumno | null>(null);


  constructor(private fb: FormBuilder,
    private alumnoService: AlumnoService
  ) {
    this.form = this.fb.group({
      nombre: [''],
      apellido: [''],
      email: [''],
      dni: [''],
    });

    effect(() => {
      const alumno = this.alumno();
    
      if (alumno) {
        this.form.patchValue({
          nombre: alumno.nombre,
          apellido: alumno.apellido,
          email: alumno.email,
          dni: String(alumno.dni),
        });
      }
    });
  }

  onCerrar() {
    this.cerrar.emit();
  }

  onSubmit() {
  const result = userSchema.safeParse(this.form.value);

  if (!result.success) {
    this.errors = result.error.flatten().fieldErrors;
    return;
  }

  this.errors = {};

  const alumnoActual = this.alumno();

  if (alumnoActual?.id) {
    this.alumnoService.actualizarAlumno(alumnoActual.id, result.data).subscribe(() => {
      this.onCerrar();
    });
  } else {
    this.alumnoService.crearAlumno(result.data).subscribe(() => {
      this.onCerrar();
    });
  }
}


}
