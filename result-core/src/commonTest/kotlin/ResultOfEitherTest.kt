import tz.co.asoft.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ResultOfEitherTest {

    @Test
    fun should_serialize_a_result_of_either() {
        val eit: Either<Car, Person> = Either.Right(Person("Andy"))
        val res: Result<Either<Car, Person>> = eit.asSuccess()
        println(res)
        assertEquals(res.status, ResultStatus.Success)
        println("Result Json: ${Result.stringifyEither(Car.serializer(), Person.serializer(), res)}")
    }

    @Test
    fun should_deserialize_a_person_from_json() {
        val json = """{"name":"Andy"}"""
        val res = Result.parseEither(Car.serializer(), Person.serializer(), json)
        val either = res.value
        assertTrue(either is Either<*, *>)

        val person = either.value

        assertTrue(person is Person)
    }
}