package com.med.voll.api.medico;

import com.med.voll.api.direccion.Direccion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity (name = "Medicos")

// lombock -------------------

@Getter                               // Genera de forma automaticas los getter en tiempo de compilacion
@NoArgsConstructor                    // Crea constructor sin ningun argumento
@AllArgsConstructor                   // Genera constructor con todos los atributos de Medico
@EqualsAndHashCode(of = "id")         // identifica que dos objectos son iguales si el id es igual
//----------------------------------------------



public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documento;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Embedded                                      //Para que aparesca en la misma tabla que los datos del Medico
    private Direccion direccion;

    public Medico(DatosRegistroMedido datos){

       this.id = null;
       this.nombre = datos.nombre();
       this.email= datos.email();
       this.documento = datos.documento();
       this.especialidad = datos.especialidad();
       this.direccion = new Direccion (datos.direccion());
    }

}
