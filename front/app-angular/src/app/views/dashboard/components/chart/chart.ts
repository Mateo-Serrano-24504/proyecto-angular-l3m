import { isPlatformBrowser } from '@angular/common';
import { Component, OnInit, PLATFORM_ID, computed, inject, input, signal } from '@angular/core';
import { ChartModule } from 'primeng/chart';
import { EstudiantesService } from '../../../../services/estudiante.service';

@Component({
  selector: 'app-chart-radar',
  templateUrl: './chart.html',
  standalone: true,
  imports: [ChartModule],
})
export class ChartRadar implements OnInit {
  id = input<number | null>(null);
  data = signal<any>({});
  radarOptions: any;
  barOptions: any;
  platformId = inject(PLATFORM_ID);
  hasData = computed(() =>
    !!this.data()?.datasets?.[0]?.data?.length
  );
  chartType = signal<'radar' | 'bar'>('radar');

  constructor(
    private studentService: EstudiantesService
  ) {}

  ngOnInit() {
    this.configureRadarOptions();
    this.configureBarOptions();
    this.initChart();
  }

  configureBarOptions() {
    this.barOptions = {
      responsive: true,
      maintainAspectRatio: false,

      plugins: {
        legend: {
          labels: {
            color: '#ffffff',
          },
        },
      },

      scales: {
        y: {
          min: 0,
          max: 10,
          ticks: {
            stepSize: 1,
            color: '#ffffff',
          },
          grid: {
            color: 'rgba(255,255,255,0.2)',
          },
        },

        x: {
          ticks: {
            color: '#ffffff',
          },
          grid: {
            color: 'rgba(255,255,255,0.1)',
          },
        },
      },
    };
  }

  configureRadarOptions() {
    this.radarOptions = {
      responsive: true,
      maintainAspectRatio: false,
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

  toggleChartType() {
    this.chartType.update(type =>
      type === 'radar' ? 'bar' : 'radar'
    );
  }
}
