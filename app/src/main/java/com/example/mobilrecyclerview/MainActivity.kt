package com.example.mobilrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Mobil>

    private val imageId = arrayOf(
        R.drawable.creta,
        R.drawable.ioniq5,
        R.drawable.ioniq6,
        R.drawable.palisade,
        R.drawable.stargazer,
        R.drawable.staria
    )

    private val heading = arrayOf(
        "Creta", "Ioniq 5", "Ioniq 6", "Palisade", "Stargazer", "Staria"
    )

    private val description = arrayOf(
        R.string.mobil_creta,
        R.string.mobil_ioniq5,
        R.string.mobil_ioniq6,
        R.string.mobil_palisade,
        R.string.mobil_stargazer,
        R.string.mobil_staria
    )

    private lateinit var binding: ActivityMainBinding // View Binding instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        newRecyclerView = binding.recyclerView // Use View Binding to access RecyclerView
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = ArrayList()
        getUserData()
    }

    private fun getUserData() {
        for (i in imageId.indices) {
            val mobil = Mobil(imageId[i], heading[i])
            newArrayList.add(mobil)
        }

        val adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, MobilActivity::class.java)
                intent.putExtra("heading", newArrayList[position].heading)
                intent.putExtra("image", newArrayList[position].titleImage)
                intent.putExtra("description", getString(description[position]))
                startActivity(intent)
            }
        })
    }
}
