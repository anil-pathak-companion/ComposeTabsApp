package com.pathak.dogs.ui.features

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavType
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.pathak.dogs.data.model.Breed

object NavGraph {
    const val Home = "home"
    const val BreedDetail = "breedDetail"
    fun createNavLink(breed: Breed): String {
        val url = "$BreedDetail?breed=${GsonObject.toJson(breed)}"
        Log.d("Url generated", url)
        return url
    }

}

object NavGraphArguments {
    const val BreedId = "breedId"
}

class BreedType : NavType<Breed>(isNullableAllowed = true) {
    override fun get(bundle: Bundle, key: String): Breed? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, Breed::class.java)
        } else {
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): Breed {
        return GsonObject.fromJson(value)
    }

    override fun put(bundle: Bundle, key: String, value: Breed) {
        bundle.putParcelable(key, value)
    }
}

object GsonObject {
    var gson: Gson = GsonBuilder().setLenient().create()

    inline fun <reified T> fromJson(json: String): T =
        gson.fromJson(json, object : TypeToken<T>() {}.type)

    fun toJson(any: Any): String =
        gson.toJson(any)
}