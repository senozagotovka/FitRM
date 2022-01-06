package com.example.fitrm.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitrm.databinding.ActivityCategoriesBinding

class CategoriesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            val intent = Intent(this, NavigationActivity::class.java)
            startActivity(intent)
        }
        binding.protein.setOnClickListener {
            val intent = Intent(this, ProteinActivity::class.java)
            startActivity(intent)
        }
        binding.creatine.setOnClickListener {
            val intent = Intent(this, CreatineActivity::class.java)
            startActivity(intent)
        }
        binding.glutamine.setOnClickListener {
            val intent = Intent(this, GlutamineActivity::class.java)
            startActivity(intent)
        }
    }
}