package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the vista-cancion_administrador template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-cancion_administrador")
@JsModule("./src/vistas/vista-cancion_administrador.ts")
public class VistaCancion_administrador extends LitTemplate {

    public HorizontalLayout getCancionImgLayout() {
		return cancionImgLayout;
	}

	public void setCancionImgLayout(HorizontalLayout cancionImgLayout) {
		this.cancionImgLayout = cancionImgLayout;
	}

	public Label getCancionL() {
		return cancionL;
	}

	public void setCancionL(Label cancionL) {
		this.cancionL = cancionL;
	}

	public Button getEditarCancionB() {
		return editarCancionB;
	}

	public void setEditarCancionB(Button editarCancionB) {
		this.editarCancionB = editarCancionB;
	}

	public Button getEliminarCancionB() {
		return eliminarCancionB;
	}

	public void setEliminarCancionB(Button eliminarCancionB) {
		this.eliminarCancionB = eliminarCancionB;
	}

	@Id("cancionL")
	private Label cancionL;
	@Id("editarCancionB")
	private Button editarCancionB;
	@Id("eliminarCancionB")
	private Button eliminarCancionB;
	@Id("cancionImgLayout")
	private HorizontalLayout cancionImgLayout;

	/**
     * Creates a new VistaCancion_administrador.
     */
    public VistaCancion_administrador() {
        // You can initialise any data required for the connected UI components here.
    }

}
