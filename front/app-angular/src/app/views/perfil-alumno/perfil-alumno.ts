import { Component, signal, OnInit } from '@angular/core';
import { AlumnoService, Alumno } from '../tablaAlumnos/service/alumnoServis';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-perfil-alumno',
  standalone: true,
  imports: [],
  templateUrl: './perfil-alumno.html',
  styleUrl: './perfil-alumno.css',
})
export class PerfilAlumno implements OnInit{

  alumno = signal<Alumno | null>(null);

  constructor(
    private service: AlumnoService,
    private route: ActivatedRoute //
  ){}

  ngOnInit(): void {

    const idString = this.route.snapshot.paramMap.get('id');

    if (idString) {
      const idNumerico = Number(idString); // Lo pasamos a número
      this.inicializarPerfil(idNumerico); // Se lo pasamos al método
    }

   
  }


  inicializarPerfil(id: number){
    this.service.getAlumnoPorId(id).subscribe((res)=>{
      this.alumno.set(res);
    })
  }
}
