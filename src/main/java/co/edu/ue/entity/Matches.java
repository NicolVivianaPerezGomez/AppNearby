package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the matches database table.
 * 
 */
@Entity
@NamedQuery(name="Matches.findAll", query="SELECT m FROM Matches m")
public class Matches implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mat_id")
	private int matId;

	//bi-directional many-to-one association to CategoriasMatch
	@ManyToOne
	@JoinColumn(name="categorias_match_cat_mat_id")
	private CategoriasMatch categoriasMatch;

	public Matches() {
	}

	public int getMatId() {
		return this.matId;
	}

	public void setMatId(int matId) {
		this.matId = matId;
	}


	public CategoriasMatch getCategoriasMatch() {
		return this.categoriasMatch;
	}

	public void setCategoriasMatch(CategoriasMatch categoriasMatch) {
		this.categoriasMatch = categoriasMatch;
	}

	@Override
	public String toString() {
		return "Matches [matId=" + matId + ", usuario1=" + ", categoriasMatch="
				+ categoriasMatch + "]";
	}

}