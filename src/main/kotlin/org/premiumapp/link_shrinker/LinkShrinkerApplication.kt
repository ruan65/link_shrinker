package org.premiumapp.link_shrinker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LinkShrinkerApplication

fun main(args: Array<String>) {
	runApplication<LinkShrinkerApplication>(*args)
}
