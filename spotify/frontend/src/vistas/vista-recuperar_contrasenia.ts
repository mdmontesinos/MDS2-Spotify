import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

@customElement('vista-recuperar_contrasenia')
export class VistaRecuperar_contrasenia extends LitElement {
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
 <vaadin-button id="atrasB" style="align-self: flex-start; margin: var(--lumo-space-s);">
   Atrás 
 </vaadin-button>
 <label id="tituloL" style="align-self: center; margin: var(--lumo-space-l); font-weight: bold;">Recuperación de Contraseña</label>
 <vaadin-vertical-layout theme="spacing" style="align-self: center; flex-grow: 0; margin: var(--lumo-space-xl); height: 60%; justify-content: center;">
  <label id="correoL" style="align-self: center;">Introducir Correo Electrónico</label>
  <vaadin-text-field label="" placeholder="Email" id="correoTF" style="align-self: center;"></vaadin-text-field>
  <vaadin-button id="confirmarB" style="align-self: center;">
    Confirmar 
  </vaadin-button>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
