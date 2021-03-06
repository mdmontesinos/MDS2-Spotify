package basededatos;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Artista;

public class BD_Artistas {
	public Vector<Artista> _contiene_artistas = new Vector<Artista>();
	public BDPrincipal _bDPrincipal_artistas;

	public Artista[] Realizar_Busqueda_Artistas(String aParametrosBusqueda) throws PersistentException {
		Artista[] artistas = new Artista[0];
		
		ArtistaCriteria criteria = new ArtistaCriteria();
		criteria.nick.like("%" + aParametrosBusqueda.trim().toLowerCase() + "%");
		
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			artistas = ArtistaDAO.listArtistaByCriteria(criteria);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return artistas;
	}

	public Artista Obtener_Artista(int aIdArtista) throws PersistentException {
		Artista artista = null;
		
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			artista = ArtistaDAO.getArtistaByORMID(aIdArtista);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		return artista;
	}

	public void Actualizar_Foto_Perfil(int aIdArtista, String aNuevaFoto) throws PersistentException {
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			Artista artista = ArtistaDAO.getArtistaByORMID(aIdArtista);
			
			artista.setFotoRuta(aNuevaFoto.trim());
			ArtistaDAO.save(artista);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().disposePersistentManager();
	}

	public int Crear_Artista(int aIdDatosAcceso, String aNick, String aFotoRuta, int aIdEstilo) throws PersistentException {
		int id_artista = -1;
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {

			Datos_Acceso dato = Datos_AccesoDAO.getDatos_AccesoByORMID(aIdDatosAcceso);
			Artista artista = ArtistaDAO.createArtista();
			
			Estilo estilo = EstiloDAO.getEstiloByORMID(aIdEstilo);
			artista.setEstilo(estilo);
			
			artista.setFotoRuta(aFotoRuta.trim());
			artista.setNick(aNick.trim());
			artista.setDatos(dato);
			dato.setUsuario(artista);
			
			Estadistica estadistica = EstadisticaDAO.createEstadistica();
			estadistica.setUsuario(artista);
			artista.setEstadistica(estadistica);
			
			Lista_de_reproduccion lista = Lista_de_reproduccionDAO.createLista_de_reproduccion();
			lista.setPropietario_favorito(artista);
			lista.setTitulo("Canciones favoritas");
			lista.setAutor(artista);
			artista.setFavorita(lista);
			
			Datos_AccesoDAO.save(dato);
			ArtistaDAO.save(artista);
			
			id_artista = artista.getORMID();
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().disposePersistentManager();
		return id_artista;
	}

		

	public void Actualizar_Artista(Artista aArtista) throws PersistentException {
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			ArtistaDAO.save(aArtista);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().disposePersistentManager();
	}

	public void Eliminar_Artista(int aIdArtista) throws PersistentException {
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			Artista artista = ArtistaDAO.loadArtistaByORMID(aIdArtista);
			
			Album[] albumes = artista.albumes.toArray();
			for (Album album : albumes) {
				artista.albumes.remove(album);
			}
			
			Cancion[] canciones = artista.canciones.toArray();
			for (Cancion cancion : canciones) {
				artista.canciones.remove(cancion);
			}
			
			Cancion[] ultimasReproducidas = artista.ultimas_reproducidas.toArray();
			for (Cancion cancion : ultimasReproducidas) {
				artista.ultimas_reproducidas.remove(cancion);
			}
			
			Evento[] notificaciones = artista.notificaciones.toArray();
			for (Evento notificacion : notificaciones) {
				artista.notificaciones.remove(notificacion);
			}
			
			Evento[] eventos = artista.eventos.toArray();
			for (Evento evento : eventos) {
				artista.eventos.remove(evento);
				
				EventoDAO.delete(evento);
			}
			
			Lista_de_reproduccion[] listas = artista.listas.toArray();
			for (Lista_de_reproduccion lista : listas) {
				artista.listas.remove(lista);
				
				Cancion[] cancionesLista = lista.canciones_incluidas.toArray();
				
				for (Cancion cancion : cancionesLista) {
					lista.canciones_incluidas.remove(cancion);
				}
				
				Usuario_generico[] usuarios = lista.seguidor.toArray();
				
				for (Usuario_generico usuario : usuarios) {
					lista.seguidor.remove(usuario);
				}
				
				Lista_de_reproduccionDAO.delete(lista);
			}
			
			Lista_de_reproduccion[] listasSeguidas = artista.lista_seguida.toArray();
			for (Lista_de_reproduccion lista : listasSeguidas) {
				artista.lista_seguida.remove(lista);
			}
			
			Usuario_generico[] seguidos = artista.seguido.toArray();
			for (Usuario_generico seguido : seguidos) {
				artista.seguido.remove(seguido);
			}
			
			Usuario_generico[] seguidores = artista.seguidor.toArray();
			for (Usuario_generico seguidor : seguidores) {
				artista.seguidor.remove(seguidor);
			}
			
			Estadistica[] estadisticas = artista.aparece_en.toArray();
			for (Estadistica estadistica : estadisticas) {
				artista.aparece_en.remove(estadistica);
			}
			
			Estadistica estadistica = artista.getEstadistica();
			Artista[] artistasEscuchados = estadistica.artistas_mas_escuchados.toArray();
			for (Artista artistaEscuchado : artistasEscuchados) {
				estadistica.artistas_mas_escuchados.remove(artistaEscuchado);
			}
			
			Estilo[] estilosEscuchados = estadistica.estilos_mas_escuchados.toArray();
			for (Estilo estiloEscuchado : estilosEscuchados) {
				estadistica.estilos_mas_escuchados.remove(estiloEscuchado);
			}
			EstadisticaDAO.delete(estadistica);
			
			Lista_de_reproduccion favoritos = artista.getFavorita();
			
			Cancion[] cancionesLista = favoritos.canciones_incluidas.toArray();
			
			for (Cancion cancion : cancionesLista) {
				favoritos.canciones_incluidas.remove(cancion);
			}
			
			Usuario_generico[] usuarios = favoritos.seguidor.toArray();
			
			for (Usuario_generico usuario : usuarios) {
				favoritos.seguidor.remove(usuario);
			}
			
			Lista_de_reproduccionDAO.delete(favoritos);
			
			int idDatos = artista.getDatos().getORMID();
			
			ArtistaDAO.delete(artista);
			
			Datos_Acceso datos = Datos_AccesoDAO.getDatos_AccesoByORMID(idDatos);
			Datos_AccesoDAO.delete(datos);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().disposePersistentManager();
	}

	public Artista[] Cargar_Artistas_Similares(int aIdArtista) throws PersistentException {
		//Los artistas similares son aquellos que tienen el mismo estilo
		
		Artista artistasSimilares[] = new Artista[0];
		
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			Artista artista = ArtistaDAO.loadArtistaByORMID(aIdArtista);
			
			int estiloId = artista.getEstilo().getId();
			
			ArtistaCriteria criteria = new ArtistaCriteria();
			criteria.estiloId.eq(estiloId);
			criteria.id.ne(aIdArtista);
			
			artistasSimilares = ArtistaDAO.listArtistaByCriteria(criteria);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		return artistasSimilares;
	}

	public Artista[] Cargar_Artistas_Lista_Seguidores(int aIdUsuarioGenerico) throws PersistentException {
		List<Artista> artistasSeguidores = new Vector<Artista>();
		
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			
			Usuario_generico usuario = Usuario_genericoDAO.getUsuario_genericoByORMID(aIdUsuarioGenerico);
			
			Iterator<Usuario_generico> iterador = usuario.seguidor.getIterator();
			
			Usuario_generico temp;
			
			while(iterador.hasNext()) {
				temp = iterador.next();
				
				if (temp instanceof Artista){
			      artistasSeguidores.add((Artista)temp);
			    }
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		return artistasSeguidores.toArray(new Artista[artistasSeguidores.size()]);
	}

	public Artista[] Cargar_Artistas_Lista_Seguidos(int aIdUsuarioGenerico) throws PersistentException {
		List<Artista> artistasSeguidos = new Vector<Artista>();
		
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			
			Usuario_generico usuario = Usuario_genericoDAO.getUsuario_genericoByORMID(aIdUsuarioGenerico);
			
			Iterator<Usuario_generico> iterador = usuario.seguido.getIterator();
			
			Usuario_generico temp;
			
			while(iterador.hasNext()) {
				temp = iterador.next();
				
				if (temp instanceof Artista){
					artistasSeguidos.add((Artista)temp);
			    }
			}

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		return artistasSeguidos.toArray(new Artista[artistasSeguidos.size()]);
	}

	public void Seguir_Artista(int aIdUsuarioGenerico, int aIdArtista) throws PersistentException {
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			
			Artista artista = ArtistaDAO.getArtistaByORMID(aIdArtista);
			Usuario_generico usuario = Usuario_genericoDAO.getUsuario_genericoByORMID(aIdUsuarioGenerico);
			artista.seguidor.add(usuario);
			usuario.seguido.add(artista);
			
			ArtistaDAO.save(artista);
			Usuario_genericoDAO.save(usuario);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().disposePersistentManager();
	}
	
	public void Dejar_De_Seguir_Artista(int aIdUsuarioGenerico, int aIdArtista) throws PersistentException {
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			
			Artista artista = ArtistaDAO.getArtistaByORMID(aIdArtista);
			Usuario_generico usuario = Usuario_genericoDAO.getUsuario_genericoByORMID(aIdUsuarioGenerico);
			artista.seguidor.remove(usuario);
			usuario.seguido.remove(artista);
			
			ArtistaDAO.save(artista);
			Usuario_genericoDAO.save(usuario);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().disposePersistentManager();
	}
	
	public boolean Comprobar_Artista_Seguido(int aIdUsuarioGenerico, int aIdArtista) throws PersistentException {
		boolean yaSeguido = false;
		
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			
			Usuario_generico usuario = Usuario_genericoDAO.getUsuario_genericoByORMID(aIdUsuarioGenerico);
			Artista artista = ArtistaDAO.getArtistaByORMID(aIdArtista);
			
			yaSeguido = usuario.seguido.contains(artista);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		return yaSeguido;
	}
	
	public boolean Comprobar_Nick_Artista(String aNick) throws PersistentException {
		boolean existe = false;
		ArtistaCriteria criteria = new ArtistaCriteria();
		criteria.nick.eq(aNick.trim());
		PersistentTransaction t = AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().getSession().beginTransaction();
		try {
			
			Artista datos = ArtistaDAO.loadArtistaByCriteria(criteria);
			if(datos == null) {
				existe = false;
			}else {
				if(datos.getNick().contentEquals(aNick)){
					existe = true;
				}
			}
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		AplicacióndeBúsquedayReproduccióndeMúsicaPersistentManager.instance().disposePersistentManager();
		return existe;
	}
}