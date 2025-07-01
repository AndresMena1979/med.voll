package com.med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
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
}
