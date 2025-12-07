package utils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextUtils {

    // Подсчёт символов
    public static int countChars(String text) {
        if (text == null) return 0;
        return text.length();
    }

    // Подсчёт слов
    public static int countWords(String text) {
        if (text == null || text.isBlank()) return 0;

        // Разбиваем по любым пробельным символам
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static int countSentences(String text) {
        if (text == null || text.isBlank()) return 0;

        // Разбиваем по . ! ? включая варианты с несколькими пробелами
        String[] sentences = text.trim().split("[.!?]+\\s*");

        // Фильтруем пустые элементы (на случай лишних знаков)
        int count = 0;
        for (String s : sentences) {
            if (!s.isBlank()) count++;
        }
        return count;
    }

    public static int countCharsWithoutSpace(String text) {
        if (text == null) return 0;
        return text.replaceAll("\\s+", "").length();
    }

    public static int NumberCount(String text) {
        int count = 0;
        for (int i : text.toCharArray()) {
            if (Character.isDigit(i)) {
                count++;
            }
        }
        return count;
    }

    public static int ZnakPrepCount(String text) {
        if (text == null) return 0;
        int count = 0;
        String punc = ".,!?:;—()-\"«»";

        for (char c : text.toCharArray()) {
            if (punc.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static int ZnakCount(String text) {
        if (text == null) return 0;
        int count = 0;
        String special = "@#$%^~+=*<>";
        for (char c : text.toCharArray()) {
            if (special.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static int LatinCount(String text){
        if(text==null) return 0;
        int count = 0;
        for(char c : text.toCharArray()){
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
                count++;
            }
        }
        return count;
    }

    public static int RuCount(String text) {
        if (text == null) return 0;
        int count = 0;
        for (char c : text.toCharArray()) {
            if ((c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я') || c == 'Ё' || c == 'ё') {
                count++;
            }
        }
        return count;
    }

}
