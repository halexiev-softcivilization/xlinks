package com.xlinks.core.domain

import jakarta.persistence.*

@Entity
@Table(name = "media_assets")
enum class MediaType { IMAGE, VIDEO, GIF, ANIMATED_GIF }

data class MediaAsset(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "bookmark_id", nullable = false)
    val bookmark: Bookmark,
    @Enumerated(EnumType.STRING) @Column(nullable = false) val type: MediaType,
    @Column(nullable = false) val url: String,
    @Column var localPath: String? = null,
    @Column var cloudUrl: String? = null,
    val width: Int? = null,
    val height: Int? = null,
    val durationSeconds: Double? = null,
    val fileSizeBytes: Long? = null,
    @Column(nullable = false) val downloaded: Boolean = false
)