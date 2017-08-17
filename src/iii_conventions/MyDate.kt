package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return when {
            year != other.year -> year - other.year
            month != other.month -> month - other.month
            else -> dayOfMonth - other.dayOfMonth
        }
    }

    operator fun plus(timeInterval: TimeInterval) =
        addTimeIntervals(timeInterval, 1)

    operator fun plus(timeIntervals: RepeatedTimeInterval) =
        addTimeIntervals(timeIntervals.ti, timeIntervals.n)
}

class RepeatedTimeInterval(val ti: TimeInterval, val n: Int) {

}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(number: Int) =
            RepeatedTimeInterval(this, number)
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    operator fun contains(d: MyDate): Boolean {
        return start < d && d <= endInclusive
    }

    override fun iterator() : Iterator<MyDate> = MyDateIterator(this)

    class MyDateIterator(val dateRange: DateRange) : Iterator<MyDate> {
        var current : MyDate = dateRange.start

        override fun hasNext(): Boolean {
            return current <= dateRange.endInclusive
        }

        override fun next(): MyDate {
            val result = current
            current = current.nextDay()
            return result
        }

    }
}
