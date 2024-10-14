package com.faniillahi.appklinik_fani

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.faniillahi.appklinik_fani.adapter.AdapterListDoctors
import com.faniillahi.appklinik_fani.adapter.AdapterMenuIcon
import com.faniillahi.appklinik_fani.model.ModelIcon
import com.faniillahi.appklinik_fani.model.ModelListDosctors

class DoctorsPageActivity : AppCompatActivity() {

    private lateinit var RecyclerViewMenu : RecyclerView
    private lateinit var AdapterMenu : AdapterMenuIcon

    private lateinit var RecyclerViewDoctor : RecyclerView
    private lateinit var AdapterDoctor : AdapterListDoctors

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctors_page)

        //data contoh untuk menu
        val menuIcons = listOf(
            ModelIcon(R.drawable.icon_heart,"cardiologist"),
            ModelIcon(R.drawable.icon_eye,"Ophthalmologyst"),
            ModelIcon(R.drawable.icon_tooth,"Dentist")
        )


        //inisialisasi recyclerview dan adapter
        RecyclerViewMenu = findViewById(R.id.recycleViewMenu)
        RecyclerViewMenu.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        AdapterMenu = AdapterMenuIcon(menuIcons)
        RecyclerViewMenu.adapter = AdapterMenu

        //data untuk dokter
        val menudokter = listOf(
            ModelListDosctors("Dr.Floyd Miles",R.drawable.dokter1,R.drawable.bintang,"Pediatrics","(123 reviews)","4.9"),
            ModelListDosctors("Dr.Guy Hawkins",R.drawable.dokter2,R.drawable.bintang,"Dentist","(85 reviews)","4.9"),
            ModelListDosctors("Dr.Jane Cooper",R.drawable.dokter3,R.drawable.bintang,"Cardiologist","(44 reviews)","4.7"),
            ModelListDosctors("Dr.Jacob Jones",R.drawable.dokter4,R.drawable.bintang,"Nephrologyst","(101 reviews)","5.0"),
            ModelListDosctors("Dr.Savannah Nguyen",R.drawable.dokter5,R.drawable.bintang,"Urologist","(168 reviews)","4.8")
        )

        //inisialisasi recycleview dan adapter
        RecyclerViewDoctor = findViewById(R.id.recycleViewDoctor)
        RecyclerViewDoctor.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        AdapterDoctor= AdapterListDoctors(menudokter)
        RecyclerViewDoctor.adapter = AdapterDoctor


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}