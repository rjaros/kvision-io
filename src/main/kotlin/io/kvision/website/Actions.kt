package io.kvision.website

import kotlinx.browser.window
import io.kvision.jquery.invoke
import io.kvision.jquery.jQuery
import io.kvision.utils.obj

fun onLoad() {
    jQuery("#status").fadeOut()
    jQuery("#preloader").delay(350).fadeOut("slow")
    @Suppress("UnsafeCastFromDynamic")
    jQuery("body").delay(350).css(obj { overflow = "visible" })
}

fun handleBurgerClick() {
    jQuery(".navbar-burger").on("click") { e, _ ->
        val menuId = jQuery(e.target).attr("data-target")
        jQuery(e.target).toggleClass("is-active")
        jQuery("#$menuId").toggleClass("is-active")
        jQuery(".navbar.is-light").toggleClass("is-dark-mobile")
    }
}

fun handleScroll() {
    val winHeightPadded = jQuery(window).height().toInt() * 1.1
    val pxShow = 600
    jQuery(window).scroll {
        val height = jQuery(window).scrollTop().toInt()
        if (height > 50) {
            jQuery("#navbar-clone").addClass("is-active")
        } else {
            jQuery("#navbar-clone").removeClass("is-active")
        }
        jQuery(".revealOnScroll:not(.animated)").each { _, element ->
            val self = jQuery(element)
            val offsetTop = self.offset().top.toInt()

            if (height + winHeightPadded > offsetTop) {
                if (self.data("timeout") != undefined) {
                    window.setTimeout({
                        self.addClass("animated " + self.data("animation"))
                    }, self.data("timeout").toString().toInt())
                } else {
                    self.addClass("animated " + self.data("animation"))
                }
            }
        }
        if (height >= pxShow) {
            jQuery("#backtotop").addClass("visible")
        } else {
            jQuery("#backtotop").removeClass("visible")
        }
    }
}
