package pay.one.faster.customer.domain.security;

/**
 * @author claudioed on 2019-02-02.
 * Project customer-data
 */
public class CustomerData {

  private String id;

  private String name;

  private String email;

  private EnabledCountries enabledCountries = new EnabledCountries();

  private EnabledProvinces enabledProvinces = new EnabledProvinces();

}
