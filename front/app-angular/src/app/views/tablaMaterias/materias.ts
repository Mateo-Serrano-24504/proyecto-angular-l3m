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
  nombreEditado = '';

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

  eliminarMateria(materia: Materia) {
    this.materiaService.eliminarMateria(materia.id).subscribe(() => {
      this.cargarMaterias();
    });
  }
}
