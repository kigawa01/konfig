package net.kigawa.konfig

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class KonfigTest {
    private lateinit var konfig: Konfig

    @BeforeEach
    fun setUp() {
        konfig = Konfig(this::class.java.packageName)
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun generate() {
        konfig.builder({})
        konfig.generate()
    }
}