package com.shashank.jetpacknavigation

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.navArgument
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment() {

    lateinit var   reciverN:String
    var navController:NavController?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        reciverN = arguments?.getString("reciverN").toString()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)

        view.findViewById<Button>(R.id.send_btn).setOnClickListener {

            if(!TextUtils.isEmpty(input_amount.text.toString())){

                val amm= Money(BigDecimal( input_amount.text.toString()))

                val bundel= bundleOf("reciverN" to reciverN,
                "amount" to amm)
                navController!!.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment,bundel)
            }

        }
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener {
            activity?.onBackPressed()
        }
        recipient.text = "Sending Money To $reciverN"
    }


}