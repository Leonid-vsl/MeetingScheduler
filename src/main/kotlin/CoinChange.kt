import java.util.PriorityQueue
import kotlin.math.min

class CoinChange {

    fun minChange1(coins: IntArray, amount: Int): Int {
        return check(mutableMapOf(), coins, amount)
    }

    private fun check(cache: MutableMap<Int, Int>, coins: IntArray, leftAmount: Int): Int {
        if (leftAmount == 0) {
            return 0
        }
        var minH = Int.MAX_VALUE
        for (nextCoin in coins) {
            val newLeftAmount = leftAmount - nextCoin
            if (newLeftAmount >= 0) {
                var change = cache[leftAmount]
                if (change == null) {

                    val check = check(cache, coins, leftAmount - nextCoin)
                    change = if (check >= 0) check + 1 else check
                }
                if (change >= 0)
                    minH = min(minH,change)

            }
        }
        val min = if (minH == Int.MAX_VALUE) -1 else minH
        if (cache[leftAmount] == null) {
            cache[leftAmount] = min
        }
        return min
    }




}