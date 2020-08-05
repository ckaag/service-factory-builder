package com.github.ckaag.liferay.service.factory.builder

import com.github.ckaag.liferay.service.factory.builder.mock.exampleServiceXml
import com.github.ckaag.liferay.service.factory.builder.mock.simpleTypedXml
import org.junit.Assert
import org.junit.Test

/**
 * Created by usickaag on Mittwoch, 05.08.2020 at 11:01.
 */

class MainKtTest {

    @Test
    fun testGenerateOutputUntypedComplexSize() {
        val output = generateOutput(exampleServiceXml, false)
        Assert.assertEquals(7, output.entries.size)
    }
    
    @Test
    fun testGenerateOutputUntypedComplexSetTimestamp() {
        val output = generateOutput(exampleServiceXml, false)
        Assert.assertTrue(output.entries.find { it.key.toString().contains("BistroItemOrderFactory.java") }!!.value.contains("public BistroItemOrderFactory setTimestamp(Date value) {") )
    }
    
    @Test
    fun testGenerateOutputTypedSimpleSize() {
        val xml = simpleTypedXml
        val output = generateOutput(xml, true)
        Assert.assertEquals(4*3*2*1 + 1, output.size)
    }
    
}
