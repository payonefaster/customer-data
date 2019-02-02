package pay.one.faster.domain.repository;

import pay.one.faster.domain.security.CustomerData;

/**
 * @author claudioed on 2019-02-02.
 * Project customer-data
 */
public interface CustomerDataRepository {

  CustomerData customerData(String id);

}
