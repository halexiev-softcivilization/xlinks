package com.xlinks.storage

import org.springframework.stereotype.Service
import java.io.InputStream

interface StorageService {
    fun upload(key: String, inputStream: InputStream, contentType: String): String
    fun download(key: String): ByteArray
    fun getSignedUrl(key: String, expirationMinutes: Int = 60): String
}

@Service
class LocalStorageService : StorageService {
    override fun upload(key: String, inputStream: InputStream, contentType: String): String = "local://$key"
    override fun download(key: String): ByteArray = ByteArray(0)
    override fun getSignedUrl(key: String, expirationMinutes: Int) = "local://$key"
}