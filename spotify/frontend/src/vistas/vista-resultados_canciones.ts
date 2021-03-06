import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

@customElement('vista-resultados_canciones')
export class VistaResultados_canciones extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: center; justify-content: space-around;" theme="spacing-s">
 <label id="tituloL" style="align-self: center; margin: var(--lumo-space-m); font-weight: bold;">Canciones</label>
 <vaadin-horizontal-layout theme="spacing" id="contenedorSuperior" style="align-items: center; justify-content: space-evenly; width: 100%; height: 40%; margin: var(--lumo-space-xs); align-self: center;"></vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="contenedorInferior" style="align-items: center; justify-content: space-evenly; width: 100%; height: 40%; margin: var(--lumo-space-xs); align-self: center;"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
