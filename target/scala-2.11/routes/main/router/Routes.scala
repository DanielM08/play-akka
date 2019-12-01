// @GENERATOR:play-routes-compiler
// @SOURCE:/home/danielmarx08/play-akka/conf/routes
// @DATE:Fri Nov 29 20:34:39 BRT 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  AkkaController_0: controllers.AkkaController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    AkkaController_0: controllers.AkkaController
  ) = this(errorHandler, AkkaController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, AkkaController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.AkkaController.makeSearch()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cassandra""", """controllers.AkkaController.index()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_AkkaController_makeSearch0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_AkkaController_makeSearch0_invoker = createInvoker(
    AkkaController_0.makeSearch(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AkkaController",
      "makeSearch",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_AkkaController_index1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cassandra")))
  )
  private[this] lazy val controllers_AkkaController_index1_invoker = createInvoker(
    AkkaController_0.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AkkaController",
      "index",
      Nil,
      "GET",
      this.prefix + """cassandra""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_AkkaController_makeSearch0_route(params@_) =>
      call { 
        controllers_AkkaController_makeSearch0_invoker.call(AkkaController_0.makeSearch())
      }
  
    // @LINE:7
    case controllers_AkkaController_index1_route(params@_) =>
      call { 
        controllers_AkkaController_index1_invoker.call(AkkaController_0.index())
      }
  }
}
