package com.example.myrecyclerview
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity: AppCompatActivity() {
     private lateinit var imageDetail : ImageView
     private lateinit var titleDetail : TextView
     private lateinit var descDetail : TextView

    companion object {
        const val EXTRA_CAT = "extra_cat"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val cat = intent.getParcelableExtra<Cat>(EXTRA_CAT)

        imageDetail = findViewById(R.id.imageView)
        titleDetail = findViewById(R.id.textViewTitle)
        descDetail = findViewById(R.id.textViewOverview)

        if (cat != null) {
            titleDetail.text = cat.name
            descDetail.text = cat.description
            imageDetail.setImageResource(cat.photo)
        }
    }
}



