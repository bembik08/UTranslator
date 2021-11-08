package com.professional.viewmodels.interactions

import com.professional.models.AppState
import com.professional.models.repository.Repository
import com.professional.utils.NetworkStatus

class MainInteraction(
    private val repo: Repository,
    private val networkStatus: NetworkStatus
) : Interaction {
    override suspend fun getData(word: String): AppState {
        return if (networkStatus.isOnline()) {
            AppState.Success(repo.getData(word))
        } else {
            AppState.Error(Throwable(ERROR_MSG))
        }
    }

    companion object {
        private const val ERROR_MSG = "Error Internet connection"
    }
}