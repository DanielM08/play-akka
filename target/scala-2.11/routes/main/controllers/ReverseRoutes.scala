// @GENERATOR:play-routes-compiler
// @SOURCE:/home/danielmarx08/play-akka/conf/routes
// @DATE:Thu Nov 28 19:11:19 BRT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:15
  class ReverseMasterController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
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

  
    // @LINE:9
    def sayHi(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hi/" + implicitly[play.api.mvc.PathBindable[String]].unbind("name", name))
    }
  
    // @LINE:12
    def requestUser(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "requestinfo/" + implicitly[play.api.mvc.PathBindable[String]].unbind("name", name))
    }
  
    // @LINE:8
    def sayHello(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hello")
    }
  
    // @LINE:18
    def sparkHello(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "spark")
    }
  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cassandra")
    }
  
  }


}
