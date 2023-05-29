package com.safi.notepadwithcompose.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindNoteRepository(roomRepoImpl: RoomRepoImpl): RoomRepository

}