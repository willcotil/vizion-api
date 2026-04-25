package com.cognis.vizion.api.infra.config.migration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.flywaydb.core.Flyway;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//@Configuration
public class FlywayConfig {

    @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flywayMain = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration/public")
                .schemas("public")
                .createSchemas(true)
                .load();
        flywayMain.migrate();

        List<String> tenants = getTenantsFromDatabase(dataSource);

        for (String tenant : tenants) {
            Flyway flywayTenant = Flyway.configure()
                    .dataSource(dataSource)
                    .locations("classpath:db/migration/tenants")
                    .schemas(tenant)
                    .defaultSchema(tenant)
                    .createSchemas(true)
                    .load();
            flywayTenant.migrate();
        }

        return flywayMain;
    }

    private List<String> getTenantsFromDatabase(DataSource dataSource) {
        Set<String> tenants = new LinkedHashSet<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("""
                     SELECT DISTINCT tenant_id
                     FROM public.obra
                     WHERE tenant_id IS NOT NULL
                     ORDER BY tenant_id
                     """)) {

            while (resultSet.next()) {
                tenants.add(resultSet.getString(1));
            }
        } catch (Exception e) {
            throw new IllegalStateException("Falha ao carregar tenants para migração", e);
        }

        return List.copyOf(tenants);
    }
}
