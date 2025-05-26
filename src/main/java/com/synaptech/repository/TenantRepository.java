package com.synaptech.repository;

import com.synaptech.domain.tenant.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantRepository extends JpaRepository<Tenant, Long> {


    Optional<Tenant> findById(Long id);

    Optional<Tenant> findByTenantNif(String tenantNif);
}
