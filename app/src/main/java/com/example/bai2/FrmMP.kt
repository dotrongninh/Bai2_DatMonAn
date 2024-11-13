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


class FrmMP : Fragment() {
    private lateinit var viewModel: LastViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frm_m_p, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBack: Button = view.findViewById(R.id.btnBack)
        // Lấy tham chiếu đến nút "Tiếp theo"
        val btnNext: Button = view.findViewById(R.id.btnNext)

        // Xử lý sự kiện nhấn nút "Quay lại"
        btnBack.setOnClickListener {
            // Quay lại fragment trước đó hoặc thực hiện hành động khác
            requireActivity().supportFragmentManager.popBackStack()
        }

        // Xử lý sự kiện nhấn nút "Tiếp theo"
        btnNext.setOnClickListener {
            viewModel = ViewModelProvider(requireActivity()).get(LastViewModel::class.java)
            if (view.findViewById<CheckBox>(R.id.checkBoxNemRan).isChecked) {
                viewModel.addFood("Nem rán")
            } else viewModel.removeFood("Nem rán")
            if (view.findViewById<CheckBox>(R.id.checkBoxChaGio).isChecked) {
                viewModel.addFood("Chả giò")
            } else viewModel.removeFood("Chả giò")
            if (view.findViewById<CheckBox>(R.id.checkBoxBanhCuon).isChecked) {
                viewModel.addFood("Bánh cuốn")
            } else viewModel.removeFood("Bánh cuốn")
            val fragment = FrmDU() // Tạo một instance mới của FrmC
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frContent, fragment) // Thay thế Fragment hiện tại
                .addToBackStack(null) // Thêm vào stack trở lại nếu người dùng muốn quay lại
                .commit()
        }
    }

}