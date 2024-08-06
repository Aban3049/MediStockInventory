package com.pandaapps.medicalstoremangementsystem.DataStore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "user_preferences")

object UserPreferencesKeys {
    val USER_EMAIL = stringPreferencesKey("email")
    val USER_PASSWORD = stringPreferencesKey("password")
}

suspend fun Context.saveUserCredentials(userEmail: String, password: String) {
    dataStore.edit { preferences ->
        preferences[UserPreferencesKeys.USER_EMAIL] = userEmail
        preferences[UserPreferencesKeys.USER_PASSWORD] = password
    }
}

fun Context.getUserCredentials(): Flow<Pair<String?, String?>> {
    return dataStore.data.map { preferences ->
        val email = preferences[UserPreferencesKeys.USER_EMAIL]
        val password = preferences[UserPreferencesKeys.USER_PASSWORD]
        Pair(email, password)
    }
}