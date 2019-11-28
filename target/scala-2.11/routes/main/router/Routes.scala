// @GENERATOR:play-routes-compiler
// @SOURCE:/home/danielmarx/Documents/TI/8ºSemestre/Concorrente/Akka/exemplo-play/example-play-akka-master/conf/routes
// @DATE:Wed Nov 27 22:30:38 BRT 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  AkkaController_2: controllers.AkkaController,
  // @LINE:7
  HomeController_1: controllers.HomeController,
  // @LINE:14
  MasterController_0: controllers.MasterController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    AkkaController_2: controllers.AkkaController,
    // @LINE:7
    HomeController_1: controllers.HomeController,
    // @LINE:14
    MasterController_0: controllers.MasterController
  ) = this(errorHandler, AkkaController_2, HomeController_1, MasterController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, AkkaController_2, HomeController_1, MasterController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.AkkaController.sayHello()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hello""", """controllers.HomeController.sayHello()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hi/""" + "$" + """name<.+>""", """controllers.HomeController.sayHi(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """requestinfo/""" + "$" + """name<.+>""", """controllers.HomeController.requestUser(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """selectall""", """controllers.MasterController.selectAll()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """spark""", """controllers.HomeController.sparkHello()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_AkkaController_sayHello0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_AkkaController_sayHello0_invoker = createInvoker(
    AkkaController_2.sayHello(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AkkaController",
      "sayHello",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_sayHello1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hello")))
  )
  private[this] lazy val controllers_HomeController_sayHello1_invoker = createInvoker(
    HomeController_1.sayHello(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "sayHello",
      Nil,
      "GET",
      this.prefix + """hello""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_sayHi2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hi/"), DynamicPart("name", """.+""",false)))
  )
  private[this] lazy val controllers_HomeController_sayHi2_invoker = createInvoker(
    HomeController_1.sayHi(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "sayHi",
      Seq(classOf[String]),
      "GET",
      this.prefix + """hi/""" + "$" + """name<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_requestUser3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("requestinfo/"), DynamicPart("name", """.+""",false)))
  )
  private[this] lazy val controllers_HomeController_requestUser3_invoker = createInvoker(
    HomeController_1.requestUser(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "requestUser",
      Seq(classOf[String]),
      "GET",
      this.prefix + """requestinfo/""" + "$" + """name<.+>""",
      """# Uncomment the route below for running without Cassandra""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_MasterController_selectAll4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("selectall")))
  )
  private[this] lazy val controllers_MasterController_selectAll4_invoker = createInvoker(
    MasterController_0.selectAll(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MasterController",
      "selectAll",
      Nil,
      "GET",
      this.prefix + """selectall""",
      """ Example of supervision+routing""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_HomeController_sparkHello5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("spark")))
  )
  private[this] lazy val controllers_HomeController_sparkHello5_invoker = createInvoker(
    HomeController_1.sparkHello(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "sparkHello",
      Nil,
      "GET",
      this.prefix + """spark""",
      """ Spark test""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_AkkaController_sayHello0_route(params@_) =>
      call { 
        controllers_AkkaController_sayHello0_invoker.call(AkkaController_2.sayHello())
      }
  
    // @LINE:7
    case controllers_HomeController_sayHello1_route(params@_) =>
      call { 
        controllers_HomeController_sayHello1_invoker.call(HomeController_1.sayHello())
      }
  
    // @LINE:8
    case controllers_HomeController_sayHi2_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_HomeController_sayHi2_invoker.call(HomeController_1.sayHi(name))
      }
  
    // @LINE:11
    case controllers_HomeController_requestUser3_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_HomeController_requestUser3_invoker.call(HomeController_1.requestUser(name))
      }
  
    // @LINE:14
    case controllers_MasterController_selectAll4_route(params@_) =>
      call { 
        controllers_MasterController_selectAll4_invoker.call(MasterController_0.selectAll())
      }
  
    // @LINE:17
    case controllers_HomeController_sparkHello5_route(params@_) =>
      call { 
        controllers_HomeController_sparkHello5_invoker.call(HomeController_1.sparkHello())
      }
  }
}
