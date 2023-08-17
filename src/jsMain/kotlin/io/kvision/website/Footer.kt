package io.kvision.website

import io.kvision.core.Container
import io.kvision.html.*
import io.kvision.html.icon
import io.kvision.utils.px

fun Container.footer() {
    footer(className = "footer footer-dark") {
        div(className = "container") {
            div(className = "columns") {
                div(className = "column") {
                    div(className = "footer-logo") {
                        image(Footer.logo, "")
                    }
                }
                Footer.columns.forEach {
                    column(it)
                }
                div(className = "column") {
                    div(className = "footer-column") {
                        div(className = "footer-header") {
                            h3(Footer.joinUs.title)
                            nav(className = "level is-mobile") {
                                div(className = "level-left") {
                                    Footer.joinUs.links.forEach { (url, icon) ->
                                        link("", url, className = "level-item") {
                                            marginRight = 25.px
                                            span(className = "icon") {
                                                icon(icon)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun Container.column(footerColumn: FooterColumn) {
    div(className = "column") {
        div(className = "footer-column") {
            div(className = "footer-header") {
                h3(footerColumn.title)
            }
            ul(className = "link-list") {
                footerColumn.links.forEach { (url, title) ->
                    li {
                        link(title, url)
                    }
                }
            }
        }
    }
}
