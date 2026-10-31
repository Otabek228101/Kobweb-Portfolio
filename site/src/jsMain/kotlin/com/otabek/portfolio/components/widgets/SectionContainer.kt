package com.otabek.portfolio.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Section
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionContainer(id: String, title: String, content: @Composable () -> Unit) {
    Section(Modifier.id(id).fillMaxWidth().padding(topBottom = 3.cssRem).toAttrs()) {
        H2 { Text(title) }
        content()
    }
}