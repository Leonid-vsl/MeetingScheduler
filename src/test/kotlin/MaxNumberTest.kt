import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxNumberTest {

    @Test
    fun `test 1`() {
        val max = MaxNumber()

        val m = max.getMaxNumber(intArrayOf(10, 2))

        assertEquals("210", m)

    }

    @Test
    fun `test 2`() {
        val max = MaxNumber()

        val m = max.getMaxNumber(intArrayOf(3, 30,34,5,9))

        assertEquals("9534330", m)

    }
}