import java.lang.Math.max
import java.lang.Math.min
import java.util.*
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashSet

class LongestIncreasingSubSeq {


    fun solutionc(nums: IntArray): Int {


        if (nums.size == 1) return 1

        val queue = LinkedList<LinkedList<Pair<Int, Int>>>()

        var mins = TreeSet<MinMaxInfo>()
        var maxs = TreeSet<MinMaxInfo>() { a, b -> a.maxVal.compareTo(b.maxVal) }
        var idxs = TreeSet<MinMaxInfo>() { a, b -> a.startIdx.compareTo(b.startIdx) }
        var prevDyIsNegative = true
        var prevY = 0
        var prevMinIdx = 0
        var prevMinVal = 0
        var startGr: MinMaxInfo? = null
        for (i in 0..nums.size) {

            val item = if (i != nums.size) {
                nums[i]
            } else {
                0
            }
            val dy = item - prevY
            val isNegativeDy = max(0, dy) == 0

            if (prevDyIsNegative && !isNegativeDy) {
                val idx = max(0, i - 1)
                prevMinVal = nums[idx]
                prevMinIdx = idx
            }
            if (!prevDyIsNegative && isNegativeDy) {
                val idx = max(0, i - 1)
                val element = MinMaxInfo(prevMinVal, prevMinIdx, nums[idx], idx, idx - prevMinIdx)
                mins.add(element)
                maxs.add(element)
                idxs.add(element)
                if (startGr == null)
                    startGr = element
            }
            prevDyIsNegative = isNegativeDy
            prevY = item
        }


        val longestPath = TreeSet<MinGroup>()
//        var maxHigher = mins.higher(MinMaxInfo(Int.MIN_VALUE, 0, 0, 0, 0))
//        var minHigher = maxs.higher(MinMaxInfo(Int.MIN_VALUE, 0, 0, 0, 0))


        var higher = startGr ?: throw IllegalStateException()

        val group = TreeSet<MinMaxInfo> { a, b -> a.startIdx.compareTo(b.startIdx) }
        group.add(higher)

        while (true) {


            var newLow = mins.higher(higher)
            var newHigh = maxs.higher(higher)


            newLow = if (newLow != null && newLow.startIdx > higher.startIdx) newLow else null
            newHigh = if (newHigh != null && newHigh.startIdx > higher.startIdx) newHigh else null

            if (newLow == null && newHigh == null) break

            val newHigher = if (newHigh != null && newLow != null) {
                if (newHigh.startIdx < newLow.startIdx) {
                    newHigh
                } else newLow
            } else newHigh ?: newLow



            group.add(newHigher)

            //   println(higher)

            higher = newHigher

        }

//            longestPath.add(MinGroup(group.toList(), group.first().startIdx, group.last().endInx, group.chunked(2).sumOf {
//
//                it.first().minValue
//
//            }))


//        mins.forEach { it ->
//
//            var higher = it
//            val group = TreeSet<MinInfo> { a, b -> a.idx.compareTo(b.idx) }
//            group.add(MinInfo(it.minValue, it.startIdx, it.dist))
//            while (true) {
//
//                val newLow = mins.higher(higher)
//                val newHigh = maxs.higher(higher)
//
//                if (newLow != null) {
//                    if (newLow.startIdx > group.last().idx) {
//
//                        group.add(MinInfo(it.minValue, it.startIdx, it.dist))
//                    }
//
//                    higher = newLow
//                } else {
//                    break
//                }
//
//            }
//
//            longestPath.add(MinGroup(group.toList(), group.first().idx, group.last().idx, group.sumOf { it.dist }))
//
//        }

//        mins.forEach {
//            queue.add(LinkedList(listOf(it.value to it.idx)))
//
//        }


        nums.forEachIndexed { idx, item ->

            var newSubRes: LinkedList<Pair<Int, Int>>? = null
            val rsItr = queue.listIterator()
            while (rsItr.hasNext()) {

                val subRes = rsItr.next()
                val lstItem = subRes.peekLast()

                if (lstItem != null) {


                    if (lstItem.first >= item) {
                        if (lstItem.first > item) {
                            newSubRes = LinkedList(subRes)
                            rsItr.add(newSubRes)
                        }
                        while (subRes.peekLast() != null && item <= subRes.peekLast().first) {
                            subRes.remove(subRes.peekLast())
                        }
                        subRes.add(item to idx)
                    } else if (lstItem.second < idx) {
                        subRes.add(item to idx)
                    }

                }

            }


        }

        val results = TreeSet<SubRes>()
        queue.forEach {
            results.add(SubRes(it))
        }

        return results.first().list.size
    }

    data class MinInfo(val value: Int, val idx: Int, val dist: Int) : Comparable<MinInfo> {
        override fun compareTo(other: MinInfo): Int {
            return value.compareTo(other.value)
        }


    }

    data class MinMaxInfo(val minValue: Int, val startIdx: Int, val maxVal: Int, val endInx: Int, val dist: Int) :
        Comparable<MinMaxInfo> {
        override fun compareTo(other: MinMaxInfo): Int {
            return minValue.compareTo(other.minValue)
        }


    }

    data class MinGroup(val values: List<MinMaxInfo>, val start: Int, val end: Int, val pathLength: Int) :
        Comparable<MinGroup> {
        override fun compareTo(other: MinGroup): Int {
            return other.pathLength.compareTo(pathLength)
        }


    }

    data class SubRes(val list: LinkedList<Pair<Int, Int>>) : Comparable<SubRes> {
        override fun compareTo(other: SubRes): Int {
            return other.list.size.compareTo(this.list.size)
        }


    }

    fun solutionjj(nums: IntArray): Int {
        val tree = TreeSet<ItemJ>()

        nums.forEachIndexed { idx, i ->
            val element = ItemJ(i, idx)
//            if(tree.contains(element)) {
//
//
//            }else{
            tree.add(element)
            //  }
        }

        var cnt = 1
        var prev: ItemJ? = null
        tree.forEach {

            if (prev != null && prev!!.value < it.value && prev!!.idx < it.idx) {

                cnt++

            }
            prev = it
        }

        return cnt
    }

    fun sol(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        Arrays.fill(dp, 1);
        for (i in 0 until nums.size) {
            var j = 0
            while (j < i){
                val numI = nums[i]
                val numJ = nums[j]
                if (numI > numJ) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                j++
            }
        }
        var res = 0;
        for ( i in  0 until dp.size){
            res = Math.max(res, dp[i]);
        }
        return res;
    }


fun solutionj(nums: IntArray): Int {

    val groups = TreeSet<GroupJ>()

    val tree = TreeSet<ItemJ>()


    val recLevel = Int.MAX_VALUE

    nums.forEachIndexed { idx, i ->

        var lower = tree.lower(ItemJ(i, idx))
        var presentInGr = false

        val newGrs = mutableListOf<GroupJ>()
        var rec = 0
        while (lower != null) {

            if (lower.idx < idx) {
                val grItr = groups.iterator()
                while (grItr.hasNext() && groups.isNotEmpty() && rec <= recLevel
                ) {

                    val gr = grItr.next()

                    if (gr.items.contains(lower)) {
                        presentInGr = true
                        rec++
                        val newGr = if (gr.items.last().value > i) {
                            val subSet = gr.items.headSet(lower, true)
                            listOf(GroupJ("${gr.i}a", TreeSet(subSet + setOf(ItemJ(i, idx)))), gr)

                        } else {

                            listOf(GroupJ(gr.i, TreeSet(gr.items + setOf(ItemJ(i, idx)))))
                        }
                        newGrs.addAll(newGr)
                        grItr.remove()
                    }
                }


                //   break
            }
            lower = tree.lower(ItemJ(lower.value, lower.idx))

        }
        groups.addAll(newGrs)
        if (!presentInGr) {

            groups.add(GroupJ("$i", TreeSet(listOf(ItemJ(i, idx)))))
        }

        tree.add(ItemJ(i, idx))

    }


    return groups.first().items.size
}


fun gg(nums: IntArray): Int {
    val lis = IntArray(nums.size);
    var j = 0
    var max = 0

    /* Initialize LIS values for all indexes */
    for (i in nums.indices) {
        lis[i] = 1;
    }

    /* Compute optimized LIS values in
       bottom up manner */
    for (i in 1 until nums.size)
        while (j < i) {

            if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                lis[i] = lis[j] + 1;
            }
            j++
        }
    /* Pick maximum of all LIS values */
    var ii = 0
    while (ii < nums.size) {

        if (max < lis[ii]) {
            max = lis[ii];
        }
        ii++

    }

    return max;
}


data class ItemJ(val value: Int, val idx: Int) : Comparable<ItemJ> {
    override fun compareTo(other: ItemJ): Int {
        val compareTo = this.value.compareTo(other.value)
        return compareTo
    }
}

data class GroupJ(val i: String, val items: TreeSet<ItemJ>) : Comparable<GroupJ> {
    override fun compareTo(other: GroupJ): Int {
        val compareTo = other.items.size.compareTo(this.items.size)
        return if (compareTo == 0) other.i.compareTo(this.i) else compareTo
    }


}


fun solutionh(nums: IntArray): Int {


    var groups = TreeSet<Gr>()

    var grId = 1
    var set = TreeSet<Pair<Int, Int>>() { a, b -> a.first.compareTo(b.first) }
    groups.add(Gr(grId++.toString(), 1, LinkedList(listOf(nums[0] to 0))))

//        for (i in 1 until nums.size) {
//
//            val last = groups.first()
//
//            if (last.list.last.first < nums[i] && last.list.last.second == i - 1) {
//                groups.remove(last)
//                groups.add(Gr(grId++.toString(), last.size + 1, LinkedList(last.list + listOf(nums[i] to i))))
//            } else {
//
//
//                while (true) {
//                    val lower = set.lower(last.list.last)
//                    if (lower.second < last.)
//
//
//                }
//            }
//
//
//            if (f.list.last.first < nums[i] && f.list.last.second == i - 1) {
//
//                groups.remove(f)
//                groups.add(Gr(grId++.toString(), f.size + 1, LinkedList(f.list + listOf(nums[i] to i))))
//
//            }
//            } else if (nums[i - 1] < nums[i]) {
//                val prevIdx = i - 1
//                groups.add(Gr(grId++.toString(), 2, LinkedList(listOf(nums[i - 1] to prevIdx, nums[i] to i))))
//                if (!set.contains(nums[i - 1]))
//                    groups.add(Gr(grId++.toString(), 1, LinkedList(listOf(nums[i - 1] to prevIdx))))
//            }
//            set.add(nums[i - 1] to i - 1)
//        }
//
//        for (i in 1 until nums.size) {
//
//            val gItr = groups.iterator()
//
//
//            val newGroups = mutableListOf<Gr>()
//            while (gItr.hasNext()) {
//                val currentGr = gItr.next()
//                //   for (sIdx in i until nums.size) {
//
//
//                val currentItem = nums[i]
//                val lastGrItem = currentGr.list.last
//                if (lastGrItem.first < currentItem && lastGrItem.second < i) {
//                    gItr.remove()
//                    newGroups.add(Gr("${currentGr.i}1", currentGr.list.size, LinkedList(currentGr.list)))
//                    currentGr.list.add(currentItem to i)
//                    newGroups.add(Gr(currentGr.i, currentGr.list.size, currentGr.list))
//
//                }
//            }
//
//            groups.addAll(newGroups)
//            newGroups.clear()
//

    // }
    return if (groups.size == 0) 1 else groups.first().list.size
}

data class Gr(val i: String, val size: Int, val list: LinkedList<Pair<Int, Int>>) : Comparable<Gr> {
    override fun compareTo(other: Gr): Int {
        val sizeCompare = other.size.compareTo(this.size)
        return if (sizeCompare == 0) this.i.compareTo(other.i) else sizeCompare
    }

}


fun solutionf(nums: IntArray): Int {


    var prevDp = IntArray(nums.size)

    // = LinkedHashSet<Int>()
    for (i in nums.indices) {
        prevDp[i] = 1
    }

    var newDp = IntArray(nums.size)

    var seqSize = 1
    for (i in 1..nums.size) {

        val group = Group(i)
        for (j in 0 until i) {
            group.add(nums[j])
        }

        for (sIdx in i until nums.size) {
            val dpIdx = sIdx - 1
            val maxLength = prevDp[dpIdx]
            val value = nums[sIdx]
            val prev = nums[dpIdx]
            if (prev < value) {

                val pDp = prevDp[dpIdx]
                val sDp = prevDp[sIdx]

                val newMax =
//                        if(group.contains(value) && group.startWithDup(value)) {
//                        Math.max(pDp, sDp) - 1
//
//                    }else
                    if (pDp != sDp) {
                        Math.max(pDp, sDp)
                    } else {

                        if (prevDp[max(i, dpIdx - 1)] <= maxLength) {
                            maxLength + 1
                        } else {
                            maxLength
                        }
                    }
                seqSize = newMax
                newDp[sIdx] = newMax
            } else {
                if (!group.contains(nums[sIdx])) {
                    newDp[sIdx] = maxLength
                } else {
                    newDp[sIdx] = max(prevDp[dpIdx], prevDp[sIdx])
                }
            }

            group.remove()
            group.add(value)


        }
        group.clear()

        prevDp = newDp
        newDp = IntArray(nums.size)

    }
    return seqSize
}

class Group(val size: Int) {

    private val list = LinkedList<Int>()
    private val set = HashSet<Int>()

    fun check(value: Int) =
        list.last < value && !set.contains(value)


    fun add(value: Int) {
        if (list.size < size) {
            list.addLast(value)
            set.add(value)
        }
    }

    fun last() =
        list.last

    fun size() =
        list.size

    fun clear() {
        list.clear()
        set.clear()
    }

    fun contains(value: Int) =
        set.contains(value)

    fun startWithDup(value: Int) =
        list.first == value


    fun remove() {
        if (list.size == size) {
            val f = list.removeFirst()
            if (list.size != set.size)
                set.remove(f)
        }
    }

}


fun solutiona(nums: IntArray): Int {


    var prevDp = IntArray(nums.size)

    val group = LinkedHashSet<Int>()
    for (i in nums.indices) {
        prevDp[i] = 1
    }

    var newDp = IntArray(nums.size)

    var seqSize = 1
    for (i in 1..nums.size) {

        for (j in 0 until i) {
            group.add(nums[j])
        }

        for (sIdx in i until nums.size) {


            val dpIdx = sIdx - 1


            val prev = nums[dpIdx]
            val value = nums[sIdx]
            val maxLength = prevDp[dpIdx]
            if (prev < value) {
                val newMax = if (prevDp[dpIdx] != prevDp[sIdx]) {
                    Math.max(prevDp[dpIdx], prevDp[sIdx])
                } else {

                    if (prevDp[max(i, dpIdx - 1)] <= maxLength && !group.contains(nums[sIdx])) {
                        maxLength + 1
                    } else {
                        maxLength
                    }
                }
                seqSize = newMax
                newDp[sIdx] = newMax
            } else {

                if (!group.contains(nums[sIdx])) {
                    newDp[sIdx] = maxLength
                } else {
                    newDp[sIdx] = min(prevDp[dpIdx], prevDp[sIdx])
                }
            }
            group.add(nums[sIdx])
            if (group.size == i + 1)
                group.remove(group.first())

        }
        group.clear()

        prevDp = newDp
        newDp = IntArray(nums.size)

    }
    return seqSize
}


fun solutionb(nums: IntArray): Int {

    var prevValue = Int.MAX_VALUE
    var prevDy = -1

    val mins = TreeSet<Item>()
    var lastMax = Int.MIN_VALUE

    for (idx in 0..nums.size) {

        val item = if (idx < nums.size) nums[idx] else Int.MAX_VALUE
        val dy = item - prevValue
        val prevItemIdx = max(0, idx - 1)
        if (prevDy < 0 && dy > 0) {
            val newItem = Item(nums[prevItemIdx], prevItemIdx)
            val higher = mins.higher(newItem)
            if (higher == null) {
                mins.add(newItem)
            }
        } else {
            lastMax = nums[prevItemIdx]
        }

        prevDy = dy
        prevValue = item

    }

    val res = TreeSet<Int>()
    if (mins.isNotEmpty()) {
        val start = mins.first()
        res.add(start.value)
        for (i in start.idx until nums.size) {

            val value = nums[i]
            if (mins.isNotEmpty()) {
                val nextLocalMin = mins.first().value
                if (res.last() < value && value <= nextLocalMin) {
                    res.add(value)
                }
                if (mins.first().idx == i) {
                    mins.remove(mins.first())
                }
            } else {

                if (res.last() < value && value <= lastMax) {
                    res.add(value)
                }
            }


        }
    }
    return if (res.isEmpty()) 1 else res.size
}

data class Item(val value: Int, val idx: Int) : Comparable<Item> {
    override fun compareTo(other: Item): Int {
        return value.compareTo(other.value)
    }

}
}