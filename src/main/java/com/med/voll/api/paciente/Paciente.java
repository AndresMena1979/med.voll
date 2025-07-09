package com.med.voll.api.paciente;

import com.med.voll.api.direccion.Direccion;
import com.med.voll.api.medico.DatosRegistroMedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity (name = "Pacientes")

// lombock -------------------

@Getter                               // Genera de forma automaticas los getter en tiempo de compilacion
@NoArgsConstructor                    // Crea constructor sin ningun argumento
@AllArgsConstructor                   // Genera constructor con todos los atributos de Medico
@EqualsAndHashCode(of = "id")         // identifica que dos objectos son iguales si el id es igual
//--------------------

public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;

    @Embedded                                      //Para que aparesca en la misma tabla que los datos del Medico
    private Direccion direccion;

    public Paciente (DatosRegistroPaciente datos){

        this.id = null;
        this.nombre = datos.nombre();
        this.email= datos.email();
        this.telefono = datos.telefono();
        this.documento = datos.documento();
        this.direccion = new Direccion (datos.direccion());
    }

}
