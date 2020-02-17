package core;

import io.javalin.Javalin;

public class Example {

    public static void Route(Javalin app) {
        app.get("/", ctx -> {
            ctx.status(200);
            ctx.result("Hello");
        });
    }
}
