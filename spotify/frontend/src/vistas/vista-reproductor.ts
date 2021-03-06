import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

@customElement('vista-reproductor')
export class VistaReproductor extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%; justify-content: center; align-items: center;">
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; justify-content: center;" id="contenedor">
  <vaadin-button id="tituloB">
    TituloCancion 
  </vaadin-button>
  <label id="tituloL" style="align-self: center; font-weight: bold;">TituloCancion</label>
  <vaadin-button id="creditosB">
    Créditos 
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
