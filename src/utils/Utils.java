/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.NumberFormat;
import java.util.Base64;
import java.util.Locale;

/**
 *
 * @author manik
 */
public class Utils {

    public static byte[] base64ToArrayByte(String base64) {
//        String base64Data = base64.split(",")[1];

        // Mendekode string Base64 menjadi array byte
        byte[] imageData = Base64.getDecoder().decode(base64);

        return imageData;
    }


    public static String integerToRupiah(int number) {
        Locale myIndonesianLocale = new Locale("in", "ID");
        NumberFormat formater = NumberFormat.getCurrencyInstance(myIndonesianLocale);
        return formater.format(number);
    }
}
