import combinatorics.PermutationWithRepeatGen
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TreeGenTest
{
    @Test
    fun `test 1`() {

        val topN = PermutationWithRepeatGen()

        val top = topN.generateTree(listOf("1","2","3"))

        Assertions.assertEquals(listOf(1, 2), top)

    }
}