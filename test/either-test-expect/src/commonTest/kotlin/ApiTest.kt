import duality.Either
import tz.co.asoft.*
import kotlin.test.Test

class ApiTest {
    @Test
    fun should_have_a_good_looking_api() {
        expect(3).toBeEither<String, Int>()
    }

    @Test
    fun should_easily_assert_an_Either() {
        val res: Either<String, Int> = 4.asEither()
        expect(res).toBe(4)
        expect(res).toBe<Int>()
    }
}