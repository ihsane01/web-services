package jax.fstt.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("unit");
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				Station sa = new Station("Test","test","test");
				System.out.println("COMIITING");
				
                 em.persist(sa);		
			
				em.getTransaction().commit();
	
}}


