package com.test_app.model

import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class AppStateUnitTest {
    @Test
    fun appState_isSame() {
        assertNotEquals(AppState.Loading, AppState.Error(Throwable()))
    }
}