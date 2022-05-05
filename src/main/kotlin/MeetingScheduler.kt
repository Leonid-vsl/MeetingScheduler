import java.util.TreeSet

class MeetingScheduler {
    val rooms = mutableListOf(TreeSet<Meeting>())


    fun add(from: Int, till: Int) {
        val meeting = Meeting(from, till)
        val hasFit = rooms.any {
            val free = !it.contains(meeting)
            if (free) {
                it.add(meeting)
            }
            free
        }

        if (!hasFit) {
            rooms.add(TreeSet<Meeting>(setOf(meeting)))
        }
    }

    fun requiredRooms() = rooms.size

}

/**
 *
 * 3;8, 6;9, 7;12, 3;19
 *   5;10
 *
 * 3;4 11;14
 *
 */
data class Meeting(val from: Int, val till: Int) : Comparable<Meeting> {
    override fun compareTo(other: Meeting): Int {
        return if (!(till <= other.from || from >= other.till)) {
            0
        } else {
            if (from > other.till) 1 else -1
        }
    }

}