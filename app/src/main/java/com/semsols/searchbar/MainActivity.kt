package com.semsols.searchbar

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countryName = resources.getStringArray(R.array.countries_array)

        val countryAdapter : ArrayAdapter<String> = ArrayAdapter(
            this,android.R.layout.simple_list_item_1,
            countryName
        )

        listView.adapter = countryAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {

                searchView.clearFocus()
                if(countryName.contains(query)){

                    countryAdapter.filter.filter(query)
                }

                return false


            }

            override fun onQueryTextChange(newText: String?): Boolean {

                countryAdapter.filter.filter(newText)
                return false

            }


        })


    }


}