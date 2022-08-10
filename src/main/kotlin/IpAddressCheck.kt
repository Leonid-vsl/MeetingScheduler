class IpAddressCheck {

    /**
     *
     *
     *  2.552.551.1135 -> err
     *  25.525.511.135 -> over
     *  255.2.551.1135 -> err
     *  255.25.511.35 -> over
     *  255.255.1.1135 -> err
     *  255.255.11.135
     *  255.255.111.35
     *
     *  0.0.0.0
     *
     *
     *
     */
    fun restoreIpAddresses(str: String): List<String> {

        val ips = mutableListOf<List<String>>()

        doCheck(str, ips, mutableListOf(), str, 3, 4, 0)
        return ips.map {
            it.joinToString(separator = ".")
        }
    }


    private fun doCheck(
        or: String,
        ips: MutableList<List<String>>,
        ip: MutableList<String>,
        str: String,
        groupsLen: Int,
        groupsTotal: Int,
        level: Int
    ) {


        if (groupsTotal == level && str.isEmpty()) {
            ips.add(ip)
            return
        }

        val currentGr = StringBuilder()
        for (i in 0 until groupsLen) {

            val newIp = mutableListOf<String>()
            newIp.addAll(ip)

            if (str.length - 1 < i) {
                return
            } else {
                val newElement = str.get(i)

                currentGr.append(newElement)
                val strValue = currentGr.toString()
                val intValue = strValue.toInt()
                if(intValue <= 255 && (strValue.length == 1 || (strValue.length > 1 && !strValue.startsWith("0")))){
                    newIp.add(strValue)
                    doCheck(or, ips, newIp, str.drop(i + 1), groupsLen, groupsTotal, level + 1)
                }
            }

        }
    }


}

