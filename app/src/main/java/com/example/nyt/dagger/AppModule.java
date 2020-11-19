package com.example.nyt.dagger;

import android.content.Context;

import androidx.room.Room;

import com.example.nyt.data.AppDatabase;
import com.example.nyt.servicemanager.NetworkService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;
    private static final String APP_DATABASE_NAME = "app-database";

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    NetworkService provideZomatoService() {
        return new NetworkService();
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase() {
        return Room.databaseBuilder(context, AppDatabase.class, APP_DATABASE_NAME)
                .fallbackToDestructiveMigration().build();
    }
}