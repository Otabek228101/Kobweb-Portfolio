package com.otabek.portfolio.components.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.otabek.portfolio.data.PageInfo
import kotlinx.browser.document

@Composable
fun PageMeta(page: PageInfo) {
    LaunchedEffect(page) {
        document.title = page.title
        setMeta("name", "description", page.description)
        setMeta("property", "og:title", page.title)
        setMeta("property", "og:description", page.description)
    }
}

private fun setMeta(attr: String, key: String, value: String) {
    val head = document.head ?: return
    val meta = head.querySelector("meta[$attr=\"$key\"]")
        ?: document.createElement("meta").also {
            it.setAttribute(attr, key)
            head.appendChild(it)
        }
    meta.setAttribute("content", value)
}