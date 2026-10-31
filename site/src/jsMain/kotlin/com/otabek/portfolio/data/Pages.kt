package com.otabek.portfolio.data

data class PageInfo(val title: String, val description: String)

object Pages {
    val home = PageInfo(
        title = "Otabek - Kotlin, Go, DevOps & 3D",
        description = "Портфолио Otabek: приложения на Kotlin и Go, DevOps и 3D-модели оружия.",
    )
    val projects = PageInfo(
        title = "Projects - Otabek",
        description = "Все проекты Otabek: Kotlin, Kobweb, Go и 3D-работы в Blender и Substance Painter.",
    )
}