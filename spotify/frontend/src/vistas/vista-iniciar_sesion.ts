import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

@customElement('vista-iniciar_sesion')
export class VistaIniciar_sesion extends LitElement {
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
 <vaadin-button id="atrasB" style="align-self: flex-start; margin: var(--lumo-space-m);">
   Atrás 
 </vaadin-button>
 <label id="tituloL" style="align-self: center; margin: var(--lumo-space-m);">Inicio de Sesión</label>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 30%; justify-content: center;">
  <vaadin-vertical-layout theme="spacing" style="width: 30%; height: 100%; align-items: center;">
   <vaadin-horizontal-layout theme="spacing">
    <img id="emailImg" style="max-width: 100px;" src="https://www.leadershipmartialartsct.com/wp-content/uploads/2017/04/default-image-620x600.jpg">
    <vaadin-text-field placeholder="Email" id="emailTF" required></vaadin-text-field>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing">
    <img id="contraseniaImg" src="https://www.leadershipmartialartsct.com/wp-content/uploads/2017/04/default-image-620x600.jpg" style="max-width: 100px;">
    <vaadin-password-field label="" placeholder="Contraseña" value="" id="vaadinPasswordField"></vaadin-password-field>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" style="width: 10%; height: 100%; flex-grow: 0; align-items: center;">
   <vaadin-button id="googleB">
     Google 
   </vaadin-button>
   <vaadin-button id="microsoftB">
     Microsoft 
   </vaadin-button>
   <vaadin-button id="facebookB">
     Facebook 
   </vaadin-button>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <label id="errorL" style="align-self: center;" color="">Error Correspondiente</label>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 10%; align-self: center; justify-content: center;">
  <a href="https://vaadin.com" id="registrarseB">Registrarse</a>
  <a href="https://vaadin.com" id="recuperarContraseniaB">Recuperar Contraseña</a>
 </vaadin-horizontal-layout>
 <vaadin-button style="align-self: center; margin: var(--lumo-space-m);" id="vaadinButton">
   Iniciar Sesión 
 </vaadin-button>
</vaadin-vertical-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
