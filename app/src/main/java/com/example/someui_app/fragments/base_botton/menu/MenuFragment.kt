package com.example.someui_app.fragments.base_botton.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.someui_app.R
import com.example.someui_app.databinding.FragmentMenuBinding
import com.example.someui_app.fragments.base_botton.menu.adapter.BaseAdapter
import com.example.someui_app.fragments.base_botton.menu.adapter.HeaderAdapter
import com.example.someui_app.fragments.base_botton.menu.model.BaseRcModel
import com.example.someui_app.fragments.base_botton.menu.model.HeaderRcModel
import com.google.android.material.tabs.TabLayout

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var headerAdapter: HeaderAdapter
    private lateinit var baseAdapter: BaseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater)

        val headers = arrayListOf(
            HeaderRcModel(
                R.drawable.header_1.toString()
            ),
            HeaderRcModel(
                R.drawable.header_1.toString()
            ),
            HeaderRcModel(
                R.drawable.header_1.toString()
            ),
            HeaderRcModel(
                R.drawable.header_1.toString()
            ),
            HeaderRcModel(
                R.drawable.header_1.toString()
            ),
            HeaderRcModel(
                R.drawable.header_1.toString()
            )
        )

        val base = arrayListOf(
            BaseRcModel(
                R.drawable.pizza_1.toString(),
                "Название 1",
                "Описание 1",
                "350"
            ),
            BaseRcModel(
                R.drawable.pizza_2.toString(),
                "Название 2",
                "Описание 2",
                "350"
            ),
            BaseRcModel(
                R.drawable.pizza_3.toString(),
                "Название 3",
                "Описание 3",
                "350"
            )
        )

        bindSpinner()
        bindRcViews(headers, base)
        bindButtons(base)

        return binding.root
    }

    private fun bindButtons(base: ArrayList<BaseRcModel>) {
        binding.tabs.setOnTabSelectedListener(object  : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab!!.position){
                    0 -> {
                        baseAdapter.setNewData(base)
                    }
                    1 -> {
                        val tmp = arrayListOf(
                            base[0],
                            base[2],
                            base[1]
                        )
                        baseAdapter.setNewData(tmp)
                    }
                    2 -> {
                        val tmp = arrayListOf(
                            base[1],
                            base[0],
                            base[0]
                        )
                        baseAdapter.setNewData(tmp)
                    }
                    3 -> {
                        val tmp = arrayListOf(
                            base[2],
                            base[1],
                            base[1]
                        )
                        baseAdapter.setNewData(tmp)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

    private fun bindRcViews(headers: ArrayList<HeaderRcModel>, base: ArrayList<BaseRcModel>) {

        binding.rcheader.apply {
            headerAdapter = HeaderAdapter(headers, requireContext())
            adapter = headerAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        }
        binding.rcBase.apply {
            baseAdapter = BaseAdapter(base, requireContext())
            adapter = baseAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun bindSpinner() {
        val arrayForSpinner = arrayOf("Москва", "Мурманск")
        val adapt: ArrayAdapter<String> = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayForSpinner)

        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCity.adapter = adapt
    }

}