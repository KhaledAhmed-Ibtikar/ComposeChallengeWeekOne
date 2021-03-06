package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.entities.Cat

object CatRepository {

    fun generateRandomCatList(size : Int) =
        mutableListOf<Cat>().apply {
            for (i in 0 until size) {
                add(
                    Cat(
                        image = imageList.random(),
                        name = nameList.random(),
                        age = (1..4).random(),
                        gender = listOf("Male", "Female").random(),
                        location = locationList.random(),
                        summary = summaryList.random()
                    )
                )
            }
        }

    private val imageList = listOf(
        R.drawable.cat1,
        R.drawable.cat2,
        R.drawable.cat3,
        R.drawable.cat4,
        R.drawable.cat5,
        R.drawable.cat6,
        R.drawable.cat7
    )

    private val nameList = listOf(
        "Nala",
        "Leia",
        "Princess",
        "Honey",
        "Cassie",
        "Lady",
        "Sam",
        "Charlie",
        "Sparky",
        "Tasha",
        "Coco",
        "Jessie",
        "Molly",
        "Tyson",
        "Penny",
        "Tess",
    )

    private val locationList = listOf(
        "Alexandria",
        "Cairo",
        "Tanta",
        "Mansoura",
        "Aswan",
        "Giza",
        "Port Said",
        "Hurghada",
        "Faiyum",
        "Luxor",
        "Dahab",
        "Damanhour"
    )

    private val summaryList = listOf(
        R.string.summary1,
        R.string.summary2,
        R.string.summary3,
        R.string.summary4,
        R.string.summary5,
    )
}