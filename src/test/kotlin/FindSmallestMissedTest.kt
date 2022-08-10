import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FindSmallestMissedTest
{
    @Test
    fun `test 1`() {


        val fsm = FindSmallestMissed()

        val minSum = fsm.solution(intArrayOf(1, 3, 6, 4, 1, 2))

        Assertions.assertEquals(5, minSum)

    }

    @Test
    fun `test 2`() {


        val fsm = FindSmallestMissed()

        val minSum = fsm.solution(intArrayOf(1, 2, 3))

        Assertions.assertEquals(4, minSum)

    }

    @Test
    fun `test 3`() {


        val fsm = FindSmallestMissed()

        val minSum = fsm.solution(intArrayOf(-1, -3))

        Assertions.assertEquals(1, minSum)

    }
}