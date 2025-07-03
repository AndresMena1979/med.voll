package com.med.voll.api.controller;

import com.med.voll.api.medico.DatosRegistroMedido;
import com.med.voll.api.medico.Medico;
import com.med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController                                  /* Marca esta clase como un controlador REST. Combina @Controller y @ResponseBody, lo que significa
                                                    que los métodos devuelven datos directamente como JSON. */

@RequestMapping("/medicos")                       //Define que todas las rutas de esta clase comienzan con /medicos.

public class MedicoController {

    @Autowired               /* se usa para inyectar dependencias automáticamente. En tu código, @Autowired le dice a Spring:
                               “Busca un objeto del tipo MedicoRepository en el contenedor y asígnalo a esta variable”. Ya no hay que hace
                               este proceso:  public MedicoController(MedicoRepository repository) {
                                                      this.repository = repository;
                                                }*/

    private MedicoRepository repository;

@Transactional  //Para poder modificar o agregar datos a la base de datos (Transactional de Spring)

 @PostMapping                                  // Este método responde a solicitudes HTTP POST que lleguen a /medicos

    public void registrar(@RequestBody DatosRegistroMedido datos){  /*@RequestBody DatosRegistroMedido datos: Spring deserializa el cuerpo de la petición
                                                                    (probablemente JSON) y lo convierte en una instancia de DatosRegistroMedido.*/

     repository.save(new Medico(datos));                 // Almacena los datos cuando usamos el JPA repository
                                            // Al recibir datos que es de tipo registro medico, debemos hacer una conversion porque queremos usar la clase Medico
                                            // para esto se crea un constructor en la clase Medicos
       // System.out.println(datos);

    }
}
