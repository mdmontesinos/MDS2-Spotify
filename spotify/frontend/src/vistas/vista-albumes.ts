import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-scroller.js';

@customElement('vista-albumes')
export class VistaAlbumes extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }

    .albumes {
	    margin: var(--lumo-space-m); height: 98%;
	    }

      `;
  }

  render() {
    return html`
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: center; justify-content: space-evenly;">
 <label id="tituloL" style="align-self: center; margin: var(--lumo-space-m); font-weight: bold;">Álbumes</label>
 <vaadin-scroller style="align-self: center; width: 100%; height: 90%;" id="vaadinScroller"></vaadin-scroller>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
