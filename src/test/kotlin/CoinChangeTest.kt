import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.min

class CoinChangeTest {

    @Test
    fun `test 1`() {


        val change = CoinChange()

        val minChange = change.minChange1(intArrayOf(1, 2, 5), 11)

        Assertions.assertEquals(3, minChange)

    }

    @Test
    fun `test 2`() {


        val change = CoinChange()

        val minChange = change.minChange1(intArrayOf( 2, 5), 1)

        Assertions.assertEquals(-1, minChange)

    }

    @Test
    fun `test 3`() {


        val change = CoinChange()

        val minChange = change.minChange1(intArrayOf( 2), 3)

        Assertions.assertEquals(-1, minChange)

    }


    @Test
    fun `test 4`() {


        val change = CoinChange()

        val minChange = change.minChange1(intArrayOf(186,419,83,408), 6249)

        Assertions.assertEquals(20, minChange)

    }
}