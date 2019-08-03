package ru.nomadmoon.nameconsent

import java.util.ArrayList

object MainObject
{
    var mainDB: ArrayList<NameData> = ArrayList()
    var filteredNames: ArrayList<String> = ArrayList()
    var countThreshold: Int = 1000
    var gender: String = "М"

}


data class NameData(val ID: Int, val Name: String, val Sex: String, val PeoplesCount: Int, val WhenPeoplesCount: String, val Source: String)