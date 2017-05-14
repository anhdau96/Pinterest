/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pinterestauto;

import dbcontroller.AccountController;
import dbcontroller.PinLinkController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.LinkPin;

/**
 *
 * @author SaiBack
 */
public class PinMain {

    public static void main(String[] args) {
        while (true) {
            AccountController accountController = new AccountController();
            PinLinkController linkController = new PinLinkController();
            List<LinkPin> pinLinks = linkController.getLinkPin();
            PinPost pinPost = new PinPost();
            if (pinLinks != null) {
                for (LinkPin pinLink : pinLinks) {
                    List<Account> accounts = accountController.getAllAccount();
                    boolean check = true;
                    do {
                        for (Account account : accounts) {
                            if (Long.parseLong(account.getLastPin()) + Long.parseLong(account.getNextTime()) < System.currentTimeMillis()) {
                                pinPost.pin(pinLink.getLink(), pinLink.getImg(), account.getToken(), pinLink.getNote());
                                int nextTime = (int) (Math.random() * (60000 - 30000)) + 30000;
                                System.out.println(account.getId());
                                accountController.updateNextPin(account.getId(), String.valueOf(System.currentTimeMillis()), String.valueOf(nextTime));
                                //linkController.updateLinkPin(pinLink.getId(), account.getId());
                                System.out.println("Pin: " + pinLink.getLink());
                                check = false;
                                break;
                            }
                        }
                    } while (check);
                }
            } else {
                System.out.println("Link null");
            }
        }
    }
}
