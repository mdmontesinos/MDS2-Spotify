package basededatos;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Administrador;

public class BD_Administradores {
	public Vector<Administrador> _contiene_administradores = new Vector<Administrador>();
	public BDPrincipal _bDPrincipal_admin;

	public Administrador Obtener_Administrador(int aIdAdministrador) throws PersistentException {
		
		Administrador admin = null;
		
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			admin = AdministradorDAO.getAdministradorByORMID(aIdAdministrador);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		return admin;
	}

	public void Actualizar_Perfil_Administrador(int aIdAdministrador, String aNuevoEmail, String aNuevoNick) throws PersistentException {
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			Administrador admin = AdministradorDAO.getAdministradorByORMID(aIdAdministrador);
			
			Datos_Acceso datos = admin.getDatos();
			datos.setEmail(aNuevoEmail.trim());
			Datos_AccesoDAO.save(datos);
			
			admin.setNick(aNuevoNick.trim());
			AdministradorDAO.save(admin);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().disposePersistentManager();
	}
	
	public void Actualizar_Numero_Canciones_Mostradas(int aIdAdministrador, int aNuevoValor) throws PersistentException {
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			Administrador admin = AdministradorDAO.getAdministradorByORMID(aIdAdministrador);
			
			admin.setNumeroCancionesMostradas(aNuevoValor);
			AdministradorDAO.save(admin);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().disposePersistentManager();
	}
	
	public void Actualizar_Numero_Canciones_Reproducibles(int aIdAdministrador, int aNuevoValor) throws PersistentException {
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			Administrador admin = AdministradorDAO.getAdministradorByORMID(aIdAdministrador);
			
			admin.setLimiteCancionesReproducibles(aNuevoValor);
			AdministradorDAO.save(admin);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().disposePersistentManager();
	}
	
	public int Cargar_Numero_Canciones_Mostradas() throws PersistentException {
		return Cargar_Numero_Canciones_Mostradas(1);
	}

	public int Cargar_Numero_Canciones_Mostradas(int idAdministrador) throws PersistentException {
		int num = 0;
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			
			Administrador admin = AdministradorDAO.getAdministradorByORMID(idAdministrador);
			
			num = admin.getNumeroCancionesMostradas();
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().disposePersistentManager();
		return num;
	}
	
	public int Cargar_Numero_Canciones_Reproducibles() throws PersistentException {
		return Cargar_Numero_Canciones_Reproducibles(1);
	}
	
	public int Cargar_Numero_Canciones_Reproducibles(int idAdministrador) throws PersistentException {
		int num = 0;
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			Administrador admin = AdministradorDAO.getAdministradorByORMID(idAdministrador);
			
			num = admin.getLimiteCancionesReproducibles();
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().disposePersistentManager();
		return num;
	}
}