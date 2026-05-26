import { isPlatformBrowser } from '@angular/common';
import { Component, OnInit, PLATFORM_ID, computed, inject, input, signal } from '@angular/core';
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
  id = input<number | null>(null);
  data = signal<any>({});
  options: any;
  platformId = inject(PLATFORM_ID);
  hasData = computed(() =>
    !!this.data()?.datasets?.[0]?.data?.length
  );

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
      this.studentService.getChart(this.id()).subscribe((res) => {
        this.data.set(
          {
            labels: res.labels,
            datasets: [
              {
                label: 'Rendimiento',
                borderColor: '#06b6d4',
                backgroundColor: 'rgba(6,182,212,0.2)',
                data: res.data,
              },
            ],
          }
        );
      });
    }
  }
}
