import java.util.*
import kotlin.collections.HashMap

class TopNFreqElements {


    //O(n) + ~0(n)
    fun getTop(arr: IntArray, N: Int): List<Int> {
        //log(K)
        val topN = TreeSet<Element>()
        val counters = HashMap<Int, Int>()
        arr.forEach {
            val freq = counters[it]

            if (freq != null) {
                counters[it] = freq + 1
            } else {
                counters[it] = 1
            }
        }



        counters.forEach {

            topN.add(Element(it.key, it.value))

            if (topN.size > N) {

                val last = topN.last()

                topN.remove(last)

            }

        }

        return topN.map { it.key }.sorted()
    }

    data class Element(val key: Int, val freq: Int) : Comparable<Element> {

        override fun compareTo(other: Element): Int {
            val freqCompare = other.freq.compareTo(freq)
            return if (freqCompare == 0) other.key.compareTo(key) else freqCompare


        }
    }

    fun getTop1(arr: IntArray, N: Int): List<Int> {

        val counters = TreeSet<Element>()
        var topFreq = 1
        arr.forEach { item ->

            var hasMatch = false
            var newMax = 0
            for (i in 1..topFreq) {

                if (counters.contains(Element(item, i))) {
                    hasMatch = true
                    counters.remove(Element(item, i))
                    newMax = i + 1
                    counters.add(Element(item, newMax))
                    break

                }
            }
            if (topFreq < newMax) {
                topFreq = newMax
            }


            if (!hasMatch) {
                counters.add(Element(item, 1))
            }
        }

        return counters.take(N).map { it.key }
    }

}