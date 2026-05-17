package com.xlinks.core.domain

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(unique = true, nullable = false)
    val username: String,
    val email: String? = null,
    @CreatedDate @Column(nullable = false, updatable = false)
    val createdAt: Instant = Instant.now(),
    @LastModifiedDate @Column(nullable = false)
    var updatedAt: Instant = Instant.now(),
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val xAccounts: MutableList<XAccount> = mutableListOf()
)