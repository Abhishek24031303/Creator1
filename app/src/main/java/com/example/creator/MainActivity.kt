package com.example.creator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewpager : ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager = findViewById(R.id.videoViewPager)
        val video = arrayListOf(Videos("https://dm0qx8t0i9gc9.cloudfront.net/watermarks/video/NIHmZbghlilb1qj7b/videoblocks-sunrise-in-the-sequoias-general-grant-grove-sequoia-national-park_s40w-ptgl__adea1b84e34a7b3dd874bc7381664e18__P360.mp4",
            "The forest","Forest consist of plenty of elements and that elements are from years and years."),
            Videos("https://cdn.videvo.net/videvo_files/video/free/2019-08/small_watermarked/190301_02_KenyaWildlife_25_preview.webm",
            "The king",
            "The lion, also known as the king of the jungle. He is always shown in screen as the ruler of the wild."),
            Videos("https://assets.mixkit.co/videos/preview/mixkit-lake-surrounded-by-dry-grass-in-the-savanna-5030-large.mp4",
            "Somewhere",
            "Calmness enters directly into the inner soul of the body"))

        videoViewPager.adapter = VideosAdapter(video)
    }
}