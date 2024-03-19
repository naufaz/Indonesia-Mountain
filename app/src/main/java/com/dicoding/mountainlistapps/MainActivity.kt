package com.dicoding.mountainlistapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setting recylerView
        val recyclerView: RecyclerView = findViewById(R.id.rv_mountains)
        val recyclerAdapter = RecyclerAdapter()
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data dari resource
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhotoIds = resources.obtainTypedArray(R.array.data_photo)
        val dataGeography = resources.getStringArray(R.array.data_letak)
        val dataPeakHeight = resources.getStringArray(R.array.data_ketinggian)
        val dataMountainType = resources.getStringArray(R.array.data_jenis)
        val dataLowestTemperature = resources.getStringArray(R.array.data_suhu)
        val dataClimbingDuration = resources.getStringArray(R.array.data_durasi)
        val dataMyth = resources.getStringArray(R.array.data_myth)
        val dataDescription = resources.getStringArray(R.array.data_desc)

        // Memasukkan data ke dalam data kelas Mountain
        val mountains = arrayListOf<Mountain>()
        for (position in dataName.indices) {

            // Mendapatkan ID foto langsung dari sumber
            val photoId = dataPhotoIds.getResourceId(position, -1)
            val mountain = Mountain(
                photoId,
                dataName[position],
                dataDesc[position],
                dataGeography[position],
                dataPeakHeight[position],
                dataMountainType[position],
                dataLowestTemperature[position],
                dataClimbingDuration[position],
                dataMyth[position],
                dataDescription[position]
            )
            mountains.add(mountain)
        }
        // Mengembalikan array ke sumber daya setelah digunakan
        dataPhotoIds.recycle()

        //memasukkan data class ke adapter
        recyclerAdapter.mountains = mountains

        // Set toolbar title
        supportActionBar?.title = "Keindahan Gunung Indonesia"
    }

    //  Function agar toolbar selalu muncul ketika apps dibuka
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return true
    }

    // Ketika item person_about di select
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}