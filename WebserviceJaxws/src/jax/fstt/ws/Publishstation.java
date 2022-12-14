package jax.fstt.ws;

import jakarta.xml.ws.Endpoint;

public class Publishstation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url ="http://localhost:8081/";
		Endpoint.publish(url+"sta",new StationWsImpl() );
		Endpoint.publish(url+"carb",new CarburantWsImpl() );

	}

}
