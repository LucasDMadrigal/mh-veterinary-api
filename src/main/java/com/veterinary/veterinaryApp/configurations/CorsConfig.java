package com.veterinary.veterinaryApp.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig { // Cros origin resorcuse sherin restringe las paginas web de hacer solicitudes a un dominio diferente a un dominio diferente que sirvió la pagina web original

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173", ""));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE")); // setiamos que metodosgit
        configuration.setAllowedHeaders(List.of("*")); //Lista de todos los headers que nos puedan mandar
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); //Fuente de configuraciones para las rutas
        source.registerCorsConfiguration("/**", configuration); // que rutas de nuestra app pueden pegarle
        return source; //retorna esto para que se apliquen estas configuraciones en los  cors
    }


}
