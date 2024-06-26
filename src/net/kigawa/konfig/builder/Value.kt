package net.kigawa.konfig.builder

interface Value {
    fun merge(from: Value)
}