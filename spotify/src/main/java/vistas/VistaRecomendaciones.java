package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.dom.Element;

/**
 * A Designer generated component for the vista-recomendaciones template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-recomendaciones")
@JsModule("./src/vistas/vista-recomendaciones.ts")
public class VistaRecomendaciones extends LitTemplate {

    public Label getTituloL() {
		return tituloL;
	}

	public void setTituloL(Label tituloL) {
		this.tituloL = tituloL;
	}

	public Element getContenedor() {
		return contenedor;
	}

	public void setContenedor(Element contenedor) {
		this.contenedor = contenedor;
	}

	@Id("tituloL")
	private Label tituloL;
	@Id("contenedor")
	private Element contenedor;

	/**
     * Creates a new VistaRecomendaciones.
     */
    public VistaRecomendaciones() {
        // You can initialise any data required for the connected UI components here.
    }

}
