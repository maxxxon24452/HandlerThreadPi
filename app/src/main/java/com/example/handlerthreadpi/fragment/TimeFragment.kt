package com.example.handlerthreadpi.fragment

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer.OnChronometerTickListener
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.handlerthreadpi.databinding.FragmentTimeBinding
import java.util.*


class TimeFragment : Fragment() {
    lateinit var binding: FragmentTimeBinding
    private lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimeBinding.inflate(inflater, container, false)

        binding.chronometer.setFormat("Time: %s")
        binding.chronometer.setBase(SystemClock.elapsedRealtime())
        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        binding.chronometer.setOnChronometerTickListener(OnChronometerTickListener { chronometer ->
            if (SystemClock.elapsedRealtime() - chronometer.base >= 20000) {
                binding.notificationBackground.setBackgroundColor(color)
            }
        })
        binding.PlayTime.setOnClickListener {
            binding.chronometer.start()
        }
       binding.PauseTime.setOnClickListener {
           binding.chronometer.stop()
       }
        binding.ResetTime.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime()
        }

//        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
//        if (SystemClock.elapsedRealtime() - binding.chronometer.base <= 20){
//            binding.notificationBackground.setBackgroundColor(color)
//        }else{
//
//        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.chronometer.start()
    }

    override fun onStop() {
        super.onStop()
      binding.chronometer.stop()
    }



    companion object {

        @JvmStatic
        fun newInstance() =TimeFragment()
    }
}