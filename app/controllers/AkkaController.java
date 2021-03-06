package controllers;

import akka.actor.*;
import akka.actors.MasterActor;
import akka.kafka.Main;
import akka.util.Timeout;
import akka.utilities.Requests;
import akka.utilities.ResultRequest;
import play.mvc.*;
import scala.compat.java8.FutureConverters;

import actors_test.*;

import java.io.IOException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import static akka.pattern.Patterns.ask;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class AkkaController extends Controller {

	final ActorSystem actorSystem = ActorSystem.create("playakka");
	final ActorRef helloActor = actorSystem.actorOf(HelloActor.props());
	final ActorRef master = actorSystem.actorOf(MasterActor.props(), "master");

	public Result index() throws IOException {
		
		Main.main();
		
		return ok(views.html.index.render());
	}

	public CompletionStage<Result> makeSearch() throws InterruptedException {
	//public Result makeSearch() throws InterruptedException {

		Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
				
		Requests req = new Requests("ABEL MESQUITA JR.", "2009-03-31", "2019-03-31");
		master.tell(req, master);
		
		Thread.sleep(20000);
		System.out.println("Ai ai...");		
		//return ok(views.html.index.render());

		return FutureConverters.toJava(ask(master, new ResultRequest(), timeout))
				.thenApply(response -> ok(views.html.actor.render(response.toString())));
	}
	/*
	public CompletionStage<Result> sayHi(String name) {
		return FutureConverters.toJava(ask(helloActor, "Hi " + name, 2000))
				.thenApply(response -> ok(views.html.actor.render(response.toString())));
	}

	/*
	final ActorRef sparkActor = actorSystem.actorOf(SparkActor.props());

	public CompletionStage<Result> sparkHello() {
		return FutureConverters.toJava(ask(sparkActor, "Hi ", 2000))
				.thenApply(response -> ok(views.html.actor.render(response.toString())));
	}

	// Uncomment the code below for running without Cassandra (*AND UNCOMMENT THE
	// RESPECTIVE ROUTE)
	final ActorRef dbActor = actorSystem.actorOf(DbActor.props());

	public CompletionStage<Result> requestUser(String name) {
		return FutureConverters.toJava(ask(dbActor, Integer.parseInt(name), 2000))
				.thenApply(response -> ok(views.html.actor.render(response.toString())));
	}
	*/
}
