package io.kvision.website

import io.kvision.require

@Suppress("UnsafeCastFromDynamic")
val markedInline: (String) -> String = require("marked").parseInline

@Suppress("UnsafeCastFromDynamic")
val marked: (String) -> String = require("marked")
