package i_introduction._2_Named_Arguments

// default values for arguments:
fun bar(i: Int, s: String = "", b: Boolean = true) {}

fun task2(collection: Collection<Int>): String {
    return "{" + collection.joinToString() + "}"
}
