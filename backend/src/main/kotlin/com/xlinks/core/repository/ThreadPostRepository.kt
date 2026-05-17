package com.xlinks.core.repository

import com.xlinks.core.domain.ThreadPost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ThreadPostRepository : JpaRepository<ThreadPost, Long> {
    fun findByBookmarkIdOrderByPositionAsc(bookmarkId: Long): List<ThreadPost>
}