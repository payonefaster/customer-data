package pay.one.faster.customer.infra.web.opentracing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.reactive.function.server.ServerRequest.Headers;

/** @author claudioed on 2019-02-17. Project requester */
public class OpenTracingHeaders {

  public static final List<String> options =
      List.of(
          "x-request-id",
          "x-b3-traceid",
          "x-b3-spanid",
          "x-b3-parentspanid",
          "x-b3-sampled",
          "x-b3-flags",
          "x-ot-span-context");

  private final Map<String, String> headers = new HashMap<>();

  public OpenTracingHeaders add(String header, String value) {
    this.headers.put(header, value);
    return this;
  }

  public String headerValue(String header) {
    return this.headers.getOrDefault(header, "");
  }

  public static OpenTracingHeaders fromHeaders(Headers headers) {
    OpenTracingHeaders openTracingHeaders = new OpenTracingHeaders();
    OpenTracingHeaders.options.forEach(
        el -> {
          if (!headers.header(el).isEmpty()) {
            openTracingHeaders.add(el, headers.header(el).get(0));
          }
        });
    return openTracingHeaders;
  }
}
