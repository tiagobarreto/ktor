package org.jetbrains.ktor.http

import java.time.*
import java.time.format.*
import java.time.temporal.*
import java.util.*

fun Long.toHttpDateString(): String = Instant.ofEpochMilli(this).toHttpDateString()
fun Temporal.toHttpDateString(): String = httpDateFormat.format(this)

fun String.fromHttpDateString(): ZonedDateTime = ZonedDateTime.parse(this, httpDateFormat)

val httpDateFormat =
        DateTimeFormatter
                .ofPattern("EEE, dd MMM yyyy HH:mm:ss z")
                .withLocale(Locale.US)
                .withZone(ZoneId.of("GMT"))!!
