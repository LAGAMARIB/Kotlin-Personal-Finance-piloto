package br.com.lagama.mobile.personalfinance

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var icons: List<ImageView>
    private lateinit var texts: List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backgroundGradient = GradientDrawable(
            GradientDrawable.Orientation.TL_BR,
            intArrayOf(
                ContextCompat.getColor(this, R.color.start_color),
                ContextCompat.getColor(this, R.color.end_color)
            )
        )
        val rootView = findViewById<RelativeLayout>(R.id.root_layout)
        rootView.background = backgroundGradient

        icons = listOf(
            findViewById<ImageView>(R.id.icon_groups),
            findViewById<ImageView>(R.id.icon_balances),
            findViewById<ImageView>(R.id.icon_agenda),
            findViewById<ImageView>(R.id.icon_movements)
        )
        texts = listOf(
            findViewById<TextView>(R.id.text_groups),
            findViewById<TextView>(R.id.text_balances),
            findViewById<TextView>(R.id.text_calendar),
            findViewById<TextView>(R.id.text_movto)
        )
        setupBottomNavigation()
    }


    private fun setupBottomNavigation() {
        icons.forEach { icon ->
            icon.setOnClickListener {
                updateIconColors(icon)
            }
        }
    }

    private fun updateIconColors(selectedIcon: ImageView) {
        val disabledColor = ContextCompat.getColor(this, R.color.disabled_icon)
        val enabledColor = ContextCompat.getColor(this, R.color.enabled_icon)
        icons.forEachIndexed { idx, icon ->
            val color = if (icon == selectedIcon) disabledColor else enabledColor
            icon.setColorFilter(color)
            val textView = texts[idx]
            textView.setTextColor(color)
        }
    }
}