package co.edu.ue.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.io.Serializable;
import org.hibernate.annotations.NamedQuery;
import jakarta.persistence.Column;


@Entity
@NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private int usuId;

    @Column(name = "usu_contraseña")
    private String usuContraseña;

    @Column(name = "usu_edad")
    private int usuEdad;

    @Column(name = "usu_email")
    private String usuEmail;

    @Column(name = "usu_genero")
    private String usuGenero;

    @Column(name = "usu_nombre")
    private String usuNombre;

    public Usuarios() {}

    // Getters y Setters
    public int getUsuId() {
        return this.usuId;
    }

    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    public String getUsuContraseña() {
        return this.usuContraseña;
    }

    public void setUsuContraseña(String usuContraseña) {
        this.usuContraseña = usuContraseña;
    }

    public int getUsuEdad() {
        return this.usuEdad;
    }

    public void setUsuEdad(int usuEdad) {
        this.usuEdad = usuEdad;
    }

    public String getUsuEmail() {
        return this.usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public String getUsuGenero() {
        return this.usuGenero;
    }

    public void setUsuGenero(String usuGenero) {
        this.usuGenero = usuGenero;
    }

    public String getUsuNombre() {
        return this.usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }


    @Override
    public String toString() {
        return "Usuarios [usuId=" + usuId + ", usuContraseña=" + usuContraseña + ", usuEdad=" + usuEdad + ", usuEmail="
                + usuEmail + ", usuGenero=" + usuGenero + ", usuNombre=" + usuNombre + "]";
    }
}
