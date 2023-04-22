package com.polinasmogi.threesomemeal.ui.shapes

import android.graphics.Matrix
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection


val BoardShape: Shape = object: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val baseWidth = 328.0001f
        val baseHeight = 593f

        val path = Path().apply {
            moveTo(0f, 593f)
            lineTo(0f, 32f)
            cubicTo(0f, 14.3269f, 14.3269f, 0f, 32f, 0f)
            lineTo(296f, 0f)
            cubicTo(313.6731f, 0f, 328f, 14.3269f, 328f, 32f)
            lineTo(328.0001f, 593f)
            lineTo(0f, 593f)
            close()
        }

        return Outline.Generic(
            path
                .asAndroidPath()
                .apply {
                    transform(Matrix().apply {
                        setScale(size.width / baseWidth, size.height / baseHeight)
                    })
                }
                .asComposePath()
        )
    }
}