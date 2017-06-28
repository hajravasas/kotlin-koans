package i_introduction._5_String_Templates

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.regex.Pattern

class _05_String_Templates() {
    @Test fun match() {
        getMonth()
        assertTrue("11 MAR 1952".matches(task5().toRegex()))
    }

    @Test fun match1() {
        println(task5().toRegex())
        assertTrue("24 AUG 1957".matches(task5().toRegex()))
    }

    @Test fun doNotMatch() {
        println(task5().toRegex())
        assertFalse("24 RRR 1957".matches(task5().toRegex()))
    }
}
