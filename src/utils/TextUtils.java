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

    // Подсчёт строк
    public static int countLines(String text) {
        if (text == null || text.isEmpty()) return 0;

        // Делим по переносам строк
        String[] lines = text.split("\\R");
        return lines.length;
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

}
