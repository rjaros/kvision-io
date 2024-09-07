package io.kvision.website

import io.kvision.Application
import io.kvision.CoreModule
import io.kvision.FontAwesomeModule
import io.kvision.html.div
import io.kvision.html.link
import io.kvision.module
import io.kvision.panel.root
import io.kvision.require
import io.kvision.startApplication
import kotlinx.browser.window

class App : Application() {
    init {
        require("modules/sass/style.sass")
    }

    override fun start() {
        root("kvapp") {
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
                addAfterInsertHook {
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
    startApplication(::App, module.hot, FontAwesomeModule, CoreModule)
}
