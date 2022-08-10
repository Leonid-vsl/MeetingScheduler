import java.util.LinkedList
import java.util.Queue
import java.util.TreeSet
import java.util.UUID

class ArrayLargestSum {

    /**
    7,2 -> 7,2

    7,2,5 ->  7,7; 9,5;

    7,2,5,10 -> 7,17; 9,15; 14,10

    7,2,5,10,8 -> 7,25; 9,23; 14,18; 24,8


    7,2,5 -> 7,2,5
    7, 2, 5,10 ->    7,7,10;               9,5,10;             7,2,15
    7, 2, 5,10,8 -> 14,10,8; 7,17,8; --     14,10,8;9,15,8;      9,2,23;   --7,17,8
    7, 2, 5,10,8,6 -> --24,8,14; 7,25,6      24,8,6   14,18,6   24,8,14  9,25,6  11,23,6   --9,25,6


    7,2,5,10 -> 7,2,5,10
    7, 2, 5,10,8 -> 9,5,10,8  7,7,10,8  7,2,15,8  7,2,5,18

     **/
    fun solutiona(nums: IntArray, m: Int): Int {

        val initGr = LinkedList<Int>()
        for (i in 0 until m) {
            initGr.add(nums[i])
        }
        var groups = TreeSet(listOf(Item1("1", initGr)))
        var newGr = TreeSet<Item1>()

        for (i in m until nums.size) {

            val itr = groups.iterator()
            while (itr.hasNext()) {
                val gr = itr.next()

                for (j in 1 until m) {

                    val newGrItems = LinkedList(gr.items)
                    for (ite in 1 until gr.items.size) {
                        if (ite == j) {
                            val a = newGrItems[ite]
                            val b = newGrItems[ite - 1]
                            newGrItems.removeAt(ite)
                            newGrItems.removeAt(ite - 1)
                            newGrItems.add(j - 1, a + b)
                        }

                    }

                    newGr.add(Item1("${UUID.randomUUID()}", newGrItems + listOf(nums[i])))
                }
                val newGrItems = LinkedList<Int>(gr.items)
                val a = newGrItems.removeLast()
                newGr.add(Item1("${UUID.randomUUID()}", newGrItems + listOf(nums[i] + a)))

            }

            val sdd = mutableListOf<Item1>()
            var s = newGr.first()
            sdd.add(s)

            while (true){

                val lower = newGr.higher(s)
                if(lower != null && lower.sum == s.sum) {
                    sdd.add(lower)
                }else{
                    break
                }
                s = lower
            }

            groups = TreeSet<Item1>(sdd)
            newGr = TreeSet<Item1>()
        }


        return groups.first().max
    }

    data class Item1(val idx: String, val items: List<Int>) : Comparable<Item1> {

        var min: Int
        var max: Int
        var sum: Int

        init {

            val ss = TreeSet(items)
            max = ss.last()
            min = ss.first()
            sum = max - min

        }





        override fun compareTo(other: Item1): Int {

            val compareTo = this.sum.compareTo(other.sum)
            return if (compareTo == 0) idx.compareTo(other.idx) else compareTo

        }


    }


    fun solutionb(nums: IntArray, m: Int): Int {


        val sumCache = IntArray(nums.size)

        var prevSum = 0
        nums.forEachIndexed { idx, n ->
            val sum = prevSum + n
            sumCache[idx] = sum
            prevSum = sum
        }


        var minSum = TreeSet<Item>()
        checkGr(nums, m, m, nums.size, 0, 1, sumCache, mutableListOf(), minSum)

        return minSum.first().items.last() ?: throw IllegalStateException("no min")
    }


    fun checkGr(
        nums: IntArray,
        groups: Int,
        totalGrps: Int,
        length: Int,
        startIdx: Int,
        startGrSize: Int,
        sumCache: IntArray,
        gr: MutableList<Int>,
        collector: TreeSet<Item>
    ) {

        if (groups == 1) {
            val grSum = getGrSum(startIdx, length - startIdx, sumCache)
            gr.add(grSum)
            collector.add(Item("${UUID.randomUUID()}", TreeSet(gr)))

            if (collector.size > 1) {
                collector.remove(collector.last())
            }
            return
        }

        val maxGrSize = length - (totalGrps - 1) // no more than total amount of grs except current
        var currentGrSize = startGrSize
        while (currentGrSize <= maxGrSize && (currentGrSize + startIdx) < length) {

            val newGr = LinkedList(gr)
            val grSum = getGrSum(startIdx, currentGrSize, sumCache)

            newGr.add(grSum)

            checkGr(
                nums,
                groups - 1,
                totalGrps,
                length,
                startIdx + currentGrSize,
                startGrSize,
                sumCache,
                newGr,
                collector
            )
            currentGrSize++
        }
    }

    private fun getGrSum(startIdx: Int, currentGrSize: Int, sumCache: IntArray): Int {
        return if (startIdx <= 0) {
            sumCache[(startIdx + currentGrSize) - 1]
        } else {
            val end = (startIdx + currentGrSize) - 1
            sumCache[end] - sumCache[startIdx - 1]
        }
    }

    data class Item(val idx: String, val items: TreeSet<Int>) : Comparable<Item> {

        var sum: Int = items.last() - items.first()

        override fun compareTo(other: Item): Int {

            val compareTo = this.sum.compareTo(other.sum)
            return if (compareTo == 0) idx.compareTo(other.idx) else compareTo

        }


    }


}