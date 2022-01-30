package io.kvision.website

import io.kvision.require

object Navbar {
    val title = "KVision"
    val menu =
        mapOf("features" to "Features", "examples" to "Examples", "docs" to "Documentation", "showcases" to "Showcases")
    val starLabel = "Star rjaros/kvision on GitHub"
}

object Hero {
    val version = "5.8.0"
    val releasesUrl = "https://github.com/rjaros/kvision/releases"
    @Suppress("UnsafeCastFromDynamic")
    val logo: String = require("images/logos/kvision.svg")
    val logoAlt = "KVision logo"
    val title = "KVision - object oriented web framework for Kotlin/JS"
    val subtitle =
        "Build modern web applications with the full power of the Kotlin language. Choose **yourself** the preferred way."
    val buttonText = "Get started"
    val buttonLink = "https://kvision.gitbook.io/kvision-guide/1.-getting-started-1"
    val reactiveHello = """
class App : Application() {

    val state = ObservableValue("Hello reactive world")

    override fun start() {
        root("root") {
            vPanel {
                h1().bind(state) {
                    +it
                }
                button("Add an exclamation mark").onClick {
                    state.value += "!"
                }
            }
        }
    }
}

fun main() {
    startApplication(::App, module.hot)
}
    """.trimIndent()

    val imperativeHello = """
class App : Application() {

    override fun start() {
        root("root") {
            vPanel {
                val helloHeader = h1("Hello imperative world")
                button("Add an exclamation mark").onClick {
                    helloHeader.content += "!"
                }
            }
        }
    }
}

//
// Sometimes old school imperative way is perfectly fine :-)
//

fun main() {
    startApplication(::App, module.hot)
}
    """.trimIndent()
}

data class Article(val image: String, val title: String, val text: String)

data class Section(
    val id: String,
    val title: String,
    val subtitle: String,
    val image: String,
    val articles: List<Article>,
    val articleMarginClass: String = "mt-30"
)

@Suppress("UnsafeCastFromDynamic")
object Config {
    val sections = listOf(
        Section(
            "features",
            "Features",
            "Almost 100 ready to use GUI components, used as builder blocks for the application UI",
            require("images/sky.jpg"),
            listOf(
                Article(
                    require("images/illustrations/icons/laptop-globe.svg"),
                    "Solid foundations",
                    """
          - Idiomatic [Kotlin](https://kotlinlang.org/) syntax with type safe DSL builders
          - Both reactive and imperative programming models
          - [Bootstrap 5](https://getbootstrap.com/) styles, typography and components
          - [Snabbdom](https://github.com/snabbdom/snabbdom) fast virtual DOM implementation
          - [Font Awesome](https://fontawesome.com/) icons
          - Unidirectional and bidirectional bindings for Kotlin Flows
          - [Redux](https://redux.js.org/) and [ReduxKotlin](https://reduxkotlin.org/) modules
          - [React](https://reactjs.org/) components and [Onsen UI](https://onsen.io/) mobile web components
          - Internationalization support based on [gettext](https://www.gnu.org/software/gettext/) translations
                    """.trimIndent()
                ),
                Article(
                    require("images/illustrations/icons/doc-sync.svg"),
                    "Rich components library",
                    """
          - Sophisticated layout containers
          - Forms with type safe data model and built-in validation
          - Different text input components including rich text and typeahead
          - Buttons, checkboxes and radios
          - Date and time picker
          - Spinner and range numeric input components
          - Advanced select box with ajax support
          - File upload with preview and multi-selection
          - Advanced charts
          - Reactive tables
          - Navigation bar, toolbar and context menu
          - Tooltips and popovers
          - Modals including ready to use alerts and confirm dialogs
          - Floating, re-sizable windows
          - Configurable toasts
                    """.trimIndent()
                ),
                Article(
                    require("images/illustrations/icons/plug-cloud.svg"),
                    "Fullstack ready",
                    """
          - Innovative connectivity interface for many popular server side frameworks, to build fullstack applications with shared code for data model and business logic
          - Full support for [Ktor](https://ktor.io), [Jooby](https://jooby.io), [Spring Boot](https://spring.io/projects/spring-boot), [Javalin](https://javalin.io), [Vert.x](https://vertx.io) and [Micronaut](https://micronaut.io) frameworks
          - Experimental type safe websockets connections
                    """.trimIndent()
                ),
            )
        ),
        Section(
            "examples",
            "Examples",
            "Explore open source example applications",
            require("images/blocks.jpg"),
            listOf(
                Article(
                    require("images/illustrations/icons/mouse-globe.svg"),
                    "Showcase",
                    """
          A simple application presenting all main features of the KVision framework.

          \[ [Sources](https://github.com/rjaros/kvision-examples/tree/master/showcase) \] \[ [Live demo](https://rjaros.github.io/kvision-examples/showcase/) \]
                    """.trimIndent()
                ),
                Article(
                    require("images/illustrations/icons/doc-sync.svg"),
                    "Fomantic-UI demo",
                    """
          A demo application created with [Fomantic-UI](https://fomantic-ui.com/) toolkit. It shows how to create KVision applications with a modern design system alternative to Bootstrap. It also presents state management based on Kotlin flows (using both StateFlow and SharedFlow).

          \[ [Sources](https://github.com/rjaros/kvision-examples/tree/master/fomantic) \] \[ [Live demo](https://rjaros.github.io/kvision-examples/fomantic/) \]
                    """.trimIndent()
                ),
                Article(
                    require("images/illustrations/icons/laptop-cloud.svg"),
                    "Pokedex PWA",
                    """
          The list of Pokémon with live search, build with the Redux module. It's also a fully compatible [PWA](https://developers.google.com/web/progressive-web-apps/).

          \[ [Sources](https://github.com/rjaros/kvision-examples/tree/master/pokedex) \] \[ [Live demo](https://kvision-pokedex.netlify.com/) \]
                    """.trimIndent()
                ),
                Article(
                    require("images/illustrations/icons/mobile-feed.svg"),
                    "Onsen UI Kitchen Sink",
                    """
          An example mobile application created with KVision's bindings for [Onsen UI](https://onsen.io/) library. It's an almost 1 to 1 rewrite of an official [Vue Kitchen Sink](https://github.com/OnsenUI/vue-onsenui-kitchensink) example. It presents how to use all Onsen UI visual components with fully type safe Kotlin API and DSL builders.

          \[ [Sources](https://github.com/rjaros/kvision-examples/tree/master/onsenui-kitchensink) \] \[ [Live demo with iOS](https://rjaros.github.io/kvision-examples/onsenui-kitchensink/?platform=ios) \] \[ [Live demo with Android](https://rjaros.github.io/kvision-examples/onsenui-kitchensink/?platform=android) \]
                    """.trimIndent()
                ),
                Article(
                    require("images/illustrations/icons/plug-cloud.svg"),
                    "Fullstack address book",
                    """
          A complete, fullstack address book application. It presents an innovative way to build fullstack applications with KVision and [Ktor](https://ktor.io), [Jooby](https://jooby.io), [Spring Boot](https://spring.io/projects/spring-boot), [Javalin](https://javalin.io), [Vert.x](https://vertx.io) or [Micronaut](https://micronaut.io) frameworks.

          \[ [Spring Boot version sources](https://github.com/rjaros/kvision-examples/tree/master/addressbook-fullstack-spring-boot) \] \[ [Live demo on Heroku](https://kvision-address-book.herokuapp.com/) \]
                    """.trimIndent()
                ),
                Article(
                    require("images/illustrations/icons/doc-sync.svg"),
                    "RealWorld example application",
                    """
          A fully fledged fullstack application based on [RealWorld project](https://realworld.io/) specification, supporting CRUD operations, authentication, routing, pagination, and more.

          \[ [Frontend version sources](https://github.com/rjaros/kvision-realworld-example-app) \] \[ [Live demo](https://rjaros.github.io/kvision-realworld-example-app/) \]

          \[ [Fullstack version sources](https://github.com/rjaros/kvision-realworld-example-app-fullstack) \] \[ [Live demo on Heroku](https://kvision-realworld-fullstack.herokuapp.com/) \]
                    """.trimIndent()
                ),
                Article(
                    require("images/illustrations/icons/kvision.svg"),
                    "KVision website",
                    """
          This website is created with KVision. The Kotlin sources are available on GitHub.

          \[ [Open project](https://github.com/rjaros/kvision-io) \]
                    """.trimIndent()
                ),
                Article(
                    require("images/illustrations/icons/laptop-globe.svg"),
                    "More examples and templates",
                    """
          More examples and templates are available in the dedicated GitHub repostitory.

          \[ [Open project](https://github.com/rjaros/kvision-examples) \]
                    """.trimIndent()
                ),
            ), "mt-20"
        ),
        Section(
            "docs",
            "Documentation",
            "Comprehensive source of information",
            require("images/books.jpg"),
            listOf(
                Article(
                    require("images/illustrations/icons/laptop-cloud.svg"),
                    "KVision Guide",
                    """
          The guide is published on GitBook. It contains all information about the framework, its components and typical use cases.

          \[ [Open the guide](https://kvision.gitbook.io/kvision-guide/) \]
                    """.trimIndent()
                ),
                Article(
                    require("images/illustrations/icons/doc-sync.svg"),
                    "API documentation",
                    """
          It's generated directly from the source codes with Dokka 1.6 tool.

          \[ [API docs](https://rjaros.github.io/kvision/index.html) \]
                    """.trimIndent()
                ),
                Article(
                    require("images/illustrations/icons/laptop-globe.svg"),
                    "Community",
                    """
          Check [KVision blog posts at dev.to](https://dev.to/t/kvision/latest) to learn more about the framework and it's development process.

          Everyday you can talk with KVision users and developers on Kotlin Slack [#kvision](https://kotlinlang.slack.com/messages/kvision/) channel and on the [Discord server](https://discord.gg/SdsN3arN2w).

          [Fill an issue on GitHub](https://github.com/rjaros/kvision/issues) if you find a bug or have a feature request. Open and closed issues are also a valuable source of information.

          The [KVision Project Wizard](https://github.com/JakubNeukirch/kvision-project-wizard) for IntelliJ IDEA is being developed as a separate project (thanks to [@JakubNeukirch](https://github.com/JakubNeukirch))
                    """.trimIndent()
                ),
                Article(
                    require("images/illustrations/icons/mouse-globe.svg"),
                    "Legacy docs",
                    """
          API documentation for KVision 4.x is still available [here](https://rjaros.github.io/kvision/api4/).

          Even older API documentation is available [here](https://rjaros.github.io/kvision/api/).

          If you are interested in the documentation for KVision 1.x (based on Bootstrap 3), you can [find the guide here](https://kvision.gitbook.io/kvision-guide/v/kvision-1.x/) and the [API docs here](https://rjaros.github.io/kvision/api1/).
                    """.trimIndent()
                ),
            ), "mt-20"
        )
    )
}

data class UseCase(val url: String, val image: String, val caption: String)

@Suppress("UnsafeCastFromDynamic")
object UseCases {
    val id = "showcases"
    val title = "Stable and verified"
    val subtitle = "KVision applications are already running on production websites used by hundreds of users every day"
    val useCases = listOf(
        UseCase("https://peup.finn.pl", require("images/peup.png"), "Public administration services"),
        UseCase(
            "https://www.eurzad.radlin.pl/#!/rejestry/S.0007/10/1/default/_",
            require("images/eurzad.png"),
            "Public information bulletin"
        ),
        UseCase(
            "https://e-rezerwacje.finn.pl/gmwodzislawsl/",
            require("images/erezerwacje.png"),
            "Online reservation system"
        )
    )
}

data class FooterColumn(val title: String, val links: Map<String, String>)

@Suppress("UnsafeCastFromDynamic")
object Footer {
    val logo: String = require("images/logos/kvision.svg")
    val columns =
        listOf(
            FooterColumn(
                "Information",
                mapOf(
                    "https://kvision.gitbook.io/kvision-guide/" to "User guide",
                    "https://github.com/rjaros/kvision-examples" to "Examples and templates",
                    "https://rjaros.github.io/kvision/kvision/index.html" to "API documentation",
                    "https://github.com/rjaros/kvision-io" to "Website Kotlin/JS sources",
                )
            ),
            FooterColumn(
                "Created by",
                mapOf(
                    "https://github.com/rjaros" to "Robert Jaros",
                    "mailto:rjaros@treksoft.pl" to "rjaros@treksoft.pl",
                    "https://github.com/StefMa/hugo-fresh" to "Website based on Hugo Fresh",
                    "https://www.pexels.com/" to "Photos from Pexels"
                )
            ),
        )
    val joinUs = FooterColumn(
        "Join Us",
        mapOf(
            "https://github.com/rjaros/kvision" to "fab fa-github fa-2x",
            "https://kotlinlang.slack.com/?redir=%2Fmessages%2FCL4C1SLKC" to "fab fa-slack fa-2x",
            "https://discord.gg/SdsN3arN2w" to "fab fa-discord fa-2x",
            "https://dev.to/t/kvision/latest" to "fab fa-dev fa-2x"
        )
    )
}
