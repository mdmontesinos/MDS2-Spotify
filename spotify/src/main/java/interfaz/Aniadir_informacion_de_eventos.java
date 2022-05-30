package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.FinishedEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;

import basededatos.BDPrincipal;
import basededatos.iArtista;
import spotify.GestorVentana;
import spotify.GestorArchivos;
import vistas.VistaAniadir_informacion_de_eventos;

public class Aniadir_informacion_de_eventos extends VistaAniadir_informacion_de_eventos {
//	private event _confirmar_evento;
	private iArtista bd = new BDPrincipal();
	private basededatos.Artista artista;
	private String rutaFoto;
	
	public Aniadir_informacion_de_eventos(basededatos.Artista artista) {
		this.artista = artista;
		
		this.getConfirmarB().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				if(Validar_informacion_evento() == false) {
					Notification.show("Hay un error en los datos introducidos");
					return;
				}
				
				
				Confirmar_evento();
				
				GestorVentana.Atras();
			}
		});
		
		this.getCancelarB().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {

				GestorVentana.Atras();

			}
		});
		this.getElegirImagenFC().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				
				MemoryBuffer buffer = new MemoryBuffer();
				Upload upload = new Upload(buffer);
				Dialog modal = new Dialog(upload);
				
				upload.addFinishedListener(new ComponentEventListener<FinishedEvent>() {
					
					@Override
					public void onComponentEvent(FinishedEvent event) {
						rutaFoto = GestorArchivos.SubirImagen(buffer);
						
						getImagenImg().setSrc(rutaFoto);
						
						modal.close();
					}
				});
			}
		});
	}

	public boolean Validar_informacion_evento() {
		//VALIDAR
		boolean correcto = true;
		if(this.getFechaHoraTF().getValue().isBlank() || this.getVaadinTextArea().getValue().isBlank() || rutaFoto.isBlank() || this.getPrecioTF().getValue().isBlank()) {
			correcto = false;
		}
		return correcto;
	}

	public void Confirmar_evento() {
		bd.Crear_Evento(artista.getORMID(), rutaFoto, this.getFechaHoraTF().getValue(), this.getVaadinTextArea().getValue(), Integer.parseInt(this.getPrecioTF().getValue()));
	}
}