package net.kigawa.konfig.builder

interface BuilderBlock<B : Builder> {
    fun B.build()
    fun toLambda(): B.() -> Unit = {
        build()
    }
}