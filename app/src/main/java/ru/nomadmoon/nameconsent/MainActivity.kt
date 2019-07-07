package ru.nomadmoon.nameconsent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var RV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val StrList: Array<String> = arrayOf("odin", "dva", "tri", "4etyre", "pyat", "shest", "odin", "dva", "tri", "4etyre", "pyat", "shest")

        val ll = LinearLayoutManager(this)

        RV = findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager=ll
            adapter=RVAdapter(StrList)
        }
    }
}
