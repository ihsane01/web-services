package jax.fstt.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Station {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idstat;
    private String nom;
    private String ville;
    private String adresse;
    
    
	//@ManyToMany
  //  @JoinTable( name = "histocarb", joinColumns = @JoinColumn( name = "idstat" ),  inverseJoinColumns = @JoinColumn( name = "idcarb" ) )
    @OneToMany(mappedBy = "stat")
    private List<Histocarb> histocarb  = new ArrayList<>();
	public List<Histocarb> getHistocarb() {
		return histocarb;
	}
	public void setHistocarb(List<Histocarb> histocarb) {
		this.histocarb = histocarb;
	}
	public int getIdstat() {
		return idstat;
	}
	public void setIdstat(int idstat) {
		this.idstat = idstat;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Station(String nom, String ville, String adresse) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.adresse = adresse;
	}

	
	
}
