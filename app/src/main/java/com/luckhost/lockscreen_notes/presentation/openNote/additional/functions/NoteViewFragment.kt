package com.luckhost.lockscreen_notes.presentation.openNote.additional.functions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luckhost.lockscreen_notes.R
import com.luckhost.lockscreen_notes.presentation.openNote.OpenNoteViewModel
import dev.jeziellago.compose.markdowntext.MarkdownText

@Composable
fun NoteViewFragment(vm: OpenNoteViewModel) {
    Column {
        TextButton(
            onClick = { vm.changeEditModeState() },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = vm.titleText,
                style = TextStyle(
                    color = colorResource(id = R.color.main_title_text),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                ),
            )
        }
        HorizontalDivider()

        Column {
            vm.note.content.forEach{
                when(it["name"]) {
                    "md" -> MarkdownText(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(16.dp)
                            .fillMaxWidth(),
                        markdown = it["text"].toString(),
                        onClick = { vm.changeEditModeState() },
                        style = TextStyle(
                            color = colorResource(id = R.color.grey_neutral),
                            fontSize = 24.sp
                        ),
                    )
                }
            }
        }
    }
}