package com.xlinks.core.repository

import com.xlinks.core.domain.XAccount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface XAccountRepository : JpaRepository<XAccount, Long> {
    fun findByXUserId(xUserId: String): XAccount?
}