package com.otabek.portfolio.pages

import androidx.compose.runtime.Composable
import com.otabek.portfolio.data.Portfolio
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun HomePage() {
    val ctx = rememberPageContext()

    H1 { Text(Portfolio.name) }
    P { Text(Portfolio.role) }
    P { Text(Portfolio.bio) }

    Button(onClick = { ctx.router.navigateTo("/projects") }) {
        Text("View projects")
    }

    Ul {
        Portfolio.skills.forEach { skill ->
            Li { Text("${skill.name} (${skill.group.title})") }
        }
    }
}