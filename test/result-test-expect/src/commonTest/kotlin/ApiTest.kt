import duality.Result
import duality.Success
import duality.toFailure
import tz.co.asoft.*
import kotlin.test.Test

class ApiTest {
    @Test
    fun should_easily_assert_an_Either() {
        val res: Result<Int> = Success(4)
        expect(res).toBe(4)
        expect(res).toBe<Int>()
        expect(res).toBeSuccess()

        val res2: Result<String> = Exception("Test Failure").toFailure()
        expect(res2).toBeFailure()
    }
}