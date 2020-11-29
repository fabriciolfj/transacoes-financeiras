package com.fabriciolfj.github.limites.api.exceptions

import java.lang.RuntimeException

class LimiteNotFoundException : RuntimeException {

    constructor(msg: String) : super(msg)
}