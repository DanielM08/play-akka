// @GENERATOR:play-routes-compiler
// @SOURCE:/home/danielmarx08/play-akka/conf/routes
// @DATE:Thu Nov 28 19:11:19 BRT 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
