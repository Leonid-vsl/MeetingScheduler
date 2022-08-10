import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IpAddressCheckTest
{

    /**
     *
     *
     *  2.552.551.1135 -> err
     *  25.525.511.135 -> over
     *  255.2.551.1135 -> err
     *  255.25.511.135 -> over
     *  255.255.1.1135 -> err
     *  255.255.11.135
     *  255.255.111.35
     */
    @Test
    fun `test 1`() {

        val ipCh = IpAddressCheck()

        val ips = ipCh.restoreIpAddresses("25525511135")

        assertEquals(listOf("255.255.11.135","255.255.111.35"),ips)

    }

    @Test
    fun `test 2`() {

        val ipCh = IpAddressCheck()

        val ips = ipCh.restoreIpAddresses("0000")

        assertEquals(listOf("0.0.0.0"),ips)

    }

    @Test
    fun `test 3`() {

        val ipCh = IpAddressCheck()

        val ips = ipCh.restoreIpAddresses("101023")

        assertEquals(listOf("1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"),ips)

    }


}