// Paquete principal del proyecto que agrupa las clases relacionadas con la aplicación de crepas.
package com.dosideas.crepas;

// Importa la clase que lanza la aplicación Spring Boot.
import org.springframework.boot.SpringApplication;

// Importa la anotación que marca esta clase como el punto de inicio de una aplicación Spring Boot.
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación "La Esquina de las Crepas". Esta clase sirve
 * como punto de entrada para iniciar toda la aplicación Spring Boot.
 *
 * La anotación @SpringBootApplication combina tres anotaciones importantes: -
 * @Configuration: Permite registrar beans en el contexto de Spring. -
 * @EnableAutoConfiguration: Habilita la configuración automática basada en las
 * dependencias del classpath. - @ComponentScan: Escanea el paquete actual y sus
 * subpaquetes en busca de componentes (@Component, @Service, @Repository,
 * @Controller, etc.).
 */
@SpringBootApplication
public class CrepasApplication {

    /**
     * Método principal (main), el punto de entrada estándar de una aplicación
     * Java.
     *
     * SpringApplication.run(...) inicializa el contexto de Spring, configura
     * beans, escanea componentes y arranca el servidor embebido (como Tomcat).
     *
     * @param args Argumentos que pueden ser pasados por consola al ejecutar la
     * app (opcional).
     */
    public static void main(String[] args) {
        SpringApplication.run(CrepasApplication.class, args);
    }
}
