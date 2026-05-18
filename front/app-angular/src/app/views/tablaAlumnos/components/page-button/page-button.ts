import { Component, input, output } from '@angular/core';

@Component({
  selector: 'app-page-button',
  imports: [],
  templateUrl: './page-button.html',
  styleUrl: './page-button.css',
})
export class PageButton {
  text = input.required<string>();
  clicked = output<void>();

  onClick() {
    this.clicked.emit();
  }
}
