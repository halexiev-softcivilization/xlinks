package com.xlinks.storage

import com.xlinks.core.domain.MediaAsset
import org.springframework.stereotype.Service

@Service
class MediaDownloadService {
    fun downloadMediaForBookmark(bookmarkId: Long, mediaList: List<MediaAsset>) {
        println("Downloading ${mediaList.size} media items for bookmark $bookmarkId")
    }
}