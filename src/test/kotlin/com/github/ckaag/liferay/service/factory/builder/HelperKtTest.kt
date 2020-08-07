package com.github.ckaag.liferay.service.factory.builder

import org.junit.Assert
import org.junit.Test

/**
 * Created by usickaag on Freitag, 07.08.2020 at 18:35.
 */
internal class HelperKtTest {
    @Test
    fun testPermutationsOfSet() {
        val input = setOf("A", "B", "C", "D")
        val output = buildPartialSubsets(input, true)
        Assert.assertEquals(15, output.size)
        Assert.assertEquals(4, output.count { it.size == 1 })
        Assert.assertEquals(6, output.count { it.size == 2 })
        Assert.assertEquals(4, output.count { it.size == 3 })
        Assert.assertEquals(1, output.count { it.size == 4 })
    }
    @Test
    fun testPermutationsOfSetSmall() {
        val input = setOf("A", "B", "C")
        val output = buildPartialSubsets(input, true)
        Assert.assertEquals(7, output.size)
        Assert.assertEquals(3, output.count { it.size == 1 })
        Assert.assertEquals(3, output.count { it.size == 2 })
        Assert.assertEquals(1, output.count { it.size == 3 })
        Assert.assertEquals(0, output.count { it.size == 4 })
    }
}
