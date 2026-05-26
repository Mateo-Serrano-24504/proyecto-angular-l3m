import { isPlatformBrowser } from '@angular/common';
import { Component, OnInit, PLATFORM_ID, inject, signal } from '@angular/core';
import { ChartModule } from 'primeng/chart';
import { EstudiantesService } from '../../../../services/estudiantes.service';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-chart-radar',
  templateUrl: './chart.html',
  standalone: true,
  imports: [ChartModule],
})
export class ChartRadar implements OnInit {
  data = signal<any>({});
  options: any;
  platformId = inject(PLATFORM_ID);

  constructor(
    private studentService: EstudiantesService
  ) {}

  ngOnInit() {
    this.configureOptions();
    this.initChart();
  }

  configureOptions() {
    this.options = {
      plugins: {
        legend: {
          labels: {
            color: '#ffffff',
          },
        },
      },
      scales: {
        r: {
          min: 1,
          max: 10,
          ticks: {
            stepSize: 1,
          },
          grid: {
            color: 'rgba(255,255,255,0.2)',
          },
          angleLines: {
            color: 'rgba(255,255,255,0.2)',
          },
          pointLabels: {
            color: '#e5e7eb',
          },
        },
      },
    };
  }

  initChart() {
    if (isPlatformBrowser(this.platformId)) {
      this.studentService.getChart().subscribe((res) => {
        this.data.set(
          {
            labels: res.labels,
            datasets: [
              {
                label: 'Rendimiento',
                borderColor: '#22c55e',
                backgroundColor: 'rgba(34, 197, 94, 0.2)',
                data: res.data,
              },
            ],
          }
        );
      });
    }
  }
}
