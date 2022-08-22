import combinatorics.PermutationWithRepeatGen
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PermGenTest
{
    @Test
    fun `permutation With Repeat`() {

        val topN = PermutationWithRepeatGen()

        val top = topN.generate(listOf("1","2","3"))

        Assertions.assertEquals(listOf(1, 2), top)

    }

    @Test
    fun `permutation Without Repeat`() {

        val topN = PermutationWithRepeatGen()

        val top = topN.generate(listOf("1","2","3"))

        Assertions.assertEquals(listOf(1, 2), top)

    }
}