package com.polinasmogi.threesomemeal.ui.shapes

import android.graphics.Matrix
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

val MithosisShape: Shape = object: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val baseWidth = 565f
        val baseHeight = 320f

        val path = Path().apply {
            moveTo(333.2529f, 301.1311f)
            cubicTo(302.6745f, 284.5264f, 259.4564f, 284.0276f, 228.4984f, 299.9084f)
            cubicTo(207.1144f, 310.8789f, 182.9077f, 317.0649f, 157.268f, 317.0649f)
            cubicTo(70.4116f, 317.0649f, 0f, 246.0867f, 0f, 158.5324f)
            cubicTo(0f, 70.976f, 70.4116f, 0f, 157.268f, 0f)
            cubicTo(184.2143f, 0f, 209.5775f, 6.8314f, 231.7471f, 18.8698f)
            cubicTo(262.3255f, 35.4748f, 305.5436f, 35.9724f, 336.4994f, 20.0911f)
            cubicTo(357.8856f, 9.1207f, 382.0923f, 2.9358f, 407.7314f, 2.9358f)
            cubicTo(494.5891f, 2.9358f, 565f, 73.9134f, 565f, 161.4676f)
            cubicTo(565f, 249.024f, 494.5891f, 320f, 407.7314f, 320f)
            cubicTo(380.7857f, 320f, 355.4225f, 313.1697f, 333.2529f, 301.1311f)
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