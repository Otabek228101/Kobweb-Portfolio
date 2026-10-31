package com.otabek.portfolio.components.sections

import androidx.compose.runtime.Composable
import com.otabek.portfolio.data.Portfolio
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text

@Composable
fun HeroSection() {
    val ctx = rememberPageContext()

    Section(Modifier.id("home").padding(topBottom = 4.cssRem).toAttrs()) {
        H1 { Text(Portfolio.name) }
        P { Text(Portfolio.role) }
        P { Text(Portfolio.tagline) }
        Row(Modifier.gap(1.cssRem)) {
            Button(onClick = { ctx.router.navigateTo("/projects") }) { Text("View projects") }
            Button(onClick = { ctx.router.navigateTo("/#contact") }) { Text("Contact me") }
        }
    }
}