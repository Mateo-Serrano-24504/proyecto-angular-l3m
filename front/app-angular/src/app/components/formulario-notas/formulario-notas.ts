import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-formulario-notas',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './formulario-notas.html',
  styleUrl: './formulario-notas.css'
})
export class FormularioNotas {
  @Input() dniAlumno: string | null = null;
  @Output() cerrar = new EventEmitter<void>();

  // 1. Agregamos la lista de materias que pide el @for del HTML
  materias = ['Matemática', 'Programación I', 'Sistemas Operativos', 'Bases de Datos'];
  
  // 2. Agregamos el objeto nuevaNota que pide el [(ngModel)]
  nuevaNota = {
    materia: '',
    valor: null as number | null
  };

  // 3. Agregamos la función guardar() que pide el (click)
  guardar() {
    if (this.nuevaNota.materia && this.nuevaNota.valor !== null) {
      console.log(`Grabando nota ${this.nuevaNota.valor} en ${this.nuevaNota.materia} para el DNI: ${this.dniAlumno}`);
      // Aquí irá la conexión al servicio después
      this.cerrar.emit();
    }
  }

  cancelar() {
    this.cerrar.emit();
  }
}
