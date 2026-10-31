package com.otabek.portfolio.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

val TagStyle = CssStyle.base {
    Modifier
        .padding(leftRight = 0.6.cssRem, topBottom = 0.2.cssRem)
        .borderRadius(999.px)
        .fontSize(0.8.cssRem)
        .backgroundColor(if (colorMode.isLight) Color.rgb(0xE8EEF9) else Color.rgb(0x1F2A3D))
}

@Composable
fun Tag(text: String, modifier: Modifier = Modifier) {
    SpanText(text, TagStyle.toModifier().then(modifier))
}