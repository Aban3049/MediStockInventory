package com.pandaapps.medicalstoremangementsystem.DataStore

import android.content.Context
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "user_preferences")

object UserPreferencesKeys {
    val USER_EMAIL = stringPreferencesKey("email")
    val USER_PASSWORD = stringPreferencesKey("password")
    val Id = intPreferencesKey("id")
}

suspend fun Context.saveId(value: Int) {
    dataStore.edit { preferences ->
        preferences[UserPreferencesKeys.Id] = value
    }
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

fun Context.getId(): Flow<Int?> {
    return dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[UserPreferencesKeys.Id]
        }
}
