package pay.one.faster.customer.domain.request;

/**
 * @author claudioed on 2019-02-02.
 * Project customer-data
 */
public class RequestCustomerData {

  private String id;

  public RequestCustomerData(){}

  public RequestCustomerData(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
