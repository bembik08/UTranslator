package com.professional.viewmodels.interactions

import com.professional.models.AppState
import com.professional.models.data.TranslationDataItem
import com.professional.models.repository.Repository
import com.professional.utils.NetworkStatus

class MainInteraction(
    private val repo: Repository,
    private val networkStatus: NetworkStatus
) : Interaction {
    override suspend fun getData(word: String): AppState {
        return if (networkStatus.isOnline()) {
            val data = repo.getFromCloudData(word)
            repo.saveToDatabase(data)
            AppState.Success(data)
        } else {
            AppState.Error(Throwable(ERROR_MSG))
        }
    }

    override suspend fun getHistoryData(): AppState =
        AppState.Success(repo.getHistoryData())

    override suspend fun saveToFavorite(item: TranslationDataItem) =
        repo.insertFavorite(item)


    companion object {
        private const val ERROR_MSG = "Error Internet connection"
    }
}