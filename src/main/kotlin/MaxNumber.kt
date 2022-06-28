import java.util.PriorityQueue

class MaxNumber {

    fun getMaxNumber(item: IntArray): String {

        val maxHeap = PriorityQueue<Element>()

        item.forEach { maxHeap.add(Element("$it")) }

        val res = StringBuffer()
        while (maxHeap.peek() != null){
            res.append(maxHeap.poll().strVal)
        }

        return res.toString()

    }


    data class Element(val strVal: String) : Comparable<Element> {

        override fun compareTo(other: Element): Int {

            val l = (strVal + other.strVal).toInt()
            val r = ( other.strVal + strVal).toInt()
            return r.compareTo(l)

        }
    }

}



