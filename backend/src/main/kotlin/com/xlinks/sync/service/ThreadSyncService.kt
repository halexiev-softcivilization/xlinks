package com.xlinks.sync.service

import com.xlinks.core.domain.ThreadPost
import com.xlinks.core.repository.ThreadPostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ThreadSyncService(
    private val threadPostRepository: ThreadPostRepository
) {
    @Transactional
    fun syncFullThread(bookmarkId: Long, rootTweetId: String) {
        val mockPosts = listOf(ThreadPost(bookmarkId = bookmarkId, tweetId = rootTweetId, text = "Root tweet", authorUsername = "demo", position = 0, postCreatedAt = java.time.Instant.now()))
        threadPostRepository.saveAll(mockPosts)
    }
}