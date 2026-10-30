package com.otabek.portfolio.components.layouts

import androidx.compose.runtime.Composable
import com.otabek.portfolio.components.sections.NavHeader
import com.otabek.portfolio.components.sections.SiteFooter
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexGrow
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.layout.Layout
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Main

@Layout
@Composable
fun PageLayout(content: @Composable () -> Unit) {
    Column(
        Modifier.fillMaxWidth().minHeight(100.vh),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        NavHeader()
        Main(
            Modifier
                .fillMaxWidth()
                .maxWidth(1100.px)
                .padding(leftRight = 1.cssRem)
                .flexGrow(1)    
                .toAttrs()
        ) {
            content()
        }
        SiteFooter()
    }
}