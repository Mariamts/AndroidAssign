package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.note.view.*

class MainActivity : AppCompatActivity() {
    val noteItem = ArrayList<NoteItem>()
    private var stringSet: ArrayList<String> = ArrayList<String>()


    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val sharedPref = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        val savedAmount = sharedPref.getInt("LENGTH", 0)
        val savedStrings = ArrayList<String>()
        Toast.makeText(
            this@MainActivity,
            "${savedAmount.toString()}",
            Toast.LENGTH_SHORT
        ).show()
        for(i in 0 until savedAmount) {
            savedStrings.add(sharedPref.getString(i.toString(), "").toString())
            noteItem.add(NoteItem(savedStrings[i]))
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter=RecyclerViewAdapter(noteItem)
        recyclerView.adapter=adapter
        adapter.setOnItemClickListener(object : RecyclerViewAdapter.ClickListener {
            override fun onItemClick(v: View, position: Int) {
                noteItem.remove(noteItem[position])
                recyclerView.adapter=adapter
                Toast.makeText(
                    this@MainActivity,
                    "deleted",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })


        buttonAdd.setOnClickListener {


            val input = editTextNote.text.toString()

            if (input.isNotEmpty()) {

                stringSet.add(input.toString())
                sharedPref.edit().putInt("LENGTH" , (stringSet.size + savedAmount).toInt()).apply()
                for (i in 0 until stringSet.size) {
                    sharedPref.edit().putString(i.toString(), stringSet[i]).apply()
                }


                noteItem.add(NoteItem(input))
                recyclerView.adapter=adapter



                editTextNote.setText("")

            }

        }

    }

}