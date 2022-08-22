import java.util.concurrent.locks.ReentrantLock

/*

        1. FIFO
        2. Ring buffer, use all space in the buffer. Throw exception in corner cases:  no free space (on put) or data (on get)

        e.g.

        empty buffer (size = 3) _,_,_
        get -> no data, buffer is empty (exception: non thread-safe , block: thread-safe)
        put 1 ->     1,_,_
        put 2 ->     1,2,_
        put 3 ->     1,2,3
        put 4 -> buffer is full  (exception: non thread-safe , block: thread-safe)
        get -> 1     _,2,3
        put 4 ->    4,2,3
        get -> 2     4,_,3
        put 5 ->    4,5,3
        get -> 3     4,5,_
        put 6 ->    4,5,6
        get -> 4     4,5,_
        get -> 5     _,5,6
        get -> 6     _,_,_

        3. blocking when no free place (on put) or data (on get)
        4. Thread safe

 */
class RingBufferThreadSafe(
    val maxBufferSize: Int,
) {
    private var data: Array<Any?> = arrayOfNulls(maxBufferSize)
    private var currentFreeItemIdx = 0
    private var currentReadIdx = 0
    private var size = 0
    private var lock = ReentrantLock()
    private var condition = lock.newCondition()


    fun put(item: Any?) {

        try {
            lock.lock()

            while (size == maxBufferSize) {
                condition.await()
            }
            condition.signalAll()


            data[currentFreeItemIdx++ % maxBufferSize] = item
            size++

        } finally {
            lock.unlock()
        }
    }

    fun get(): Any? {

        try {
            lock.lock()
            while (size == 0) {
                condition.await()
            }
            condition.signalAll()

            val readIdx = currentReadIdx++ % maxBufferSize
            val res = data[readIdx]
            size--

            return res
        } finally {
            lock.unlock()
        }
    }
}