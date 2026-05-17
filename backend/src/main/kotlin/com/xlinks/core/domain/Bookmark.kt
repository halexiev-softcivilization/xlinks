package com.xlinks.core.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.Instant

@Entity
@Table(name = "bookmarks", indexes = [Index(name = "idx_bookmark_user_created", columnList = "user_id, created_at DESC"), Index(name = "idx_bookmark_tweet_id", columnList = "tweet_id", unique = true)])
data class Bookmark(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false)
    val user: User,
    @Column(unique = true, nullable = false) val tweetId: String,
    @Column(columnDefinition = "TEXT", nullable = false) val text: String,
    @Column(nullable = false) val authorUsername: String,
    @Column(nullable = false) val authorId: String,
    val likeCount: Int = 0,
    val repostCount: Int = 0,
    val replyCount: Int = 0,
    @Column(nullable = false) val tweetCreatedAt: Instant,
    @CreatedDate @Column(nullable = false, updatable = false) val syncedAt: Instant = Instant.now(),
    @Column(name = "thread_root_id") val threadRootId: String? = null,
    @OneToMany(mappedBy = "bookmark", cascade = [CascadeType.ALL], orphanRemoval = true) val media: MutableList<MediaAsset> = mutableListOf(),
    @OneToMany(mappedBy = "bookmark", cascade = [CascadeType.ALL], orphanRemoval = true) val threadPosts: MutableList<ThreadPost> = mutableListOf()
)