package pt.bnurbit.coding.quarkus.greeting;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RouteBase;
import io.quarkus.vertx.web.RouteFilter;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@RouteBase(produces = MediaType.TEXT_HTML, path = "hello/reactive-routing")
public class GreetingResourceReactiveRouting {

    @Route(methods = HttpMethod.GET)
    @Route(methods = HttpMethod.GET, path = "greeting")
    public void test(RoutingContext rc) {
        rc.response().end("hello");
    }

    @Route(methods = HttpMethod.GET, path = "test2")
    public void test2(RoutingContext rc) {
        rc.response().end("hello with path");
    }

    @Route(methods = HttpMethod.GET)
    public void test3(RoutingExchange re) {
        re.ok("hello");
    }

    public void init(@Observes Router router) {
        router.get("/hello").method(HttpMethod.GET).handler( rc -> {
            rc.response().end("Hello from reactive routing service");
        });
    }

    @RouteFilter
    public void filter(RoutingContext rc) {
        rc.response().putHeader("test", "test");
        rc.next();
    }
}

