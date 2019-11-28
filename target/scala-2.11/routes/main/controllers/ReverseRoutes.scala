// @GENERATOR:play-routes-compiler
// @SOURCE:/home/danielmarx/Documents/TI/8ºSemestre/Concorrente/Akka/exemplo-play/example-play-akka-master/conf/routes
// @DATE:Wed Nov 27 22:30:38 BRT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:14
  class ReverseMasterController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def selectAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "selectall")
    }
  
  }

  // @LINE:6
  class ReverseAkkaController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def sayHello(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def requestUser(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "requestinfo/" + implicitly[play.api.mvc.PathBindable[String]].unbind("name", name))
    }
  
    // @LINE:8
    def sayHi(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hi/" + implicitly[play.api.mvc.PathBindable[String]].unbind("name", name))
    }
  
    // @LINE:7
    def sayHello(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hello")
    }
  
    // @LINE:17
    def sparkHello(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "spark")
    }
  
  }


}
