package in.stackroute.apigateway;

import in.stackroute.apigateway.filter.JWTValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigatewayApplication {

	@Autowired
	private JWTValidationFilter jwtValidationFilter;

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}

	@Bean
	public RouteLocator apiRoutes(RouteLocatorBuilder builder){
		return builder.routes()
				.route("contacts_route",route -> route.path("/api/v1/contacts/**")
						.filters(temp->temp.filter(jwtValidationFilter)).uri("lb://contacts-service"))
				.route("users_route",route->route.path("/api/v1/users/**").uri("lb://user-profile-service"))
				.build();
	}

}
