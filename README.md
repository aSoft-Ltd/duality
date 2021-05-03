# Duality

![badge][badge-maven] ![badge][badge-mpp] ![badge][badge-android] ![badge][badge-js] ![badge][badge-jvm]

A multiplatform Either Datatype

## Samples

```kotlin
val thing1: Either<Int, String> = Either.Left(1)
val thing2: Either<Int, String> = Either.Right("jaribio")
val thing3 = 3.asEither<Int, String>()

val res: Result<Int> = Success(4)
```

## Setup

```kotlin
dependencies {
    implementation("tz.co.asoft:either-core:0.0.40")
    // also
    implementation("tz.co.asoft:result-core:0.0.40")
}
```

[badge-maven]: https://img.shields.io/maven-central/v/tz.co.asoft/either-core/0.0.40?style=flat

[badge-mpp]: https://img.shields.io/badge/kotlin-multiplatform-blue?style=flat

[badge-android]: http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat

[badge-js]: http://img.shields.io/badge/platform-js-yellow.svg?style=flat

[badge-jvm]: http://img.shields.io/badge/platform-jvm-orange.svg?style=flat
