package jax.fstt.ws;

import java.util.List;



import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jax.fstt.entity.Station;

@WebService
@SOAPBinding(style =SOAPBinding.Style.DOCUMENT )
public interface stationWs {


	@WebMethod(operationName="getAllStation")
	List<Station> getAllStation();
	
	@WebMethod(operationName="updateStation")
	void updateStation(Station stat);
	
	@WebMethod(operationName="deleteStation")
	void deleteStation(int id);
	
	@WebMethod(operationName="addStation")
	void addStation(Station Station);
	
	@WebMethod(operationName="renvoyerprix")
	float renvoyerprix(String  nom,String date);
}
