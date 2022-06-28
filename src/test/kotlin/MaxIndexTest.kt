import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxIndexTest
{

    @Test
    fun `test 1`() {
        val app = MaxIndex()


        val res = app.maxIndex(10,50)
        assertEquals(20, res)

    }

    @Test
    fun `test 2`() {
        val app = MaxIndex()


        val res = app.maxIndex(2,1)
        assertEquals(2, res)

    }


    @Test
    fun `test 3`() {
        val app = MaxIndex()


        val res = app.maxIndex(3,3)
        assertEquals(5, res)

    }

    @Test
    fun `test 4`() {
        val app = MaxIndex()


        val res = app.maxIndex(4,3)
        assertEquals(5, res)

    }
}