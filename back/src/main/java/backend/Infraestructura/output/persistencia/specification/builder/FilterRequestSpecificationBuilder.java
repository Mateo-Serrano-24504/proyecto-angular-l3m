package backend.Infraestructura.output.persistencia.specification.builder;

import backend.Aplicacion.shared.pagination.filter.FilterOperation;
import backend.Aplicacion.shared.pagination.filter.FilterRequest;
import org.springframework.data.jpa.domain.Specification;

public interface FilterRequestSpecificationBuilder<T> {
    FilterOperation handles();
    Specification<T> build(FilterRequest request);
}
