import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class FindMissedTest {


    @Test
    fun `test 1`() {



        val min = FindMissed()

        val lowesMissed = min.solutionb(intArrayOf(3,2,4,3),2,4)

       // 12 / 4 = 3

       // 12 / 4 = 3



        println(lowesMissed)

        val lowesMissed1 = min.solutionb(intArrayOf(1,5,6),4,3)


        println(lowesMissed1)

    }




}