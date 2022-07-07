import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TopNElementsTest
{

    @Test
    fun `test 1`() {

        val topN = TopNElements()

        val top = topN.getTop(intArrayOf(1,1,1,2,2,3),2)

        assertEquals(listOf(1,2),top)

    }

    @Test
    fun `test 2`() {

        val topN = TopNElements()

        val top = topN.getTop(intArrayOf(1,1,1,2,2,3,4,5,6,7,7,8,8,7,4,3,7),2)

        assertEquals(listOf(1,7),top)

    }

    @Test
    fun `test 3`() {

        val topN = TopNElements()

        val top = topN.getTop(intArrayOf(1,2),2)

        assertEquals(listOf(1,2),top)

    }

    @Test
    fun `test 4`() {

        val topN = TopNElements()

        val top = topN.getTop(intArrayOf(4,1,-1,2,-1,2,3),2)

        assertEquals(listOf(-1,2),top)

    }
    @Test
    fun `test 5`() {

        val topN = TopNElements()

        val top = topN.getTop(intArrayOf(5,3,1,1,1,3,73,1),2)

        assertEquals(listOf(1,3),top)

    }


    @Test
    fun `test 4_1`() {

        val topN = TopNElements()

        val top = topN.getTop1(intArrayOf(4,1,-1,2,-1,2,3),2)


        assertEquals(listOf(-1,2),top)

    }

    @Test
    fun `test 5_1`() {

        val topN = TopNElements()

        val top = topN.getTop1(intArrayOf(5,2,5,3,5,3,1,1,3),2)


        assertEquals(listOf(3,5),top)

    }


}