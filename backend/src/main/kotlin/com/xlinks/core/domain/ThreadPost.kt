package com.xlinks.core.domain

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "thread_posts")
data class ThreadPost(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "bookmark_id", nullable = false)
    val bookmark: Bookmark,
    @Column(nullable = false) val tweetId: String,
    @Column(columnDefinition = "TEXT", nullable = false) val text: String,
    @Column(nullable = false) val authorUsername: String,
    @Column(nullable = false) val position: Int,
    @Column(nullable = false) val postCreatedAt: Instant,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "parent_post_id") val parentPost: ThreadPost? = null
)