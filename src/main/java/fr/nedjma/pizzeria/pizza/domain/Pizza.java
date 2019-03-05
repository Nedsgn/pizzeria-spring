package fr.nedjma.pizzeria.pizza.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA")

public class Pizza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	//le id est autoincrémenté
	
	@Column(name="ID")
private Integer id;

	@Column(name="libelle")
	private String libelle;
	
	@Column(name="reference")
private String reference;
	
	@Column(name="prix")
private Integer prix;
	
	@Column(name="stock")
private Integer stock;
	
	@Column(name="description")
private String description;
	
	@Column(name="urlimg")
private String urlImg;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	
	
	
	
}
