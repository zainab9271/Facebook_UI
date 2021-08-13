package com.example.facebookUiUpdate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
            val constraintsCopy = constraints
            if (situation == "See More"){
                binding.expandableImages.visibility = View.VISIBLE
                constraints.topToBottom = binding.expandableImages.id
                constraints.startToStart = binding.expandableImages.id
                constraints.endToEnd = binding.expandableImages.id
                binding.seeMorePhotos.text = "See Less"
                binding.seeMorePhotosButton.setImageResource(R.drawable.ic_baseline_expand_less_24)
            }else{
                constraints = constraintsCopy
                binding.expandableImages.visibility = View.GONE
                binding.seeMorePhotos.text = "See More"
                binding.seeMorePhotosButton.setImageResource(R.drawable.ic_baseline_expand_more_24)
            }

        }

        binding.seeMorefriendsButton.setOnClickListener {
            val situation = binding.seeMoreFriends.text.toString()
            var constraints = binding.seeMoreFriends.layoutParams as ConstraintLayout.LayoutParams
            val constraintsCopy = constraints
            if (situation == "See More"){
                binding.expandableFriends.visibility = View.VISIBLE
                constraints.topToBottom = binding.expandableFriends.id
                constraints.startToStart = binding.expandableFriends.id
                constraints.endToEnd = binding.expandableFriends.id
                binding.seeMoreFriends.text = "See Less"
                binding.seeMorefriendsButton.setImageResource(R.drawable.ic_baseline_expand_less_24)
            }else{
                constraints = constraintsCopy
                binding.expandableFriends.visibility = View.GONE
                binding.seeMoreFriends.text = "See More"
                binding.seeMorefriendsButton.setImageResource(R.drawable.ic_baseline_expand_more_24)
            }
        }
    }
}