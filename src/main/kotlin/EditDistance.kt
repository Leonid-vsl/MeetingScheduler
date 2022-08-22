class EditDistance {


    /**
     *          a b c      a b c s     a b *     a b *     c b *     c e *     a b c      a d b f
     *                                                                                  0 0 0 0 0
     *        a 0 1 2    a 0 1 2 3   a 0 1 2   a 0 1 2   a 1 2 3   a 1 2 3   a 0 1 2    a 0 1 2 3
     *        d 0 1 2    d 0 1 2 3   d 0 1 2   b 0 0 1   b 0 1 2   b 0 2 3   b 0 0 1    b 0 1 2 3
     *        c 0 1 1    c 0 1 1 2   c 0 1 2   c 0 0 2   c 0 0 2   c 0 0 3   c 0 0 0    c 0 0 2 2
     *                                                                                  s 0 0 0 3
     */
    fun editDistance(a: String, b: String): Int {


        if(a.isEmpty() && b.isEmpty()) return 0

        var longestStr = a
        var shortestStr = b
        if (a.length != b.length) {
            longestStr = if (a.length > b.length) a else b
            shortestStr = if (a.length < b.length) a else b
        }

        var prev = IntArray(longestStr.length) { i -> i + 1 }
        var current = IntArray(longestStr.length)


        for (i in 0 until shortestStr.length) {

            for (j in i until longestStr.length) {
                val prevGr = if (j >= 1) prev[j - 1] else 0
                val prevCur = if (i == j) prevGr else {
                    current[j - 1]
                }
                val prevTop = prev[j]

                val new = Math.min(prevTop,Math.min(prevGr, prevCur))
                if (shortestStr[i] == longestStr[j]) {
                    current[j] = new
                } else {
                    current[j] = new + 1

                }
            }
            prev = current
            current = IntArray(longestStr.length)
        }

        return prev.last()
    }
}