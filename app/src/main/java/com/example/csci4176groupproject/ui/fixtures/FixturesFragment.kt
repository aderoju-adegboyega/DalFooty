package com.example.csci4176groupproject.ui.fixtures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.csci4176groupproject.databinding.FragmentFixturesBinding

class FixturesFragment : Fragment() {

    private var _binding: FragmentFixturesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fixturesViewModel =
            ViewModelProvider(this).get(FixturesViewModel::class.java)

        _binding = FragmentFixturesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textFixtures
        fixturesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}