package pay.one.faster.customer.infra.web.handler;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.created;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import pay.one.faster.customer.domain.request.NewCustomerRequest;
import pay.one.faster.customer.domain.security.CustomerData;
import pay.one.faster.customer.domain.service.CustomerDataService;
import reactor.core.publisher.Mono;

@Configuration
public class CustomerDataRouter {

  @Bean(name = "customerRouter")
  RouterFunction<ServerResponse> customerDataRouter(CustomerDataService customerDataService) {
    return route(
            GET("/api/customers/{id}"),
            req ->
                ok().body(
                        customerDataService.requestCustomerData(req.pathVariable("id")),
                        CustomerData.class))
        .and(
            route(
                POST("/api/customers"),
                req -> {
                  Mono<NewCustomerRequest> request = req.bodyToMono(NewCustomerRequest.class);
                  return created(UriComponentsBuilder.fromPath("customers/").build().toUri())
                      .contentType(MediaType.APPLICATION_JSON)
                      .body(fromPublisher(
                          request.map(p -> p)
                              .flatMap(customerDataService::registerCustomer), CustomerData.class));
                }));
  }
}
