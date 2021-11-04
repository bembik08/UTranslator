package com.professional.models

import com.professional.models.data.TranslationDataItem

sealed class AppState {
    data class Success(val data: List<TranslationDataItem>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
