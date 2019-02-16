package pay.one.faster.customer.infra.web.handler;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import pay.one.faster.customer.domain.request.NewCustomerRequest;
import pay.one.faster.customer.domain.security.CustomerData;
import pay.one.faster.customer.domain.service.CustomerDataService;

@Configuration
public class CustomerDataRouter {

  @Bean
  RouterFunction<ServerResponse> customerDataRouter(CustomerDataService customerDataService) {
    return route(GET("/api/customers/{id}"),
        req -> ok().body(customerDataService.requestCustomerData(req.pathVariable("id")), CustomerData.class))
        .and(
            route(
                POST("/api/customers"),
                req ->
                    req.body(toMono(NewCustomerRequest.class))
                        .doOnNext(customerDataService::registerCustomer)
                        .then(ok().build())));
  }

}
