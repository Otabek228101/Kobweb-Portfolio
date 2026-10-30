package com.otabek.portfolio.data

data class Project(
    val title: String,
    val description: String,
    val tags: List<String>,
    val repoUrl: String,
    val demoUrl: String? = null,     
    val imagePath: String? = null,   
    val featured: Boolean = false,   
)

enum class SkillGroup(val title: String) {
    Languages("Languages"),
    Frameworks("Frameworks"),
    Tools("Tools"),
}

data class Skill(val name: String, val group: SkillGroup)

data class SocialLink(val label: String, val url: String)

object Portfolio {
    const val name = "Otabek"
    const val role = "Kotlin Developer & SG Generalist & DevOps & Golang Developer"
    const val tagline = "Пишу приложения на Kotlin и Go, занимаюсь DevOps, так же делаю в 3D всякие штуки"
    const val bio = "Привет! Я Otabek, разработчик на Kotlin и Go, а также специалист по DevOps. У меня есть опыт работы с различными технологиями и инструментами, включая Jetpack Compose, Kobweb, Git и Linux. Я увлечен созданием качественных приложений и решением сложных задач в области разработки программного обеспечения."
    const val email = "bekotabekbek56@gmail.com"

    val projects = listOf(
        Project(
            title = "Kobweb Portfolio",
            description = "Этот сайт: портфолио на Kobweb, деплой на GitHub Pages.",
            tags = listOf("Kotlin", "Kobweb", "Compose HTML"),
            repoUrl = "https://github.com/Otabek228101/Kobweb-Portfolio",
        ),
        Project(
            title = "KMP Portfolio",
            description = "Портфолио-приложение на Compose Multiplatform для Android и iOS.",
            tags = listOf("Kotlin", "KMP", "Compose"),
            repoUrl = "https://github.com/Otabek228101/Portfolio",
        ),
        Project(
            title = "Ak-47",
            description = "калаш просто калаш",
            tags = listOf("Blender", "Substance Painter", "Marmoset Toolbag"),
            repoUrl = "https://www.artstation.com/artwork/QKG1LL",
            imagePath = "https://cdna.artstation.com/p/assets/images/images/082/904/896/large/otabek-1.jpg?1734257013",
            featured = true,
        ),
    )

    val skills = listOf(
        Skill("Kotlin", SkillGroup.Languages),
        Skill("Go", SkillGroup.Languages),
        Skill("Jetpack Compose", SkillGroup.Frameworks),
        Skill("Kobweb", SkillGroup.Frameworks),
        Skill("Git", SkillGroup.Tools),
        Skill("Linux", SkillGroup.Tools),
        Skill("Blender", SkillGroup.Tools),
        Skill("Substance Painter", SkillGroup.Tools),
        Skill("Marmoset Toolbag", SkillGroup.Tools),
    )

    val socials = listOf(
        SocialLink("GitHub", "https://github.com/Otabek228101"),
        SocialLink("ArtStation", "https://www.artstation.com/den2288"),
    )
}