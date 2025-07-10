package com.med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter                               // Genera de forma automaticas los getter en tiempo de compilacion
@NoArgsConstructor                    // Crea constructor sin ningun argumento
@AllArgsConstructor                   // Genera constructor con todos los atributos de Medico

@Embeddable                       //Para que aparesca en la misma tabla que los datos del Medico
public class Direccion {
    private String calle;
    private String numero;
    private String complemento;
    private String barrio;
    private String codigo_postal;
    private String ciudad;
    private String estado;

    public Direccion(DatosDireccion datosDireccion) {

        this.calle = datosDireccion.calle();
        this.numero = datosDireccion.numero();
        this.complemento = datosDireccion.complemento();
        this.barrio = datosDireccion.barrio();
        this.ciudad = datosDireccion.ciudad();
        this.codigo_postal = datosDireccion.codigo_postal();
        this.estado = datosDireccion.estado();


    }

    public void actualizarDireccion(DatosDireccion datos) {

        if (datos.calle() != null){
            this.calle = datos.calle();
        }

        if (datos.numero() != null){
            this.numero = datos.numero();
        }

        if (datos.complemento() != null){
            this.complemento = datos.complemento();
        }
        if (datos.barrio() != null){
            this.barrio = datos.barrio();
        }

        if (datos.ciudad() != null){
            this.ciudad = datos.ciudad();
        }

        if (datos.codigo_postal() != null){
            this.codigo_postal = datos.codigo_postal();
        }

        if (datos.estado() != null){
            this.estado = datos.estado();
        }

    }
}

