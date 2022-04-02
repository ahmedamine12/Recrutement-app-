package model.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "typeoffre")
public class TypeOffre {
	
	@Id
	@Column(name = "typeoffre_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String libelle;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "type", cascade = CascadeType.ALL)
	private Set<Offre> offres;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
	public Set<Offre> getOffres() {
		return offres;
	}

	public void setOffres(Set<Offre> offres) {
		this.offres = offres;
	}

	public TypeOffre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeOffre(String libelle) {
		super();
		this.offres = new HashSet<Offre>();
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "TypeOffre [id=" + id + ", libelle=" + libelle + ", offres=" + offres + "]";
	}

}
