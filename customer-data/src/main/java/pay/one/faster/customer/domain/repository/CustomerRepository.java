package pay.one.faster.customer.domain.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import pay.one.faster.customer.domain.security.CustomerData;

/** @author claudioed on 2019-02-16. Project customer-data */
public interface CustomerRepository extends ReactiveCrudRepository<CustomerData, String> {}
