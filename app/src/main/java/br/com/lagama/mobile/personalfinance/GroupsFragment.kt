package br.com.lagama.mobile.personalfinance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class GroupsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_groups, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editButton = view.findViewById<Button>(R.id.button_edit)
        editButton.setOnClickListener {
            loadSubFragment("Editando grupo")
        }

        val insertButton = view.findViewById<Button>(R.id.button_insert)
        insertButton.setOnClickListener {
            loadSubFragment("Novo grupo")
        }
    }

    private fun loadSubFragment(action: String) {
        val actionBundle = Bundle().apply {
            putString("actionName", action)
        }
        findNavController().navigate(R.id.groupEditFragment, actionBundle)
    }

}