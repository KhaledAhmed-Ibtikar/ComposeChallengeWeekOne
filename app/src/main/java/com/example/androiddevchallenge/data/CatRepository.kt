/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.entities.Cat

object CatRepository {

    fun generateRandomCatList(size: Int) =
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
        R.drawable.cat7,
        R.drawable.cat8,
        R.drawable.cat9,
        R.drawable.cat10,
        R.drawable.cat11,
        R.drawable.cat12,
        R.drawable.cat13,
        R.drawable.cat14
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
