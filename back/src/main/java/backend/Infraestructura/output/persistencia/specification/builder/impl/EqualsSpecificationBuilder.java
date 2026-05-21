package backend.Infraestructura.output.persistencia.specification.builder.impl;

import backend.Aplicacion.shared.pagination.filter.FilterOperation;
import backend.Aplicacion.shared.pagination.filter.FilterRequest;
import backend.Infraestructura.output.persistencia.specification.builder.FilterRequestSpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


@Component
public class EqualsSpecificationBuilder<T>
        implements FilterRequestSpecificationBuilder<T> {
    @Override
    public FilterOperation handles() {
        return FilterOperation.EQUALS;
    }

    @Override
    public Specification<T> build(FilterRequest request) {
        return (root, query, cb) -> {
            Integer integerValue = this.tryParseInteger(request.value());
            return cb.equal(
                    root.get(request.selector()),
                    integerValue == null ? request.value() : integerValue
            );
        };
    }

    private Integer tryParseInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (Exception e) {
            return null;
        }
    }
}
