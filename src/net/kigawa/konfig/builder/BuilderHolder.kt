package net.kigawa.konfig.builder

interface BuilderHolder : Builder{
    val builders: MutableMap<String, Value>
    fun <B : Builder> add(key: String, provider: () -> B, builderBlock: B.() -> Unit) {
        provider.invoke()
            .also { builders[key]?.let { from -> it.merge(from) } }
            .also { builders[key] = it }
    }
}