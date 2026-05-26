import { Component, OnInit, signal } from '@angular/core';
import { ChartRadar} from './components/chart/chart';
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: 'app-dashboard',
  imports: [ChartRadar],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard implements OnInit {
  alumnoId = signal<number | null>(null);

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((params) => {
      const id = params.get('id');

      this.alumnoId.set(
        id ? Number(id) : null
      );
    });
  }

  navigateBack() {
    if (this.alumnoId() == null) {
      this.router.navigate([''])
      return
    }
    this.router.navigate(['perfil', `${this.alumnoId()}`])
  }

  navigateToHome() {
    this.router.navigate([''])
  }
}
