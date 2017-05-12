/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iofile;

import model.Account;
import model.LinkPin;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author SaiBack
 */
public class FileController {

    public void writeAccountToFile(String account, String pass, String token) {
        try {
            File file = new File("account.xls");
            WritableWorkbook accountFile = null;
            if (file.exists() && !file.isDirectory()) {
                try {
                    Workbook workbook = Workbook.getWorkbook(file);
                    accountFile = Workbook.createWorkbook(file, workbook);
                } catch (IOException | BiffException ex) {
                    Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    accountFile = Workbook.createWorkbook(file);
                    accountFile.createSheet("account", 0);
                } catch (IOException ex) {
                    Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            WritableSheet sheet = accountFile.getSheet(0);
            int rows = sheet.getRows();
            Label labelAcc = new Label(0, rows, account);
            sheet.addCell(labelAcc);
            Label labelPass = new Label(1, rows, pass);
            sheet.addCell(labelPass);
            Label labelToken = new Label(2, rows, token);
            sheet.addCell(labelToken);
            sheet.addCell(new Label(3, rows, "0"));
            sheet.addCell(new Label(4, rows, "0"));
            accountFile.write();
            accountFile.close();
        } catch (WriteException | IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<LinkPin> readLinkToPin() {
        Workbook workbook = null;
        try {
            List<LinkPin> lstLink = new ArrayList<>();
            workbook = Workbook.getWorkbook(new File("link.xls"));
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            for (int i = 0; i < rows; i++) {
                lstLink.add(new LinkPin(sheet.getCell(0, i).getContents(), sheet.getCell(1, i).getContents()));
            }
            return lstLink;
        } catch (IOException | BiffException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }
        return null;
    }

    public List<Account> getAllAccount() {
        Workbook workbook = null;
        try {
            List<Account> lstAcc = new ArrayList<>();
            workbook = Workbook.getWorkbook(new File("account.xls"));
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            for (int i = 0; i < rows; i++) {
                lstAcc.add(new Account(i, sheet.getCell(0, i).getContents(), sheet.getCell(1, i).getContents(), sheet.getCell(2, i).getContents(), sheet.getCell(3, i).getContents(), sheet.getCell(4, i).getContents()));
            }
            return lstAcc;
        } catch (IOException | BiffException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }
        return null;
    }

    public void updateNextPin(int index, String lastPin, String nextPin) {
        try {
            File file = new File("account.xls");
            Workbook workbook = Workbook.getWorkbook(file);
            WritableWorkbook accountFile = Workbook.createWorkbook(file, workbook);
            WritableSheet sheet = accountFile.getSheet(0);
            sheet.addCell(new Label(3, index, lastPin));
            sheet.addCell(new Label(4, index, nextPin));
            accountFile.write();
            accountFile.close();
        } catch (IOException | BiffException | WriteException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
