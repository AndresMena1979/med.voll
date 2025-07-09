package com.med.voll.api.paciente;

import  com.med.voll.api.paciente.Paciente;

public record DatosListaPaciente(String nombre,
                                 String email,
                                 String documento ) {


    public DatosListaPaciente(Paciente paciente) {
        this(
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getDocumento()
        );
    }
}
