import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;



public class App {

  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<CD> cds = request.session().attribute("CDs");
      if(cds == null){
        cds = new ArrayList<CD>();
        request.session().attribute("CDs", cds);
      }
      ArrayList<Object> artists = request.session().attribute("Artists");
      if(artists == null){
        artists = new ArrayList<Object>();
        request.session().attribute("Artists", artists);
      }
      model.put("CDList", request.session().attribute("CDs"));
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/CDName", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      String newCDName = request.queryParams("CDName");
      ArrayList<CD> cds = request.session().attribute("CDs");
      CD newCD = new CD(newCDName);
      cds.add(newCD);
      model.put("CDList", request.session().attribute("CDs"));
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

}
