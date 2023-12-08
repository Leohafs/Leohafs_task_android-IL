package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        var viewPager : ViewPager = findViewById(R.id.viewpager)
        var tabLayout : TabLayout = findViewById(R.id.tablayout)

        val fragmentAdapter = ImageAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(CatFragment(),"Cat")
        fragmentAdapter.addFragment(DogFragment(),"Dog")

        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}