import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class InsertDeleteUpdateRnd {
    private val list = ArrayList<Int>()
    private val set = HashMap<Int, Int>()
    private val random = Random()


    fun insert(value: Int): Boolean {

        val added = !set.contains(value)
        if (added) {
            list.add(value)
            set[value] = list.size - 1

        }
        return added
    }

    fun remove(value: Int): Boolean {
        val res = set.contains(value)
        if (res) {
            val idx = set[value] ?: throw IllegalStateException("Can't happen")
            val last = list[list.size - 1]
            list[idx] = last
            list.removeAt(list.size - 1)
            set[last] = idx
            set.remove(value)
        }
        return res
    }

    fun getRandom(): Int? {
        if(list.size == 0) return null
        val idx = random.nextInt(list.size)
        return list[idx]
    }
}