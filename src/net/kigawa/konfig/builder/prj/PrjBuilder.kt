package net.kigawa.konfig.builder.prj

import net.kigawa.konfig.builder.AbstractBuilderHolder
import net.kigawa.konfig.builder.Builder
import net.kigawa.konfig.builder.file.FileBuilder

class PrjBuilder : AbstractBuilderHolder(), Builder {

    fun file(builderBlock: FileBuilder.() -> Unit)
            = add("project", { FileBuilder() }, builderBlock)
}