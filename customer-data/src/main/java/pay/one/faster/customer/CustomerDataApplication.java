package pay.one.faster.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pay.one.faster.customer")
public class CustomerDataApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerDataApplication.class, args);
  }

}
