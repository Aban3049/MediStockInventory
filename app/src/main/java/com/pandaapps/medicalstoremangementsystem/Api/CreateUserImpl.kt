package com.pandaapps.medicalstoremangementsystem.Api

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//class CreateUserImpl(
//    private val api: Api_Builder
//) : CreateUserRepo {
//
//    override suspend fun createUser(): Flow<Result<UserCreateResponse>> {
//        return flow {
//
//            val userCreateResponse = try {
//                api.createUser(
//                    "Muhammad Aban APP",
//                    "appPassword",
//                    "app@gmail.com",
//                    "Rawalpindi",
//                    "03458824252",
//                    "+580"
//                )
//            } catch (e: Exception) {
//                emit(Result.Error(message = e.localizedMessage?.toString()))
//                return@flow
//            }
//
//            emit(Result.Success(userCreateResponse))
//
//
//        }
//    }
//
//
//}