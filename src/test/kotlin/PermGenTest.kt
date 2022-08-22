import combinatorics.PermutationWithRepeatGen
import combinatorics.PermutationWithoutRepeatGen
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

    /**
     *    123, 231, 312, 132, 321, 213
     */
    @Test
    fun `permutation Without Repeat`() {

        val permGen = PermutationWithoutRepeatGen()

        val perm = permGen.generate(listOf("1","2","3"))

        Assertions.assertEquals(listOf("123", "231", "312", "132", "321", "213"), perm)

    }
}