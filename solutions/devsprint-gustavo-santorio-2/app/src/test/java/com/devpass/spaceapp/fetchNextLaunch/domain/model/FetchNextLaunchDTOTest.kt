package com.devpass.spaceapp.fetchNextLaunch.domain.model

import org.junit.Assert.assertEquals
import org.junit.Test

class FetchNextLaunchDTOKtTest {
    @Test
    fun `should return the formatted date when the formatDate method is called`(){
        val nextLaunchDTO = FetchNextLaunchDTOMocks.getFetchNextLaunchDTO()
        val formattedDate = nextLaunchDTO.formatDate()

        val expected = "July 03,2020"
        assertEquals(expected, formattedDate)
    }

    @Test
    fun `should return formatted status when formatStatus method is called`(){
        val nextLaunchDTO = FetchNextLaunchDTOMocks.getFetchNextLaunchDTO()
        val formattedStatus = nextLaunchDTO.formatStatus()

        val expected = "Success"
        assertEquals(expected, formattedStatus)
    }
}
