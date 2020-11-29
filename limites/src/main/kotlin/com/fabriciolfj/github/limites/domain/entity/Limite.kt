package com.fabriciolfj.github.limites.domain.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "limite")
data class Limite(@Id
             @GeneratedValue(strategy = GenerationType.IDENTITY)
             val id: Long,
             @Column(name = "code_cliente") val codeCliente: String,
             @Column(name = "quantidade_saques") val quantidadeSaques: Long,
             @Column(name = "quantidade_transferencia") val quantidadeTransf: Long,
             @Column(name = "volume_diario") val volumeDiario: BigDecimal)