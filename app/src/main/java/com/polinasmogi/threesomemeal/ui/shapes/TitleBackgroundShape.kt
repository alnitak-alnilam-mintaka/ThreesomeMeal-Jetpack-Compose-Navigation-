package com.polinasmogi.threesomemeal.ui.shapes

import android.graphics.Matrix
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

val TitleBackgroundShape: Shape = object: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val baseWidth = 362f
        val baseHeight = 100f

        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(362f, 0f)
            lineTo(362f, 68f)
            cubicTo(362f, 85.6731f, 347.6731f, 100f, 330f, 100f)
            lineTo(0f, 100f)
            lineTo(0f, 0f)
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