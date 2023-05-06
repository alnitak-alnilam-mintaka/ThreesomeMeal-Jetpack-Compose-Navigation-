package com.polinasmogi.threesomemeal.ui.shapes

import android.graphics.Matrix
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

val SubtractShape: Shape = object: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val baseWidth = 360.0001f
        val baseHeight = 610f

        val path = Path().apply {
            fillType = PathFillType.EvenOdd
            moveTo(0f, 32f)
            lineTo(0f, 610f)
            lineTo(360.0001f, 610f)
            lineTo(360f, 32f)
            cubicTo(360f, 14.3269f, 345.6732f, 0f, 328f, 0f)
            lineTo(32f, 0f)
            cubicTo(14.3269f, 0f, 0f, 14.3269f, 0f, 32f)
            close()
            moveTo(145.8204f, 13.927f)
            cubicTo(140.9491f, 13.927f, 137f, 17.876f, 137f, 22.7474f)
            cubicTo(137f, 27.6187f, 140.9491f, 31.5678f, 145.8204f, 31.5678f)
            lineTo(215.1796f, 31.5678f)
            cubicTo(220.051f, 31.5678f, 224f, 27.6187f, 224f, 22.7474f)
            cubicTo(224f, 17.876f, 220.051f, 13.927f, 215.1796f, 13.927f)
            lineTo(145.8204f, 13.927f)
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