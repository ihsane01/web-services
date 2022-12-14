package jax.fstt.ws;

import java.util.List;



import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jax.fstt.entity.Carburant;

@WebService
@SOAPBinding(style =SOAPBinding.Style.DOCUMENT )
public interface CarburantWs{


	@WebMethod
	List<Carburant> getAllCarburant();
	
	@WebMethod
	void updateCarburant(Carburant stat);
	
	@WebMethod
	void deleteCarburant(int id);
	
	@WebMethod
	void addCarburant(Carburant Carburant);
	
	@WebMethod
	float renvoyerprix(String  nom,String date);
}
