package com.rjasso.smsdashboard.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.rjasso.smsdashboard.model.SMSMessage;

@Entity(tableName = "Spam")
public class Spam {
    @NonNull
    @PrimaryKey private String id;
    private String thread_id;
    private String address;
    private String person;
    private String date;
    private String date_sent;
    private String protocol;
    private String read;
    private String status;
    private String type;
    private String reply_path_present;
    private String subject;
    private String body;
    private String service_center;
    private String locked;
    private String sub_id;
    private String error_code;
    private String creator;
    private String seen;

    public Spam(){}
    public Spam(SMSMessage message) {
        id = message.getId();
        thread_id = message.getThread_id();
        address = message.getAddress();
        person = message.getPerson();
        date = message.getDate();
        date_sent = message.getDate_sent();
        protocol = message.getProtocol();
        read = message.getRead();
        status = message.getStatus();
        type = message.getType();
        reply_path_present = message.getReply_path_present();
        subject = message.getSubject();
        body = message.getBody();
        service_center = message.getService_center();
        locked = message.getLocked();
        sub_id = message.getSub_id();
        error_code = message.getError_code();
        creator = message.getCreator();
        seen = message.getSeen();
    }


    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThread_id() {
        return thread_id;
    }

    public void setThread_id(String thread_id) {
        this.thread_id = thread_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_sent() {
        return date_sent;
    }

    public void setDate_sent(String date_sent) {
        this.date_sent = date_sent;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReply_path_present() {
        return reply_path_present;
    }

    public void setReply_path_present(String reply_path_present) {
        this.reply_path_present = reply_path_present;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getService_center() {
        return service_center;
    }

    public void setService_center(String service_center) {
        this.service_center = service_center;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSeen() {
        return seen;
    }

    public void setSeen(String seen) {
        this.seen = seen;
    }

}
