import core.Example;
import helperj.SrvCfg;
import io.javalin.Javalin;

import java.io.FileNotFoundException;
import java.util.Map;

public class Run {

    public static void main(String[] args) {
        try {
            Map<String, Object> cfg = SrvCfg.get();
            System.out.println(String.format("Config Loaded Successfully!%n" +
                    "Env: %s%n" +
                    "Port: %.0f", cfg.get("env"), cfg.get("port")));
            Javalin app = Javalin.create().start(8082);
            routes(app);
        } catch (FileNotFoundException e) {
            System.out.println("could not parse configuration file correctly.");
            e.printStackTrace();
        }
    }

    private static void routes(Javalin app) {
        Example.Route(app);
    }

}
