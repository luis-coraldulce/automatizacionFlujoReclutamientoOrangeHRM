# Automatización del Flujo de Reclutamiento en OrangeHRM

Este proyecto implementa la automatización del flujo de reclutamiento en la plataforma OrangeHRM utilizando el Patrón Screenplay y Cucumber. A continuación, se detalla la estructura del proyecto y cómo se han aplicado estos principios.

## **Estructura del Proyecto**

### **1. Patrón Screenplay**
El Patrón Screenplay se utiliza para organizar el código de automatización en roles, tareas y preguntas, lo que facilita la legibilidad y el mantenimiento del código.

- **Actors**: Representan a los usuarios que interactúan con la aplicación.
- **Tasks**: Son las acciones que los actores realizan, como iniciar sesión, completar formularios o navegar por la aplicación.
- **Interactions**: Describen interacciones específicas con elementos de la interfaz, como hacer clic o escribir texto.
- **Questions**: Verifican el estado de la aplicación, como comprobar si un elemento está visible o si un texto es correcto.

### **2. Cucumber**
Cucumber se utiliza para escribir escenarios en lenguaje Gherkin, que describe el flujo de las pruebas en términos de características, escenarios y pasos.

#### **Ejemplo de un archivo Gherkin**
```gherkin
Feature: Automatización del flujo de reclutamiento

  Scenario: Registrar un candidato exitosamente
    Given El usuario está en la página de inicio de sesión
    When El usuario inicia sesión con credenciales válidas
    And Navega a la sección de Recruitment
    And Completa el formulario de registro de candidato
    And Marca al candidato como "Shortlist"
    And Agenda una entrevista para el candidato
    Then El candidato debería aparecer en el estado "Entrevista Programada"
