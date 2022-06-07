package com.example.handlerthreadpi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.handlerthreadpi.databinding.ActivityMainBinding
import com.example.handlerthreadpi.fragment.PiFragment
import com.example.handlerthreadpi.fragment.TimeFragment
import java.math.BigDecimal


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction().replace(R.id.place_holder, PiFragment.newInstance())
            .commit()
        supportFragmentManager
            .beginTransaction().replace(R.id.place_holder_time, TimeFragment.newInstance())
            .commit()


    }

}
