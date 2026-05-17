package com.xlinks.sync.service

import com.xlinks.core.domain.Bookmark
import com.xlinks.core.repository.BookmarkRepository
import com.xlinks.core.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant

@Service
class BookmarkSyncService(
    private val bookmarkRepository: BookmarkRepository,
    private val userRepository: UserRepository
) {
    @Transactional
    fun syncBookmarksForUser(userId: Long): Int {
        val user = userRepository.findById(userId).orElseThrow()
        // TODO: Real X API call here
        val mock = listOf(Bookmark(user = user, tweetId = "demo-${Instant.now().toEpochMilli()}", text = "Preserved forever!", authorUsername = "demo", authorId = "1", tweetCreatedAt = Instant.now()))
        return bookmarkRepository.saveAll(mock).size
    }
}