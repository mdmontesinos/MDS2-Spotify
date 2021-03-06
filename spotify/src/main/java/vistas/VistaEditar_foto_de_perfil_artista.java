package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.template.Id;

/**
 * A Designer generated component for the vista-editar_foto_de_perfil_artista template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-editar_foto_de_perfil_artista")
@JsModule("./src/vistas/vista-editar_foto_de_perfil_artista.ts")
public class VistaEditar_foto_de_perfil_artista extends LitTemplate {

    public Button getElegirFotoFC() {
		return elegirFotoFC;
	}

	public void setElegirFotoFC(Button elegirFotoFC) {
		this.elegirFotoFC = elegirFotoFC;
	}

	@Id("elegirFotoFC")
	private Button elegirFotoFC;

	/**
     * Creates a new VistaEditar_foto_de_perfil_artista.
     */
    public VistaEditar_foto_de_perfil_artista() {
        // You can initialise any data required for the connected UI components here.
    }

}
