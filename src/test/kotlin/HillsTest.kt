import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HillsTest
{

    @Test
    fun `test 1`() {

        val hv = HillsAndValleys()

        val hvCnt = hv.getHilsAndValleys(intArrayOf(2,2,3,4,3,3,2,2,1,1,2,5))

        assertEquals(4,hvCnt)

    }

    @Test
    fun `test 2`() {

        val hv = HillsAndValleys()

        val hvCnt = hv.getHilsAndValleys(intArrayOf(-3,-3))

        assertEquals(1,hvCnt)

    }


    @Test
    fun `test 3`() {

        val hv = HillsAndValleys()

        val hvCnt = hv.getHilsAndValleys(intArrayOf(2,1,1,2))

        assertEquals(1,hvCnt)

    }

    @Test
    fun `test 4`() {

        val hv = HillsAndValleys()

        val hvCnt = hv.getHilsAndValleys(intArrayOf(1,1,1,1))

        assertEquals(1,hvCnt)

    }

}