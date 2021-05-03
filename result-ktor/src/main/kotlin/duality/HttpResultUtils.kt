package duality

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.util.pipeline.*
import kotlinx.serialization.KSerializer

/**
 * Returns null if the text body is empty or blank otherwise it returns the text body of the request
 */
suspend fun ApplicationCall.receiveTextBody() = receiveText().takeIf { it.isNotBlank() }

suspend inline fun <T> PipelineContext<Unit, ApplicationCall>.respond(
    serializer: KSerializer<T>,
    builder: HttpResult<T>.() -> Unit
) {
    val (res, status) = try {
        HttpResult<T>().apply(builder).response
    } catch (err: Throwable) {
        when (err) {
            is HttpResult.ResultException -> err.error.toFailure<T>() to err.code
            is MissingRequestParameterException -> err.toFailure<T>() to HttpStatusCode.BadRequest
            else -> err.toFailure<T>() to HttpStatusCode.BadRequest
        }
    }
    call.respondText(
        text = Result.stringify(serializer, res),
        contentType = ContentType.Application.Json,
        status = status
    )
}