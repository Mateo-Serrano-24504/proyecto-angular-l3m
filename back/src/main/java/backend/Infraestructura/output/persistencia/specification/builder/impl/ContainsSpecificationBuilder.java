package backend.Infraestructura.output.persistencia.specification.builder.impl;

import backend.Aplicacion.shared.pagination.filter.FilterOperation;
import backend.Aplicacion.shared.pagination.filter.FilterRequest;
import backend.Infraestructura.output.persistencia.specification.builder.FilterRequestSpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


@Component
public class ContainsSpecificationBuilder<T>
        implements FilterRequestSpecificationBuilder<T> {

    @Override
    public FilterOperation handles() {
        return FilterOperation.CONTAINS;
    }

    @Override
    public Specification<T> build(FilterRequest request) {
        return (root, query, cb) -> cb.like(
                cb.lower(
                        root.get(request.selector())
                                .as(String.class)
                ),
                "%" + request.value().toLowerCase() + "%"
        );
    }
}
