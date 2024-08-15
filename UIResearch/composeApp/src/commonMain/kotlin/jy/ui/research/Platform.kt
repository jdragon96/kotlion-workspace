package jy.ui.research

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform