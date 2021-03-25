package com.f3pro.fullstackweek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f3pro.fullstackweek.domain.GruposPrioridades;

@Repository
public interface GrupoPrioridadeRepository extends JpaRepository<GruposPrioridades, Long> {

}
