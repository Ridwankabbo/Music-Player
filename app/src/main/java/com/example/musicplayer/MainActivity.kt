package com.example.musicplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var privious:ImageView
    private lateinit var pause_play:ImageView
    private lateinit var next:ImageView

    private lateinit var mediaPlayer:MediaPlayer

    var n = 0
    var music_index = 0
    private var music_list = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        privious = findViewById(R.id.previous)
        pause_play = findViewById(R.id.pause_play)
        next = findViewById(R.id.next)

        initializeMusic()

        mediaPlayer = MediaPlayer.create(this, music_list[music_index])

        privious.setOnClickListener(this)
        pause_play.setOnClickListener(this)
        next.setOnClickListener(this)

    }

    fun initializeMusic(){
        music_list.add(R.raw.mixkit_beautiful_dream)
        music_list.add(R.raw.background_piano_music)
    }

    override fun onClick(v: View?) {
        if(v!!.id == pause_play.id){
            n++
            if(n % 2 != 0){
                mediaPlayer.start()
                pause_play.setImageResource(R.drawable.pause)
            }
            else{
                mediaPlayer.stop()
                pause_play.setImageResource(R.drawable.play)
            }
        }

        if(v!!.id == next.id){
            music_index++
            mediaPlayer = MediaPlayer.create(this, music_list[music_index])
            n = 0
        }

        if(v!!.id == privious.id){
            music_index--
            mediaPlayer = MediaPlayer.create(this, music_list[music_index])
            n = 0
        }
    }
}