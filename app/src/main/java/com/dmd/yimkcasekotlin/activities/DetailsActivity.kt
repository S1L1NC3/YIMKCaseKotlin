package com.dmd.yimkcasekotlin.activities

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import com.dmd.yimkcasekotlin.R
import com.dmd.yimkcasekotlin.models.News
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val newsExtra = intent.getSerializableExtra(R.string.detailsExtrasKey.toString())
        arrangeDatas(newsExtra as News)
    }

    private fun arrangeDatas(news: News){
        txtNewsDetailHeader.text = news.title
        txtNewsDetailDescription.text = news.spot

        val uri = Uri.parse(news.videoUrl)
        videoViewDetails.setVideoURI(uri)
        videoViewDetails.start()
    }

    fun playPauseMethod(view: View){
        if (videoViewDetails.isPlaying){
            videoViewDetails.pause()
            toggleVisibility()
        } else {
            videoViewDetails.start()
            toggleVisibility()
        }
    }

    private fun toggleVisibility() {
        val unwrappedDrawable: Drawable? = AppCompatResources.getDrawable(applicationContext, R.drawable.pause)

        val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
        DrawableCompat.setTint(wrappedDrawable, Color.WHITE)

        if (videoViewDetails.isPlaying){
            playPauseButton.setImageDrawable(null)
        } else {
            playPauseButton.setImageDrawable(unwrappedDrawable)
            playPauseButton.colorFilter
        }

    }
}