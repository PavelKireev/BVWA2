package cz.upce.bvwa2.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"cz.upce.bvwa2"})
@EntityScan(basePackages = {"cz.upce.bvwa2.db.entity"})
@EnableJpaRepositories(basePackages = {"cz.upce.bvwa2.db.repository"})
public class DataConfiguration {
}