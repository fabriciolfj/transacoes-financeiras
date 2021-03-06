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
             @Column(name = "volume_diario") val volumeDiario: BigDecimal) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Limite

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}