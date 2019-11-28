// @GENERATOR:play-routes-compiler
// @SOURCE:/home/danielmarx/Documents/TI/8ºSemestre/Concorrente/Akka/exemplo-play/example-play-akka-master/conf/routes
// @DATE:Wed Nov 27 22:30:38 BRT 2019


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
