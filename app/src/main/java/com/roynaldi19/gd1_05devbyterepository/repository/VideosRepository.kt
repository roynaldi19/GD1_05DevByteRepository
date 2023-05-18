package com.roynaldi19.gd1_05devbyterepository.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.roynaldi19.gd1_05devbyterepository.database.VideosDatabase
import com.roynaldi19.gd1_05devbyterepository.database.asDomainModel
import com.roynaldi19.gd1_05devbyterepository.domain.DevByteVideo
import com.roynaldi19.gd1_05devbyterepository.network.DevByteNetwork
import com.roynaldi19.gd1_05devbyterepository.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideosRepository (private val database: VideosDatabase) {

    suspend fun refreshVideo() {
        withContext(Dispatchers.IO) {
            val playlist = DevByteNetwork.devbytes.getPlaylist()
            database.videoDao.insertAll(playlist.asDatabaseModel())
        }

    }

    val videos: LiveData<List<DevByteVideo>> = Transformations.map(database.videoDao.getVideos()){
      it.asDomainModel()
    }
}