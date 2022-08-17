package com.devpass.spaceapp.presentation.launchList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.devpass.spaceapp.data.api.*
import com.devpass.spaceapp.repository.FetchLaunchesRepository
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyOrder
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class LaunchListViewModelTest {

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @get:Rule
    val dispatcherRule = DispatcherRule()

    //simular o repository, não é o objeto real
    private val repository = mockk<FetchLaunchesRepository>()

    private val viewModel = LaunchListViewModel(repository)

    private val observer = mockk<Observer<StateViewData>>(relaxed = true)

    @Test
    fun `when fetch the rocket list should return success`() {
        //quando eu chamar o método fetchLaunches, devo retornar Results<NextLaunchesModel> mockado
        coEvery {
            repository.fetchLaunches()
        } coAnswers {
            mockResults()
        }
        viewModel.fetchNextLaunches()

        Assert.assertTrue(viewModel.nextLaunchesLiveData.value is StateView.Success)
    }

    @Test
    fun `when fetch the rocket list should return error`() {
        coEvery {
            repository.fetchLaunches()
        } coAnswers {
            Results.Error(Throwable())
        }
        viewModel.fetchNextLaunches()

        Assert.assertTrue(viewModel.nextLaunchesLiveData.value is StateView.Error)
    }

    @Test
    fun `when fetch the rocket list should return empty`(){
        coEvery {
            repository.fetchLaunches()
        } coAnswers {
            mockEmptyResults()
        }
        viewModel.fetchNextLaunches()

        Assert.assertTrue(viewModel.nextLaunchesLiveData.value is StateView.Empty)
    }

    @Test
    fun `when fetch the rocket list should verified state success`() {
        //quando eu chamar o método fetchLaunches, devo retornar Results<NextLaunchesModel> mockado

        val objectMock = mockSuccess()

        val stateLoading = StateViewData(
            loading = true,
            success = false,
            empty = false,
            error = false,
            nextLaunchesModel = null
        )

        val stateSuccess = stateLoading.copy(
            loading = false, success = true, nextLaunchesModel = objectMock
        )

        coEvery {
            repository.fetchLaunches()
        } coAnswers {
            Results.Success(objectMock)
        }
        viewModel.nextLaunchesDataLiveData.observeForever(observer)

        viewModel.fetchNextLaunchesData()

        viewModel.nextLaunchesDataLiveData.removeObserver(observer)

        verifyOrder {
            observer.onChanged(stateSuccess)
            observer.onChanged(stateLoading)
        }
    }

    private fun mockResults() =
        Results.Success(
            NextLaunchesModel(
                listOf(
                    NextLaunchModel(
                        date = "10/08/2022",
                        details = "Detalhe do foguete",
                        flightNumber = 10,
                        launchpad = "launchpad",
                        Links(patch = Patch(large = "url_large", small = "url_small"))
                    )
                )
            )
        )

    private fun mockEmptyResults() =
        Results.Success(
            NextLaunchesModel(
                listOf()
            )
        )

    private fun mockSuccess() =
        NextLaunchesModel(
            listOf(
                NextLaunchModel(
                    date = "10/08/2022",
                    details = "Detalhe do foguete",
                    flightNumber = 10,
                    launchpad = "launchpad",
                    Links(patch = Patch(large = "url_large", small = "url_small"))
                )
            )
        )
}