package com.fabriciolfj.github.limites.domain.service

import com.fabriciolfj.github.limites.api.dto.request.LimiteRequest
import com.fabriciolfj.github.limites.api.dto.response.LimiteResponse
import com.fabriciolfj.github.limites.api.exceptions.LimiteNotFoundException
import com.fabriciolfj.github.limites.api.mapper.LimiteMapper
import com.fabriciolfj.github.limites.domain.entity.Limite
import com.fabriciolfj.github.limites.domain.repository.LimiteRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LimiteService {

    var log = LoggerFactory.getLogger(LimiteService::class.java)

    @Autowired
    lateinit var limiteRepository: LimiteRepository

    @Autowired
    lateinit var mapper: LimiteMapper

    fun save(limiteRequest: LimiteRequest) {
        limiteRepository.save(toEntity(limiteRequest))
    }

    fun findByCode(code: String) : LimiteResponse {
        return limiteRepository.findByCodeCliente(code)
                .map { mapper.toResponse(it) }
                .orElseThrow{ LimiteNotFoundException("Limite não encontrado para o cliente: $code")}
    }

    fun delete(code: String) {
        limiteRepository.findByCodeCliente(code)
                .map { limiteRepository.delete(it) }
                .orElseThrow{ LimiteNotFoundException("Limite não encontrado para o cliente: $code")}
    }

    fun findAll() : List<LimiteResponse> {
        return limiteRepository.findAll()
                .map {
                    log.info(it.toString())
                    mapper.toResponse(it)
                }
    }

    fun update(limiteRequest: LimiteRequest, code: String) : LimiteResponse {
        return limiteRepository.findByCodeCliente(code)
                .map {
                    BeanUtils.copyProperties(toEntity(limiteRequest), it, "id")
                    limiteRepository.save(it)
                }.map { mapper.toResponse(it) }
                .orElseThrow{ LimiteNotFoundException("Limite não encontrado para o cliente: $code")}
    }

    private fun toEntity(limiteRequest: LimiteRequest) : Limite {
        return mapper.toEntity(limiteRequest);
    }
}