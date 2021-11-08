package com.professional.models.cloud

import com.professional.models.data.TranslationDataItem

interface CloudSource {
    suspend fun getData(word : String) : List<TranslationDataItem>
}