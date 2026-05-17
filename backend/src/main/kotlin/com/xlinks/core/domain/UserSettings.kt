package com.xlinks.core.domain

import jakarta.persistence.*

@Entity
@Table(name = "user_settings")
data class UserSettings(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false, unique = true)
    val user: User,
    @Column(nullable = false) var mediaDownloadEnabled: Boolean = true,
    @Column(nullable = false) var preferredStorageProvider: String = "aws",
    @Column(nullable = false) var autoSyncEnabled: Boolean = true,
    var syncFrequencyMinutes: Int = 60,
    @Column(columnDefinition = "TEXT") var awsBucket: String? = null,
    var azureContainer: String? = null,
    var gcpBucket: String? = null
)