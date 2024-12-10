package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
        public static void main(String[] args) {
                // Configuración del driver
                System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
                WebDriver driver = new FirefoxDriver();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

                try {
                        // Acceder a la página de inicio de sesión
                        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
                        System.out.println("Página cargada correctamente.");

                        // Iniciar sesión
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username"))).sendKeys("Admin");
                        driver.findElement(By.name("password")).sendKeys("admin123");
                        driver.findElement(By.cssSelector("button[type='submit']")).click();
                        System.out.println("Inicio de sesión completado.");

                        // Ir a Recruitment y abrir el formulario Add
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Recruitment']")))
                                        .click();
                        System.out.println("Ingresando a Recruitment.");
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Add ']")))
                                        .click();
                        System.out.println("Formulario abierto.");

                        // Llenar el formulario
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstName']")))
                                        .sendKeys("Marcos");
                        driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("Antonio");
                        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Solis");

                        // Vacancy (Seleccionar la tercera opción disponible)
                        WebElement vacancyDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//div[@class='oxd-select-text oxd-select-text--active']")));
                        vacancyDropdown.click();
                        WebElement thirdOption = wait.until(ExpectedConditions.presenceOfElementLocated(
                                        By.xpath("(//div[@role='listbox']//div[@class='oxd-select-option'])[3]")));
                        thirdOption.click();
                        System.out.println("Vacancy seleccionado: Tercera opción.");

                        // Email
                        driver.findElement(By.xpath("//label[text()='Email']/following::input[1]"))
                                        .sendKeys("marco_solis@gmail.com");

                        // Contact Number
                        driver.findElement(By.xpath("//label[text()='Contact Number']/following::input[1]"))
                                        .sendKeys("3104472060");

                        // Resume
                        WebElement uploadButton = driver.findElement(By.xpath("//input[@type='file']"));
                        uploadButton.sendKeys("D:\\Archivo de prueba.docx");

                        // Notes
                        driver.findElement(By.xpath("//label[text()='Notes']/following::textarea[1]"))
                                        .sendKeys("Este es un candidato con experiencia en pruebas automatizadas y manuales.");

                        // Consent to keep data
                        WebElement consentCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//label[text()='Consent to keep data']/following::span[contains(@class,'oxd-checkbox-input')]")));
                        consentCheckbox.click();
                        System.out.println("Consentimiento marcado.");

                        // Guardar el formulario
                        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//button[text()=' Save ']")));
                        saveButton.click();
                        System.out.println("Formulario enviado correctamente.");

                        // Esperar a la sección "Application Stage" y buscar el botón "Shortlist"
                        wait.until(ExpectedConditions
                                        .presenceOfElementLocated(By.xpath("//h6[text()='Application Stage']")));
                        WebElement shortlistButton = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//button[text()=' Shortlist ']")));
                        shortlistButton.click();
                        System.out.println("Botón 'Shortlist' ejecutado correctamente.");

                        // Shortlist Candidate - Llenar Notas y Guardar
                        wait.until(ExpectedConditions
                                        .presenceOfElementLocated(By.xpath("//h6[text()='Shortlist Candidate']")));
                        driver.findElement(By.xpath("//label[text()='Notes']/following::textarea[1]"))
                                        .sendKeys("Candidato altamente calificado.");

                        // Validar y esperar que el botón "Save" esté clickeable antes de hacer clic
                        WebElement shortlistSaveButton = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//button[text()=' Save ']")));
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader"))); // Esperar
                                                                                                                      // que
                                                                                                                      // no
                                                                                                                      // haya
                                                                                                                      // loader
                        shortlistSaveButton.click();
                        System.out.println("Formulario 'Shortlist Candidate' guardado correctamente.");

                        // Navegar a Application Stage y hacer clic en "Schedule Interview"
                        wait.until(ExpectedConditions
                                        .presenceOfElementLocated(By.xpath("//h6[text()='Application Stage']")));
                        WebElement scheduleInterviewButton = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//button[text()=' Schedule Interview ']")));
                        scheduleInterviewButton.click();
                        System.out.println("Botón 'Schedule Interview' ejecutado correctamente.");

                        // Llenar los campos en "Schedule Interview"
                        wait.until(ExpectedConditions
                                        .presenceOfElementLocated(By.xpath("//h6[text()='Schedule Interview']")));

                        // Título de la entrevista
                        WebElement interviewTitle = wait.until(ExpectedConditions.presenceOfElementLocated(
                                        By.xpath("//label[text()='Interview Title']/following::input[1]")));
                        interviewTitle.sendKeys("Technical Round");

                        // Escribir una letra en el campo "Interviewer"
                        WebElement interviewerField = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//label[text()='Interviewer']/following::input[1]")));
                        interviewerField.sendKeys("J");

                        // Agregar tiempo para esperar que el listado aparezca
                        Thread.sleep(2000); // Esperar 2 segundos

                        // Esperar que aparezca el listado desplegable
                        WebElement firstOption = wait.until(ExpectedConditions.presenceOfElementLocated(
                                        By.xpath("//div[@role='listbox']//div[contains(@class,'oxd-autocomplete-option')]")));

                        // Agregar tiempo antes de hacer clic
                        Thread.sleep(1000); // Esperar 1 segundo

                        // Seleccionar la primera opción del listado
                        firstOption.click();

                        // Agregar tiempo después de hacer clic para asegurar que la selección se
                        // registre
                        Thread.sleep(1000); // Esperar 1 segundo

                        System.out.println("Entrevistador seleccionado correctamente.");

                        // Fecha de la entrevista
                        WebElement interviewDate = wait.until(ExpectedConditions.presenceOfElementLocated(
                                        By.xpath("//label[text()='Date']/following::input[1]")));
                        interviewDate.sendKeys("2024-12-10");

                        // Hora de la entrevista
                        WebElement interviewTime = driver
                                        .findElement(By.xpath("//label[text()='Time']/following::input[1]"));
                        interviewTime.sendKeys("10:30");

                        // Notas
                        WebElement interviewNotes = driver
                                        .findElement(By.xpath("//label[text()='Notes']/following::textarea[1]"));
                        interviewNotes.sendKeys("Primera ronda de entrevista técnica.");

                        // Guardar
                        WebElement saveScheduleButton = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//button[text()=' Save ']")));
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
                        saveScheduleButton.click();
                        System.out.println("Formulario 'Schedule Interview' guardado correctamente.");

                        // Navegar a Application Stage
                        wait.until(ExpectedConditions
                                        .presenceOfElementLocated(By.xpath("//h6[text()='Application Stage']")));
                        System.out.println("Vista 'Application Stage' cargada correctamente.");

                        // Buscar el botón "Mark Interview Passed" y hacer clic
                        WebElement markInterviewPassedButton = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//button[text()=' Mark Interview Passed ']")));
                        markInterviewPassedButton.click();
                        System.out.println("Botón 'Mark Interview Passed' ejecutado correctamente.");

                        // Navegar a "Mark Interview Passed"
                        wait.until(ExpectedConditions
                                        .presenceOfElementLocated(By.xpath("//h6[text()='Mark Interview Passed']")));
                        System.out.println("Vista 'Mark Interview Passed' cargada correctamente.");

                        // Llenar el campo "Notes"
                        WebElement notesField = wait.until(ExpectedConditions.presenceOfElementLocated(
                                        By.xpath("//label[text()='Notes']/following::textarea[1]")));
                        notesField.sendKeys("El candidato aprobó la entrevista técnica con un buen desempeño.");
                        System.out.println("Notas completadas en 'Mark Interview Passed'.");

                        // Validar y hacer clic en el botón "Save"
                        WebElement saveButton2 = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//button[text()=' Save ']")));
                        saveButton2.click();
                        System.out.println("Formulario 'Mark Interview Passed' guardado correctamente.");

                        // Esperar que la nueva vista "Application Stage" cargue correctamente
                        wait.until(ExpectedConditions.presenceOfElementLocated(
                                        By.xpath("//h6[text()='Application Stage' and following-sibling::hr and ../div[@class='orangehrm-recruitment']]")));
                        System.out.println("Vista 'Application Stage' cargada correctamente.");

                        // Buscar y hacer clic en el botón "Offer Job"
                        WebElement offerJobButton = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//button[text()=' Offer Job ']")));
                        offerJobButton.click();
                        System.out.println("Botón 'Offer Job' ejecutado correctamente.");

                        // Esperar que la vista 'Offer Job' cargue correctamente
                        wait.until(ExpectedConditions.presenceOfElementLocated(
                                        By.xpath("//h6[text()='Offer Job']")));
                        System.out.println("Vista 'Offer Job' cargada correctamente.");

                        // Llenar el campo 'Notes'
                        WebElement offerNotes = wait.until(ExpectedConditions.presenceOfElementLocated(
                                        By.xpath("//label[text()='Notes']/following::textarea[1]")));
                        offerNotes.sendKeys("Candidato seleccionado para la oferta laboral.");
                        System.out.println("Notas completadas en 'Offer Job'.");

                        // Validar y esperar que el botón "Save" esté clickeable antes de hacer clic
                        WebElement offerSaveButton = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//button[text()=' Save ']")));
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
                        offerSaveButton.click();
                        System.out.println("Formulario 'Offer Job' guardado correctamente.");

                        // Esperar que la vista 'Application Stage' con estado 'Job Offered' cargue
                        // correctamente
                        wait.until(ExpectedConditions.presenceOfElementLocated(
                                        By.xpath("//h6[text()='Application Stage' and ../following::div[contains(.,'Status: Job Offered')]]")));
                        System.out.println("Vista 'Application Stage' con estado 'Job Offered' cargada correctamente.");

                        // Buscar y hacer clic en el botón 'Hire'
                        WebElement hireButton = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//button[text()=' Hire ']")));
                        hireButton.click();
                        System.out.println("Botón 'Hire' ejecutado correctamente.");

                } catch (Exception e) {
                        e.printStackTrace();
                } finally {
                        // driver.quit();
                }
        }
}
