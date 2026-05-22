import { Component, signal, OnInit, computed } from '@angular/core';
import { AlumnoService, Alumno } from '../tablaAlumnos/service/alumnoServis';
import { ActivatedRoute } from '@angular/router';
import { Router } from "@angular/router";
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-perfil-alumno',
  standalone: true,
  imports: [DatePipe],
  templateUrl: './perfil-alumno.html',
  styleUrl: './perfil-alumno.css',
})

export class PerfilAlumno implements OnInit{

  alumno = signal<Alumno | null>(null);

  constructor(
    private service: AlumnoService,
    private route: ActivatedRoute,
    private router: Router
  ){}

  ngOnInit(): void {

    const idString = this.route.snapshot.paramMap.get('id');

    if (idString) {
      const idNumerico = Number(idString);
      this.inicializarPerfil(idNumerico); 
    }
   
  }
  puntajesAgrupados = computed(() => {
    const datos = this.alumno();
    
    if (!datos || !datos.puntajes) return [];

    return [...datos.puntajes].sort((a, b) => a.label.localeCompare(b.label));
  });
  navigateToTableAlumnos(){
    this.router.navigate(['alumnos'])
  }
  inicializarPerfil(id: number){
    this.service.getAlumnoPorId(id).subscribe({
      next: (res) => {
        this.alumno.set(res);
      },
      error: (err) => {
        console.error('Error al traer alumno', err);
      }
    });
  }
}
