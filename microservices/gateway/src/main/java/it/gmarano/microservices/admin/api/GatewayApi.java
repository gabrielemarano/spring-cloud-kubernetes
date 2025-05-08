package it.gmarano.microservices.admin.api;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GatewayApi {

    @Value("${route-definition.filter.names}")
    private String routeDefinitionFilterNames;

    @Autowired
    RouteDefinitionLocator locator;

    @Bean
    public List<GroupedOpenApi> apis() {
        List<GroupedOpenApi> groups = new ArrayList<>();
        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
        assert definitions != null;
        definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(routeDefinitionFilterNames))
                .forEach(routeDefinition -> {
                    String name = routeDefinition.getId();
                    groups.add(GroupedOpenApi.builder().pathsToMatch("/" + routeDefinition.getId() + "/**").group(name).build());
                });
        return groups;
    }
}
