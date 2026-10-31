package com.otabek.portfolio.components.widgets

import androidx.compose.runtime.Composable
import com.otabek.portfolio.data.Project
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ProjectCard(project: Project, modifier: Modifier = Modifier) {
    Column(modifier.gap(0.5.cssRem)) {
        H3 { Text(project.title) }
        P { Text(project.description) }
        SpanText(project.tags.joinToString(" · "))
        Row(Modifier.gap(1.cssRem)) {
            if (project.repoUrl.contains("github.com")) {
                Link(project.repoUrl, "Code")
            }else {
                Link(project.repoUrl, "Artstation")
            }
            project.demoUrl?.let { Link(it, "Demo") }
        }
    }
}