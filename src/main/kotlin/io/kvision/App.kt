package io.kvision

import kotlinx.browser.window
import pl.treksoft.kvision.Application
import pl.treksoft.kvision.html.div
import pl.treksoft.kvision.html.link
import pl.treksoft.kvision.module
import pl.treksoft.kvision.panel.ContainerType
import pl.treksoft.kvision.panel.root
import pl.treksoft.kvision.require
import pl.treksoft.kvision.startApplication

class App : Application() {
    init {
        require("sass/style.sass")
    }

    override fun start() {
        root("kvapp", ContainerType.NONE, addRow = false) {
            hero()
            Config.sections.forEach {
                section(it)
            }
            useCases()
            footer()
            div {
                id = "backtotop"
                link("", "#", icon = "fas fa-chevron-up")
            }
            div {
                afterInsertHook = {
                    handleBurgerClick()
                    handleScroll()
                    SmoothScroll("a[href*=\"#\"]")
                }
            }
        }
        window.onload = { onLoad() }
    }
}

fun main() {
    startApplication(::App, module.hot)
}
