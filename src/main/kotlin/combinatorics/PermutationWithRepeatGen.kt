package combinatorics

class PermutationWithRepeatGen {


    /**
     *
     *   Generate permutation with repeat
     *
     *   for instance for 3 it produce 27 results
     *
     *
     *   111 -> 112 -> 113 -> 121 -> 122 -> 123 -> 131... -> 333
     *
     */
    fun generateTree(source: List<String>): List<List<String>> {

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

            gen0(collector, newRes, source, level+1, size)

        }



    }
}