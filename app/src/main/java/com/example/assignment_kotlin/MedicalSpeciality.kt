package com.example.assignment_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MedicalSpeciality : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medical_speciality)


        var list = ArrayList<MedicalSpecialtyResponseModel>()
        list.add(
            MedicalSpecialtyResponseModel(
                "Cardiologist",
                "For Heart related issues",
                "Common symptoms are chest pain, high blood pressure, anxiety"
            )
        )
        list.add(
            MedicalSpecialtyResponseModel(
                "Gyneacologist",
                "Women's health issues",
                "Pregnancy, irregular periods, PCOD"
            )
        )
        list.add(
            MedicalSpecialtyResponseModel(
                "Orthopedist",
                "Bones and Joint issues",
                "Get an initial diagnosis on your head to toe ortho-related issues with our online orthopedists. When to see: Pain after fall, accident or such incident, severe pain in body parts, etc."
            )
        )
        list.add(
            MedicalSpecialtyResponseModel(
                "Oncologist",
                "For Cancer Treatment",
                "Ongoing cancer treatment? Need to consult with an expert? Find oncologists from across the country here. Common Symptoms: Ongoing treatment, severe pain, fatigue, bleeding, sudden weight change & skin changes, etc."
            )
        )
        list.add(
            MedicalSpecialtyResponseModel(
                "Ophthalmologist",
                "Eye Health Issues",
                "We take care of eye and vision health. Get in touch with our ophthalmologist here. Common symptoms: migraine, headache, shingle, etc."
            )
        )
        list.add(
            MedicalSpecialtyResponseModel(
                "Neurologist",
                "For Brain Issues",
                "Find the best consultant neurologist for conditions like general diagnostic neurology. Common symptoms: headache including migraine, neuromuscular disorders, etc."
            )
        )



        val numberOfColumns = 2
            findViewById<RecyclerView>(R.id.rvMedicalSpeciality).layoutManager =
            GridLayoutManager(this, numberOfColumns)
        val spanCount = 2
        val spacing = 10
        val includeEdge = true
        findViewById<RecyclerView>(R.id.rvMedicalSpeciality).addItemDecoration(
            GridSpacingItemDecoration(
                spanCount,
                spacing,
                includeEdge

            )
        )

        // layoutBinding.rvMedicalSpeciality.autoFitColumns(150)

//        findViewById<RecyclerView>(R.id.rvMedicalSpeciality).onFlingListener = null

        findViewById<RecyclerView>(R.id.rvMedicalSpeciality).onFlingListener = null

        findViewById<RecyclerView>(R.id.rvMedicalSpeciality).adapter =  MedicalSpecialtyAdapter(list)


    }
}