package com.polinasmogi.threesomemeal.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.polinasmogi.threesomemeal.R
import kotlin.random.Random

@Composable
fun StepItem(
    step: String
) {
    Row(
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_flower),
            modifier = Modifier
                .padding(start = 2.dp)
                .rotate(Random.nextInt(0, 90).toFloat()),
            tint = Color.Unspecified,
            contentDescription = null
        )
        Text(
            text = step,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp),
            color = Color.White
        )
    }
}