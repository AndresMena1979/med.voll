package com.med.voll.api.paciente;

import com.med.voll.api.direccion.DatosDireccion;

public record DatosRegistroPaciente(String nombre, String email, String telefono, String documento, DatosDireccion direccion) {
}
