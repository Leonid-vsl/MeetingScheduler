import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class InesrtDeleteUpdateTest {
    @Test
    fun `test 1`() {


        val fsm = InsertDeleteUpdateRnd()

        val minSum = fsm.getRandom()
        Assertions.assertEquals(null, minSum)
        fsm.insert(0)
        fsm.insert(1)
        fsm.remove(0)
        fsm.insert(2)
        fsm.remove(1)
        val rnd = fsm.getRandom()

        Assertions.assertEquals(2, rnd)

    }


}