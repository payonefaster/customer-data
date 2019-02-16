package pay.one.faster.customer.domain.repository;

import java.util.UUID;
import org.springframework.stereotype.Service;
import pay.one.faster.customer.domain.request.NewCustomerRequest;
import pay.one.faster.customer.domain.security.CustomerData;
import reactor.core.publisher.Mono;

/**
 * @author claudioed on 2019-02-16.
 * Project customer-data
 */
@Service
public class CommonCustomerDataRepository implements CustomerDataRepository {

  private final CustomerRepository customerRepository;

  public CommonCustomerDataRepository(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public Mono<CustomerData> customerData(String id) {
    return this.customerRepository.findById(id);
  }

  @Override
  public Mono<CustomerData> register(NewCustomerRequest newCustomerRequest) {
    final CustomerData customerData = new CustomerData(UUID.randomUUID().toString(),
        newCustomerRequest.getName(), newCustomerRequest.getEmail(),
        newCustomerRequest.getEnabledCountries(), newCustomerRequest.getEnabledProvinces());
    return this.customerRepository.save(customerData);
  }

}
