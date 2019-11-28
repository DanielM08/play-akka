package akka.actors;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.pattern.Patterns;
import akka.util.Timeout;
import akka.utilities.Requests;
import akka.utilities.ResultAkka;
import scala.concurrent.Await;
import scala.concurrent.Future;

/**
 * Map Reduce app
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception{
    	Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
    	
    	ActorSystem  _system = ActorSystem.create("App");
    	ActorRef  master = _system.actorOf(MasterActor.props(), "master");
    	//master.tell("/home/danielmarx/Documents/TI/8ºSemestre/Concorrente/ProjetoDisciplina/Ano-2017.csv", master);
    	
    	Requests req = new Requests("EVAIR VIEIRA DE MELO", "2009-03-31", "2019-03-31");    	    	    	
    	master.tell(req, master);    	
    	
    	//System.out.println("Olá");
    	Thread.sleep(20000); 
    	Future<Object> future = Patterns.ask(master, new ResultAkka(), timeout);
    	String result = (String) Await.result(future, timeout.duration());
    	System.out.println(result);
    	_system.terminate();

    }
}
