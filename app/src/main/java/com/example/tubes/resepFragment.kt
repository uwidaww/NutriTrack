package com.example.tubes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class resepFragment : Fragment() {
    private lateinit var recycler: RecyclerView
    private lateinit var dataList: ArrayList<dataClassRv>
    private lateinit var imageList: Array<Int>
    private lateinit var titleList: Array<String>
    private lateinit var kaloriList: Array<String>
    private lateinit var myAdapter: AdapterClass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_resep, container, false)

        // Initialize data arrays
        imageList = arrayOf(
            R.drawable.bubur,
            R.drawable.burjo,
            R.drawable.pecel,
            R.drawable.cheese_quesadilla,
            R.drawable.rujak,
            R.drawable.bubur_pisang,
            R.drawable.kangkung,
            R.drawable.somtam
        )

        titleList = arrayOf(
            "Bubur Ayam",
            "Bubur Kacang Hijau",
            "Pecel",
            "Cheese Quesadilla",
            "Rujak Buah",
            "Bubur Pisang",
            "Tumis Kangkung",
            "Somtam"
        )

        kaloriList = arrayOf(
            "± 250-350 kkal",
            "± 200-300 kkal",
            "± 200-300 kkal",
            "± 400-500 kkal",
            "± 100-150 kkal",
            "± 300-400 kkal",
            "± 300-450 kkal",
            "± 500-650 kkal"
        )



        // Initialize RecyclerView
        recycler = view.findViewById(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.setHasFixedSize(true)

        // Initialize data list and adapter
        dataList = arrayListOf()
        myAdapter = AdapterClass(dataList)
        recycler.adapter = myAdapter

        // Load data into the adapter
        getData()

        // Set item click listener
        myAdapter.onItemClick = {
            val intent = Intent(requireContext(), detailResep::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }

        return view
    }

    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = dataClassRv(imageList[i], titleList[i], kaloriList[i])
            dataList.add(dataClass)
        }

        // Notify adapter about data changes
        myAdapter.notifyDataSetChanged()
    }
}
