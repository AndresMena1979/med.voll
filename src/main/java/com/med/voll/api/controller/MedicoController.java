package com.med.voll.api.controller;

import com.med.voll.api.medico.*;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.ModCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

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

    public void registrar(@RequestBody @Valid DatosRegistroMedido datos) {  /*@RequestBody DatosRegistroMedido datos: Spring deserializa el cuerpo de la petición
                                                                            (probablemente JSON) y lo convierte en una instancia de DatosRegistroMedido.*/
        // El @Valid le dice a spring que mire las validaciones que tiene los campos de DatosRegistroMedico

        repository.save(new Medico(datos));                 // Almacena los datos cuando usamos el JPA repository
        // Al recibir datos que es de tipo registro medico, debemos hacer una conversion porque queremos usar la clase Medico
        // para esto se crea un constructor en la clase Medicos
        // System.out.println(datos);

    }

    //--------------------------------Get para consultar Lista medico
    @GetMapping
    public Page<DatosListaMedico> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {

       // return repository.findAll(paginacion).map(DatosListaMedico::new);
        return repository.findAllByActivoTrue(paginacion).map(DatosListaMedico::new);    //Se crea el metodo findAllByActivoTrue que no existe en el repositorio JPA

    }

    @Transactional  //Para poder modificar o agregar datos a la base de datos (Transactional de Spring)

    @PutMapping     // Para actualizar datos en la base de datos

    public void actualizar(@RequestBody @Valid DatosActualizacionMedico datos) {

        var medico = repository.getReferenceById(datos.id());  // para obtener al medico de la base de datos

        medico.actualizarInformaciones(datos);

// Ahora para actualizar los cambios en la base de datos, gracias al @Transactional, no hay necesidad de llamar repository.save


    }

    @Transactional
    @DeleteMapping("/{id}")

    public void eliminar(@PathVariable Long id) {   //@PathVariable indica que String id es mismo id del @DeleteMapping ("/{id}")

        // repository.deleteById(id);                 // Borra el médico de la base de datos de forma fisica

        var medico = repository.getReferenceById(id);  // obtenermos el medico de la base de datos

        medico.eliminar();   // Se crea el metodo eliminar
    }
}
