package vistas;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the vista-ver_perfil_propio template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("vista-ver_perfil_propio")
@JsModule("./src/vistas/vista-ver_perfil_propio.ts")
public class VistaVer_perfil_propio extends LitTemplate {

	public HorizontalLayout getFotoImgLayout() {
		return fotoImgLayout;
	}

	public void setFotoImgLayout(HorizontalLayout fotoImgLayout) {
		this.fotoImgLayout = fotoImgLayout;
	}

	public Element getContenedorIzquierdo() {
		return contenedorIzquierdo;
	}

	public void setContenedorIzquierdo(Element contenedorIzquierdo) {
		this.contenedorIzquierdo = contenedorIzquierdo;
	}

	public Element getContenedorDerecho() {
		return contenedorDerecho;
	}

	public void setContenedorDerecho(Element contenedorDerecho) {
		this.contenedorDerecho = contenedorDerecho;
	}

	public Label getEmailL() {
		return emailL;
	}

	public void setEmailL(Label emailL) {
		this.emailL = emailL;
	}

	public Label getNickL() {
		return nickL;
	}

	public void setNickL(Label nickL) {
		this.nickL = nickL;
	}

	public Button getModificarInformacionB() {
		return modificarInformacionB;
	}

	public void setModificarInformacionB(Button modificarInformacionB) {
		this.modificarInformacionB = modificarInformacionB;
	}

	public Button getDarseBajaB() {
		return darseBajaB;
	}

	public void setDarseBajaB(Button darseBajaB) {
		this.darseBajaB = darseBajaB;
	}

	public Button getAniadirInformacionEventosB() {
		return aniadirInformacionEventosB;
	}

	public void setAniadirInformacionEventosB(Button aniadirInformacionEventosB) {
		this.aniadirInformacionEventosB = aniadirInformacionEventosB;
	}

	public Button getSeguidoresB() {
		return seguidoresB;
	}

	public void setSeguidoresB(Button seguidoresB) {
		this.seguidoresB = seguidoresB;
	}

	public Button getSeguidosB() {
		return seguidosB;
	}

	public void setSeguidosB(Button seguidosB) {
		this.seguidosB = seguidosB;
	}

	public Button getNotificacionesB() {
		return notificacionesB;
	}

	public void setNotificacionesB(Button notificacionesB) {
		this.notificacionesB = notificacionesB;
	}

	@Id("emailL")
	private Label emailL;
	@Id("nickL")
	private Label nickL;
	@Id("modificarInformacionB")
	private Button modificarInformacionB;
	@Id("darseBajaB")
	private Button darseBajaB;
	@Id("aniadirInformacionEventosB")
	private Button aniadirInformacionEventosB;
	@Id("seguidoresB")
	private Button seguidoresB;
	@Id("seguidosB")
	private Button seguidosB;
	@Id("notificacionesB")
	private Button notificacionesB;
	@Id("contenedorIzquierdo")
	private Element contenedorIzquierdo;
	@Id("contenedorDerecho")
	private Element contenedorDerecho;
	@Id("fotoImgLayout")
	private HorizontalLayout fotoImgLayout;

	/**
     * Creates a new VistaVer_perfil_propio.
     */
    public VistaVer_perfil_propio() {
        // You can initialise any data required for the connected UI components here.
    }

}
