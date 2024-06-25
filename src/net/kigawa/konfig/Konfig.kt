package net.kigawa.konfig

import net.kigawa.konfig.builder.AbstractBuilderHolder
import net.kigawa.konfig.builder.prj.PrjBuilder
import net.kigawa.konfig.builder.prj.PrjBuilderBlock
import net.kigawa.kutil.unitapi.component.container.UnitContainer
import net.kigawa.kutil.unitapi.registrar.InstanceRegistrar
import net.kigawa.kutil.unitapi.registrar.ResourceRegistrar
import util.KFormatter
import java.util.logging.ConsoleHandler
import java.util.logging.Logger

class Konfig(
    private val servicePackage: String,
) : AbstractBuilderHolder() {
    private val container = UnitContainer.create()
    private val logger = Logger.getLogger(javaClass.name)

    fun generate() {
        logger.info("starting generator")
        initLogger()
        initContainer()
        container.getUnit(Generator::class.java).generate()
        logger.info("ended generator")
    }

    fun project(builderBlock: PrjBuilder.() -> Unit) = add("project", { PrjBuilder() }, builderBlock)

    private fun initLogger() {
        logger.info("initializing logger")
        Logger.getLogger("").handlers.filterIsInstance<ConsoleHandler>().forEach {
            it.formatter = KFormatter()
        }
        logger.info("initialized logger")
    }

    private fun initContainer() {
        logger.info("initializing container")
        container.getUnit(InstanceRegistrar::class.java).apply {
            register(logger)
        }
        container.getUnit(ResourceRegistrar::class.java).register(javaClass.classLoader, servicePackage)
        logger.info("initialized container")
    }
}