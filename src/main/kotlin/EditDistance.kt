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



        val max = Math.max(a.length,b.length)
        val min = Math.min(a.length,b.length)
        val charsA = a.toCharArray()
        val charsB = b.toCharArray()
        var prev = IntArray(max)
        var current = IntArray(max)


        for(i in 0 until  min){

            for(j in i until  max){
                val prevGr = if(j > 1)prev[j - 1] else 0
                if(charsA[i] == charsB[j]){
                    current[j] = prevGr
                }else{
                    current[j] = prevGr +1

                }
            }
            prev = current
            current = IntArray(max)
        }

        return prev.last()
    }
}