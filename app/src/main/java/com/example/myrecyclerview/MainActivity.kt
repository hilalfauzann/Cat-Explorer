package com.example.myrecyclerview

import android.content.Intent
import android.media.RouteListingPreference.Item
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){

    private lateinit var rvCat: RecyclerView
    private val list = ArrayList<Cat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCat = findViewById(R.id.rv_cat)
        rvCat.setHasFixedSize(true)

        list.addAll(getListCat())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page-> {
                val moveAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun getListCat(): ArrayList<Cat> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listCat = ArrayList<Cat>()
        for (i in dataName.indices) {
            val cat = Cat(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listCat.add(cat)
        }
        return listCat
    }

    private fun showRecyclerList() {
        rvCat.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListCatAdapter(list)
        rvCat.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListCatAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Cat) {
                moveSelectedCat(data)
            }
        })

    }
    private fun moveSelectedCat(cat: Cat) {
        val moveDetail = Intent(this@MainActivity, DetailActivity::class.java)
        moveDetail.putExtra(DetailActivity.EXTRA_CAT, cat)
        startActivity(moveDetail)
    }
}