package com.otabek.portfolio.components.sections

import androidx.compose.runtime.Composable
import com.otabek.portfolio.data.Portfolio
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.navigation.Link
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Nav

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
    val ctx = rememberPageContext()

    Header(Modifier.fillMaxWidth().padding(1.cssRem).toAttrs()) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Link("/", Portfolio.name, Modifier.fontWeight(FontWeight.Bold))

            Nav {
                Row(Modifier.gap(1.5.cssRem)) {
                    navItems.forEach { item ->
                        val isActive = ctx.route.path == item.path
                        Link(
                            path = item.path,
                            text = item.label,
                            modifier = Modifier.fontWeight(
                                if (isActive) FontWeight.Bold else FontWeight.Normal
                            ),
                        )
                    }
                }
            }
        }
    }
}