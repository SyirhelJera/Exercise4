package ph.edu.dlsu.mobdeve.jera.exercise4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var  recyclerView: RecyclerView
    private lateinit var videoList: ArrayList<Content>
    private lateinit var videoAdapter: VideoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.contentRecycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)


        videoList = ArrayList()

        videoList.add(Content("sample", Creator("sai", R.drawable.a), "14:42"))
        videoList.add(Content("sample", Creator("ewan", R.drawable.b), "14:42"))
        videoList.add(Content("sample", Creator("jennifer", R.drawable.c), "14:42"))
        videoList.add(Content("sample", Creator("ryujin", R.drawable.d), "14:42"))
        videoList.add(Content("sample", Creator("sai", R.drawable.a), "14:42"))
        videoList.add(Content("sample", Creator("ewan", R.drawable.b), "14:42"))
        videoList.add(Content("sample", Creator("jennifer", R.drawable.c), "14:42"))
        videoList.add(Content("sample", Creator("ryujin", R.drawable.d), "14:42"))
        //Sort Button
        val myButton = findViewById<Button>(R.id.filterButton)
        myButton.setOnClickListener {
            videoList.sortBy { it.creator.name }
            videoAdapter.notifyDataSetChanged()
        }

        videoAdapter = VideoAdapter(videoList)
        recyclerView.adapter = videoAdapter


//        val contentButton = findViewById<ImageButton>(R.id.contentButton)
//        val profileButton = findViewById<ImageButton>(R.id.profileButton)
//
//        contentButton.setOnClickListener(){
//            val intent = Intent(this, Detailed::class.java)
//            startActivity(intent)
//        }

        videoAdapter.onItemClick = {
            val intent = Intent(this, Detailed::class.java)
            intent.putExtra("Content", it)
            startActivity(intent)
        }


    }
}

