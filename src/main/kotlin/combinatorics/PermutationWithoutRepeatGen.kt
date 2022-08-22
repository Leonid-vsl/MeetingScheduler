package combinatorics

class PermutationWithoutRepeatGen {


    /**
     *
     *   Generate permutation without repeat
     *
     *   for instance for 3 it produce 6 results
     *
     *
     *   123, 231, 312, 132, 321, 213
     *
     */
    fun generate(source: List<String>): List<List<String>> {

        var res = mutableListOf<MutableList<String>>()
        gen0(res, mutableListOf(),source,0,source.size)

        return res
    }

    private fun gen0(collector:MutableList<MutableList<String>>, res: MutableList<String>, source: List<String>, level: Int, size: Int) {

        if (level == size){
            collector.add(res)
            return
        }

        for(item in source){

            val newRes = mutableListOf<String>()
            newRes.addAll(res)
            newRes.add(item)

            gen0(collector, newRes, source.filter { it == item }, level+1, size)

        }



    }
}