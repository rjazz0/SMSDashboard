package com.rjasso.smsdashboard.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import kotlin.jvm.Synchronized;

@Database(entities = {Spam.class, Inbox.class}, version = 1, exportSchema = false)
public abstract class SMSMessagesDataBase extends RoomDatabase {
        public static final String DATABASE_NAME = "SMSMessagesDataBase";
        private static SMSMessagesDataBase database = null;

        @Synchronized
        static public SMSMessagesDataBase getInstance(Context context) {
                if (database == null) {
                    database = Room.databaseBuilder(context, SMSMessagesDataBase.class, DATABASE_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
                }
            return database;
        }

        public abstract InboxDAO inboxDAO();
        public abstract SpamDAO spamDAO();

}
