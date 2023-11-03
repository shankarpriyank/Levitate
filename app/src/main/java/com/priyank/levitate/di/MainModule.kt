package com.priyank.levitate.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.priyank.levitate.dating.data.MatchDao
import com.priyank.levitate.onboarding.data.UserDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Singleton
    @Provides
    fun provideUserDetails(@ApplicationContext context: Context): UserDetails {
        val sharedPreferences = context.getSharedPreferences("accountDetails", MODE_PRIVATE)
        return UserDetails(sharedPreferences)
    }

    @Singleton
    @Provides
    fun provideMatchDao(): MatchDao {
        return MatchDao()
    }
}
