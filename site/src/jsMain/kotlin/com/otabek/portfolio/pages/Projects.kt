package com.otabek.portfolio.pages

import androidx.compose.runtime.Composable
import com.otabek.portfolio.data.Portfolio
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.silk.components.navigation.Link
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun ProjectsPage() {
    H1 { Text("Projects") }

    Ul {
        Portfolio.projects.forEach { project ->
            Li {
                Link(project.repoUrl, project.title)
                Text(" - ${project.description}")
            }
        }
    }
}