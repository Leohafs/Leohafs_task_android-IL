package com.example.app

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var adapter: AnimalAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var animalList: ArrayList<Animal>

    private lateinit var imageId : Array<Int>
    private lateinit var headingId : Array<String>
    private lateinit var deskripsiId : Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val imageButton: Button = view.findViewById(R.id.btn_image)

        imageButton.setOnClickListener {
            val intent = Intent(activity, ImageActivity::class.java)
            startActivity(intent)

            activity?.overridePendingTransition(0, 0)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataintialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyle_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AnimalAdapter(animalList)
        recyclerView.adapter = adapter
    }

    private fun dataintialize(){

        animalList = arrayListOf()

        imageId = arrayOf(
            R.drawable.kc_1,
            R.drawable.kc_2,
            R.drawable.kc_3,
            R.drawable.kc_4,
            R.drawable.kc_5,
            R.drawable.aj_1,
            R.drawable.aj_2,
            R.drawable.aj_3,
        )

        headingId = arrayOf(
            getString(R.string.anm_1),
            getString(R.string.anm_2),
            getString(R.string.anm_3),
            getString(R.string.anm_4),
            getString(R.string.anm_5),
            getString(R.string.anm_6),
            getString(R.string.anm_7),
            getString(R.string.anm_8),
        )

        deskripsiId = arrayOf(
            getString(R.string.desk_1),
            getString(R.string.desk_2),
            getString(R.string.desk_3),
            getString(R.string.desk_4),
            getString(R.string.desk_5),
            getString(R.string.desk_6),
            getString(R.string.desk_7),
            getString(R.string.desk_8),
        )

        for(i in imageId.indices){
            val animal = Animal(imageId[i],headingId[i],deskripsiId[i])
            animalList.add(animal)
        }
    }
}