package br.com.lagama.mobile.personalfinance

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var icons: List<ImageView>
    lateinit var texts: List<TextView>
    lateinit var navController: NavController

    val IDX_GROUPS = 0
    val IDX_BALANCES = 1
    val IDX_AGENDA = 2
    val IDX_MOVEMENT = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
            ?: NavHostFragment.create(R.navigation.nav_graph).also { navFragment ->
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, navFragment)
                    .setPrimaryNavigationFragment(navFragment)
                    .commit()
                supportFragmentManager.executePendingTransactions()
            }

        navController = navHostFragment?.navController ?: throw IllegalStateException("NavController não foi inicializado corretamente.")

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
            findViewById<TextView>(R.id.text_agenda),
            findViewById<TextView>(R.id.text_movto)
        )

        if (savedInstanceState == null) {
            updateIconColors(icons[IDX_AGENDA])
            navController.navigate(R.id.agendaFragment)
        }

        setupBottomNavigation()

    }

    protected fun updateIconColors(selectedIcon: ImageView) {
        val disabledColor = ContextCompat.getColor(this, R.color.disabled_icon)
        val enabledColor = ContextCompat.getColor(this, R.color.enabled_icon)
        icons.forEachIndexed { idx, icon ->
            val color = if (icon == selectedIcon) disabledColor else enabledColor
            icon.setColorFilter(color)
            val textView = texts[idx]
            textView.setTextColor(color)
        }
    }

    //override fun onSupportNavigateUp(): Boolean {
    //    return navController.navigateUp() || super.onSupportNavigateUp()
    //}

    private fun setupBottomNavigation() {
        icons[IDX_GROUPS].setOnClickListener {
            updateIconColors(icons[IDX_GROUPS])
            navController.navigate(R.id.groupsFragment)
        }
        icons[IDX_BALANCES].setOnClickListener {
            updateIconColors(icons[IDX_BALANCES])
            navController.navigate(R.id.balancesFragment)
        }
        icons[IDX_AGENDA].setOnClickListener {
            updateIconColors(icons[IDX_AGENDA])
            navController.navigate(R.id.agendaFragment)
        }
        icons[IDX_MOVEMENT].setOnClickListener {
            updateIconColors(icons[IDX_MOVEMENT])
            navController.navigate(R.id.movementsFragment)
        }
    }
}