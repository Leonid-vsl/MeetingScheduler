import java.util.PriorityQueue

class MergeArrays {


    fun merge2Arr(arr1: IntArray, arr2: IntArray): IntArray {

        val iter1 = arr1.iterator()
        val iter2 = arr2.iterator()

        val rs = IntArray(arr1.size + arr2.size)

        var cnt = 0
        var left: Int? = null
        var right: Int? = null
        while (true) {


            left = if (left == null && iter1.hasNext()) iter1.next() else left
            right = if (right == null && iter2.hasNext()) iter2.next() else right

            if (left != null && right != null) {

                val min = Math.min(left, right)
                rs[cnt++] = min
                if (min == left) {
                    left = null
                } else {
                    right = null
                }

            } else {

                if (left == null && right == null) break

                if (left != null) {
                    rs[cnt++] = left
                    left = null
                } else if (right != null) {
                    rs[cnt++] = right
                    right = null
                }
            }


        }
        return rs
    }

    fun mergeKArr(arrays: List<IntArray>): IntArray {


        val rs = IntArray(arrays.sumOf { it.size })

        var cnt = 0

        val iters = arrays.map { it.iterator() }

        val minHeap = PriorityQueue<Item>()

        for (itr in iters) {
            val value = if (itr.hasNext()) itr.next() else null
            if (value != null)
                minHeap.add(Item(value, itr))
        }

        while (true) {

            val min = minHeap.poll()
            if (min != null) {
                rs[cnt++] = min.value
                val value = if (min.iter.hasNext()) min.iter.next() else null
                if (value != null)
                    minHeap.add(Item(value, min.iter))
            } else {
                break
            }
        }
        return rs
    }

}

data class Item(val value: Int, val iter: Iterator<Int>) : Comparable<Item> {

    override fun compareTo(other: Item): Int {
        return value.compareTo(other.value)
    }


}