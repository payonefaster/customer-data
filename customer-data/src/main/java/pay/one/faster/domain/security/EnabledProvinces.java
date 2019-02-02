package pay.one.faster.domain.security;

import java.util.HashSet;
import java.util.Set;

/**
 * @author claudioed on 2019-02-02.
 * Project customer-data
 */
public class EnabledProvinces {

  private Set<String> provinces = new HashSet<>();

  public boolean addProvince(String province){
    return this.provinces.add(province);
  }

}
