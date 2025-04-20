package io.kvision.website

import io.kvision.Application
import io.kvision.CoreModule
import io.kvision.FontAwesomeModule
import io.kvision.Hot
import io.kvision.html.div
import io.kvision.html.link
import io.kvision.panel.root
import io.kvision.startApplication
import io.kvision.utils.useModule
import kotlinx.browser.window
import kotlin.js.unsafeCast

@JsModule("/kotlin/modules/sass/style.sass")
external val styleSass: dynamic

class App : Application() {
    init {
        useModule(styleSass)
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
    startApplication(::App, js("import.meta.webpackHot").unsafeCast<Hot?>(), FontAwesomeModule, CoreModule)
}
