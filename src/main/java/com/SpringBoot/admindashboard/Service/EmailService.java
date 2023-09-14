package com.SpringBoot.admindashboard.Service;

import com.SpringBoot.admindashboard.Entities.ClientEntity;
import com.SpringBoot.admindashboard.Entities.ProductEntity;

public interface EmailService {
    void sendClientMail(String subject, String message, ClientEntity client);

    /**
     * send large NO. of mails by invoking sendClientMail on
     * each client from a client collection
     * @param subject
     * @param product_id
     * remove one param btn product_id and product
     */
    void sendBulkClientMail(String subject, Long product_id, ProductEntity product);

    //void sendStaffSetPasswordMail();
}
