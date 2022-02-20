package com.example.lesson20.data.network.retrofit.models

import com.google.gson.annotations.SerializedName

data class Cat(
    val id: String,
    val url: String,
    val category: List<Category>,
    val breeds: List<Breed>
)

data class Category(val id: Int, val name: String)

data class Breed(val name: String, @SerializedName("wikipedia_url") val wikipediaUrl: String)