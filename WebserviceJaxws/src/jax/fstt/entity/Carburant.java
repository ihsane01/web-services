package jax.fstt.entity;

import java.util.ArrayList;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Carburant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idcarb;
	String nom;
	String description;
	
	
	@OneToMany(mappedBy = "carb")
	   private List<Histocarb> histocarb  = new ArrayList<>();
	    
	
	public int getIdcarb() {
		return idcarb;
	}
	
	public List<Histocarb> getHistocarb() {
			return histocarb;
		}
		public void setHistocarb(List<Histocarb> histocarb) {
			this.histocarb = histocarb;
		}
	public void setIdcarb(int idcarb) {
		this.idcarb = idcarb;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Carburant(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}
	
	
}
