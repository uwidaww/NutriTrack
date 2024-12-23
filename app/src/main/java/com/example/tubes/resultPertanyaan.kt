package com.example.tubes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.aallam.openai.api.chat.ChatCompletion
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.http.Timeout
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds


private lateinit var selanjutnya: Button
private lateinit var kembali: Button
private lateinit var hasili: TextView

class resultPertanyaan : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var Data = promptData()

        var text = "Hitungkan kebutuhan kalori untuk program menaikkan berat badan berdasarkan biodata berikut:\n" +
                "\n" +
                "Tanggal Lahir: " +  Data.tglLahir +"\n" +
                "Jenis Kelamin: " + Data.kelamin + "\n" +
                "Tinggi Badan: "+Data.tinggiBadan+" cm\n" +
                "Berat Badan: "+Data.beratBadan+" kg\n" +
                "Konsumsi Air: "+Data.air+"\n" +
                "Olahraga: "+Data.banyakOlahraga+"\n" +
                "Aktivitas Harian: "+Data.aktivitasHarian+"\n" +
                "Pola Makan: "+Data.polaMakan+"n\n" +
                "Tujuan: "+Data.tujuan+ "."

        // Inflate the layout for this fragment

        var AI = openAII()


        val x = AI.getAIRESPONSE(text)



        val view = inflater.inflate(R.layout.fragment_result_pertanyaan, container, false)
        hasili = view.findViewById(R.id.hasil)
        kembali = view.findViewById(R.id.button_backHasil)
        selanjutnya = view.findViewById(R.id.button_nextHasil)
        hasili.text = x.toString()



        selanjutnya.setOnClickListener {
            (activity as MainActivity).loadFragment(berandaFragment())
        }
        kembali.setOnClickListener {
            (activity as MainActivity).loadFragment(pertanyaanSatu())
        }
        return view
        }


}
