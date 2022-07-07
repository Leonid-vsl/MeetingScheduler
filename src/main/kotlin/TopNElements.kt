import java.util.*
import kotlin.collections.HashMap

class TopNElements {


    fun getTop(arr: IntArray, N: Int): Int {
        //log(K)
        val topN = TreeSet<Element>()
        arr.forEachIndexed{ idx, item ->
            topN.add(Element(idx,item))
            if(topN.size > N){
                val low = topN.last()
                topN.remove(low)
            }
        }
        return topN.last().freq
    }


    data class Element(val key: Int, val freq: Int) : Comparable<Element> {

        override fun compareTo(other: Element): Int {
            val freqCompare = other.freq.compareTo(freq)
            return if (freqCompare == 0) other.key.compareTo(key) else freqCompare


        }
    }

}