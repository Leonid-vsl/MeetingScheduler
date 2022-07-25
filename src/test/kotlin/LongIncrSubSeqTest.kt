import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongIncrSubSeqTest {

    @Test
    fun `test 1`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.solutionjj(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18))

        assertEquals(4, res)

    }


    @Test
    fun `test 3`() {

        val subSeq = LongestIncreasingSubSeq()

       // val res = subSeq.solutiona(intArrayOf(0, 1, 0, 3, 2, 3))
        val res = subSeq.solutionj(intArrayOf(0, 1, 0, 3, 2, 3))

        assertEquals(4, res)

    }


    @Test
    fun `test 4`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.solutionjj(intArrayOf(7, 7, 7, 7, 7, 7, 7))

        assertEquals(1, res)

    }


    @Test
    fun `test 5`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.solutionh(intArrayOf(-2, -1))

        assertEquals(2, res)

    }

    @Test
    fun `test 6`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.solutiona(intArrayOf(1, 3, 6, 7, 9, 4, 10, 5, 6))

        assertEquals(6, res)

    }


    @Test
    fun `test 7`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.solutionc(intArrayOf(1, 3, 6, 7, 9, 4, 10, 5, 6))

        assertEquals(6, res)

    }

    @Test
    fun `test 8`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.solutionh(intArrayOf(3, 2, 1))

        assertEquals(1, res)

    }

    @Test
    fun `test 9`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.solutiona(intArrayOf(2, 15, 3, 7, 8, 6, 18))

        assertEquals(5, res)

    }

    @Test
    fun `test 10`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.solutionj(intArrayOf(11, 12, 13, 14, 15, 6, 7, 8, 101, 18))

        assertEquals(6, res)

    }

    @Test
    fun `test 10_1_1`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.solutionj(intArrayOf(300,200,11, 12, 13, 14, 15, 6, 7, 8,9,10, 101, 18))

        assertEquals(6, res)

    }

    @Test
    fun `test 10_1`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.solutionj(intArrayOf(2,15,3,7,8,6,18))

        assertEquals(5, res)

    }


    @Test
    fun `test 11`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.solutionjj((-1 downTo -2500).toList().toIntArray())

        assertEquals(1, res)

    }

    @Test
    fun `test 11_1`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.solutionj((1 until  2500).toList().toIntArray())

        assertEquals(1, res)

    }

    @Test
    fun `test 12`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.solutiona(intArrayOf(0))

        assertEquals(1, res)

    }

    @Test
    fun `test 12_2`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.sol(intArrayOf(4,10,4,3,8,9))

        assertEquals(3, res)

    }


    @Test
    fun `test 13`() {

        val subSeq = LongestIncreasingSubSeq()

        val res = subSeq.sol(
            intArrayOf(
                -813,82,-728,-82,-432,887,-551,324,-315,306,-164,-499,-873,-613,932,177,61,52,1000,-710,372,-306,-584,-332,-500,407,399,-648,290,-866,222,562,993,-338,-590,303,-16,-134,226,-648,909,582,177,899,-343,55,629,248,333,1,-921,143,629,981,-435,681,844,349,613,457,797,695,485,15,710,-450,-775,961,-445,-905,466,942,995,-289,-397,434,-14,34,-903,314,862,-441,507,-966,525,624,-706,39,152,536,874,-364,747,-35,446,-608,-554,-411,987,-354,-700,-34,395,-977,544,-330,596,335,-612,28,586,228,-664,-841,-999,-100,-620,718,489,346,450,772,941,952,-560,58,999,-879,396,-101,897,-1000,-566,-296,-555,938,941,475,-260,-52,193,379,866,226,-611,-177,507,910,-594,-856,156,71,-946,-660,-716,-295,-927,148,620,201,706,570,-659,174,637,-293,736,-735,377,-687,-962,768,430,576,160,577,-329,175,51,699,-113,950,-364,383,5,748,-250,-644,-576,-227,603,832,-483,-237,235,893,-336,452,-526,372,-418,356,325,-180,134,-698
            )
        )

        assertEquals(25, res)

    }


}