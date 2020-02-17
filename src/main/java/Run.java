import core.Example;
import core.portfolio.ProjectsRoutes;
import helperj.SrvCfg;
import io.javalin.Javalin;

import java.io.FileNotFoundException;
import java.util.Map;

public class Run {

    public static void main(String[] args) {
        try {
            Map<String, Object> cfg = SrvCfg.get();
            String env = cfg.get("env").toString();
            int port = (int)Double.parseDouble(cfg.get("port").toString());
            System.out.println(String.format("Config Loaded Successfully!%n" +
                    "Env: %s%n" +
                    "Port: %d", env, port));
            Javalin app = Javalin.create().start(port);
            routes(app);
        } catch (FileNotFoundException e) {
            System.out.println("could not parse configuration file correctly.");
            e.printStackTrace();
        }
    }

    private static void routes(Javalin app) {
        Example.Route(app);
        new ProjectsRoutes(app);
    }

}
