// Paquete base del proyecto donde se agrupan las clases relacionadas con la aplicación de crepas.
package com.dosideas.crepas;

// Importaciones necesarias para configurar la seguridad con Spring Security.
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Clase de configuración de seguridad para la aplicación "La Esquina de las
 * Crepas". Define las reglas de autenticación y autorización para las rutas y
 * recursos protegidos.
 */
@Configuration                // Indica que esta clase contiene definiciones de Beans para el contexto de Spring.
@EnableWebSecurity            // Habilita la seguridad web en la aplicación.
public class SecurityConfig {

    /**
     * Define un bean que implementa PasswordEncoder usando el algoritmo BCrypt.
     * BCrypt es ideal para almacenar contraseñas de forma segura, aplicando
     * hashing con sal (salt).
     *
     * @return una instancia de BCryptPasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configura la cadena de filtros de seguridad HTTP. Aquí se definen qué
     * rutas están protegidas, cómo se maneja el inicio/cierre de sesión, y qué
     * recursos son públicos.
     *
     * @param http instancia de HttpSecurity para definir reglas de seguridad
     * @return un objeto SecurityFilterChain con las reglas aplicadas
     * @throws Exception si ocurre un error durante la configuración
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Define las reglas de autorización para las peticiones HTTP
                .authorizeHttpRequests(auth -> auth
                // Permite acceso libre a la página de login y recursos estáticos (CSS, JS, imágenes)
                .requestMatchers("/login", "/css/**", "/js/**", "/img/**").permitAll()
                // Cualquier otra ruta requiere que el usuario esté autenticado
                .anyRequest().authenticated()
                )
                // Configura el comportamiento del formulario de login
                .formLogin(form -> form
                // Ruta personalizada para mostrar el formulario de login
                .loginPage("/login")
                // Ruta a la que se redirige después de un login exitoso
                .defaultSuccessUrl("/", true)
                .permitAll() // Permite acceder a la página de login sin autenticación previa
                )
                // Configura el comportamiento de logout (cerrar sesión)
                .logout(logout -> logout.permitAll() // Permite que cualquier usuario autenticado pueda cerrar sesión
                );

        // Retorna la cadena de filtros con la configuración establecida
        return http.build();
    }
}
