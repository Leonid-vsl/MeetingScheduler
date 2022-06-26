import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeArrayTest
{

    @Test
    fun `test 1`() {

        val merge = MergeArrays()

        val merged = merge.merge2Arr(intArrayOf(1,2),intArrayOf(3,4))

        assertArrayEquals(intArrayOf(1,2,3,4),merged)

    }

    @Test
    fun `test 2`() {

        val merge = MergeArrays()

        val merged = merge.merge2Arr(intArrayOf(1,2),intArrayOf(1,2,3,4))

        assertArrayEquals(intArrayOf(1,1,2,2,3,4),merged)

    }

    @Test
    fun `test 3`() {

        val merge = MergeArrays()

        val merged = merge.mergeKArr(listOf(intArrayOf(1,4,8),intArrayOf(2,3),intArrayOf(5,6,10)))

        assertArrayEquals(intArrayOf(1,2,3,4,5,6,8,10),merged)

    }


    @Test
    fun `test 4`() {

        val merge = MergeArrays()

        val merged = merge.mergeKArr(listOf(intArrayOf(1,5,6),intArrayOf(2,3,7),intArrayOf(8,9,10)))

        assertArrayEquals(intArrayOf(1,2,3,5,6,7,8,9,10),merged)

    }

    @Test
    fun `test 5`() {

        val merge = MergeArrays()

        val merged = merge.mergeKArr(listOf(intArrayOf(1,5,6,11,15,18),intArrayOf(2,3,7,12),intArrayOf(8,9,10)))

        assertArrayEquals(intArrayOf(1,2,3,5,6,7,8,9,10,11,12,15,18),merged)

    }
}