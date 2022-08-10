import java.util.BitSet

class FindSmallestMissed {

    fun solution(A: IntArray): Int {

        val set = BitSet(1_000_000)

        A.forEach {

            if (it > 0) {
                set.set(it)
            }
        }

        return set.nextClearBit(1)
    }
}