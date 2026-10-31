package com.otabek.portfolio.pages

import androidx.compose.runtime.Composable
import com.otabek.portfolio.components.widgets.ProjectCard
import com.otabek.portfolio.data.Portfolio
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun ProjectsPage() {
    H1 { Text("Projects") }
    Column(Modifier.gap(1.5.cssRem)) {
        Portfolio.projects.forEach { project -> ProjectCard(project) }
    }
}