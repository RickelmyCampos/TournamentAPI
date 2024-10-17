package com.gilberson.domain.repository

import com.gilberson.domain.model.ClashModel
import com.gilberson.domain.model.PlayerModel

interface ClashRepository {
    suspend fun saveClash(clash: ClashModel)
}