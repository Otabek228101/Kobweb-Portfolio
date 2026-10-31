package com.otabek.portfolio.components.sections

import androidx.compose.runtime.Composable
import com.otabek.portfolio.SplitStyle
import com.otabek.portfolio.data.Portfolio
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.flexBasis
import com.varabyte.kobweb.compose.ui.modifiers.flexGrow
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text

@Composable
fun HeroSection() {
    val ctx = rememberPageContext()
    val half = Modifier.flexGrow(1).flexBasis(0.px)

    Section(SplitStyle.toModifier().id("home").padding(topBottom = 3.cssRem).toAttrs()) {
        Column(half.gap(0.5.cssRem)) {
            H1 { Text(Portfolio.name) }
            P { Text(Portfolio.role) }
        }
        Column(half.gap(1.cssRem)) {
            P { Text(Portfolio.tagline) }
            Row(Modifier.gap(1.cssRem).flexWrap(FlexWrap.Wrap)) {
                Button(onClick = { ctx.router.navigateTo("/projects") }) { Text("View projects") }
                Button(onClick = { ctx.router.navigateTo("/#contact") }) { Text("Contact me") }
            }
        }
    }
}