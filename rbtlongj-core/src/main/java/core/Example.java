package core;

import helperj.ctrl.Ctrl;
import io.javalin.Javalin;

public class Example {

    public static void Route(Javalin app) {
        app.get("/", ctx -> Ctrl.Succ(ctx, "Hello"));
    }
}
