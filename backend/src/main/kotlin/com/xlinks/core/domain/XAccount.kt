package com.xlinks.core.domain

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "x_accounts")
data class XAccount(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false)
    val user: User,
    @Column(unique = true, nullable = false)
    val xUserId: String,
    @Column(nullable = false)
    val username: String,
    @Column(columnDefinition = "TEXT") var accessToken: String? = null,
    @Column(columnDefinition = "TEXT") var refreshToken: String? = null,
    var tokenExpiresAt: Instant? = null,
    @Column(nullable = false) val connectedAt: Instant = Instant.now()
)