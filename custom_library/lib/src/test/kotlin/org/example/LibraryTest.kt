/*
 * This source file was generated by the Gradle 'init' task
 */
package jy.library

import kotlin.test.Test
import kotlin.test.assertTrue

class LibraryTest {
    @Test fun someLibraryMethodReturnsTrue() {
        val classUnderTest = Library()
        classUnderTest.PrintName("James")
        assertTrue(true, "someLibraryMethod should return 'true'")
    }
}
