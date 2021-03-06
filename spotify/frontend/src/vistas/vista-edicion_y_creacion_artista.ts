import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

@customElement('vista-edicion_y_creacion_artista')
export class VistaEdicion_y_creacion_artista extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%; justify-content: space-around; align-items: center; padding: var(--lumo-space-s);">
 <label id="tituloL" style="font-weight: bold;">Artista</label>
 <label id="errorL">Mensaje de error correspondiente</label>
 <vaadin-horizontal-layout theme="spacing">
  <vaadin-horizontal-layout theme="spacing" id="fotoImgLayout" style="max-width: 500px; max-height: 500px;"></vaadin-horizontal-layout>
  <vaadin-button id="elegirFotoB">
    Elegir archivo 
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout">
  <label id="emailL">Email</label>
  <vaadin-text-field id="emailTF"></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing">
  <label id="nickL">Nick</label>
  <vaadin-text-field id="nickTF">
    Text 
  </vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing">
  <label id="label">Contraseña</label>
  <vaadin-text-field id="contraseniaTF"></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing">
  <label id="estiloL">Estilo</label>
  <vaadin-combo-box id="estiloCB"></vaadin-combo-box>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing">
  <vaadin-button id="guardarB">
    Guardar 
  </vaadin-button>
  <vaadin-button id="cancelarB">
    Cancelar 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
