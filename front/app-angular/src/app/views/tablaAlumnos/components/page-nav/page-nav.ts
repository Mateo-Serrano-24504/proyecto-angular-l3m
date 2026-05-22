import { Component, input, output } from '@angular/core';
import { PageButton } from '../page-button/page-button';
import { PageSelector } from '../page-selector/page-selector';

@Component({
  selector: 'app-page-nav',
  imports: [PageButton, PageSelector],
  templateUrl: './page-nav.html',
  styleUrl: './page-nav.css',
})
export class PageNav {
  pageCount = input.required<number>();
  currentPage = input.required<number>();
  nextPage = output<void>();
  previousPage = output<void>();
  goToPage = output<number>();

  emitNextPage() {
    this.nextPage.emit();
  }
  emitPreviousPage() {
    this.previousPage.emit();
  }
  emitGoToPage(page: number) {
    console.log(`PAGE: ${page}`);
    this.goToPage.emit(page);
  }
}
