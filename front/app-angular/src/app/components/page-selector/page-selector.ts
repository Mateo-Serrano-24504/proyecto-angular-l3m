import { Component, input, output, signal } from '@angular/core';

@Component({
  selector: 'app-page-selector',
  imports: [],
  templateUrl: './page-selector.html',
  styleUrl: './page-selector.css',
})
export class PageSelector {
  pageCount = input.required<number>();
  currentPage = input.required<number>();
  pageSelector = output<number>();
  pageValue = signal(1);

  setPage(event: Event) {
    var page = Number((event.target as HTMLInputElement).value);
    this.pageValue.set(page);
  }
  goToPage() {
    if (this.pageValue() < 1 || this.pageValue() > this.pageCount()) {
      this.pageValue.set(this.currentPage());
      return;
    }
    this.pageSelector.emit(this.pageValue() - 1);
  }
}
