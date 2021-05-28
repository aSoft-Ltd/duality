package duality

import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.util.pipeline.*
import kotlinx.serialization.KSerializer

@ContextDsl
inline fun <T> Route.post(
    path: String,
    serializer: KSerializer<T>,
    crossinline builder: suspend HttpResult<T>.(call: ApplicationCall) -> Unit
): Route = post(path) {
    respond(serializer) { builder(call) }
}

@ContextDsl
inline fun <T> Route.get(
    path: String,
    serializer: KSerializer<T>,
    crossinline builder: suspend HttpResult<T>.(call: ApplicationCall) -> Unit
): Route = get(path) {
    respond(serializer) { builder(call) }
}

@ContextDsl
inline fun <T> Route.put(
    path: String,
    serializer: KSerializer<T>,
    crossinline builder: suspend HttpResult<T>.(call: ApplicationCall) -> Unit
): Route = put(path) {
    respond(serializer) { builder(call) }
}

@ContextDsl
inline fun <T> Route.patch(
    path: String,
    serializer: KSerializer<T>,
    crossinline builder: suspend HttpResult<T>.(call: ApplicationCall) -> Unit
): Route = patch(path) {
    respond(serializer) { builder(call) }
}

@ContextDsl
inline fun <T> Route.delete(
    path: String,
    serializer: KSerializer<T>,
    crossinline builder: suspend HttpResult<T>.(call: ApplicationCall) -> Unit
): Route = delete(path) {
    respond(serializer) { builder(call) }
}

@ContextDsl
inline fun <T> Route.head(
    path: String,
    serializer: KSerializer<T>,
    crossinline builder: suspend HttpResult<T>.(call: ApplicationCall) -> Unit
): Route = head(path) {
    respond(serializer) { builder(call) }
}

@ContextDsl
inline fun <T> Route.options(
    path: String,
    serializer: KSerializer<T>,
    crossinline builder: suspend HttpResult<T>.(call: ApplicationCall) -> Unit
): Route = options(path) {
    respond(serializer) { builder(call) }
}