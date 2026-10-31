package com.otabek.portfolio.components.sections

import androidx.compose.runtime.Composable
import com.otabek.portfolio.components.widgets.SectionContainer
import com.otabek.portfolio.data.Portfolio
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.components.navigation.Link
import org.jetbrains.compose.web.css.cssRem

@Composable
fun ContactSection() {
    SectionContainer(id = "contact", title = "Contact") {
        Column(Modifier.gap(0.5.cssRem)) {
            Link("mailto:${Portfolio.email}", Portfolio.email)
            Portfolio.socials.forEach { link -> Link(link.url, link.label) }
        }
    }
}