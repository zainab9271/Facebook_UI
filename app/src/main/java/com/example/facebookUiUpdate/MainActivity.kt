package com.example.facebookUiUpdate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.facebookUiUpdate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        callBacks()
    }
    private fun callBacks() {
        binding.seeMorePhotosButton.setOnClickListener {
            val situation = binding.seeMorePhotos.text.toString()
            var constraints = binding.seeMorePhotos.layoutParams as ConstraintLayout.LayoutParams

            if (situation == "See More"){
                expand(binding.expandableImages,constraints, binding.seeMorePhotos, binding.seeMorePhotosButton)
            }else{
                shrink(binding.expandableImages,constraints, binding.seeMorePhotos, binding.seeMorePhotosButton)
            }

        }

        binding.seeMorefriendsButton.setOnClickListener {
            val situation = binding.seeMoreFriends.text.toString()
            var constraints = binding.seeMoreFriends.layoutParams as ConstraintLayout.LayoutParams
            if (situation == "See More"){
                expand(binding.expandableFriends, constraints, binding.seeMoreFriends, binding.seeMorefriendsButton)
            }else{
                shrink(binding.expandableFriends, constraints, binding.seeMoreFriends, binding.seeMorefriendsButton)
            }
        }
    }

    private fun shrink(layout: ConstraintLayout, constraints: ConstraintLayout.LayoutParams, view: TextView, button: ImageButton) {
        layout.visibility = View.GONE
        view.layoutParams = constraints
        view.text = "See More"
        button.setImageResource(R.drawable.ic_baseline_expand_more_24)
    }

    private fun expand(layout: ConstraintLayout, constraints: ConstraintLayout.LayoutParams, view: TextView, button: ImageButton) {
        layout.visibility = View.VISIBLE
        constraints.topToBottom = layout.id
        constraints.startToStart = layout.id
        constraints.endToEnd = layout.id
        view.text = "See Less"
        button.setImageResource(R.drawable.ic_baseline_expand_less_24)
    }
}