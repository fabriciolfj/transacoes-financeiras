package com.fabriciolfj.github.limites.api.controller

import com.fabriciolfj.github.limites.api.dto.request.LimiteRequest
import com.fabriciolfj.github.limites.api.dto.response.LimiteResponse
import com.fabriciolfj.github.limites.domain.service.LimiteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/limites")
class LimiteController {

    @Autowired
    lateinit var limiteService: LimiteService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@RequestBody limiteRequest: LimiteRequest) {
        limiteService.save(limiteRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun findAll() : List<LimiteResponse> {
        return limiteService.findAll()
    }

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun findById(@PathVariable("code") code: String) : LimiteResponse {
        return limiteService.findByCode(code)
    }

    @PutMapping("/{code}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun update(@RequestBody limiteRequest: LimiteRequest, @PathVariable("code") code: String) : LimiteResponse {
        return limiteService.update(limiteRequest, code)
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("code") code: String) {
        limiteService.delete(code)
    }
}