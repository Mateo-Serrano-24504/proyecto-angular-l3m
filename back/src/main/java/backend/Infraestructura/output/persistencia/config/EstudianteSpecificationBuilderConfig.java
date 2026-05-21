package backend.Infraestructura.output.persistencia.config;

import backend.Infraestructura.output.persistencia.entity.estudiante.EstudianteEntity;
import backend.Infraestructura.output.persistencia.specification.builder.impl.ContainsSpecificationBuilder;
import backend.Infraestructura.output.persistencia.specification.builder.impl.EqualsSpecificationBuilder;
import backend.Infraestructura.output.persistencia.specification.factory.FilterRequestSpecificationBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstudianteSpecificationBuilderConfig {

    @Bean
    public FilterRequestSpecificationBuilderFactory<EstudianteEntity>
    estudianteFilterSpecificationBuilderFactory(
            ContainsSpecificationBuilder<EstudianteEntity> containsBuilder,
            EqualsSpecificationBuilder<EstudianteEntity> equalsBuilder
    ) {
        FilterRequestSpecificationBuilderFactory<EstudianteEntity>
                factory = new FilterRequestSpecificationBuilderFactory<>();

        factory.register(containsBuilder);
        factory.register(equalsBuilder);

        return factory;
    }
}