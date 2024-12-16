package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the categorias_match database table.
 * 
 */
@Entity
@Table(name="categorias_match")
@NamedQuery(name="CategoriasMatch.findAll", query="SELECT c FROM CategoriasMatch c")
public class CategoriasMatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cat_mat_id")
	private int catMatId;

	@Column(name="cat_mat_amistad")
	private String catMatAmistad;

	@Column(name="cat_mat_casual")
	private String catMatCasual;

	@Column(name="cat_mat_diversion")
	private String catMatDiversion;

	@Column(name="cat_mat_romance")
	private String catMatRomance;

	public CategoriasMatch() {
	}

	public int getCatMatId() {
		return this.catMatId;
	}

	public void setCatMatId(int catMatId) {
		this.catMatId = catMatId;
	}

	public String getCatMatAmistad() {
		return this.catMatAmistad;
	}

	public void setCatMatAmistad(String catMatAmistad) {
		this.catMatAmistad = catMatAmistad;
	}

	public String getCatMatCasual() {
		return this.catMatCasual;
	}

	public void setCatMatCasual(String catMatCasual) {
		this.catMatCasual = catMatCasual;
	}

	public String getCatMatDiversion() {
		return this.catMatDiversion;
	}

	public void setCatMatDiversion(String catMatDiversion) {
		this.catMatDiversion = catMatDiversion;
	}

	public String getCatMatRomance() {
		return this.catMatRomance;
	}

	public void setCatMatRomance(String catMatRomance) {
		this.catMatRomance = catMatRomance;
	}


	
	public CategoriasMatch orElse(CategoriasMatch cateogria) {
		return null;
	}
	public static int findById(int catMatId2) {
		return catMatId2;
	}

	@Override
	public String toString() {
		return "CategoriasMatch [catMatId=" + catMatId + ", catMatAmistad=" + catMatAmistad + ", catMatCasual="
				+ catMatCasual + ", catMatDiversion=" + catMatDiversion + ", catMatRomance=" + catMatRomance
				+ ", citas="  + "]";
	}


}