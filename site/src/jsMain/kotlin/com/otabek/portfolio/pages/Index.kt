package com.otabek.portfolio.pages

import androidx.compose.runtime.Composable
import com.otabek.portfolio.components.sections.AboutSection
import com.otabek.portfolio.components.sections.ContactSection
import com.otabek.portfolio.components.sections.HeroSection
import com.otabek.portfolio.components.sections.ProjectsSection
import com.otabek.portfolio.components.sections.SkillsSection
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import com.otabek.portfolio.components.widgets.PageMeta
import com.otabek.portfolio.data.Pages

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun HomePage() {
    PageMeta(Pages.home)
    HeroSection()
    AboutSection()
    SkillsSection()
    ProjectsSection()
    ContactSection()
}