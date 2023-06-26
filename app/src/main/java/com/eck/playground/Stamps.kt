package com.eck.playground

object Stamps {

    private const val REQUIRED_STAMP_COUNT = 2

    fun changeStamps(jane: List<Int>, alice: List<Int>): Pair<List<Int>, List<Int>> {
        val janeMap = HashMap<Int, Int>()
        val aliceMap = HashMap<Int, Int>()

        jane.forEach { id ->
            janeMap.addToMap(id)
        }

        alice.forEach { id ->
            aliceMap.addToMap(id)
        }

        val forAlice = janeMap.findExtras(aliceMap)
        val forJane = aliceMap.findExtras(janeMap)

        return Pair(forJane, forAlice)
    }

    private fun HashMap<Int, Int>.addToMap(id: Int) {
        this[id]?.let { value ->
            this[id] = value + 1
        } ?: run {
            this[id] = 1
        }
    }

    private fun HashMap<Int, Int>.findExtras(controlMap: HashMap<Int, Int>) : List<Int> {
        val extras = ArrayList<Int>()
        this.filterValues { it > REQUIRED_STAMP_COUNT }.forEach { (key, value) ->
            val extraStampsCount = value - REQUIRED_STAMP_COUNT
            if (controlMap.getOrDefault(key, 0) < REQUIRED_STAMP_COUNT) {
                for (i in 0 until extraStampsCount) {
                    extras.add(key)
                }
            }
        }
        return extras
    }
}