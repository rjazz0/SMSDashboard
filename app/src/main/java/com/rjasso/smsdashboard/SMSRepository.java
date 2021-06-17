package com.rjasso.smsdashboard;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.rjasso.smsdashboard.database.Inbox;
import com.rjasso.smsdashboard.database.SMSMessagesDataBase;
import com.rjasso.smsdashboard.database.Spam;
import com.rjasso.smsdashboard.model.SMSMessage;

import java.util.ArrayList;
import java.util.List;

public class SMSRepository {

    private static final String TAG = SMSRepository.class.getSimpleName();
    private static final String SPAM = "spam";
    private MutableLiveData<List<Inbox>> mInboxMessages = new MutableLiveData<>();
    private MutableLiveData<List<Spam>> mSpamMessages = new MutableLiveData<>();
    private SMSMessagesDataBase mDataBase;

    public SMSRepository(SMSMessagesDataBase db) {
        mDataBase = db;
    }

    public void getData(ContentResolver contentResolver) {
        getInboxSMSFromDB();
        getSpamSMSFromDB();
        getSMSFromContentResolver(contentResolver);
    }

    private void getInboxSMSFromDB(){
        List<Inbox> inboxList = mDataBase.inboxDAO().getAll();
        mInboxMessages.postValue(inboxList);
    }

    private void getSpamSMSFromDB(){
        List<Spam> spamList = mDataBase.spamDAO().getAll();
        mSpamMessages.postValue(spamList);
    }

    private void getSMSFromContentResolver(ContentResolver contentResolver) {
        List<SMSMessage> messages = new ArrayList<>();
        Cursor cursor = contentResolver.query(Uri.parse("content://sms/inbox"), null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                SMSMessage message = new SMSMessage();
                message.setId(cursor.getString(SMSMessage.ID));
                message.setThread_id(cursor.getString(SMSMessage.THREAD_ID));
                message.setAddress(cursor.getString(SMSMessage.ADDRESS));
                message.setPerson(cursor.getString(SMSMessage.PERSON));
                message.setDate(cursor.getString(SMSMessage.DATE));
                message.setDate_sent(cursor.getString(SMSMessage.DATE_SENT));
                message.setProtocol(cursor.getString(SMSMessage.PROTOCOL));
                message.setRead(cursor.getString(SMSMessage.READ));
                message.setStatus(cursor.getString(SMSMessage.STATUS));
                message.setType(cursor.getString(SMSMessage.TYPE));
                message.setReply_path_present(cursor.getString(SMSMessage.REPLY_PATH_PRESENT));
                message.setSubject(cursor.getString(SMSMessage.SUBJECT));
                message.setBody(cursor.getString(SMSMessage.BODY));
                message.setService_center(cursor.getString(SMSMessage.SERVICE_CENTER));
                message.setLocked(cursor.getString(SMSMessage.SERVICE_CENTER));
                message.setSub_id(cursor.getString(SMSMessage.SUB_ID));
                message.setError_code(cursor.getString(SMSMessage.ERROR_CODE));
                message.setCreator(cursor.getString(SMSMessage.CREATOR));
                messages.add(message);
            } while (cursor.moveToNext());
        } else {
            Log.d(TAG,"No messages were found!");
        }
        filterSPAM(messages);
    }

    private void filterSPAM(List<SMSMessage> messages) {
        List<Inbox> inbox = new ArrayList<>();
        List<Spam> spam = new ArrayList<>();
        for (SMSMessage message: messages) {
            if (message.getBody().contains(SPAM)) {
                spam.add(new Spam(message));
            } else {
                inbox.add(new Inbox(message));
            }
        }
        insertInboxSMSIntoDB(inbox);
        insertSpamSMSIntoDB(spam);
    }

    public LiveData<List<Inbox>> getInboxMessagesLiveData() {
        return mInboxMessages;
    }

    public LiveData<List<Spam>> getSpamMessagesLiveData() {
        return mSpamMessages;
    }

    private void insertInboxSMSIntoDB(List<Inbox> messages) {
        mDataBase.inboxDAO().deleteAll();
        List<Long> inserted = mDataBase.inboxDAO().insertAll(messages);
        mInboxMessages.postValue(messages);
    }

    private void insertSpamSMSIntoDB(List<Spam> messages) {
        mDataBase.spamDAO().deleteAll();
        mDataBase.spamDAO().insertAll(messages);
        mSpamMessages.postValue(messages);
    }

}
