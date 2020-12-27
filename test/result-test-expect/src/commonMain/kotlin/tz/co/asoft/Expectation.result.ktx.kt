package tz.co.asoft

import kotlin.test.assertEquals
import kotlin.test.assertTrue

fun Expectation<Result<*>>.toBe(expected: Any?) = assertEquals(expected, value.value)

inline fun <reified T> Expectation<Result<*>>.toBe() = assertTrue(
    """
        
    Expected : ${T::class.simpleName}
    Actual   : ${value.value}
    =================================
    
    """.trimIndent()
) { value.value is T }

inline fun <reified S> Expectation<Result<S>>.toBeSuccess() = assertTrue(
    """
        
    Expected : Result to be success
    Actual   : ${value.value}
    =================================
    
    """.trimIndent()
) { value.value is S }

fun Expectation<Result<*>>.toBeFailure() = assertTrue(
    """
        
    Expected : Result to be failure
    Actual   : ${value.value}
    =================================
    
    """.trimIndent()
) { value.value is Failure }