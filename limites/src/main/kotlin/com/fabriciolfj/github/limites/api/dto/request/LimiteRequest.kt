package com.fabriciolfj.github.limites.api.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import javax.persistence.*

data class LimiteRequest (@JsonProperty("cod_cliente") val codeCliente: String,
                     @JsonProperty("quantidade_saques") val quantidadeSaques: Long,
                     @JsonProperty("quantidade_transf") val quantidadeTransf: Long,
                     @JsonProperty("volume_diario") val volumeDiario: BigDecimal)