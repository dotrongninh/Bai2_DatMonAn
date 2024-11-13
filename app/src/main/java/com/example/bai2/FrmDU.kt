package com.example.bai2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.lifecycle.ViewModelProvider


class FrmDU : Fragment() {
    private lateinit var viewModel: LastViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frm_d_u, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBack: Button = view.findViewById(R.id.btnBack)

        val btnNext: Button = view.findViewById(R.id.btnNext)


        btnBack.setOnClickListener {

            requireActivity().supportFragmentManager.popBackStack()
        }

        // Xử lý sự kiện nhấn nút "Tiếp theo"
        btnNext.setOnClickListener {
            viewModel = ViewModelProvider(requireActivity()).get(LastViewModel::class.java)
            if (view.findViewById<CheckBox>(R.id.checkBoxNuocCam).isChecked) {
                viewModel.addFood("Nước cam")
            } else viewModel.removeFood("Nước cam")
            if (view.findViewById<CheckBox>(R.id.checkBoxSinhToBo).isChecked) {
                viewModel.addFood("Sinh tố bơ")
            }else viewModel.removeFood("Sinh tố bơ")
            if (view.findViewById<CheckBox>(R.id.checkBoxTraSua).isChecked) {
                viewModel.addFood("Trà sữa")
            }else viewModel.removeFood("Trà sữa")

            val fragment = FrmTM() // Tạo một instance mới của FrmC
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frContent, fragment) // Thay thế Fragment hiện tại
                .addToBackStack(null) // Thêm vào stack trở lại nếu người dùng muốn quay lại
                .commit()
        }
    }
}