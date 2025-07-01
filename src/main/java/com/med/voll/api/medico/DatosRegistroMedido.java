package com.med.voll.api.medico;

import com.med.voll.api.direccion.DatosDireccion;

public record DatosRegistroMedido(String nombre, String email, String documento, Especialidad especialidad, DatosDireccion direccion) {
}
