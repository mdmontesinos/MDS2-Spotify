package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.template.Id;

/**
 * A Designer generated component for the vista-lista_de_reproduccion_propia template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-lista_de_reproduccion_propia")
@JsModule("./src/vistas/vista-lista_de_reproduccion_propia.ts")
public class VistaLista_de_reproduccion_propia extends LitTemplate {

    public Image getFotoB() {
		return fotoB;
	}

	public void setFotoB(Image fotoB) {
		this.fotoB = fotoB;
	}

	@Id("fotoB")
	private Image fotoB;

	/**
     * Creates a new VistaLista_de_reproduccion_propia.
     */
    public VistaLista_de_reproduccion_propia() {
        // You can initialise any data required for the connected UI components here.
    }

}
