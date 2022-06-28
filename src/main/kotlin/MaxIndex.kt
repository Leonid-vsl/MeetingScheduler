import kotlin.math.max

class MaxIndex {


    fun maxIndex(steps: Int, badIndex: Int): Int {
        return nextStep(0, 1, 0, steps, badIndex, false, "")
    }

    fun nextStep(idx: Int, j: Int, cnt: Int, steps: Int, badIndex: Int, hasZero: Boolean, path: String): Int {

        if (cnt == steps){
            println("path:$path hasZero:$hasZero idx:$idx")
            return idx
        }
        val nexIdx = if (idx + j == badIndex){ idx }else idx + j

        val newPath = "${path}${(nexIdx - idx)}"



        return if (idx <= badIndex) {
            if (hasZero && nexIdx != idx) {
                nextStep(nexIdx, j + 1, cnt + 1, steps, badIndex, true, newPath)
            } else{
                max(
                    nextStep(nexIdx, j + 1, cnt + 1, steps, badIndex, false, newPath),
                    if(idx != badIndex)nextStep(idx, j + 1, cnt + 1, steps, badIndex, true, "${path}0") else idx
                )
            }
        } else {

            var res = idx
            for (n in j..steps) {
                res += n
            }
            println("path:$path hasZero:$hasZero idx:$res")
            res
        }
    }


}


