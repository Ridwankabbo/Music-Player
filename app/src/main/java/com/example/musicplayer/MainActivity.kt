package com.example.musicplayer

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.SyncStateContract.Constants
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

    private var n = 0
    private var music_index = 0
    private var music_list = ArrayList<Int>()

    private lateinit var  recivedIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        privious = findViewById(R.id.previous)
        pause_play = findViewById(R.id.pause_play)
        next = findViewById(R.id.next)

        initializeMusic()
        getMusicIndex()

        mediaPlayer = MediaPlayer.create(this, music_list[music_index])

        privious.setOnClickListener(this)
        pause_play.setOnClickListener(this)
        next.setOnClickListener(this)

    }

    fun initializeMusic(){
        music_list.add(R.raw.background_piano_music)
        music_list.add(R.raw.lost_ambient)
        music_list.add(R.raw.mixkit_beautiful_dream)
        music_list.add(R.raw.mixkit_pop_05)
        music_list.add(R.raw.mixkit_relaxing_in_nature)
        music_list.add(R.raw.sad_ambient_piano_cinematic_thinking_in_silence)
        music_list.add(R.raw.sad_waltz_piano_music)
        music_list.add(R.raw.the_longest_night_solo_piano_track)
    }

    override fun onClick(v: View?) {
        if(v!!.id == pause_play.id){
            n++
            if(n % 2 != 0){
                mediaPlayer.start()
                pause_play.setImageResource(R.drawable.pause)
            }
            else{
                mediaPlayer.pause()
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


    fun getMusicIndex(){
        recivedIntent = Intent()
        val extras:Bundle? = recivedIntent.extras
        if(extras != null){
            music_index = extras.getString("index")!!.toInt()
        }

    }


}