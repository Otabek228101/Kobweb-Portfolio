package com.otabek.portfolio.components.sections

import androidx.compose.runtime.Composable
import com.otabek.portfolio.components.widgets.SectionContainer
import com.otabek.portfolio.data.Portfolio
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutSection() {
    SectionContainer(id = "about", title = "About") {
        Row(Modifier.gap(2.cssRem), verticalAlignment = Alignment.CenterVertically) {
            Image(
                Portfolio.photoPath,
                Portfolio.photoAlt,
                Modifier.size(160.px).borderRadius(50.percent).objectFit(ObjectFit.Cover),
            )
            P { Text(Portfolio.bio) }
        }
    }
}