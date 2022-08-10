class Ships {

    /**
     *                          0 0 0 0
     *   0 0 0 0                0 1 1 1
     *   0 1 1 0                0 0 0 0
     *   0 0 0 0                0 0 0 0
     *   0 0 0 0                0 0 1 1
     */
    fun calculateShips(matrix: Array<BooleanArray>): Int {

        var ships = 0

        for (i in 0 until matrix.size) {

            val currentRow = matrix[i]
            for (j in 0 until matrix.size) {

                if (currentRow[j] == true) {

                    if ((i > 1 && matrix[i - 1][j] == false) || (i == 0))  {
                        val hasNoLeft = if (j > 1) currentRow[j - 1] == false else true
                        val hasNoRight = if (j < currentRow.size - 1) currentRow[j + 1] == false else true
                        if (hasNoLeft && hasNoRight) {
                            ships++
                        }
                    }

                    if ((j > 1 && currentRow[j - 1] == false) || (j == 0)) {
                        val hasNoTop = if (i > 1) matrix[i - 1][j] == false else true
                        val hasNoBottom = if ( i <= (matrix.size - 2)) matrix[i + 1][j] == false else true
                        if (hasNoTop && hasNoBottom) {
                            ships++
                        }
                    }

                }

            }

        }




        return ships
    }
}