package br.com.lagama.mobile.personalfinance

import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            super.updateIconColors(icons[IDX_AGENDA])
            loadFragment(AgendaFragment())
        }

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        icons[IDX_GROUPS].setOnClickListener {
            super.updateIconColors(icons[IDX_GROUPS])
            loadFragment(GroupsFragment())
        }
        icons[IDX_BALANCES].setOnClickListener {
            super.updateIconColors(icons[IDX_BALANCES])
            loadFragment(BalancesFragment())
        }
        icons[IDX_AGENDA].setOnClickListener {
            super.updateIconColors(icons[IDX_AGENDA])
            loadFragment(AgendaFragment())
        }
        icons[IDX_MOVEMENT].setOnClickListener {
            super.updateIconColors(icons[IDX_MOVEMENT])
            loadFragment(MovementFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

}