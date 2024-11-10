package br.com.lagama.mobile.personalfinance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

private const val ARG_PARAM1 = "actionName"

class GroupEditFragment : Fragment() {
    private var actionName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            actionName = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_group_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textAction = view.findViewById<TextView>(R.id.textAction)
        textAction.text = actionName

        val backButton = view.findViewById<Button>(R.id.button_back)
        backButton.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(action: String) =
            GroupEditFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, action)
                }
            }
    }
}