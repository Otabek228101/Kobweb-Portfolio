package com.otabek.portfolio.pages

import androidx.compose.runtime.Composable
import com.otabek.portfolio.data.Portfolio
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Page
@Composable
fun HomePage() {
    H1 { Text(Portfolio.name) }
    P { Text(Portfolio.role) }
    P { Text(Portfolio.bio) }

    Ul {
        Portfolio.projects.forEach { project ->
            Li { Text("${project.title} - ${project.tags.joinToString()}") }
        }
    }

    Ul {
        Portfolio.skills.forEach { skill ->
            Li { Text("${skill.name} (${skill.group.title})") }
        }
    }

    Ul {
        Portfolio.socials.forEach { link ->
            Li { Text("${link.label}: ${link.url}") }
        }
    }
}