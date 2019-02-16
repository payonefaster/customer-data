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

  public CustomerData(){}

  public CustomerData(String id, String name, String email,
      EnabledCountries enabledCountries,
      EnabledProvinces enabledProvinces) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.enabledCountries = enabledCountries;
    this.enabledProvinces = enabledProvinces;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  public void setEnabledCountries(
      EnabledCountries enabledCountries) {
    this.enabledCountries = enabledCountries;
  }

  public EnabledProvinces getEnabledProvinces() {
    return enabledProvinces;
  }

  public void setEnabledProvinces(
      EnabledProvinces enabledProvinces) {
    this.enabledProvinces = enabledProvinces;
  }

}
