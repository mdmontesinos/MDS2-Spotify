package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TituloCancion extends Cancion {
//	private Button _tituloB;
//	public Canciones_de_lista _canciones_de_lista;
//	public Canciones_album _canciones_album;
	
	public TituloCancion(basededatos.Cancion cancion) {
		
		super(cancion);
		
		this.getTituloB().setVisible(true);
		
		this.getTituloB().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				
				Reproducir__No_Cibernauta_();
			}
		});
	}
	
}