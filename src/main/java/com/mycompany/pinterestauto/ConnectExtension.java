/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pinterestauto;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SaiBack
 */
public class ConnectExtension {

    private static Robot robot = null;

    public static void clickConnect() {
        try {
            robot = new Robot();
            robot.mouseMove(1000, 80);
            robot.mousePress(MouseEvent.BUTTON1_MASK);
            robot.mouseRelease(MouseEvent.BUTTON1_MASK);
            robot.mouseMove(900, 350);
            robot.delay(1000);
            robot.mousePress(MouseEvent.BUTTON1_MASK);
            robot.mouseRelease(MouseEvent.BUTTON1_MASK);
            robot.mouseMove(1000, 80);
            robot.delay(4000);
            robot.mousePress(MouseEvent.BUTTON1_MASK);
            robot.mouseRelease(MouseEvent.BUTTON1_MASK);
        } catch (AWTException ex) {
            Logger.getLogger(ConnectExtension.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        clickConnect();
    }
}
