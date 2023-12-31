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

    private val image = arrayOf(
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

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newRecyclerView = binding.recyclerView
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = ArrayList()
        getUserData()
    }

    private fun getUserData() {
        for (i in image.indices) {
            val mobil = Mobil(image[i], heading[i], (getString(description[i])))
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
