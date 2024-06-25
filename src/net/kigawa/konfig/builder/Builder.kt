package net.kigawa.konfig.builder

interface Builder {
    fun merge(from: Builder)
}