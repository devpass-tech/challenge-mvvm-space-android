import com.devpass.spaceapp.data.api.*
import com.devpass.spaceapp.repository.FetchLaunchesRepository

private const val NUMBER_ROCKETS = 20

class FetchLaunchesRepositoryImpl(private val api: SpaceXAPIService) : FetchLaunchesRepository {
    override suspend fun fetchLaunches(): Results<NextLaunchesModel> {
        return try {
            val requestParams = QueryRequestParams(OptionsRequest(NUMBER_ROCKETS))
            val resultResponse = api.fetchNextLaunches(requestParams)
            Results.Success(resultResponse)
        } catch (exception: Exception) {
            Results.Error(exception)
        }
    }

    private fun getParams() =
        QueryRequestParams(OptionsRequest(NUMBER_ROCKETS))
}