package com.xlinks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.modulith.Modulith

@SpringBootApplication
@Modulith(systemName = "xlinks")
class XlinksApplication

fun main(args: Array<String>) {
    runApplication<XlinksApplication>(*args)
}