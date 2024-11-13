package com.example.bai2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.lifecycle.ViewModelProvider


class FrmMC : Fragment() {


    private lateinit var viewModel: LastViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frm_m_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val btnNext: Button = view.findViewById(R.id.btnNext)




        btnNext.setOnClickListener {

            viewModel = ViewModelProvider(requireActivity()).get(LastViewModel::class.java)
            if (view.findViewById<CheckBox>(R.id.checkBoxPhoBo).isChecked) {
                viewModel.addFood("Phở")
            } else viewModel.removeFood("Phở")
            if (view.findViewById<CheckBox>(R.id.checkBoxBunCha).isChecked) {
                viewModel.addFood("Bún chả")
            } else viewModel.removeFood("Bún chả")
            if (view.findViewById<CheckBox>(R.id.checkBoxComTam).isChecked) {
                viewModel.addFood("Cơm tấm")
            } else viewModel.removeFood("Cơm tấm")

            Log.d("aaa", viewModel.getSecondFood().toString())
            val fragment = FrmMP() // Tạo một instance mới của FrmC
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frContent, fragment) // Thay thế Fragment hiện tại
                .addToBackStack(null) // Thêm vào stack trở lại nếu người dùng muốn quay lại
                .commit()

        }


    }
}