package pay.one.faster.customer.domain.repository;

import pay.one.faster.customer.domain.request.NewCustomerRequest;
import pay.one.faster.customer.domain.security.CustomerData;
import reactor.core.publisher.Mono;

/**
 * @author claudioed on 2019-02-02.
 * Project customer-data
 */
public interface CustomerDataRepository {

  Mono<CustomerData> customerData(String id);

  Mono<CustomerData> register(NewCustomerRequest newCustomerRequest);

}
