import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShipTest
{

    /**
     *
     *   0 0 0 0
     *   0 1 1 0
     *   0 0 0 0
     *   0 0 0 0
     */
    @Test
    fun `test 1`() {

        val s = Ships()

       val res = s.calculateShips(arrayOf(
            booleanArrayOf(false,false,false,false),
            booleanArrayOf(false,true,true,false),
            booleanArrayOf(false,false,false,false),
            booleanArrayOf(false,false,false,false)
        ))


        assertEquals(1,res)
    }

    /**
     *
     *   1 0 0 0
     *   1 1 1 1
     *   0 0 0 0
     *   0 0 0 0
     */
    @Test
    fun `test 2`() {

        val s = Ships()

        val res = s.calculateShips(arrayOf(
            booleanArrayOf(true,false,false,false),
            booleanArrayOf(true,true,true,true),
            booleanArrayOf(false,false,false,false),
            booleanArrayOf(false,false,false,false)
        ))


        assertEquals(2,res)
    }

    /**
     *
     *   1 0 0 0
     *   1 0 1 0
     *   0 0 1 0
     *   0 0 0 0
     */
    @Test
    fun `test 3`() {

        val s = Ships()

        val res = s.calculateShips(arrayOf(
            booleanArrayOf(true,false,false,false),
            booleanArrayOf(true,false,true,false),
            booleanArrayOf(false,false,true,false),
            booleanArrayOf(false,false,false,false)
        ))


        assertEquals(2,res)
    }

}