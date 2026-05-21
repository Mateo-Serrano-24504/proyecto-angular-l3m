import { Component, OnInit, signal } from '@angular/core';
import { TableModule } from 'primeng/table';
import { Router, RouterLink } from "@angular/router";
import { Formulario } from '../../components/formulario/formulario';
import { AlumnoService, Alumno } from './service/alumnoServis';
import { PageNav } from './components/page-nav/page-nav';
import { PuntajeService } from './service/puntajesService';
import { FormularioNota } from '../../components/formulario/formulario-nota/formulario-nota';

@Component({
  selector: 'app-table',
  standalone: true,

  imports: [TableModule, Formulario, FormularioNota, PageNav,RouterLink],
  templateUrl: './table.html',
  styleUrl: './table.css'
})
export class TableComponent implements OnInit {
  alumnos = signal<Alumno[]>([]);
  pagina = signal<number>(0);
  longitudPagina = signal<number>(10);
  totalPaginas = signal<number>(0);

  constructor(
    private router: Router,
    private service: AlumnoService,
    private puntajeService: PuntajeService
  ) {}

  ngOnInit(): void {
    this.callPage();
  }

  callPage() {
    this.service.getAlumnos(this.pagina(), this.longitudPagina()).subscribe((res) => {
      this.alumnos.set(res.items);
      this.totalPaginas.set(res.pageCount);
    });
  }
  nextPage() {
    if (this.pagina() + 1 < this.totalPaginas()) {
      this.pagina.set(this.pagina() + 1);
      this.callPage();
    }
  }
  previousPage() {
    if (this.pagina() > 0) {
      this.pagina.set(this.pagina() - 1);
      this.callPage();
    }
  }
  goToPage(page: number) {
    this.pagina.set(page);
    this.callPage();
  }

  navigateToHome() {
    this.router.navigate([''])
  }

  mostrarFormulario = signal(false);
  alumnoSeleccionado = signal<Alumno | null>(null);
  mostrarFormularioNota = signal(false);
  alumnoSeleccionadoNota = signal<Alumno | null>(null);


  abrirFormulario() {
    this.alumnoSeleccionado.set(null);
    this.mostrarFormulario.set(true);
  }

  cerrarFormulario() {
    this.mostrarFormulario.set(false);
    this.callPage();
  }


  editarAlumno(alumno: Alumno) {
    this.alumnoSeleccionado.set(alumno);
    this.mostrarFormulario.set(true);
  }

  abrirFormularioNota(alumno: Alumno) {
  this.alumnoSeleccionadoNota.set(alumno);
  this.mostrarFormularioNota.set(true);
  }

  cerrarFormularioNota() {
    this.mostrarFormularioNota.set(false);
    this.alumnoSeleccionadoNota.set(null);
  }

  cargarNota(alumno: Alumno) {
    this.alumnoSeleccionadoNota.set(alumno);
    this.mostrarFormularioNota.set(true);
  }
}