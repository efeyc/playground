package com.eck.playground

import org.junit.Test

import org.junit.Assert.*


class StampsUnitTest {

    @Test
    fun `example inputs should match with correct outputs`() {
        val output1 = Stamps.changeStamps(listOf(1,7,3,1,7,4,5,1,7,1), listOf(2,3,3,2,4,3,2))
        val expected1 = Pair(listOf(2,3), listOf(1,1,7))

        val output2 = Stamps.changeStamps(listOf(1,2,3,4,4), listOf(4,4,4,5,6,7))
        val expected2 = Pair(emptyList<Int>(), emptyList<Int>())

        val output3 = Stamps.changeStamps(listOf(5,4,4,3,3,3,3), listOf(1,3))
        val expected3 = Pair(emptyList<Int>(), listOf(3,3))

        assertEquals(expected1, output1)
        assertEquals(expected2, output2)
        assertEquals(expected3, output3)
    }

    @Test
    fun `should work fine when any of the lists are empty`() {

        val output1 = Stamps.changeStamps(emptyList(), listOf(2,3,3,2,4,3,2))
        val expected1 = Pair(listOf(2,3), emptyList<Int>())

        val output2 = Stamps.changeStamps(listOf(1,7,3,1,7,4,5,1,7,1), emptyList())
        val expected2 = Pair(emptyList<Int>(), listOf(1,1,7))

        val output3 = Stamps.changeStamps(emptyList(), emptyList())
        val expected3 = Pair(emptyList<Int>(), emptyList<Int>())

        assertEquals(expected1, output1)
        assertEquals(expected2, output2)
        assertEquals(expected3, output3)
    }

    @Test
    fun `exact same lists should return empty results`() {

        val output1 = Stamps.changeStamps(listOf(1,7,3,1,7,4,5,1,7,1), listOf(1,7,3,1,7,4,5,1,7,1))
        val expected1 = Pair(emptyList<Int>(), emptyList<Int>())

        assertEquals(expected1, output1)
    }

    @Test
    fun `one item collections should give the rest to the other`() {

        val output1 = Stamps.changeStamps(listOf(1,1,1,1,1,1,1,1,1), listOf(8,8,8,8,8,8,8,8))
        val expected1 = Pair(listOf(8,8,8,8,8,8), listOf(1,1,1,1,1,1,1))

        assertEquals(expected1, output1)
    }

    @Test
    fun `no extras should return empty result`() {

        val output1 = Stamps.changeStamps(listOf(1,3,5,7,7,5,3,1), listOf(2,4,6,8,6,4,2))
        val expected1 = Pair(emptyList<Int>(), emptyList<Int>())

        assertEquals(expected1, output1)
    }

    @Test
    fun `should work in reasonable time with one million input`() {

        val jane = getOneMillionInteger()
        val alice = getOneMillionInteger()

        // Assuming that our function is already working correctly
        val output1 = Stamps.changeStamps(jane, alice)
        val expected1 = Stamps.changeStamps(jane, alice)

        assertEquals(expected1, output1)
    }

    @Test
    fun `should work in reasonable time with big numbers`() {

        val jane = getOneMillionBigInteger()
        val alice = getOneMillionBigInteger()

        // Assuming that our function is already working correctly
        val output1 = Stamps.changeStamps(jane, alice)
        val expected1 = Stamps.changeStamps(jane, alice)

        assertEquals(expected1, output1)
    }

    private fun getOneMillionInteger() : List<Int> {
        val result = ArrayList<Int>()
        for (i in 0..1000000) {
            result.add((1..100).random())
        }
        return result
    }

    private fun getOneMillionBigInteger() : List<Int> {
        val result = ArrayList<Int>()
        for (i in 0..1000000) {
            result.add((1000000 .. Integer.MAX_VALUE).random())
        }
        // just to be sure we have the max value in the list
        result.add(Integer.MAX_VALUE)
        result.add(Integer.MAX_VALUE)
        return result
    }
}