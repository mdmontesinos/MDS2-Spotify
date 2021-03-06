import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

@customElement('vista-actor_comun')
export class VistaActor_comun extends LitElement {
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
 <vaadin-vertical-layout id="LayoutCabecera" style="align-self: center; align-items: center; justify-content: center; width: 100%; height: 15%; background-color: WhiteSmoke; max-height: 15%;"></vaadin-vertical-layout>
 <vaadin-vertical-layout style="width: 100%; height: 78%; flex-shrink: 1; justify-content: space-around; overflow-y: scroll; max-height: 78%; align-self: center; align-items: center;" id="LayoutPrincipal">
  <vaadin-button id="verEstadisticasB" style="align-self: flex-end; margin: var(--lumo-space-m);">
    Estadísticas de uso 
  </vaadin-button>
  <vaadin-horizontal-layout theme="spacing" style="width: 100%;">
   <vaadin-vertical-layout theme="spacing" style="width: 70%;" id="contenedorIzquierdo"></vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" style="width: 30%; height: 100%; align-items: center;" id="contenedorDerecho">
    <vaadin-button id="menuAdministracionB">
      Menú Administración 
    </vaadin-button>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" id="LayoutReproductor" style="align-self: center; justify-content: center; align-items: center; width: 100%; height: 12%; max-height: 12%;"></vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
