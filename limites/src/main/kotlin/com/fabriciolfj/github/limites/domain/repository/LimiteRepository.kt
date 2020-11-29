package com.fabriciolfj.github.limites.domain.repository

import com.fabriciolfj.github.limites.domain.entity.Limite
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface LimiteRepository : JpaRepository<Limite, Long> {

    fun findByCodeCliente(code: String) : Optional<Limite>
}