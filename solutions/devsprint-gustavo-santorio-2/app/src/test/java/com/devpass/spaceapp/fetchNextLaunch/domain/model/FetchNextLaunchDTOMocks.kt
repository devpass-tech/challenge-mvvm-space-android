package com.devpass.spaceapp.fetchNextLaunch.domain.model

object FetchNextLaunchDTOMocks {

    fun getFetchNextLaunchDTO() =
        FetchNextLaunchDTO(
            autoUpdate = true,
            capsules = listOf(),
            cores = listOf(
                Core(
                    core = "",
                    flight = 2,
                    gridfins = true,
                    landingAttempt = true,
                    landingSuccess = true,
                    landingType = "",
                    landpad = "",
                    legs = true,
                    reused = true
                )
            ),
            crew = listOf(),
            dateLocal = "",
            datePrecision = "",
            dateUnix = 0,
            dateUtc = "2020-03-07T04:50:31.000Z",
            details = "",
            failures = listOf(),
            fairings = Any(),
            flightNumber = 0,
            id = "",
            launchpad = "",
            links = Links(
                article = null,
                flickr = null,
                presskit = null,
                patch = null,
                reddit = null,
                webcast = null,
                wikipedia = null,
                youtubeId = null
            ),
            name = "",
            net = true,
            payloads = listOf(),
            rocket = null,
            ships = listOf(),
            staticFireDateUnix = 0,
            staticFireDateUtc = null,
            success = true,
            tdb = false,
            upcoming = false,
            window = 1
        )
}