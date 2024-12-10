# Automatización del Flujo de Reclutamiento en OrangeHRM

Este proyecto implementa la automatización del flujo de reclutamiento en la plataforma OrangeHRM utilizando herramientas avanzadas de automatización como Selenium y Cucumber, estructurado bajo el Patrón Screenplay. A continuación, se detalla la estructura del proyecto y los principios aplicados.

## **Estructura del Proyecto**

### **Modelo Screenplay**
El proyecto sigue el Patrón Screenplay, organizado en roles, tareas, interacciones y preguntas:
1. **Actors**: Los usuarios que interactúan con el sistema.
2. **Tasks**: Agrupan acciones a alto nivel, como registrar un candidato o agendar una entrevista.
3. **Interactions**: Acciones específicas como hacer clic, enviar texto o seleccionar elementos.
4. **Questions**: Verifican el estado actual de la aplicación después de las interacciones.

### **Estructura del Proyecto**

El proyecto está organizado en los siguientes paquetes para garantizar escalabilidad y facilidad de mantenimiento:
- **`features/`**: Contiene los escenarios de prueba escritos en Gherkin.
- **`tasks/`**: Define las tareas de alto nivel que ejecutan los actores.
- **`interactions/`**: Implementa interacciones específicas con elementos de la interfaz de usuario.
- **`questions/`**: Define las verificaciones que validan los resultados esperados.
- **`runners/`**: Configura y ejecuta los escenarios de Cucumber.
- **`utils/`**: Métodos auxiliares como configuraciones de espera o manejo de archivos.

## **Uso de Locators en Selenium**

Se aplicó un enfoque sistemático para la identificación de objetos en la interfaz de usuario, priorizando los selectores más robustos y mantenibles.

1. **Id**
2. **Name**
3. **Class**
4. **XPath Relativo**
5. **CSS Selectors**

#### **Ejemplo de Locators en el Proyecto**
```java
// Prioridad 1: Id
By usernameField = By.id("username");

// Prioridad 2: Name
By passwordField = By.name("password");

// Prioridad 3: Class
By loginButton = By.className("oxd-button");

// Prioridad 4: XPath Relativo
By saveButton = By.xpath("//button[text()=' Save ']");

// Prioridad 5: CSS Selector
By dropdownOption = By.cssSelector(".oxd-select-option");
