package com.otabek.portfolio.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.otabek.portfolio.data.Portfolio
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Text
import com.otabek.portfolio.components.widgets.ColorModeToggle

private data class NavItem(val label: String, val path: String)

private val navItems = listOf(
    NavItem("About", "/#about"),
    NavItem("Skills", "/#skills"),
    NavItem("Projects", "/#projects"),
    NavItem("Contact", "/#contact"),
    NavItem("All projects", "/projects"),
)

@Composable
fun NavHeader() {
    var menuOpen by remember { mutableStateOf(false) }

    Header(Modifier.fillMaxWidth().padding(1.cssRem).toAttrs()) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Link("/", Portfolio.name, Modifier.fontWeight(FontWeight.Bold))
            Row(Modifier.gap(1.cssRem), verticalAlignment = Alignment.CenterVertically) {
                Nav(Modifier.displayIfAtLeast(Breakpoint.MD).toAttrs()) {
                    NavLinks(vertical = false)
                }

                ColorModeToggle()

                Button(
                    onClick = { menuOpen = !menuOpen },
                    modifier = Modifier.displayUntil(Breakpoint.MD).attrsModifier {
                        attr("aria-label", "Menu")
                        attr("aria-expanded", menuOpen.toString())
                    },
                ) {
                    Text(if (menuOpen) "✕" else "☰")
                }
            }
        }
    }
}

@Composable
private fun NavLinks(vertical: Boolean, onNavigate: () -> Unit = {}) {
    val ctx = rememberPageContext()
    val links = @Composable {
        navItems.forEach { item ->
            val isActive = ctx.route.path == item.path
            Link(
                path = item.path,
                text = item.label,
                modifier = Modifier
                    .fontWeight(if (isActive) FontWeight.Bold else FontWeight.Normal)
                    .onClick { onNavigate() },
            )
        }
    }
    if (vertical) Column(Modifier.gap(1.cssRem)) { links() }
    else Row(Modifier.gap(1.5.cssRem)) { links() }
}