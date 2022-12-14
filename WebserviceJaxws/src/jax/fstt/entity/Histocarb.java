package jax.fstt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Histocarb {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idhc;
	private  String date;
	 float prix;
	  @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "idstat")
		    private Station stat;
	  @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "idcarb")
		    private Carburant carb;
			public int getIdhc() {
				return idhc;
			}
			public void setIdhc(int idhc) {
				this.idhc = idhc;
			}
			public String getDate() {
				return date;
			}
			public void setDate(String date) {
				this.date = date;
			}
			public float getPrix() {
				return prix;
			}
			public void setPrix(float prix) {
				this.prix = prix;
			}

		  
			public Station getStat() {
				return stat;
			}
			public void setStat(Station stat) {
				this.stat = stat;
			}
			

		   
			public Carburant getCarb() {
				return carb;
			}
		    
			public void setCarb(Carburant carb) {
				this.carb = carb;
			}
		    
		    
	
}
