package com.example.startspirometrytest

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.startspirometrytest.ui.navigation.DashboardFragment
import com.example.startspirometrytest.ui.navigation.ProfileFragment
import com.example.startspirometrytest.ui.navigation.RecordFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navDashboard: LinearLayout
    private lateinit var navRecord: LinearLayout
    private lateinit var navProfile: LinearLayout

    private lateinit var imgDashboard: ImageView
    private lateinit var imgRecord: ImageView
    private lateinit var imgProfile: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // Initialize UI components
        navDashboard = findViewById(R.id.nav_dashboard)
        navRecord = findViewById(R.id.nav_record)
        navProfile = findViewById(R.id.nav_profile)

        imgDashboard = findViewById(R.id.img_dashboard)
        imgRecord = findViewById(R.id.img_record)
        imgProfile = findViewById(R.id.img_profile)

        // Load DashboardFragment by default
        if (savedInstanceState == null) {
            replaceFragment(DashboardFragment())
            setSelected(imgDashboard) // Set initial selection
        }

        // Set up navigation listeners
        setupNavigation()
    }

    private fun setupNavigation() {
        navDashboard.setOnClickListener {
            setSelected(imgDashboard)
            replaceFragment(DashboardFragment())
        }

        navRecord.setOnClickListener {
            setSelected(imgRecord)
            replaceFragment(RecordFragment())
        }

        navProfile.setOnClickListener {
            setSelected(imgProfile)
            replaceFragment(ProfileFragment())
        }
    }

    // Function to update selected item color
    private fun setSelected(selectedImage: ImageView) {
        val defaultColor = ContextCompat.getColor(this, R.color.black) // Default color
        val selectedColor = ContextCompat.getColor(this, R.color.blue) // Selected color

        // Reset all to default
        imgDashboard.setColorFilter(defaultColor)
        imgRecord.setColorFilter(defaultColor)
        imgProfile.setColorFilter(defaultColor)

        // Set selected color
        selectedImage.setColorFilter(selectedColor)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
