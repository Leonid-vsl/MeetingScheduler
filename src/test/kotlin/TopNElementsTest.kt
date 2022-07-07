import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.collections.HashMap

class TopNElementsTest {


    @Test
    fun `test 1`() {

        val topN = TopNElements()

        val top = topN.getTop(intArrayOf(3,2,1,5,6,4),2)

        Assertions.assertEquals(5, top)

    }


    @Test
    fun `test 2`() {

        val topN = TopNElements()

        val top = topN.getTop(intArrayOf(3,2,3,1,2,4,5,5,6),4)

        Assertions.assertEquals(4, top)

    }

}