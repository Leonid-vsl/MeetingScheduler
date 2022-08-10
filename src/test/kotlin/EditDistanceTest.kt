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





}