import { Component, ElementRef, OnInit, signal, viewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Materia, MateriaService } from '../../services/materia.service';
import { PageNav } from '../../components/page-nav/page-nav';

@Component({
  selector: 'app-materias',
  imports: [FormsModule, PageNav],
  templateUrl: './materias.html',
  styleUrl: './materias.css'
})
export class Materias implements OnInit {
  materias = signal<Materia[]>([]);
  pagina = signal<number>(0);
  longitudPagina = signal<number>(10);
  totalPaginas = signal<number>(0);
  materiaEditandoId = signal<number | null>(null);
  agregandoMateria = signal(false);
  nombreEditado = '';
  nombreNuevo = '';
  tableContainer = viewChild<ElementRef<HTMLDivElement>>('tableContainer');


  constructor(
    private router: Router,
    private materiaService: MateriaService
  ) {}

  ngOnInit(): void {
    this.callPage();
  }

  scrollToTop(): void {
    this.tableContainer()?.nativeElement.scrollTo({
        top: 0,
        behavior: 'smooth'
    });
  }

  callPage() {
    this.materiaService.obtenerMaterias(this.pagina(), this.longitudPagina()).subscribe((res) => {
      this.materias.set(res.items);
      this.totalPaginas.set(res.pageCount);
      this.scrollToTop();
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
      this.callPage();
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
      this.callPage();
    });
  }

  eliminarMateria(materia: Materia) {
    this.materiaService.eliminarMateria(materia.id).subscribe(() => {
      this.callPage();
    });
  }
}
