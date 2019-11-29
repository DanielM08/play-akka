// @GENERATOR:play-routes-compiler
// @SOURCE:/home/danielmarx08/play-akka/conf/routes
// @DATE:Thu Nov 28 19:11:19 BRT 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseMasterController MasterController = new controllers.ReverseMasterController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAkkaController AkkaController = new controllers.ReverseAkkaController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseMasterController MasterController = new controllers.javascript.ReverseMasterController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAkkaController AkkaController = new controllers.javascript.ReverseAkkaController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
