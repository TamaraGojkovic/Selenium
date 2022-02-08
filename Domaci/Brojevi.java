package Domaci;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
Napisati program koji racuna sumu brojeva koji se nalaze prvom sheet-u excel tabele koji se zove Brojevi
(sami izaberite neke random brojeve). U tabeli svi brojevi se nalaze u prvoj koloni. Program treba da cita red po red
iz tabele i upisane brojeve dodaje na sumu. Ukupnu sumu na kraju treba ispisati na standardnom izlazu. Potrebno je
omoguciti da program radi i ukoliko se u datu tabelu doda jos brojeva.
 */

public class Brojevi {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Tamara\\Downloads\\Brojevi.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Brojevi");
        XSSFRow row = sheet.getRow(1);
        XSSFCell cell = row.getCell(0);

        double suma = 0;

        System.out.println("\nSvi brojevi iz kolone su: ");

        for (int i = 1; i <= wb.getSheet("Brojevi").getLastRowNum(); i++) {
            double vrednostBroja = sheet.getRow(i).getCell(0).getNumericCellValue();
            System.out.println(vrednostBroja);
            suma += vrednostBroja;
        }

        System.out.println("\nSuma svih brojeva iz kolone je = " + suma);
        System.out.println("\n*** Kraj programa ***");
    }
}


