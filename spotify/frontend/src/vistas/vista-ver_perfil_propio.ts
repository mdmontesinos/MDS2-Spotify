import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './vista-listas_de_reproduccion_perfil';
import '@vaadin/vaadin-button/src/vaadin-button.js';

@customElement('vista-ver_perfil_propio')
export class VistaVer_perfil_propio extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; justify-content: space-between;">
  <vaadin-vertical-layout theme="spacing" style="align-items: center;">
   <img id="fotoImg" src="https://skillz4kidzmartialarts.com/wp-content/uploads/2017/04/default-image-620x600.jpg">
   <label id="emailL">Email</label>
   <label id="nickL">Nick</label>
   <vaadin-button id="modificarInformacionB">
    Modificar Información
   </vaadin-button>
   <vaadin-button id="darseBajaB">
    Darse de baja
   </vaadin-button>
   <vaadin-button id="aniadirInformacionEventosB">
    Añadir información de conciertos
   </vaadin-button>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing">
   <vaadin-horizontal-layout theme="spacing" style="width: 100%; justify-content: space-around;">
    <vaadin-button id="seguidoresB">
     Seguidores: X
    </vaadin-button>
    <vaadin-button id="seguidosB">
     Seguidos: X
    </vaadin-button>
    <vaadin-button id="notificacionesB">
     Notificaciones
    </vaadin-button>
   </vaadin-horizontal-layout>
   <vista-listas_de_reproduccion_perfil></vista-listas_de_reproduccion_perfil>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}