package com.med.voll.api.controller;


import com.med.voll.api.medico.DatosListaMedico;
import com.med.voll.api.paciente.DatosListaPaciente;
import com.med.voll.api.paciente.DatosRegistroPaciente;
import com.med.voll.api.paciente.Paciente;
import com.med.voll.api.paciente.PacienteRepository;
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

    return repository.findAll(paginacion).map(DatosListaPaciente::new);

  }


}
