package duality

import io.ktor.http.*

class HttpResult<T> {
    private val cause = Throwable("Primarily due to not calling resolve or reject on your HttpResult builder")
    var response: Pair<Result<T>, HttpStatusCode> =
        Exception("Unhandled result", cause).toFailure<T>() to HttpStatusCode.InternalServerError

    class ResultException(val code: HttpStatusCode, val error: Throwable) : Exception(error)

    fun resolve(result: T, status: HttpStatusCode = HttpStatusCode.OK) {
        response = Success(result) to status
    }

    fun reject(error: Throwable, status: HttpStatusCode = HttpStatusCode.BadRequest): Nothing {
        val cause = ResultException(code = status, error = error)
        response = cause.toFailure<T>() to status
        throw cause
    }

    fun reject(error: String, status: HttpStatusCode = HttpStatusCode.BadRequest): Nothing {
        reject(Exception(error), status)
    }

    fun badRequest(message: String): Nothing {
        reject(message, HttpStatusCode.BadRequest)
    }
}