package com.example.dambite.rest

import com.google.gson.annotations.SerializedName

data class ListaDePlatosResponse(
    @SerializedName("meals")
    val meals: List<PlatoResponse>
)