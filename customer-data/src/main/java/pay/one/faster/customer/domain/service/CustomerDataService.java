package pay.one.faster.customer.domain.service;

import org.springframework.stereotype.Service;
import pay.one.faster.customer.domain.repository.CustomerDataRepository;
import pay.one.faster.customer.domain.request.NewCustomerRequest;
import pay.one.faster.customer.domain.request.RequestCustomerData;
import pay.one.faster.customer.domain.security.CustomerData;
import reactor.core.publisher.Mono;

/** @author claudioed on 2019-02-16. Project customer-data */
@Service
public class CustomerDataService {

  private final CustomerDataRepository customerDataRepository;

  public CustomerDataService(CustomerDataRepository customerDataRepository) {
    this.customerDataRepository = customerDataRepository;
  }

  public Mono<CustomerData> requestCustomerData(String id) {
    final RequestCustomerData requestCustomerData = new RequestCustomerData(id);
    return this.customerDataRepository.customerData(requestCustomerData.getId());
  }

  public Mono<CustomerData> registerCustomer(NewCustomerRequest newCustomerRequest){
    return this.customerDataRepository.register(newCustomerRequest);
  }

}
