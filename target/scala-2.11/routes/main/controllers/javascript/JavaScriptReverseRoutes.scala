// @GENERATOR:play-routes-compiler
// @SOURCE:/home/danielmarx/Documents/TI/8ºSemestre/Concorrente/Akka/exemplo-play/example-play-akka-master/conf/routes
// @DATE:Wed Nov 27 22:30:38 BRT 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:14
  class ReverseMasterController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def selectAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MasterController.selectAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "selectall"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseAkkaController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def sayHello: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AkkaController.sayHello",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def requestUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.requestUser",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "requestinfo/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0)})
        }
      """
    )
  
    // @LINE:8
    def sayHi: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.sayHi",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hi/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0)})
        }
      """
    )
  
    // @LINE:7
    def sayHello: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.sayHello",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hello"})
        }
      """
    )
  
    // @LINE:17
    def sparkHello: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.sparkHello",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "spark"})
        }
      """
    )
  
  }


}
