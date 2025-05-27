package com.example.musicplayer

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MusicListActivity : AppCompatActivity() {


    lateinit var listView: ListView

    //lateinit var music_list_adapter:ArrayAdapter<String>
//    lateinit var music_list:arr

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_music_list)

        listView = findViewById(R.id.music_list)

//        val music_list = resources.getStringArray(R.array.music_name).toString()
        // In your Activity/Fragment:
        val music_array: Array<String> = resources.getStringArray(R.array.music_name)

        // Then, use it with ArrayAdapter:
       val music_list_adapter = ArrayAdapter(this,R.layout.sample_layout, R.id.sample_item, music_array)
        listView.adapter = music_list_adapter

        listView.setOnItemClickListener{parent, view, position, id ->
            var song_index = music_array[position]
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("index",song_index)
            startActivity(intent)
        }


    }
}