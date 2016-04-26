import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/tamagotchi", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      if (request.session().attribute("myPet") != null) {
        Tamagotchi myPet = request.session().attribute("myPet");

        String action = request.queryParams("action");
        if (action.equals("feed")) {
          myPet.feedPet();
          myPet.timePasses();
        }
        model.put("myPet", myPet);
      } else {
        String name = request.queryParams("name");
        Tamagotchi myPet = new Tamagotchi(name);
        request.session().attribute("myPet", myPet);
        model.put("myPet", myPet);
      }

      model.put("template", "templates/tamagotchi.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
