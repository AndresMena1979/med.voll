package com.med.voll.api.paciente;

import com.med.voll.api.direccion.Direccion;
import com.med.voll.api.medico.DatosActualizacionMedico;
import com.med.voll.api.medico.DatosRegistroMedido;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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
    private boolean activo;
    @Embedded                                      //Para que aparesca en la misma tabla que los datos del Medico
    private Direccion direccion;


    public Paciente (DatosRegistroPaciente datos){

        this.id = null;
        this.activo = true;
        this.nombre = datos.nombre();
        this.email= datos.email();
        this.telefono = datos.telefono();
        this.documento = datos.documento();
        this.direccion = new Direccion (datos.direccion());
    }

    public void actualizarInformaciones(@Valid DatosActualizacionPaciente datos) {
        if (datos.nombre() != null) {            // COnfirmar que no sea null para que no borre los datos en la base de datos
            this.nombre= datos.nombre();
        }

        if (datos.telefono() != null) {
            this.nombre= datos.telefono();
        }

        if (datos.direccion() != null) {
            this.direccion.actualizarDireccion(datos.direccion());

        }
}




    public void eliminar() {
        this.activo = false;

    }
}
