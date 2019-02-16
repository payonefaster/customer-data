package pay.one.faster.customer.domain.request;

import pay.one.faster.customer.domain.security.EnabledCountries;
import pay.one.faster.customer.domain.security.EnabledProvinces;

/** @author claudioed on 2019-02-16. Project customer-data */
public class NewCustomerRequest {

  private String name;

  private String email;

  private EnabledCountries enabledCountries = new EnabledCountries();

  private EnabledProvinces enabledProvinces = new EnabledProvinces();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public EnabledCountries getEnabledCountries() {
    return enabledCountries;
  }

  public void setEnabledCountries(EnabledCountries enabledCountries) {
    this.enabledCountries = enabledCountries;
  }

  public EnabledProvinces getEnabledProvinces() {
    return enabledProvinces;
  }

  public void setEnabledProvinces(EnabledProvinces enabledProvinces) {
    this.enabledProvinces = enabledProvinces;
  }
}
