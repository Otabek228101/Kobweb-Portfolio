package com.otabek.portfolio.components.sections

import androidx.compose.runtime.Composable
import com.otabek.portfolio.components.widgets.ProjectCard
import com.otabek.portfolio.components.widgets.SectionContainer
import com.otabek.portfolio.data.Portfolio
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import org.jetbrains.compose.web.css.cssRem

@Composable
fun ProjectsSection() {
    SectionContainer(id = "projects", title = "Projects") {
        SimpleGrid(numColumns(base = 1, md = 2, lg = 3), Modifier.fillMaxWidth().gap(1.5.cssRem)) {
            Portfolio.projects.forEach { project -> ProjectCard(project) }
        }
    }
}