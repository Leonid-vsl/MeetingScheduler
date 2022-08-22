import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MovingZerosToBeginningTest {

    @Test
    fun `test 1`() {

        val hv = MoveZerosToBeginning()

        val res = hv.moveZeros(intArrayOf(99, 10, 20, 0, 59, 63, 0, 88, 0))

        assertArrayEquals(intArrayOf(0, 0, 0, 99, 10, 20, 59, 63, 88), res)

        res.joinToString(separator = ",")

    }


}