// @GENERATOR:play-routes-compiler
// @SOURCE:/home/danielmarx08/play-akka/conf/routes
// @DATE:Fri Nov 29 20:34:39 BRT 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAkkaController AkkaController = new controllers.ReverseAkkaController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAkkaController AkkaController = new controllers.javascript.ReverseAkkaController(RoutesPrefix.byNamePrefix());
  }

}
