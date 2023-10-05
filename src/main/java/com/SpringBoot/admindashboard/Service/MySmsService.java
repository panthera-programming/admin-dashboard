package com.SpringBoot.admindashboard.Service;

public interface MySmsService {
    String sendSms(String message, String[] contacts) throws Exception;
}
