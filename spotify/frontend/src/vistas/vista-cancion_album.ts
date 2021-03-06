import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

@customElement('vista-cancion_album')
export class VistaCancion_album extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: center; justify-content: center;">
 <label id="nombreL">Cancion</label>
 <vaadin-horizontal-layout theme="spacing" id="fotoImgLayout" style="flex-grow: 0; flex-shrink: 1; align-items: center; justify-content: center; margin: var(--lumo-space-m); max-width: 150px; max-height: 150px;"></vaadin-horizontal-layout>
 <vaadin-button id="eliminarB">
   Eliminar 
 </vaadin-button>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
