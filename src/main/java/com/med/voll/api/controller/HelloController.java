package com.med.voll.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                     // Marca la clase como un controlador REST.
                                    /* Indica que esta clase es un controlador REST. Combina dos cosas:
                                       @Controller: Le dice a Spring que esta clase maneja peticiones web.
                                       @ResponseBody: Hace que el valor devuelto por los métodos se escriba directamente
                                       en el cuerpo de la respuesta (por ejemplo, un string o JSON).*/

@RequestMapping("/hello")           //: Asocia una URL base al controlador.
                                    /* Establece una URL base para este controlador. Es decir, todos los métodos dentro
                                     de la clase responderán a rutas que empiecen con /hello. */
public class HelloController {
@GetMapping                         //  Asocia un método con peticiones HTTP GET.
                                    //  @GetMapping: Este método se ejecutará cuando alguien haga una petición GET a /hello.
    public String hello(){

        return "Hello World";
    }


}
