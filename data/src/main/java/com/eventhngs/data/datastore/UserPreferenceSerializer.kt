package com.eventhngs.data.datastore

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.eventhngs.data.UserPreference
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

val Context.userPreferenceDataStore: DataStore<UserPreference> by dataStore(
    fileName = "settings.pb",
    serializer = UserPreferenceSerializer
)

object UserPreferenceSerializer : Serializer<UserPreference> {

    override val defaultValue: UserPreference
        get() = UserPreference.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserPreference {
        try {
            return UserPreference.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: UserPreference, output: OutputStream) = t.writeTo(output)

}
