package pay.one.faster.customer.domain.security;

import java.util.HashSet;
import java.util.Set;

/**
 * @author claudioed on 2019-02-02.
 * Project customer-data
 */
public class EnabledCountries {

  private Set<String> countries = new HashSet<>();

  public boolean addCountry(String country){
    return this.countries.add(country);
  }

}
