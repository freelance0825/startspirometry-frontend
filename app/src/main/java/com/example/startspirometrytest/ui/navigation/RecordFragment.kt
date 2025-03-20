package com.example.startspirometrytest.ui.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.startspirometrytest.R

class RecordFragment : Fragment() {

    // Declare navigation buttons
    private lateinit var btnDay: Button
    private lateinit var btnWeek: Button
    private lateinit var btnMonth: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.record, container, false)

        // Initialize UI elements
        btnDay = view.findViewById(R.id.btnDay)
        btnWeek = view.findViewById(R.id.btnWeek)
        btnMonth = view.findViewById(R.id.btnMonth)

        val buttons = listOf(btnDay, btnWeek, btnMonth)

        // Set default fragment to DayRecordFragment
        if (savedInstanceState == null) {
            replaceFragment(DayRecordFragment())
            btnDay.isSelected = true
            btnDay.setBackgroundResource(R.drawable.toggle_selected)
        }

        // Handle selection state for navigation buttons
        buttons.forEach { button ->
            button.setOnClickListener {
                buttons.forEach {
                    it.isSelected = false
                    it.setBackgroundResource(android.R.color.transparent) // Reset others
                }
                button.isSelected = true
                button.setBackgroundResource(R.drawable.toggle_selected) // Highlight selected

                // Switch fragment based on button
                when (button.id) {
                    R.id.btnDay -> replaceFragment(DayRecordFragment())
                    R.id.btnWeek -> replaceFragment(WeekRecordFragment())
                    R.id.btnMonth -> replaceFragment(MonthRecordFragment())
                }
            }
        }

        return view
    }

    // Method to replace the fragment dynamically
    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.sub_fragment_container, fragment) // Use a nested fragment container
            .commit()
    }
}
