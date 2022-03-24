import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

@customElement('vista-imagen_artistas')
export class VistaImagen_artistas extends LitElement {
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
<vaadin-vertical-layout style="width: 100%; height: 100%; padding: var(--lumo-space-s);">
 <img id="artistaImg" style="width: 100%; height: 100%;" src="https://www.softzone.es/app/uploads/2018/04/guest.png?x=480&amp;quality=20">
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
