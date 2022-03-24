import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import './vista-canciones_ultimos_exitos';

@customElement('vista-cibernauta')
export class VistaCibernauta extends LitElement {
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
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 20%; padding: var(--lumo-space-l);">
  <img id="fotoImg" style="width: 100%; height: 100%; max-width: 150px;" src="https://play-lh.googleusercontent.com/PCpXdqvUWfCW1mXhH1Y_98yBpgsWxuTSTofy3NGMo9yBTATDyzVkqU580bfSln50bFU">
  <label id="nombreAppL" style="width: 100%; margin: var(--lumo-space-l); text-align: center; font-size:large;">Nombre App</label>
  <vaadin-button id="iniciarSesionB" style="width: 300px; max-width: 300px;">
    Iniciar Sesión 
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 80%; flex-grow: 0; padding: var(--lumo-space-m);">
  <vista-canciones_ultimos_exitos style="width: 100%; height: 100%;" id="vistaCanciones_ultimos_exitos"></vista-canciones_ultimos_exitos>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
