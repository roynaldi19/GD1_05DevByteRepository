package com.roynaldi19.gd1_05devbyterepository.domain

import com.roynaldi19.gd1_05devbyterepository.util.smartTruncate

data class DevByteVideo(val title: String,
                        val description: String,
                        val url: String,
                        val updated: String,
                        val thumbnail: String) {
    val shortDescription: String
        get() = description.smartTruncate(200)
}