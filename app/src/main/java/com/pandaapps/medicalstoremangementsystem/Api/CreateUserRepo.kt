package com.pandaapps.medicalstoremangementsystem.Api

import kotlinx.coroutines.flow.Flow


interface CreateUserRepo {

    suspend fun createUser(): Flow<Result<UserCreateResponse>>

}
