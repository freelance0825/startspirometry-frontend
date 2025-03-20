package com.example.startspirometrytest.ui.navigation

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.startspirometrytest.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class DayRecordFragment : Fragment() {

    private lateinit var chart: LineChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.day_record_fragment, container, false)

        // Find the chart from the layout
        chart = view.findViewById(R.id.spirometryChart)

        // Setup the chart with daily data
        setupChart()

        return view
    }

    private fun setupChart() {
        // Example Daily Data (Time vs FEV1)
        val entries = mutableListOf<Entry>()
        entries.add(Entry(6f, 100f))  // 6:00 AM - 100 L/m
        entries.add(Entry(7f, 300f))  // 7:00 AM - 300 L/m
        entries.add(Entry(8f, 400f))  // 8:00 AM - 400 L/m
        entries.add(Entry(9f, 400f))  // 9:00 AM - 400 L/m
        entries.add(Entry(10f, 450f)) // 10:00 AM - 450 L/m

        val dataSet = LineDataSet(entries, "FEV1 Readings").apply {
            color = Color.BLUE
            valueTextColor = Color.BLACK
            setCircleColor(Color.BLUE)
            setDrawFilled(true)
            fillColor = Color.BLUE
            fillAlpha = 50
            lineWidth = 2f
            circleRadius = 5f
        }

        val lineData = LineData(dataSet)
        chart.data = lineData

        // Configure X-Axis
        val xAxis = chart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.textColor = Color.BLACK

        // Configure Y-Axis
        chart.axisLeft.textColor = Color.BLACK
        chart.axisRight.isEnabled = false
        chart.axisLeft.setDrawGridLines(true)

        // Hide legend and chart description
        chart.legend.isEnabled = false
        chart.description.isEnabled = false

        chart.invalidate() // Refresh the chart
    }
}
