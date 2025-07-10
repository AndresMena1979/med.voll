package com.med.voll.api.controller;


import com.med.voll.api.medico.DatosActualizacionMedico;
import com.med.voll.api.medico.DatosListaMedico;
import com.med.voll.api.paciente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/paciente")


public class PacienteController {

  @Autowired


  private PacienteRepository repository;

    @Transactional  //Para poder modificar o agregar datos a la base de datos (Transactional de Spring)

    @PostMapping

    public void registrar(@RequestBody @Valid DatosRegistroPaciente datos) {  /*@RequestBody DatosRegistroMedido datos: Spring deserializa el cuerpo de la petición
                                                                            (probablemente JSON) y lo convierte en una instancia de DatosRegistroMedido.*/
        // El @Valid le dice a spring que mire las validaciones que tiene los campos de DatosRegistroMedico

        repository.save(new Paciente(datos));                 // Almacena los datos cuando usamos el JPA repository
        // Al recibir datos que es de tipo registro paciente, debemos hacer una conversion porque queremos usar la clase Medico
        // para esto se crea un constructor en la clase Medicos
        // System.out.println(datos);

    }

  @GetMapping
  public Page<DatosListaPaciente> listar (@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion) {

   // return repository.findAll(paginacion).map(DatosListaPaciente::new);
    return repository.findAllByActivoTrue(paginacion).map(DatosListaPaciente::new);    //Se crea el metodo findAllByActivoTrue que no existe en el repositorio JPA

  }

  @Transactional  //Para poder modificar o agregar datos a la base de datos (Transactional de Spring)

  @PutMapping     // Para actualizar datos en la base de datos

  public void actualizar(@RequestBody @Valid DatosActualizacionPaciente datos) {

    var paciente = repository.getReferenceById(datos.id());  // para obtener al medico de la base de datos

    paciente.actualizarInformaciones(datos);

// Ahora para actualizar los cambios en la base de datos, gracias al @Transactional, no hay necesidad de llamar repository.save


  }
  @Transactional
  @DeleteMapping("/{id}")

  public void eliminar(@PathVariable Long id) {   //@PathVariable indica que String id es mismo id del @DeleteMapping ("/{id}")

    // repository.deleteById(id);                 // Borra el médico de la base de datos de forma fisica

    var paciente = repository.getReferenceById(id);  // obtenermos el medico de la base de datos

    paciente.eliminar();   // Se crea el metodo eliminar

  }

}
