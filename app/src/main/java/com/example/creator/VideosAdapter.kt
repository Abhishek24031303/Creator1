package com.example.creator

import android.net.Uri
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class VideosAdapter(private val listItems: ArrayList<Videos>):RecyclerView.Adapter<VideosAdapter.VideoViewHolder>() {

    class VideoViewHolder(view: View):RecyclerView.ViewHolder(view){
        val videoTitle : TextView = view.findViewById(R.id.txtVideoTitle)
        val videoDesc : TextView = view.findViewById(R.id.txtVideoDescription)
        val videoView : VideoView = view.findViewById(R.id.videoView)
        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_container_video,parent,false)
        return VideoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {

        val videos = listItems[position]
        holder.videoTitle.text = videos.videoTitle
        holder.videoDesc.text = videos.videoDescription
        holder.videoView.setVideoPath(videos.videoUrl)
        holder.videoView.setOnPreparedListener{
            holder.progressBar.visibility   = View.GONE
            it.start()

            val videoRatio: Float = it.videoWidth/(it.videoHeight.toFloat())
            val screenRatio : Float = holder.videoView.width/ holder.videoView.height.toFloat()
            val scale : Float = videoRatio / screenRatio

            if(scale >= 1f){
                holder.videoView.scaleX = scale
            }else {
                holder.videoView.scaleY = 1f / scale
            }
        }
        holder.videoView.setOnCompletionListener {
            it.start()
        }
    }

}


