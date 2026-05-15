package backend.Aplicacion.dto.chart;

import java.util.List;

public record ChartResponse(
        List<String> labels,
        List<Integer> data
) {
}
