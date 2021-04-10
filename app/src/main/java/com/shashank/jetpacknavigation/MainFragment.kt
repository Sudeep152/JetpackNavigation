package com.shashank.jetpacknavigation

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.navArgument
import com.shashank.jetpacknavigation.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    var navController:NavController ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        val mainFragment = this
        view.findViewById<Button>(R.id.view_transactions_btn).setOnClickListener {
            navController!!.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
        }
        view.findViewById<Button>(R.id.send_money_btn).setOnClickListener {

            navController!!.navigate(R.id.action_mainFragment_to_chooserRecipientFragment2)
        }
        view.findViewById<Button>(R.id.view_balance_btn).setOnClickListener {
            navController!!.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
    }




}