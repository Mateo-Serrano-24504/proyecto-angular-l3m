import { Component, OnInit, signal } from '@angular/core';
import { TableModule } from 'primeng/table';
import { Router } from "@angular/router";
import { Formulario } from '../../components/formulario/formulario';
import { AlumnoService, Alumno } from './service/alumnoServis';
import { PageNav } from './components/page-nav/page-nav';

@Component({
  selector: 'app-table',
  standalone: true,
  // Agregar los imports de este componente
  imports: [TableModule, Formulario, PageNav],
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
    private service: AlumnoService
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
    console.log("NEXT");
    if (this.pagina() + 1 < this.totalPaginas()) {
      this.pagina.set(this.pagina() + 1);
      this.callPage();
    }
  }
  previousPage() {
    console.log("PREV");
    if (this.pagina() > 0) {
      this.pagina.set(this.pagina() - 1);
      this.callPage();
    }
  }

  navigateToHome() {
    this.router.navigate([''])
  }

  // Estado del modal (equivalente a useState en React)
  mostrarFormulario = signal(false);

  abrirFormulario() {
    this.mostrarFormulario.set(true);
  }

  cerrarFormulario() {
    this.mostrarFormulario.set(false);
  }
}