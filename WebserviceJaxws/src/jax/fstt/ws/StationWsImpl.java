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
import jax.fstt.entity.Histocarb;
import jax.fstt.entity.Station;






@WebService(endpointInterface = "jax.fstt.ws.stationWs")
public class StationWsImpl implements stationWs {
	 private static final EntityManagerFactory emf = 
	           Persistence.createEntityManagerFactory("unit");
	   
	   public static EntityManagerFactory getEmFactory() {
	      return emf;} 
	   
	@Override
	public List<Station> getAllStation() {
		// TODO Auto-generated method stub
	      EntityManager em =getEmFactory().createEntityManager();
	      String queryString = "SELECT p FROM station p";
	      Query query = em.createQuery(queryString);
	      
	      List<Station> Stations = null;
	      
	      try {
	    	  Stations = query.getResultList();
	      } catch (Exception e) {
	         System.err.println(e);
	         System.out.println("hii");
	      } finally {
	         em.close();
	      }
	      
	      return Stations;
	   }

	@Override
	public void updateStation(@WebParam(name = "station") Station stas) {
		// TODO Auto-generated method stub
		EntityManager em = getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();

	      try {
	         transaction.begin();
	         em.merge(stas);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	   }

	@Override
	public void deleteStation(@WebParam(name = "id") int id) {
		// TODO Auto-generated method stub
		 EntityManager em =getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();

	      String queryString = "SELECT p FROM station p "
	                         + "WHERE p.idstat = :id";
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
	public void addStation(@WebParam(name = "station") Station Station) {
		// TODO Auto-generated method stub
		 EntityManager em = getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();
	      
	      try {
	         transaction.begin();
	         em.persist(Station);
	         transaction.commit();
	      } catch (Exception e) {
	         System.err.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	   }

	@Override
	public float renvoyerprix(@WebParam(name = "name") String nom, @WebParam(name = "date") String date) {
		// TODO Auto-generated method stub
		
		 EntityManager em =getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();
	      String queryString = "SELECT p FROM station p "
                  + "WHERE p.nom = :nom";
			TypedQuery<Station> query = em.createQuery(queryString, Station.class);
			query.setParameter("nom", nom);
			
			 Station stas = query.getSingleResult();
			

			    for (Histocarb str : stas.getHistocarb()) {
if(str.getDate()==date)		
	return  str.getPrix();}	
	
				      
					return 0;
				}
			
			}
			 