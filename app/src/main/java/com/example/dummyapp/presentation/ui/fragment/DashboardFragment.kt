package com.example.dummyapp.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummyapp.databinding.FragmentDashboardBinding
import com.example.dummyapp.presentation.adapter.ProductsListAdapter
import com.example.dummyapp.presentation.viewmodel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    private val viewModel: ProductsViewModel by viewModels()
    private lateinit var adapter: ProductsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ProductsListAdapter()
        binding.rvProducts.adapter = adapter
        val dividerItemDecoration = DividerItemDecoration(
            binding.rvProducts.context,
            (binding.rvProducts.layoutManager as LinearLayoutManager).orientation
        )
        binding.rvProducts.addItemDecoration(dividerItemDecoration)

        viewModel.getProductsDetails()

        lifecycleScope.launch {
            viewModel.getProductResponse.collect { data ->
                Log.d("TAG", "onViewCreated345345: ${data.body()}")
                data.body()?.products?.let { adapter.setData(it) }
                binding.pbDashboard.isVisible = false
                binding.tvLoading.isVisible = false
            }
        }
    }
}