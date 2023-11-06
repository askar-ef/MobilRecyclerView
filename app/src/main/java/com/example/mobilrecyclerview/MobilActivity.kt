package com.example.mobilrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobilrecyclerview.databinding.ActivityMobilBinding

class MobilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMobilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMobilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val bundle: Bundle? = intent.extras
            val heading = bundle?.getString("heading")
            val image = bundle?.getInt("image")
            val description = bundle?.getString("description")

            headingMobil.text = heading
            descriptionMobil.text = description
            imageMobil.setImageResource(image ?: R.drawable.ioniq5)
        }
    }
}
