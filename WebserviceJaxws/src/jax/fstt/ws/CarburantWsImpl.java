package jax.fstt.ws;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jax.fstt.entity.Carburant;
import jax.fstt.entity.Station;


@WebService(endpointInterface = "jax.fstt.ws.CarburantWs")
public class CarburantWsImpl  implements CarburantWs  {
	 private static final EntityManagerFactory emf = 
	           Persistence.createEntityManagerFactory("unit");
	   
	   public static EntityManagerFactory getEmFactory() {
	      return emf;} 
	@Override
	public List<Carburant> getAllCarburant() {
		// TODO Auto-generated method stub
		 EntityManager em =getEmFactory().createEntityManager();
	      String queryString = "SELECT p FROM carburant p";
	      Query query = em.createQuery(queryString);
	      
	      List<Carburant> Carburants = null;
	      
	      try {
	    	  Carburants = query.getResultList();
	      } catch (Exception e) {
	         System.err.println(e);
	         System.out.println("hii");
	      } finally {
	         em.close();
	      }
	      
	      return Carburants;	}

	@Override
	public void updateCarburant(@WebParam(name = "carburant") Carburant carb) {
		// TODO Auto-generated method stub
		EntityManager em = getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();

	      try {
	         transaction.begin();
	         em.merge(carb);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	}

	@Override
	public void deleteCarburant(int id) {
		// TODO Auto-generated method stub
		 EntityManager em =getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();

	      String queryString = "SELECT p FROM carburant p "
	                         + "WHERE p.idcarb = :id";
	      TypedQuery<Station> query = em.createQuery(queryString, Station.class);
	      query.setParameter("id", id);
	      
	      Station stas = null;
	      try {
	         stas = query.getSingleResult();
	         transaction.begin();
	         em.remove(stas);
	         transaction.commit();
	         
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	}

	@Override
	public void addCarburant(@WebParam(name = "carburant") Carburant Carburant) {
		// TODO Auto-generated method stub
		 EntityManager em = getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();
	      
	      try {
	         transaction.begin();
	         em.persist(Carburant);
	         transaction.commit();
	      } catch (Exception e) {
	         System.err.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	}

	@Override
	public float renvoyerprix(String nom, String date) {
		// TODO Auto-generated method stub
		return 0;
	}

}
