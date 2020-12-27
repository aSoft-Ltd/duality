package tz.co.asoft

import kotlinx.serialization.json.Json

val EJson by lazy {
    Json {
        ignoreUnknownKeys = true
        prettyPrint = true
    }
}