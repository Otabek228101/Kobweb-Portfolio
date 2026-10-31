package com.otabek.portfolio

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import com.varabyte.kobweb.compose.ui.modifiers.margin

@InitSilk
fun initSiteStyles(ctx: InitSilkContext) {
    ctx.stylesheet.apply {
        registerStyle("body") {
            base { Modifier.fontSize(1.cssRem).lineHeight(1.6) }
            Breakpoint.MD { Modifier.fontSize(1.125.cssRem) }
        }
        registerStyle("h1") {
            base { Modifier.fontSize(2.25.cssRem) }
            Breakpoint.MD { Modifier.fontSize(3.cssRem) }
            Breakpoint.LG { Modifier.fontSize(3.5.cssRem) }
        }
        registerStyle("p") {
            base { Modifier.margin(topBottom = 0.5.cssRem) }
        }
        registerStyle("h2") {
            base { Modifier.fontSize(1.75.cssRem) }
            Breakpoint.MD { Modifier.fontSize(2.25.cssRem) }
        }
        registerStyle("img") {
            base { Modifier.maxWidth(100.percent) }
        }
    }
}

val SplitStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .gap(2.cssRem)
    }
    Breakpoint.MD {
        Modifier
            .flexDirection(FlexDirection.Row)
            .alignItems(AlignItems.Center)
    }
}