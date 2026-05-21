import { Routes } from '@angular/router';
import { Home } from './views/home/home';
import { Formulario } from './components/formulario/formulario';
import { Dashboard } from './views/dashboard/dashboard';
import { TableComponent } from './views/tablaAlumnos/table';
import { PerfilAlumno } from './views/perfil-alumno/perfil-alumno';
import { Materias } from './views/tablaMaterias/materias';

export const routes: Routes = [
  { path: '', component: Home },
  { path: 'formulario', component: Formulario },
  { path: 'dashboard', component: Dashboard },
  { path: 'alumnos', component: TableComponent },
  { path: 'materias', component: Materias },
  { path: 'perfil/:id', component: PerfilAlumno },
];     
