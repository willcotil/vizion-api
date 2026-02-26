package com.cognis.buildup_api.config.migration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import java.util.List;

@Configuration
public class FlywayConfig {

    @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flywayMain = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration/main")
                .schemas("public")
                .load();
        flywayMain.migrate();

        List<String> tenants = getTenantsFromDatabase(dataSource);

        for (String tenant : tenants) {
            Flyway flywayTenant = Flyway.configure()
                    .dataSource(dataSource)
                    .locations("classpath:db/migration/tenants")
                    .schemas(tenant)
                    .load();
            flywayTenant.migrate();
        }

        return flywayMain;
    }

    private List<String> getTenantsFromDatabase(DataSource dataSource) {
        return List.of("cliente_a", "cliente_b");
    }
}