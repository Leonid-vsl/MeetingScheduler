import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.min

class EditDistanceTest {

    /**
     *          a b c
     *
     *        a 0 1 2
     *        d 0 1 2
     *        c 0 1 1
     *
     */
    @Test
    fun `test 1`() {


        val dist = EditDistance()

       // val minSum = change.solutionb(intArrayOf(7, 2, 5,10,8), 2)
        val res = dist.editDistance("abc","adc")



        Assertions.assertEquals(1, res)

    }

    /**
     *
     *        a b c s
     *
     *      a 0 1 2 3
     *      d 0 1 2 3
     *      c 0 1 1 2
     */
    @Test
    fun `test 2`() {


        val dist = EditDistance()

        // val minSum = change.solutionb(intArrayOf(7, 2, 5,10,8), 2)
        val res = dist.editDistance("abcs","adc")



        Assertions.assertEquals(2, res)

    }


    /**
     *
     *        h o r s e
     *      0 1 2 3 4 5
     *      r 1 2 2 3 4
     *      o - 1 3 3 5
     *      s - - 2 3 4
     *







     **
     *      horse -> rorse (replace 'h' with 'r')
     *      rorse -> rose (remove 'r')
     *      rose -> ros (remove 'e')
     */
    @Test
    fun `test 3`() {


        val dist = EditDistance()

        // val minSum = change.solutionb(intArrayOf(7, 2, 5,10,8), 2)
        val res = dist.editDistance("horse","ros")



        Assertions.assertEquals(3, res)

    }


    /**
     *         1 2 3 4 5 6 7 8 9
     *         e x e c u t i o n
     *       0 1 2 3 4 5 6 7 8 9
     *     1 i 1 2 3 4 5 6 6 7 8
     *     2 n - 2 3 4 5 6 7 7 7
     *     3 t - - 3 4 5 5 7 8 8
     *     4 e - - - 4 5 6 6 8 9
     *     5 n - - - - 5 6 7 7 8
     *     6 t 0 0 1 - - 5 7 8 8
     *     7 i 0 0 1 2 - - 5 8 9
     *     8 o 0 0 1 2 3 - - 5 9
     *     9 n 0 0 1 2 3 - - - 5
     *
     *      intention -> inention (remove 't')
     *      inention -> enention (replace 'i' with 'e')
     *      enention -> exention (replace 'n' with 'x')
     *      exention -> exection (replace 'n' with 'c')
     *      exection -> execution (insert 'u')
     */
    @Test
    fun `test 4`() {


        val dist = EditDistance()

        // val minSum = change.solutionb(intArrayOf(7, 2, 5,10,8), 2)
        val res = dist.editDistance("intention","execution")



        Assertions.assertEquals(5, res)

    }

    /**
     *         1 2 3
     *         s e a
     *       0 1 2 3
     *     1 e 1 1 2
     *     2 a - 2 1
     *     3 t - - 3
     */
    @Test
    fun `test 5`() {


        val dist = EditDistance()

        // val minSum = change.solutionb(intArrayOf(7, 2, 5,10,8), 2)
        val res = dist.editDistance("sea","eat")



        Assertions.assertEquals(2, res)

    }

    /**
     *         1 2 3 4
     *         m a r t
     *       0 1 2 3 1
     *     1 k 1 1 2 1
     *     2 a - 2 1 1
     *     3 r - - 3 1
     *     4 m - - 3 1
     *     5 a - - 3 1
     */
    @Test
    fun `test 6`() {


        val dist = EditDistance()

        // val minSum = change.solutionb(intArrayOf(7, 2, 5,10,8), 2)
        val res = dist.editDistance("mart","karma")



        Assertions.assertEquals(2, res)

    }


    /**
     *         1 2 3 4 5 6 7
     *         t e p a c h e
     *       0 1 2 3 4 5 6 7
     *     1 t 0 1 2 3 4 5 6
     *     2 e - 0 1 2 3 4 5
     *     3 a - - 1 1 2 3 4
     *     4 c - - - 2 2 3 4
     *     5 h - - - -
     *     6 e - - - - -
     *     7 r - - - - - -
     */
    @Test
    fun `test 7`() {


        val dist = EditDistance()

        // val minSum = change.solutionb(intArrayOf(7, 2, 5,10,8), 2)
        val res = dist.editDistance("teacher","tepache")



        Assertions.assertEquals(2, res)

    }

}