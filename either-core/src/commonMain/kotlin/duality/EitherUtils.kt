package duality

inline val <L, R> Either<L, R>.value
    get() = when (this) {
        is Either.Left -> value
        is Either.Right -> value
    }

fun <L> Either<L, *>.left(): L = when (this) {
    is Either.Left -> value
    is Either.Right -> throw Exception("Can't get left side of either coz it is right side")
}

fun <L> Either<L, *>.leftOrNull(): L? = try {
    left()
} catch (_: Throwable) {
    null
}

fun <R> Either<*, R>.right(): R = when (this) {
    is Either.Left -> throw Exception("Can't get right side of either coz it is left side")
    is Either.Right -> value
}

fun <R> Either<*, R>.rightOrNull(): R? = try {
    right()
} catch (_: Throwable) {
    null
}