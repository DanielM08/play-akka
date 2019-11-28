package akka.actors;

import java.util.ArrayList;
import java.util.List;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.bufferPackage.StorageInformation;
import akka.bufferPackage.StorageSearchResults;
import akka.cassandra.CassandraActor;
import akka.japi.pf.DeciderBuilder;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;
import akka.utilities.Requests;
import akka.utilities.ResultAkka;
import akka.utilities.MsgQuery;
import scala.concurrent.duration.Duration;

public class MasterActor extends AbstractActor {
	public static Props props() {
		return Props.create(MasterActor.class);
	}

//	ActorRef dbActor = getContext().actorOf(CassandraActor.props(), "cassandra");

	ActorRef memoryActor = getContext().actorOf(MemoryActor.props(), "memory");
	ActorRef searchActor = getContext().actorOf(SearchActor.props(), "search");
	ActorRef resultActor = getContext().actorOf(ResultActor.props(), "result");

	java.time.Duration timeout = java.time.Duration.ofSeconds(10);

//	Router router;
//	{
//		List<Routee> routees = new ArrayList<Routee>();
//		for (int i = 0; i < 10; i++) {
//			ActorRef r = getContext().actorOf(Props.create(CassandraActor.class));
//			getContext().watch(r);
//			routees.add(new ActorRefRoutee(r));
//		}
//		router = new Router(new RoundRobinRoutingLogic(), routees);
//	}

	@Override
	public Receive createReceive() {
		return receiveBuilder()
//		.match(MsgQuery.class, s -> {
//			for (int i = 0; i < s.getN(); i++) {
//				router.route(i, getSender());
//			}
//		})
						
		.match(String.class, msg -> {
			memoryActor.tell(msg, getSelf());
		}).match(StorageInformation.class, msg -> {
			System.out.println("1º");
			searchActor.tell(msg, getSelf());
		}).match(Requests.class, msg -> { // Recebe Request.class dos usuários,
											// mas tem que esperar tudo carregar na memória para responder
			System.out.println("2º");
			searchActor.tell(msg, getSelf());
		}).match(StorageSearchResults.class, msg -> {
			System.out.println("3º");
			resultActor.tell(msg, getSelf());
		}).match(ResultAkka.class, msg -> {
			System.out.println("4º");
			resultActor.forward(msg, getContext());
		}).build();
	}

	private static SupervisorStrategy supervisorStrategy = new OneForOneStrategy( // Ou AllForOneStrategy 
			10, // Tentativas 
			Duration.create("10 seconds"), //Limite de tempo
			DeciderBuilder.match(RuntimeException.class, ex -> SupervisorStrategy.stop())
					.match(NullPointerException.class, ex -> SupervisorStrategy.restart())
					.match(ArithmeticException.class, ex -> SupervisorStrategy.resume()).build());
	@Override
	public SupervisorStrategy supervisorStrategy() {
		return supervisorStrategy;
	}

}
