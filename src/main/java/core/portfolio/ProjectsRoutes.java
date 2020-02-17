package core.portfolio;

import helperj.ctrl.Ctrl;
import io.javalin.Javalin;
import io.javalin.http.Context;

import static io.javalin.apibuilder.ApiBuilder.*;

public class ProjectsRoutes {

    public ProjectsRoutes(Javalin app) {
        app.routes(() -> {
            path("/portfolio/projects", () -> {
                get(ProjectsRoutes::getProjects);
                get(":id", ProjectsRoutes::getProject);
            });
        });
    }

    public static void getProjects(Context ctx) {
        try {
            Ctrl.Succ(ctx, Projects.all());
        } catch (Exception e) {
            e.printStackTrace();
            Ctrl.Res(ctx, "error while honoring your request", -1);
        }
    }

    public static void getProject(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Ctrl.Succ(ctx, Projects.byId(id));
        } catch (NumberFormatException e) {
            Ctrl.Res(ctx, "invalid input", 0, 404);
        } catch (Exception e) {
            e.printStackTrace();
            Ctrl.Res(ctx, "error while honoring your request", -1);
        }
    }

}
