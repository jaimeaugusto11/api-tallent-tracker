package com.synaptech.service;

import com.synaptech.domain.tenant.Tenant;
import com.synaptech.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TenantService {

    @Autowired
    TenantRepository tenantRepository;

     public void findTenantById(Long id) throws Exception {
         this.tenantRepository.findById(id).orElseThrow(()-> new Exception("Empresa não encontrada"));

    }
}
