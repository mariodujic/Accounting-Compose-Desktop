package com.acc.common.ui.theme
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Roboto = FontFamily.Default

val AppTypography = Typography(
	h1 = TextStyle(
		fontFamily = Roboto,
		fontWeight = FontWeight.W400,
		fontSize = 32.sp,
		lineHeight = 40.sp,
		letterSpacing = 0.sp,
	),
	h2 = TextStyle(
		fontFamily = Roboto,
		fontWeight = FontWeight.W400,
		fontSize = 28.sp,
		lineHeight = 36.sp,
		letterSpacing = 0.sp,
	),
	h3 = TextStyle(
		fontFamily = Roboto,
		fontWeight = FontWeight.W400,
		fontSize = 24.sp,
		lineHeight = 32.sp,
		letterSpacing = 0.sp,
	),
	h4 = TextStyle(
		fontFamily = Roboto,
		fontWeight = FontWeight.W400,
		fontSize = 22.sp,
		lineHeight = 28.sp,
		letterSpacing = 0.sp,
	),
	h5 = TextStyle(
		fontFamily = Roboto,
		fontWeight = FontWeight.Medium,
		fontSize = 16.sp,
		lineHeight = 24.sp,
		letterSpacing = 0.1.sp,
	),
	h6 = TextStyle(
		fontFamily = Roboto,
		fontWeight = FontWeight.Medium,
		fontSize = 14.sp,
		lineHeight = 20.sp,
		letterSpacing = 0.1.sp,
	),
	body1 = TextStyle(
		fontFamily = Roboto,
		fontWeight = FontWeight.Medium,
		fontSize = 14.sp,
		lineHeight = 20.sp,
		letterSpacing = 0.1.sp,
	)
)
