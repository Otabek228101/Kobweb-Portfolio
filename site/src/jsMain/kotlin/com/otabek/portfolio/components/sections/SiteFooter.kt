package com.otabek.portfolio.components.sections

import androidx.compose.runtime.Composable
import com.otabek.portfolio.data.Portfolio
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Footer
import kotlin.js.Date
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import org.jetbrains.compose.web.css.FlexWrap

@Composable
fun SiteFooter() {
    val year = Date().getFullYear()

    Footer(Modifier.fillMaxWidth().padding(1.cssRem).toAttrs()) {
        Row(
            Modifier.fillMaxWidth().flexWrap(FlexWrap.Wrap).gap(1.cssRem),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SpanText("© $year ${Portfolio.name}")
            Row(Modifier.gap(1.cssRem)) {
                Portfolio.socials.forEach { link ->
                    Link(link.url, link.label)
                }
            }
        }
    }
}