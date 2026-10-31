package com.otabek.portfolio.components.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.dom.Text

@Composable
fun ColorModeToggle(modifier: Modifier = Modifier) {
    var colorMode by ColorMode.currentState

    Button(
        onClick = { colorMode = colorMode.opposite },
        modifier = modifier.attrsModifier {
            attr("aria-label", if (colorMode.isLight) "Switch to dark mode" else "Switch to light mode")
        },
    ) {
        Text(if (colorMode.isLight) "🌙" else "☀️")
    }
}