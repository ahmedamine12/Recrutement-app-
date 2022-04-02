package model.bo;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "offre")
public class Offre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "offre_id")
	private int id;
	@Column(name ="lettreMotiv")
	private byte[] tab1;
	
	
	public byte[] getTab1() {
		return tab1;
	}

	public void setTab1(byte[] tab1) {
		this.tab1 = tab1;
	}

	@Column(name ="file")
	private byte[] tab;
	public byte[] getTab() {
		return tab;
	}

	public void setTab(byte[] tab) {
		this.tab = tab;
	}

	private String titre;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private String description;

	@ManyToOne
    @JoinColumn(name = "fk_user")
	private User createur;
	
	@ManyToOne
    @JoinColumn(name = "fk_type")
	private TypeOffre type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeOffre getType() {
		return type;
	}


	public User getCreateur() {
		return createur;
	}

	public void setCreateur(User createur) {
		this.createur = createur;
	}

	public void setType(TypeOffre type) {
		this.type = type;
	}

	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offre(String titre, String description, byte[] file, byte[] file2) {
		super();
		this.titre = titre;
		this.description = description;
		this.date = new Date();
		this.tab=file;
		this.tab1=file2;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Offre [id=" + id + ", titre=" + titre + ", description=" + description + ", createur=" + createur
				+ ", type=" + type + "]";
	}



}
