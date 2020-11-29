package com.fabriciolfj.github.limites.api.mapper

import com.fabriciolfj.github.limites.api.dto.request.LimiteRequest
import com.fabriciolfj.github.limites.api.dto.response.LimiteResponse
import com.fabriciolfj.github.limites.domain.entity.Limite
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "string")
interface LimiteMapper {

    @Mapping(target = "id", ignore = true)
    fun toEntity(limiteRequest: LimiteRequest) : Limite

    fun toResponse(limite: Limite) : LimiteResponse
}