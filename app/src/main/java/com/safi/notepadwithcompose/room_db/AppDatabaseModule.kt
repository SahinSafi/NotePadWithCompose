package com.safi.notepadwithcompose.room_db

import android.app.Application
import androidx.room.Room
import com.safi.notepadwithcompose.room_db.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "jatri_user.db")
            .fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideNotificationDao(appDatabase: AppDatabase): NoteDao =
        appDatabase.noteDao()

}
