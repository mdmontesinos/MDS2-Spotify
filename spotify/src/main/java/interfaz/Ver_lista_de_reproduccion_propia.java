package interfaz;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import vistas.VistaVer_lista_de_reproduccion_propia;

public class Ver_lista_de_reproduccion_propia extends VistaVer_lista_de_reproduccion_propia {
//	private Label _editarL;
//	private Button _editarB;
	public Ver_mas_canciones_favoritas _ver_mas_canciones_favoritas;
	public Modificar_lista_de_reproduccion _modificar_lista_de_reproduccion;
	public Ver_lista_de_reproduccion _ver_lista_de_reproduccion;
	
	public Ver_lista_de_reproduccion_propia() {
		_modificar_lista_de_reproduccion = new Modificar_lista_de_reproduccion();
		_ver_lista_de_reproduccion = new Ver_lista_de_reproduccion();
		
		HorizontalLayout hl = this.getVaadinHorizontalLayout();
		
		hl.add(_ver_lista_de_reproduccion);
		
	}
}