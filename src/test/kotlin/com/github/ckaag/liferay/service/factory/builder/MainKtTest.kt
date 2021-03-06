package com.github.ckaag.liferay.service.factory.builder

import org.junit.Assert
import org.junit.Test

/**
 * Created by usickaag on Mittwoch, 05.08.2020 at 11:01.
 */

class MainKtTest {

    @Test
    fun testGenerateOutputUntypedComplexSize() {
        val output = generateOutput(exampleServiceXml, null, false)
        Assert.assertEquals(7, output.entries.size)
    }
    
    @Test
    fun testGenerateOutputUntypedComplexSetTimestamp() {
        val output = generateOutput(exampleServiceXml, null, false)
        Assert.assertTrue(output.entries.find { it.key.toString().contains("BistroItemOrderFactory.java") }!!.value.contains("public BistroItemOrderFactory setTimestamp(Date value) {") )
    }

    @Test
    fun testGenerateOutputTypedSimpleSize() {
        val xml = simpleTypedXml
        val output = generateOutput(xml,  simpleTypedXmlHints,true)
        Assert.assertEquals(1+4+6+4 + 1, output.size)
    }

    @Test
    fun testGenerateOnlyOneBuilderMethodForTyped() {
        val xml = simpleTypedXml
        val output = generateOutput(xml,  simpleTypedXmlHints,true)
        Assert.assertEquals(1, output.count { it.value.contains(" builder() ") })
    }

    @Test
    fun testGenerateOnlyOneBuildMethodForTyped() {
        val xml = simpleTypedXml
        val output = generateOutput(xml,  simpleTypedXmlHints,true)
        Assert.assertEquals(1, output.count { it.value.contains(" build(") })
    }
    
}
