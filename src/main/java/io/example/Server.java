package io.example;

import io.example.util.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

/**
 * @author yf.zhao@upltv.com
 */
public class Server extends AbstractVerticle {

    public static void main(String[] args) {
        Runner.runExample(Server.class);
    }

    @Override
    public void start() {

        Router router = Router.router(vertx);

        router.route().handler(routingContext -> {
            routingContext.response().putHeader("content-type", "text/html").end("Hello World!");
        });

        vertx.createHttpServer().requestHandler(router).listen(8080);
    }

}
