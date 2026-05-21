import { Component, OnInit, signal } from '@angular/core';
import { TableModule } from 'primeng/table';
import { Router, RouterLink } from '@angular/router';
import { Materia, MateriaService } from './service/materiaService';

@Component({
  selector: 'app-materias',
  imports: [TableModule, RouterLink],
  templateUrl: './materias.html',
  styleUrl: '../tablaAlumnos/table.css'
})
export class Materias implements OnInit {
  materias = signal<Materia[]>([]);

  constructor(
    private router: Router,
    private materiaService: MateriaService
  ) {}

  ngOnInit(): void {
    this.materiaService.getMaterias().subscribe((materias) => {
      this.materias.set(materias);
    });
  }

  navigateToHome() {
    this.router.navigate(['']);
  }
}
