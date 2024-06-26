package net.kigawa.konfig.builder

abstract class AbstractBuilderHolder : BuilderHolder {
    override val builders: MutableMap<String, Value> = mutableMapOf()
    override fun merge(from: Value) {
        if (from !is BuilderHolder) return
        builders.putAll(from.builders)
    }
}