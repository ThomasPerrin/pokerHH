package com.example.thomasperrin.pokerhh.di

import androidx.room.Room
import android.content.Context
import com.example.thomasperrin.pokerhh.App
import com.example.thomasperrin.pokerhh.data.database.AppDatabase
import com.example.thomasperrin.pokerhh.data.database.HistoryDao
import com.example.thomasperrin.pokerhh.data.repository.HistoryRepositoryImpl
import com.example.thomasperrin.pokerhh.domain.history.usecase.AddHistoryUseCase
import com.example.thomasperrin.pokerhh.domain.history.usecase.GetAllHistoryUseCase
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: App): Context {
        return app.applicationContext
    }

    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "hh.db")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun providesFirebaseFirestore() = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun providesAddHistoryUseCase(historyRepositoryImpl: HistoryRepositoryImpl): AddHistoryUseCase{
        return AddHistoryUseCase(historyRepositoryImpl)
    }

    @Provides
    @Singleton
    fun providesGetAllHistoryUseCase(historyRepositoryImpl: HistoryRepositoryImpl): GetAllHistoryUseCase{
        return GetAllHistoryUseCase(historyRepositoryImpl)
    }

    @Singleton
    @Provides
    fun provideHistoryDAO(db: AppDatabase): HistoryDao {
        return db.historyDao()
    }

}