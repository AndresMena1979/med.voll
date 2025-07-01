package com.med.voll.api.controller;

import com.med.voll.api.medico.DatosRegistroMedido;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController                                  /* Marca esta clase como un controlador REST. Combina @Controller y @ResponseBody, lo que significa
                                                    que los métodos devuelven datos directamente como JSON. */

@RequestMapping("/medicos")                       //Define que todas las rutas de esta clase comienzan con /medicos.

public class MedicoController {

 @PostMapping                                  // Este método responde a solicitudes HTTP POST que lleguen a /medicos

    public void registrar(@RequestBody DatosRegistroMedido datos){  /*@RequestBody DatosRegistroMedido datos: Spring deserializa el cuerpo de la petición
                                                                    (probablemente JSON) y lo convierte en una instancia de DatosRegistroMedido.*/

        System.out.println(datos);
    }
}
