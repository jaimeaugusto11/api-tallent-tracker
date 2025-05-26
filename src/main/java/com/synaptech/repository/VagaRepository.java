package com.synaptech.repository;

import com.synaptech.domain.vaga.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
    List<Vaga> findByTenantId(String tenantId);
    List<Vaga> findByCidade(String cidade);
    List<Vaga> findByTituloContainingIgnoreCase(String titulo);
}

