package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-actor_comun template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-actor_comun")
@JsModule("./src/vistas/vista-actor_comun.ts")
public class VistaActor_comun extends LitTemplate {

    public Element getLayoutReproductor() {
		return layoutReproductor;
	}

	public void setLayoutReproductor(Element layoutReproductor) {
		this.layoutReproductor = layoutReproductor;
	}

	public Element getLayoutCabecera() {
		return layoutCabecera;
	}

	public void setLayoutCabecera(Element layoutCabecera) {
		this.layoutCabecera = layoutCabecera;
	}

	public Element getLayoutPrincipal() {
		return layoutPrincipal;
	}

	public void setLayoutPrincipal(Element layoutPrincipal) {
		this.layoutPrincipal = layoutPrincipal;
	}

//	public Element getContenedorDerecho() {
//		return contenedorDerecho;
//	}
//
//	public void setContenedorDerecho(Element contenedorDerecho) {
//		this.contenedorDerecho = contenedorDerecho;
//	}
//
//	public Element getContenedorIzquierdo() {
//		return contenedorIzquierdo;
//	}
//
//	public void setContenedorIzquierdo(Element contenedorIzquierdo) {
//		this.contenedorIzquierdo = contenedorIzquierdo;
//	}
//
//	public Button getVerEstadisticasB() {
//		return verEstadisticasB;
//	}
//
//	public void setVerEstadisticasB(Button verEstadisticasB) {
//		this.verEstadisticasB = verEstadisticasB;
//	}
//
//	public Button getMenuAdministracionB() {
//		return menuAdministracionB;
//	}
//
//	public void setMenuAdministracionB(Button menuAdministracionB) {
//		this.menuAdministracionB = menuAdministracionB;
//	}
//
//	@Id("verEstadisticasB")
//	private Button verEstadisticasB;
//	@Id("menuAdministracionB")
//	private Button menuAdministracionB;
//	@Id("contenedorDerecho")
//	private Element contenedorDerecho;
//	@Id("contenedorIzquierdo")
//	private Element contenedorIzquierdo;
	@Id("LayoutPrincipal")
	private Element layoutPrincipal;
	@Id("LayoutCabecera")
	private Element layoutCabecera;
	@Id("LayoutReproductor")
	private Element layoutReproductor;
	/**
     * Creates a new VistaActor_comun.
     */
    public VistaActor_comun() {
        // You can initialise any data required for the connected UI components here.
    }

}
