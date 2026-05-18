import { Component, signal } from '@angular/core';
import { TableModule } from 'primeng/table';
import { Router, RouterLink } from "@angular/router";
import { Formulario } from '../../components/formulario/formulario';
import { Alumno } from './service/alumnoServis';

@Component({
  selector: 'app-table',
  standalone: true,
  // Agregar los imports de este componente
  imports: [TableModule, Formulario],
  templateUrl: './table.html',
  styleUrl: './table.css'
})
export class TableComponent {
  constructor(private router: Router) { }

  navigateToHome() {
    this.router.navigate([''])
  }

  // Estado del modal (equivalente a useState en React)
  mostrarFormulario = signal(false);
  alumnoSeleccionado = signal<Alumno | null>(null);


  abrirFormulario() {
    this.alumnoSeleccionado.set(null);
    this.mostrarFormulario.set(true);
  }

  cerrarFormulario() {
    this.mostrarFormulario.set(false);
  }

  editarAlumno(alumno: Alumno) {
  this.alumnoSeleccionado.set(alumno);
  this.mostrarFormulario.set(true);
}


  alumnos = [
    { nombre: 'Juan', apellido: 'Pérez', dni: '12345678', email: 'juan@example.com', notas: 8 },
    { nombre: 'María', apellido: 'García', dni: '87654321', email: 'maria@example.com', notas: 9 },
    { nombre: 'Carlos López', apellido: 'López', dni: '11223344', email: 'carlos@example.com', notas: 6 },
    { nombre: 'Ana Martínez', apellido: 'Martínez', dni: '44332211', email: 'ana@example.com', notas: 10 }
  ];
}