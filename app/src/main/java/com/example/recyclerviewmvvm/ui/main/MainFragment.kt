package com.example.recyclerviewmvvm.ui.main

import CountryInfo_Base
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmvvm.R

class MainFragment : Fragment() {
    protected lateinit var rootView: View
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CountryInfoAdapter
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        rootView =  inflater.inflate(R.layout.main_fragment, container, false);
        initView()
        return rootView
    }
    private fun initView(){
        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        recyclerView = rootView.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.mutableData.observe(this, object: Observer<CountryInfo_Base> {
            override fun onChanged(@Nullable mutableData:CountryInfo_Base) {
                adapter = CountryInfoAdapter( mutableData.rows, this@MainFragment)
                recyclerView.adapter = adapter
            }
        })
    }

}