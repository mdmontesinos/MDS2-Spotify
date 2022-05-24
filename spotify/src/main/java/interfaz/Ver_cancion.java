package interfaz;

import java.util.stream.Collectors;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.BDPrincipal;
import basededatos.iActor_comun;
import spotify.GestorActor;
import spotify.GestorArchivos;
import vistas.VistaVer_cancion;

public class Ver_cancion extends VistaVer_cancion {
//	private event _marcar_cancion_como_favorita;
//	private event _aniadir_cancion_a_lista_de_reproduccion;
//	private Label _tituloL;
//	private Button _aniadirFavoritosB;
//	private Label _aniadirListaL;
//	private Button _aniadirListaB;
//	private Label _creditosTituloL;
//	private Label _creditosTituloCancionL;
//	private Label _creditosTituloAlbumL;
//	private Label _creditosCompositorL;
//	private Label _creditosProductorL;
//	private Label _creditosInterpreteL;
//	private Label _creditosFicheroL;
//	private Label _creditoEstiloL;
//	private Image _fotoCancionImg;
	
	iActor_comun bd = new BDPrincipal();
	basededatos.Cancion _cancion;
	
	public Ver_cancion(basededatos.Cancion cancion) {
		
		_cancion = cancion;
		
		this.getFotoCancionImg().setSrc(GestorArchivos.CargarImagen(_cancion.getFicheroMultimediaAltaCalidadRuta()));
		this.getTituloL().setText(_cancion.getTitulo());
		this.getCreditosTituloCancionL().setText(_cancion.getTitulo());
		this.getCreditosTituloAlbumL().setText(_cancion.getIncluida_en_albumes().getTitulo());
		this.getCreditosCompositorL().setText(_cancion.getCompositores());
		this.getCreditosProductorL().setText(_cancion.getProductores());
		
		StringBuilder intepretes = new StringBuilder();
		basededatos.Artista[] artistas = _cancion.intepretes.toArray();
		
		for (int i = 0; i < artistas.length; i++) {
			intepretes.append(artistas[i].getNick() + ", ");
		}
		
		this.getCreditosInterpreteL().setText(intepretes.toString());
		
		basededatos.Estilo[] estilo = _cancion.estilos.toArray();
		
		this.getCreditoEstiloL().setText(estilo[0].getNombre());
		
		this.getCreditosFicheroL().setText("FICHERO??");
		
		if (GestorActor.getUsuario().getFavorita().canciones_incluidas.contains(_cancion)) {
			this.getAniadirFavoritosB().setText("Eliminar de favoritos");
			
			this.getAniadirFavoritosB().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					Quitar_cancion_favoritos();
				}
			});
		}
		else {
			this.getAniadirFavoritosB().setText("Añadir a favoritos");
			
			this.getAniadirFavoritosB().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					Marcar_cancion_como_favorita();
				}
			});
		}

		//Este método hay que rehacerlo
		
//		for(int i=0; i<this.getAniadirListaB().getPageSize(); i++) {
//			this.getAniadirListaB().getElement().addEventListener("click", e ->{
//				
//				Aniadir_cancion_a_lista_de_reproduccion(e);
//				
//			});
//			
//		}

	}

	public void Marcar_cancion_como_favorita() {
		bd.Marcar_cancion_favorita(GestorActor.getIdUsuario(), _cancion.getORMID());
	}

	public void Aniadir_cancion_a_lista_de_reproduccion(int idLista) {
		bd.Aniadir_cancion_a_lista(_cancion.getORMID(), idLista);
	}
	
	public void Quitar_cancion_favoritos() {
		bd.Quitar_cancion_favoritos(GestorActor.getIdUsuario(), _cancion.getORMID());
	}
}