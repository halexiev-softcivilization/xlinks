package com.xlinks.core.repository

import com.xlinks.core.domain.Bookmark
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookmarkRepository : JpaRepository<Bookmark, Long> {
    fun findByUserIdOrderByTweetCreatedAtDesc(userId: Long, pageable: Pageable): Page<Bookmark>
    fun findByTweetId(tweetId: String): Bookmark?
}