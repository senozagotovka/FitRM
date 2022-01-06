package com.example.fitrm.activity

import android.os.Bundle
import android.widget.Toast
import com.example.fitrm.databinding.ActivityVideoBinding
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer

class VideoActivity : YouTubeBaseActivity() {
    private lateinit var binding: ActivityVideoBinding
    val video_id1 = "iybfiQSVgYk"
    val video_id2 = "B0eAmMa25fU"
    private val youtubeApikey = "AIzaSyAPjSCR01bk47vMOfGyy7ginsa-6afc_g0"
    private lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener
    private lateinit var youtubePlayerInit2: YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo(video_id1)
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {

                val text = "Failed"
                Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
            }

        }

        youtubePlayerInit2 = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo(video_id2)
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {

                val text = "Failed"
                Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
            }

        }

        binding.toolbar.setNavigationOnClickListener {
           finish()
        }

        binding.btnPlay.setOnClickListener {
            binding.youtubePlayer1.initialize(youtubeApikey, youtubePlayerInit)
        }
        binding.btnPlay2.setOnClickListener {
            binding.youtubePlayer2.initialize(youtubeApikey, youtubePlayerInit2)
        }
    }
}
