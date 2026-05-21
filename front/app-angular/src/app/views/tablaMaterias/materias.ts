import { Component, OnInit, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TableModule } from 'primeng/table';
import { Router } from '@angular/router';
import { Materia, MateriaService } from './service/materiaService';

@Component({
  selector: 'app-materias',
  imports: [TableModule, FormsModule],
  templateUrl: './materias.html',
  styleUrl: '../tablaAlumnos/table.css'
})
export class Materias implements OnInit {
  materias = signal<Materia[]>([]);
  materiaEditandoId = signal<number | null>(null);
  agregandoMateria = signal(false);
  nombreEditado = '';
  nombreNuevo = '';

  constructor(
    private router: Router,
    private materiaService: MateriaService
  ) {}

  ngOnInit(): void {
    this.cargarMaterias();
  }

  cargarMaterias() {
    this.materiaService.getMaterias().subscribe((materias) => {
      this.materias.set(materias);
    });
  }

  navigateToHome() {
    this.router.navigate(['']);
  }

  editarMateria(materia: Materia) {
    this.cancelarNuevaMateria();
    this.materiaEditandoId.set(materia.id);
    this.nombreEditado = materia.nombre;
  }

  cancelarEdicion() {
    this.materiaEditandoId.set(null);
    this.nombreEditado = '';
  }

  guardarMateria(materia: Materia) {
    const nombre = this.nombreEditado.trim();

    if (!nombre) {
      return;
    }

    this.materiaService.actualizarMateria(materia.id, { ...materia, nombre }).subscribe(() => {
      this.cancelarEdicion();
      this.cargarMaterias();
    });
  }

  abrirNuevaMateria() {
    this.cancelarEdicion();
    this.agregandoMateria.set(true);
    this.nombreNuevo = '';
  }

  cancelarNuevaMateria() {
    this.agregandoMateria.set(false);
    this.nombreNuevo = '';
  }

  guardarNuevaMateria() {
    const nombre = this.nombreNuevo.trim();

    if (!nombre) {
      return;
    }

    this.materiaService.crearMateria({ nombre }).subscribe(() => {
      this.cancelarNuevaMateria();
      this.cargarMaterias();
    });
  }

  eliminarMateria(materia: Materia) {
    this.materiaService.eliminarMateria(materia.id).subscribe(() => {
      this.cargarMaterias();
    });
  }
}
