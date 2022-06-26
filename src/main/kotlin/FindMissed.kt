import java.util.BitSet

class FindMissed {

    fun solutionb(A: IntArray, F: Int, M: Int): List<List<Int>> {

        if (A.size == 0 || A.size > 1_000_000) return listOf()
        if (F < 0 || F > 1_000_000) return listOf()
        if (M < 0 || M > 6) return listOf()


        val aSum = A.sum()


        val target = ((A.size + F) * M) - aSum

        val digits = mutableSetOf<Int>()
            for (d in 1..6) {
                val max = d + ((F -1) * 1)
                if (max <= target) {
                    digits.add(d)

                }


            }



        //   t 5    t 12  t 4 t 16
        //   s 3    s 2   s 3   s3

        // 3 1 1    6 1   2 1 1  6 1 1
        // 3 3 3    6 6   3 3 3
        //                2 1 1
        //                2 2 2
        var g = digits.map { listOf(it) to it }
        for (f in 1 until F) {
            g = gen(g, target)
        }

        val grouped = g.groupBy({ it.second }, { it.first })



        return grouped[target] ?: listOf()
    }


    fun gen(result: List<Pair<List<Int>, Int>>, target: Int): List<Pair<List<Int>, Int>> {

        val res = mutableListOf<Pair<List<Int>, Int>>()

        for (item in result) {
            for (i in 1..6) {

                if(item.second + i > target) break
                res.add(item.first + listOf(i) to item.second + i)

            }
        }

        return res
    }


}