package tz.co.asoft

import kotlin.test.assertEquals
import kotlin.test.assertTrue

fun Expectation<Either<*, *>>.toBe(expected: Any?) = assertEquals(expected, value.value)

inline fun <reified T> Expectation<Either<*, *>>.toBe() = assertTrue(
    """
        
    Expected : ${T::class.simpleName}
    Actual   : ${value.value}
    =================================
    
    """.trimIndent()
) { value.value is T }

inline fun <reified L, reified R> Expectation<*>.toBeEither(): Either<L, R> {
    assertTrue(
        """
            
    Expected : [${L::class.simpleName} | ${R::class.simpleName}]
    Actual   : $value
    =============================================================

    """.trimIndent()
    ) { value is L || value is R }
    return value.asEither()
}