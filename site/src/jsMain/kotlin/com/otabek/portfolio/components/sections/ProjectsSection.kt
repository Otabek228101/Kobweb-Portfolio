package com.otabek.portfolio.components.sections

import androidx.compose.runtime.Composable
import com.otabek.portfolio.components.widgets.ProjectCard
import com.otabek.portfolio.components.widgets.SectionContainer
import com.otabek.portfolio.data.Portfolio
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import org.jetbrains.compose.web.css.cssRem

@Composable
fun ProjectsSection() {
    SectionContainer(id = "projects", title = "Projects") {
        Column(Modifier.gap(1.5.cssRem)) {
            Portfolio.projects.forEach { project -> ProjectCard(project) }
        }
    }
}