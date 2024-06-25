package net.kigawa.konfig.builder

abstract class AbstractBuilderHolder : BuilderHolder {
    override val builders: MutableMap<String, Builder> = mutableMapOf()
}