package basededatos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Vector;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.engine.spi.TypedValue;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Datos_Acceso;

public class BD_Datos_Acceso {
	public BDPrincipal _bDPrincipal_datos_acceso;
	public Vector<Datos_Acceso> _contiene_datos_acceso = new Vector<Datos_Acceso>();

	public int Dar_De_Alta_Cuenta(String aEmail, String aContrasenia, String aTipoUsuario) throws PersistentException {
		int id_datos = -1;
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {

			Datos_Acceso datos = Datos_AccesoDAO.createDatos_Acceso();
			datos.setEmail(aEmail);
			datos.setPassword(aContrasenia);
			datos.setTipo(aTipoUsuario);
			datos.setNumeroIntentos(0);

			Datos_AccesoDAO.save(datos);
			id_datos = datos.getORMID();
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return id_datos;
	}

	public void Actualizar_Contrasenia(String aEmail, String aNuevaContrasenia) throws PersistentException {
		Datos_AccesoCriteria criteria = new Datos_AccesoCriteria();
		criteria.email.eq(aEmail);
		
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			Datos_Acceso datos = Datos_AccesoDAO.loadDatos_AccesoByCriteria(criteria);
			datos.setPassword(aNuevaContrasenia);
			Datos_AccesoDAO.save(datos);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
	}

	public Datos_Acceso Realizar_Intento_Inicio_Sesion(String aEmail, String aContrasenia) throws PersistentException {
		
		Datos_Acceso datos = null;
		
		Datos_AccesoCriteria criteria = new Datos_AccesoCriteria();
		criteria.email.like("%" + aEmail + "%");
		
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			
			datos = Datos_AccesoDAO.loadDatos_AccesoByCriteria(criteria);
			
			String fechaString = datos.getFechaYHoraBloqueo();
			
			if (fechaString != null && !fechaString.isEmpty()) {
				LocalDateTime fecha = LocalDateTime.parse(fechaString);
				LocalDateTime termina = fecha.plus(Duration.of(15, ChronoUnit.MINUTES));
				
				if (termina.compareTo(LocalDateTime.now()) > 0) {
					datos = null;
				}
			}
			
			if (datos != null) {
				String password = datos.getPassword();
				
				if (!password.equals(aContrasenia)) {
					int intentos = datos.getNumeroIntentos();
					intentos++;
					
					if (intentos == 3) {
						datos.setNumeroIntentos(0);
						datos.setFechaYHoraBloqueo(LocalDateTime.now().toString());
					}
					else {
						datos.setNumeroIntentos(intentos);
					}
					Datos_AccesoDAO.save(datos);
					
					datos = null;
				}
			}
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		return datos;
	}
}