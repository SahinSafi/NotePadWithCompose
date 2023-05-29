package com.safi.notepadwithcompose.common_ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.safi.notepadwithcompose.R
import com.safi.notepadwithcompose.ui.theme.Purple80

@Composable
fun CommonToolBar(title: String, onClickBackButton: (() -> Unit)? = null) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Purple80),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp)
        ) {
            onClickBackButton?.let {
                Icon(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterVertically)
                        .clickable { onClickBackButton.invoke() },
                    painter = painterResource(id = R.drawable.ic_arrow_back_30),
                    contentDescription = ""
                )
            }
            Text(modifier = Modifier.padding(start = 16.dp), text = title, fontSize = 24.sp)
        }
    }
}