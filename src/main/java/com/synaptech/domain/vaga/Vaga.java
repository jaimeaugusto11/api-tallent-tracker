package com.synaptech.domain.vaga;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "vaga")
@Table(name = "vaga")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenantId;
    private String titulo;
    private String Descrição;

    private BigDecimal salario;
    @Enumerated(EnumType.STRING)
    private SalarioPor periodo;
    private String local;
    private Integer quantidade;
    private String pais;
    private String provincia;
    private String cidade;
    private Integer cargaHoraria;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createAt = LocalDateTime.now();
}
