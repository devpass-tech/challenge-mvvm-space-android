import com.devpass.spaceapp.data.api.NextLaunchesModel
import com.devpass.spaceapp.data.api.OptionsRequest
import com.devpass.spaceapp.data.api.QueryRequestParams
import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.data.api.Results
import com.devpass.spaceapp.repository.FetchLaunchesRepository

private const val NUMBER_ROCKETS = 91

class FetchLaunchesRepositoryImpl(private val api: SpaceXAPIService) : FetchLaunchesRepository {
    override suspend fun fetchLaunches(): Results<NextLaunchesModel> {
        return try {
            Results.Success(api.fetchNextLaunches(getParams()))
        } catch (exception: Exception) {
            Results.Error(exception)
        }
    }

    private fun getParams() =
        QueryRequestParams(OptionsRequest(NUMBER_ROCKETS))
}