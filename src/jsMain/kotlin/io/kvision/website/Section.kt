package io.kvision.website

import io.kvision.core.Container
import io.kvision.html.article
import io.kvision.html.div
import io.kvision.html.figure
import io.kvision.html.h1
import io.kvision.html.h3
import io.kvision.html.iframe
import io.kvision.html.image
import io.kvision.html.link
import io.kvision.html.p
import io.kvision.html.section
import io.kvision.html.span
import io.kvision.utils.rem

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
                    section.articles?.forEach {
                        article(it, section.marginClass)
                    }
                    section.videos?.forEach {
                        video(it, section.marginClass)
                    }
                }
            }
        }
    }
}

fun Container.article(article: Article, marginClass: String) {
    article(className = "media icon-box") {
        figure(className = "media-left is-hidden-mobile") {
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
                span(parse(article.text), rich = true)
            }
        }
    }
}

fun Container.video(video: Video, marginClass: String) {
    article(className = "media icon-box") {
        div(className = "media-content $marginClass") {
            div(className = "content") {
                marginBottom = 1.rem
                p {
                    span(video.title, className = "icon-box-title")
                    +video.description
                }
                iframe("https://www.youtube.com/embed/${video.url}", iframeWidth = 560, iframeHeight = 315) {
                    title = "YouTube video player"
                    setAttribute("frameborder", "0")
                    setAttribute(
                        "allow",
                        "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                    )
                    setAttribute("allowfullscreen", "allowfullscreen")
                }
            }
        }
    }
}
