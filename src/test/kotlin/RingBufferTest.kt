import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RingBufferTest
{

    @Test
    fun `test throws exception if empty`() {

        val buffer = RingBufferT(3)


       val err = assertThrows<IllegalStateException> {
           buffer.get()
       }


        assertEquals("Buffer is empty",err.message)
    }


    @Test
    fun `test put get`() {

        val buffer = RingBufferT(3)


        buffer.put("1")
        val result  = buffer.get()


        assertEquals("1", result)
    }

    @Test
    fun `test buffer is full`() {

        val buffer = RingBufferT(3)


        buffer.put("1")
        buffer.put("2")
        buffer.put("3")

        val err = assertThrows<IllegalStateException> {
            buffer.put("4")
        }


        assertEquals("Buffer is full",err.message)
    }

    @Test
    fun `test access order FIFO`() {

        val buffer = RingBufferT(3)


        buffer.put("1")
        buffer.put("2")
        buffer.put("3")



        assertEquals("1",buffer.get())
        assertEquals("2",buffer.get())
        assertEquals("3",buffer.get())
    }

    /**
        put 1 ->     1,_,_
        put 2 ->     1,2,_
        put 3 ->     1,2,3
        get -> 1     _,2,3
        put 4 ->    4,2,3
        get -> 2     4,_,3
        put 5 ->    4,5,3
        get -> 3     4,5,_
        put 6 ->    4,5,6
        get -> 4     4,5,_
        get -> 5     _,5,6
        get -> 6     _,_,_
     */
    @Test
    fun `test scenario FIFO`() {

        val buffer = RingBufferT(3)


        buffer.put("1")
        buffer.put("2")
        buffer.put("3")

        assertEquals("1",buffer.get())

        buffer.put("4")

        assertEquals("2",buffer.get())

        buffer.put("5")

        assertEquals("3",buffer.get())

        buffer.put("6")

        assertEquals("4",buffer.get())
        assertEquals("5",buffer.get())
        assertEquals("6",buffer.get())

        assertThrows<IllegalStateException> {
            buffer.get()
        }

    }

}