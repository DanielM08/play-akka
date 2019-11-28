package akka.actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.bufferPackage.StorageSearchResults;
import akka.utilities.ResultAkka;

public class ResultActor extends AbstractActor{
	
	public static Props props() {
		return Props.create(ResultActor.class);
	}

	private String resultFinal = "";
	
	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(StorageSearchResults.class, msg-> {
					showSearchResults(msg);
				})
				.match(ResultAkka.class, msg-> {
					getSender().tell(resultFinal, getSelf());
				})
			.build();
	}
	
	private void showSearchResults(StorageSearchResults results)
	{
		
		resultFinal += results.printMapAverage() + "\n";

	}
}
