package com.xlinks.api.controller

import com.xlinks.core.repository.BookmarkRepository
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/bookmarks")
class BookmarkController(
    private val bookmarkRepository: BookmarkRepository
) {
    @GetMapping
    fun getBookmarks(@RequestParam userId: Long, @RequestParam page: Int = 0, @RequestParam size: Int = 20) =
        bookmarkRepository.findByUserIdOrderByTweetCreatedAtDesc(userId, PageRequest.of(page, size))

    @PostMapping("/sync")
    fun triggerSync(@RequestParam userId: Long) = "Sync started for user $userId"
}