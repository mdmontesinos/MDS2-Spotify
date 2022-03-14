import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-scroller.js';
import './vista-usuario_administrador';

@customElement('vista-usuarios_administrador')
export class VistaUsuarios_administrador extends LitElement {
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
 <label id="tituloL">Usuarios</label>
 <vaadin-scroller style="width: 100%; height: 100%;">
  <vista-usuario_administrador></vista-usuario_administrador>
  <vista-usuario_administrador></vista-usuario_administrador>
  <vista-usuario_administrador></vista-usuario_administrador>
  <vista-usuario_administrador></vista-usuario_administrador>
 </vaadin-scroller>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}