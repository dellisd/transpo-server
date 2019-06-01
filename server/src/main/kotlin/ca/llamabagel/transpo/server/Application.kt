/*
 * Copyright (c) 2019 Derek Ellis. Subject to the MIT license.
 */

package ca.llamabagel.transpo.server

import ca.llamabagel.transpo.Configuration
import ca.llamabagel.transpo.server.data.data
import ca.llamabagel.transpo.server.plans.plans
import ca.llamabagel.transpo.server.trips.trips
import com.google.gson.FieldNamingPolicy
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.routing.Routing

val Config = Configuration("config")

fun Application.main() {
    install(DefaultHeaders)
    install(ContentNegotiation) {
        //register(ContentType.Any, JsonSerializableConverter())
        gson {
            setFieldNamingStrategy(FieldNamingPolicy.IDENTITY)
        }
    }

    install(Routing) {
        index()
        trips()
        plans()
        data()
    }
}