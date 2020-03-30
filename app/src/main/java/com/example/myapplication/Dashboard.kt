package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var lesson1 = "https://firebasestorage.googleapis.com/v0/b/videoappschool.appspot.com/o/3.%20Android%20Errors%20part%203.mp4?alt=media&token=e8d1543b-2f61-41a2-8fe5-cec7484b5488"
        var lesson2 = "https://firebasestorage.googleapis.com/v0/b/videoappschool.appspot.com/o/5.%20Android%20Errors%20part%205.mp4?alt=media&token=49ab974a-519b-43e1-8520-0812e4f1bc16"
        var lesson3 = "https://firebasestorage.googleapis.com/v0/b/videoappschool.appspot.com/o/6.%20Android%20Errors%20part%206.mp4?alt=media&token=b17aed07-dac5-4727-ad47-c3ad236d86ac"
        var lesson4 = "https://firebasestorage.googleapis.com/v0/b/videoappschool.appspot.com/o/7.%20Android%20Errors%20part%207.mp4?alt=media&token=d60c80d1-4b8c-4b7a-9876-96f16349b255"
        var lesson5 = "https://firebasestorage.googleapis.com/v0/b/videoappschool.appspot.com/o/8.%20Android%20Errors%20part%208.mp4?alt=media&token=ec1b58c6-e6c8-4b88-966f-246b3434b080"

        var items = ArrayList<Lesson>()

        items.add(Lesson("Android Dvelopment", "Android errors part 3", lesson1 ))
        items.add(Lesson("Android Dvelopment", "Android errors part 5", lesson2 ))
        items.add(Lesson("Android Dvelopment", "Android errors part 6", lesson3 ))
        items.add(Lesson("Android Dvelopment", "Android errors part 7", lesson4 ))
        items.add(Lesson("Android Dvelopment", "Android errors part 8", lesson5 ))

        val list = findViewById<RecyclerView>(R.id.videos_list)
        val adapter = Adapter(items, applicationContext)

        list.layoutManager = GridLayoutManager(applicationContext, 1)
        list.adapter = adapter


    }
}
