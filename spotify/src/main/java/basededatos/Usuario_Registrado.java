/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Manuel David Montesinos Navarrete(University of Almeria)
 * License Type: Academic
 */
package basededatos;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Usuario_Registrado")
@Inheritance(strategy=InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name="Usuario_genericoId", referencedColumnName="Id")
public class Usuario_Registrado extends basededatos.Usuario_generico implements Serializable {
	public Usuario_Registrado() {
	}
	
	public String toString() {
		return super.toString();
	}
	
}
