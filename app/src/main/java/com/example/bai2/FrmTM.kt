package com.example.bai2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.lifecycle.ViewModelProvider


class FrmTM : Fragment() {
    private lateinit var viewModel: LastViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frm_t_m, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBack: Button = view.findViewById(R.id.btnBack)
        // Lấy tham chiếu đến nút "Tiếp theo"
        val btnNext: Button = view.findViewById(R.id.btnNext)
        viewModel = ViewModelProvider(requireActivity()).get(LastViewModel::class.java)
        // Xử lý sự kiện nhấn nút "Quay lại"
        btnBack.setOnClickListener {
            // Quay lại fragment trước đó hoặc thực hiện hành động khác
            requireActivity().supportFragmentManager.popBackStack()
        }

        // Xử lý sự kiện nhấn nút "Tiếp theo"
        btnNext.setOnClickListener {
            if (view.findViewById<CheckBox>(R.id.checkBoxCheBaMau).isChecked) {
                viewModel.addFood("Chè ba màu")
            } else viewModel.removeFood("Chè ba màu")

            if (view.findViewById<CheckBox>(R.id.checkBoxRauCau).isChecked) {
                viewModel.addFood("Rau câu")
            } else viewModel.removeFood("Rau câu")
            if (view.findViewById<CheckBox>(R.id.checkBoxBanhFlan).isChecked) {
                viewModel.addFood("Bánh Flan")
            } else viewModel.removeFood("Bánh Flan")

            var i = Intent(requireActivity(),LastActivity::class.java)
            i.putStringArrayListExtra("list", ArrayList(viewModel.selectedFoods.value ?: listOf()))
            Log.d("ccc", viewModel.getSecondFood().toString())
            startActivity(i)
        }
    }
}