class MoveZerosToBeginning {


    fun moveZeros(input:IntArray): IntArray {

        var lastZeroIdx = 0
        for(i in 0 until  input.size){

            if(input[i] == 0){

                var prevValue = input[lastZeroIdx]
                input[lastZeroIdx++] = 0

                var shiftIdx = lastZeroIdx
                while (shiftIdx <= i){
                    val tmpPrev = input[shiftIdx]
                    input[shiftIdx] = prevValue
                    prevValue = tmpPrev
                    shiftIdx++
                }

            }

        }

        return input

    }
}