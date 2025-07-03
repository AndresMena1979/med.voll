package com.med.voll.api.controller;



import com.med.voll.api.paciente.DatosRegistroPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/paciente")

public class PacienteController {

    @PostMapping

    public void registraPaciente(@RequestBody DatosRegistroPaciente datosPaciente){

        System.out.println(datosPaciente);
    }

}
//---------------
