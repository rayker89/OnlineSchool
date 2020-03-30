package com.example.myapplication

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tcking.github.com.giraffeplayer2.VideoView

class Adapter(data:ArrayList<Lesson>, var context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var data:List<Lesson>

    init {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video_item = data[position]

        holder.title.text = video_item.title
        holder.desc.text = video_item.desc
        holder.video.setVideoPath(video_item.videoUrl)

        holder.download.setOnClickListener {

            var download = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            var video_uri = Uri.parse(video_item.videoUrl)
            var get_video = DownloadManager.Request(video_uri)
            get_video.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            download.enqueue(get_video)


        }
    }

    override fun getItemCount(): Int {
        return data.size
    }




    class ViewHolder(item:View) : RecyclerView.ViewHolder(item) {

        var title: TextView
        var desc: TextView
        var video: VideoView
        var download: Button

        init{
            title = item.findViewById(R.id.video_title)
            desc = item.findViewById(R.id.video_desc)
            video = item.findViewById(R.id.lesson_video)
            download = item.findViewById(R.id.video_download)
        }


    }
}