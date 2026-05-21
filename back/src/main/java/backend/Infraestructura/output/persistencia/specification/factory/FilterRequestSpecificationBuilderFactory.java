package backend.Infraestructura.output.persistencia.specification.factory;

import backend.Aplicacion.shared.pagination.filter.FilterOperation;
import backend.Aplicacion.shared.pagination.filter.FilterRequest;
import backend.Infraestructura.output.persistencia.specification.builder.FilterRequestSpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterRequestSpecificationBuilderFactory<T> {
    private final Map<FilterOperation, FilterRequestSpecificationBuilder<T>> builders
            = new HashMap<>();

    public void register(FilterRequestSpecificationBuilder<T> builder) {
        this.builders.put(builder.handles(), builder);
    }

    public FilterRequestSpecificationBuilder<T> get(FilterOperation operation) {
        FilterRequestSpecificationBuilder<T> builder =
                builders.get(operation);

        if (builder == null) {
            throw new RuntimeException(
                    "Operacion no soportada: " + operation
            );
        }

        return builder;
    }

    public Specification<T> build(List<FilterRequest> operations) {
        if (operations == null || operations.isEmpty()) {
            return null;
        }
        return operations.stream()
                .map(filter -> {

                    FilterRequestSpecificationBuilder<T>
                            builder =
                            get(filter.operation());

                    return builder.build(filter);
                })
                .reduce(Specification::and)
                .orElse(null);
    }
}
