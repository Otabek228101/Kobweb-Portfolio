package com.otabek.portfolio.components.widgets

import androidx.compose.runtime.Composable
import com.otabek.portfolio.data.Project
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.ComponentKind
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.silk.theme.colors.ColorMode

sealed interface ProjectCardKind : ComponentKind

val ProjectCardStyle = CssStyle<ProjectCardKind> {
    base {
        Modifier
            .padding(1.5.cssRem)
            .borderRadius(12.px)
            .border(1.px, LineStyle.Solid, if (colorMode.isLight) Color.rgb(0xDDDDDD) else Color.rgb(0x333333))
            .transition(Transition.of("transform", 200.ms), Transition.of("box-shadow", 200.ms))
    }
    hover {
        Modifier
            .translateY((-4).px)
            .boxShadow(offsetY = 8.px, blurRadius = 24.px, color = Color.rgba(0, 0, 0, 0.15f))
    }
}

val FeaturedProjectCardVariant = ProjectCardStyle.addVariant {
    base {
        Modifier.border(2.px, LineStyle.Solid, if (colorMode.isLight) Color.rgb(0x2563EB) else Color.rgb(0x60A5FA))
    }
}

@Composable
fun ProjectCard(project: Project, modifier: Modifier = Modifier) {
    val variant = if (project.featured) FeaturedProjectCardVariant else null
    val colorMode = ColorMode.current  

    Column(ProjectCardStyle.toModifier(variant).gap(0.75.cssRem).then(modifier)) {
        project.imagePath?.let { path ->
            Image(
                path,
                "Превью проекта ${project.title}",
                Modifier
                    .fillMaxWidth()
                    .height(200.px)
                    .borderRadius(8.px)
                    .objectFit(ObjectFit.Contain)
                    .backgroundColor(if (colorMode.isLight) Color.rgb(0xEEEEEE) else Color.rgb(0x2A2A2A)),
            )
        }

        H3 { Text(project.title) }
        P { Text(project.description) }
        Row(Modifier.gap(0.5.cssRem).flexWrap(FlexWrap.Wrap)) {
            project.tags.forEach { Tag(it) }
        }
        Row(Modifier.gap(1.cssRem)) {
            Link(project.repoUrl, project.repoLabel)
            project.demoUrl?.let { Link(it, "Demo") }
        }
    }
}