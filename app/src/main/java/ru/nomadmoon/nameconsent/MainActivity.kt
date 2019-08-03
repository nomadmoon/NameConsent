package ru.nomadmoon.nameconsent

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.google.gson.GsonBuilder
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    private lateinit var RV: RecyclerView
    val gson = GsonBuilder().setPrettyPrinting().create()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ins: InputStream = resources.openRawResource(R.raw.rus_names)
        val se = getSharedPreferences("nameconsent", Context.MODE_PRIVATE)
        MainObject.countThreshold = se.getInt("countThreshold", 1000)
        MainObject.countThreshold = se.getString("gender", "М")




        val collectionType = object : TypeToken<ArrayList<NameData>>() {}.type


        try {
            MainObject.mainDB = gson.fromJson(ins.bufferedReader(), collectionType)
        }
        catch (e: JsonParseException)
        {

        }

        updateFilteredNames()
        val StrList: Array<String> = arrayOf("odin", "dva", "tri", "4etyre", "pyat", "shest", "odin", "dva", "tri", "4etyre", "pyat", "shest")

        val ll = LinearLayoutManager(this)

        RV = findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager=ll
            adapter=RVAdapter(MainObject.filteredNames)
        }
    }

    fun updateFilteredNames()
    {
        MainObject.filteredNames.clear()
        MainObject.mainDB.forEach {
            if (it.PeoplesCount>MainObject.countThreshold) MainObject.filteredNames.add(it.Name)
        }
    }
}

class genderButtListener: View.OnClickListener{
    override fun onClick(p0: View) {

    }

}