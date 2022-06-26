class HillsAndValleys {


    fun getHilsAndValleys(data: IntArray): Int {


        val minValue = -10000
        var prevY = minValue

        var prevDYPositive = false
        var cnt = 0
        for (i in data.indices + 1) {

            val dy = (if (i >= data.size) minValue else data[i]) - prevY

            if (!prevDYPositive && dy > 0) {
                cnt++
                prevDYPositive = true
            } else if (prevDYPositive && dy < 0) {
                cnt++
                prevDYPositive = false
            }
            prevY = data[i]


        }


        return cnt
    }
}