package io.kvision

import pl.treksoft.kvision.core.Container
import pl.treksoft.kvision.html.*
import pl.treksoft.kvision.utils.rem

fun Container.section(section: Section) {
    link("") {
        id = section.id
    }
    section(className = "section is-medium") {
        div(className = "container") {
            div(className = "columns") {
                div(className = "column is-centered-tablet-portrait") {
                    h1(section.title, className = "title section-title")
                    h3(section.subtitle, className = "subtitle is-5 is-muted")
                    div(className = "divider")
                    div(className = "mt-50 has-text-centered") {
                        image(section.image, "")
                    }
                }
                div(className = "column is-7") {
                    section.articles.forEach {
                        article(it, section.articleMarginClass)
                    }
                }
            }
        }
    }
}

fun Container.article(article: Article, marginClass: String) {
    customTag("article", className = "media icon-box") {
        tag(TAG.FIGURE, className = "media-left is-hidden-mobile") {
            p(className = "image") {
                image(article.image, "")
            }
        }
        div(className = "media-content $marginClass") {
            div(className = "content") {
                marginBottom = 1.rem
                p {
                    span(article.title, className = "icon-box-title")
                }
                span(marked(article.text), rich = true)
            }
        }
    }
}
