/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.torang_core.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.torang_core.data.dao.*
import com.example.torang_core.data.dao.RestaurantDao
import com.example.torang_core.data.dao.SearchDao
import com.example.torang_core.data.model.*
import com.example.torang_core.utilities.DATABASE_NAME


/**
 * The Room database for this app
 */
@Database(
    entities = [
        UserData::class, FeedData::class, ReviewImage::class, Like::class,
        RestaurantData::class, ReviewData::class, Menu::class, AlarmData::class,
        LoggedInUserData::class, Search::class, Favorite::class, CommentData::class
    ], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun restaurantDao(): RestaurantDao
    abstract fun reviewDao(): ReviewDao
    abstract fun menuDao(): MenuDao
    abstract fun alarmDao(): AlarmDao
    abstract fun myReviewDao(): MyReviewDao
    abstract fun LoggedInUserDao(): LoggedInUserDao
    abstract fun searchDao(): SearchDao
    abstract fun pictureDao(): PictureDao
    abstract fun feedDao(): FeedDao
    abstract fun commentDao(): CommentDao

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context, AppDatabase::class.java,
                DATABASE_NAME
            )
                .addCallback(
                    object : RoomDatabase.Callback() {
                    }
                )
                .addMigrations(MIGRATION_1_2)
                .build()
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "ALERT TABLE `feed` " +
                            "ADD COLUMN user_id VARCHAR(30)"
                )
            }
        }
    }
}
