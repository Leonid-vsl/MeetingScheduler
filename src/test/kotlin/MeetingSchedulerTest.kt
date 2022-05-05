import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import java.net.MalformedURLException

@ExtendWith(MockitoExtension::class)
class MeetingSchedulerTest {


    @Test
    fun `test 1`() {

       val s=  Scheduler()

        s.add(0,30)
        s.add(5,10)
        s.add(15,20)


        assertEquals(2,s.requiredRooms())

    }

    @Test
    fun `test 2`() {

        val s=  Scheduler()

        s.add(7,10)
        s.add(2,4)


        assertEquals(1,s.requiredRooms())

    }


    @Test
    fun `test 3`() {

        val s=  Scheduler()

        s.add(8,12)
        s.add(10,20)
        s.add(3,19)
        s.add(11,30)
        s.add(1,10)
        s.add(2,7)


        assertEquals(4,s.requiredRooms())

    }


}