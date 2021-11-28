package com.test_app.utils

import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ValidateInputStringUnitTest {
    @Test
    fun validateField_Is_True() {
        assertTrue(validateField("field"))
    }
    @Test
    fun validateField_Is_False() {
        assertFalse(validateField(""))
    }
}