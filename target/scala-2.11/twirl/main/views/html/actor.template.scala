
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object actor extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(msg: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Page Title")/*3.20*/ {_display_(Seq[Any](format.raw/*3.22*/("""

	"""),format.raw/*5.2*/("""<h1> """),_display_(/*5.8*/msg),format.raw/*5.11*/(""" """),format.raw/*5.12*/("""<h1>

 	<!-- <ul>
		"""),_display_(/*8.4*/for(m <- msg) yield /*8.17*/ {_display_(Seq[Any](format.raw/*8.19*/("""
  			"""),format.raw/*9.6*/("""<li>"""),_display_(/*9.11*/m),format.raw/*9.12*/("""</li>
		""")))}),format.raw/*10.4*/("""
	"""),format.raw/*11.2*/("""</ul> -->
""")))}),format.raw/*12.2*/("""
"""))
      }
    }
  }

  def render(msg:String): play.twirl.api.HtmlFormat.Appendable = apply(msg)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (msg) => apply(msg)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Nov 28 19:11:20 BRT 2019
                  SOURCE: /home/danielmarx08/play-akka/app/views/actor.scala.html
                  HASH: 784531831dda4ccc882bb758feed4713d1aed60d
                  MATRIX: 948->1|1055->15|1082->17|1108->35|1147->37|1176->40|1207->46|1230->49|1258->50|1304->71|1332->84|1371->86|1403->92|1434->97|1455->98|1494->107|1523->109|1564->120
                  LINES: 28->1|33->2|34->3|34->3|34->3|36->5|36->5|36->5|36->5|39->8|39->8|39->8|40->9|40->9|40->9|41->10|42->11|43->12
                  -- GENERATED --
              */
          