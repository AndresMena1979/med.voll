package com.med.voll.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MedicoRepository extends JpaRepository<Medico,Long> {


    Page<Medico> findAllByActivoTrue(Pageable paginacion);         // permite mostrar los elementos de la base de datos que tengan en true el campo activo
}
