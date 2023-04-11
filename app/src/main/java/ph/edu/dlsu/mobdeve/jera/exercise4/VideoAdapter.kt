package ph.edu.dlsu.mobdeve.jera.exercise4

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class VideoAdapter (private val videoList: ArrayList<Content>) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder> () {

    var onItemClick : ((Content) -> Unit)? = null


    class VideoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val etTitle : TextView = itemView.findViewById(R.id.etVidTitle)
        val etDuration : TextView = itemView.findViewById(R.id.etDuration)
        val etCreator : TextView = itemView.findViewById(R.id.etVidCreator)
        val thumbnail : ImageView = itemView.findViewById(R.id.thumbnail)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoAdapter.VideoViewHolder, position: Int) {
        val video = videoList[position]
        holder.etTitle.text = video.title
        holder.etCreator.text = video.creator.name
        holder.etDuration.text = video.duration
        holder.thumbnail.setImageResource(video.creator.thumbnail)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(video)
        }
    }

    override fun getItemCount(): Int {
        return videoList.size
    }
}