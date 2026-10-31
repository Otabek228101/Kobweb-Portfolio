package com.otabek.portfolio.components.sections

import androidx.compose.runtime.Composable
import com.otabek.portfolio.components.widgets.SectionContainer
import com.otabek.portfolio.data.Portfolio
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Composable
fun SkillsSection() {
    SectionContainer(id = "skills", title = "Skills") {
        Portfolio.skills.groupBy { it.group }.forEach { (group, skills) ->
            H3 { Text(group.title) }
            Ul {
                skills.forEach { skill -> Li { Text(skill.name) } }
            }
        }
    }
}