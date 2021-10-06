package com.example.hilt.model

import com.google.gson.annotations.SerializedName

class ConfigModel {

    @SerializedName("images")
    var images = ImageConfig()

    @SerializedName("change_keys")
    var changeKeys: List<String> = ArrayList()

    class ImageConfig {
        @SerializedName("base_url")
        val baseUrl: String = ""

        @SerializedName("secure_base_url")
        val secureBaseUrl: String = ""

        @SerializedName("backdrop_sizes")
        var backDropSizes: List<String> = ArrayList()

        @SerializedName("logo_sizes")
        var logoSize: List<String> = ArrayList()

        @SerializedName("poster_sizes")
        var posterSizes: List<String> = ArrayList()

        @SerializedName("profile_sizes")
        var profileSizes: List<String> = ArrayList()

        @SerializedName("still_sizes")
        var stillSizes: List<String> = ArrayList()

    }

    fun getImagePath(path: String) : String {
        return images.baseUrl + images.posterSizes[0] + path
    }
}