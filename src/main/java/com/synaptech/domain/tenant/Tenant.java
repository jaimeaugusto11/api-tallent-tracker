package com.synaptech.domain.tenant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Tenant")
@Table(name = "Tenant")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenantName;
    @Column(unique = true)
    private String tenantNif;
    @Column(unique = true)
    private String email;
    private String logoImage;
    @Column(unique = true)
    private String domain;
}
