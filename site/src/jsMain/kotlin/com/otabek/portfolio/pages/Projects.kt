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
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.otabek.portfolio.components.widgets.PageMeta
import com.otabek.portfolio.data.Pages

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun ProjectsPage() {
    PageMeta(Pages.projects)
    H1 { Text("Projects") }
    SimpleGrid(numColumns(base = 1, md = 2, lg = 3), Modifier.fillMaxWidth().gap(1.5.cssRem)) {
        Portfolio.projects.forEach { project ->
            ProjectCard(project, Modifier.padding(2.cssRem), headingLevel = 2)
        }
    }   
}
