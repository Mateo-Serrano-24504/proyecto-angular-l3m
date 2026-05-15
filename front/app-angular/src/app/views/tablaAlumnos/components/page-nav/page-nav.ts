import { Component, output } from '@angular/core';
import { PageButton } from '../page-button/page-button';

@Component({
  selector: 'app-page-nav',
  imports: [PageButton],
  templateUrl: './page-nav.html',
  styleUrl: './page-nav.css',
})
export class PageNav {
  nextPage = output<void>();
  previousPage = output<void>();

  emitNextPage() {
    this.nextPage.emit();
  }
  emitPreviousPage() {
    this.previousPage.emit();
  }
}
