package com.lazday.kelasonline.ui.calculator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.lazday.kelasonline.R
import kotlinx.android.synthetic.main.fragment_calculator.*


class CalculatorFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)

        // Mendapatkan referensi ke tombol "Hitung"
        val lakiButton: Button = view.findViewById(R.id.btn_laki)
        val ceweButton: Button = view.findViewById(R.id.btn_perempuan)

        // Menambahkan listener klik pada tombol "Hitung"
        lakiButton.setOnClickListener {
            // Panggil Rumus Kalori Cowo
            hitungCowo()
        }

        ceweButton.setOnClickListener {
            // Panggil Rumus Kalori Cewe
            hitungCewe()
        }

        return view
    }

    private fun hitungCowo() {
        // Ambil input dari pengguna atau lakukan perhitungan sesuai kebutuhan
        val BB = bb_textfield.text.toString().toInt()
        val TB = tb_textfield.text.toString().toInt()
        val Usia = usia_textfield.text.toString().toInt()

        // Lakukan perhitungan
        val hasil = (10 * BB) + (6.25 * TB) - (5 * Usia) + 5

        // Tampilkan hasil perhitungan
        txt_hasil.text = hasil.toString()
    }

    private fun hitungCewe() {
        // Ambil input dari pengguna atau lakukan perhitungan sesuai kebutuhan
        val BB = bb_textfield.text.toString().toInt()
        val TB = tb_textfield.text.toString().toInt()
        val Usia = usia_textfield.text.toString().toInt()

        // Lakukan perhitungan
        val hasil = (10 * BB) + (6.25 * TB) - (5 * Usia) - 161


        // Tampilkan hasil perhitungan
        txt_hasil.text = hasil.toString()
    }

}