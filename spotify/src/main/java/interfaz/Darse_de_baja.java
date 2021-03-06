package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;

import spotify.GestorActor;
import vistas.VistaDarse_de_baja;

public class Darse_de_baja extends VistaDarse_de_baja {
//	private Label _mensajeL;
//	private Button _confirmarB;
//	private Button _cancelarB;
//	private event _dar_de_baja;

	public Darse_de_baja(Dialog ventanaModal) {
		
		this.getConfirmarB().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				
				ventanaModal.close();
				
				Dar_de_baja();
				
				GestorActor.Cibernauta();
			}
		});
		
		this.getCancelarB().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				
				ventanaModal.close();
			}
		});
		
	}

	public void Dar_de_baja() {
		//Ha sido overrideado
		throw new UnsupportedOperationException();
	}
}