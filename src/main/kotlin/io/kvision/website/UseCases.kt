package io.kvision.website

import io.kvision.core.Container
import io.kvision.html.TAG
import io.kvision.html.div
import io.kvision.html.h2
import io.kvision.html.h3
import io.kvision.html.image
import io.kvision.html.link
import io.kvision.html.section
import io.kvision.html.tag

fun Container.useCases() {
    link("") {
        id = UseCases.id
    }
    section(className = "section is-medium section-secondary") {
        div(className = "container") {
            div(className = "title-wrapper has-text-centered") {
                h2(UseCases.title, className = "title is-2 light-text is-spaced")
                h3(UseCases.subtitle, className = "subtitle is-5 light-text")
            }
            div(className = "content-wrapper") {
                div(className = "columns is-vcentered") {
                    UseCases.useCases1.forEach {
                        useCase(it, 4)
                    }
                }
                div(className = "columns is-vcentered") {
                    UseCases.useCases2.forEach {
                        useCase(it, 6)
                    }
                }
            }
        }
    }
}

fun Container.useCase(useCase: UseCase, size: Int = 4) {
    div(className = "column is-$size mt-30") {
        tag(TAG.FIGURE, className = "testimonial") {
            div(className = "box has-text-centered") {
                link("", useCase.url) {
                    setAttribute("target", "_blank")
                    tag(TAG.FIGURE, className = "image is-inline-block") {
                        image(useCase.image, "")
                        tag(TAG.FIGCAPTION, useCase.caption)
                    }
                }
            }
        }
    }
}
