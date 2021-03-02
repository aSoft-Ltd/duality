package duality

fun <T> Failure.toResult(): Result<T> = Either.Right(this)