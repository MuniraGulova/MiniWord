package ParameterListeners;

import org.w3c.dom.Attr;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParameterListeners implements ActionListener {
    private final JTextPane textPane;
    private final String command;
    private final Object value;

    public ParameterListeners(JTextPane textPane, String command, Object value) {
        this.textPane = textPane;
        this.command = command;
        this.value = value;
    }

    private void applyStyle(AttributeSet attrs) {
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        if (start != end) {
            doc.setCharacterAttributes(start, end - start, attrs, false);
        } else {
//            doc.setCharacterAttributes(0, doc.getLength(), attrs, false);
            textPane.setCharacterAttributes(attrs, false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int pos = (start == textPane.getSelectionEnd()) ? textPane.getCaretPosition() : start;
        AttributeSet current = doc.getCharacterElement(pos).getAttributes();

        SimpleAttributeSet attrs = new SimpleAttributeSet();
        switch(command){
            case "Bold":
                toggleBold(attrs, current);
                break;
            case "Italic":
                toggleItalic(attrs, current);
                break;
            case "Underline":
                toggleUnderline(attrs, current);
                break;
            case "Size":
                String sizeStr = JOptionPane.showInputDialog(textPane,"Введите размер шрифта пожалуйста :) ", "Размер шрифта :0 ", JOptionPane.QUESTION_MESSAGE);
                if(sizeStr != null && !sizeStr.trim().isEmpty()){
                    int size = Integer.parseInt(sizeStr.trim());
                    StyleConstants.setFontSize(attrs, size);
                }
                break;
            case "Font":
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                String [] fonts = ge.getAvailableFontFamilyNames();
                String selectedFont = (String) JOptionPane.showInputDialog(textPane, "Выберите шрифт ^_^: ", "Тип шрифта", JOptionPane.QUESTION_MESSAGE, null, fonts, fonts[0]);
                StyleConstants.setFontFamily(attrs, selectedFont);
                break;
        }
        applyStyle(attrs);
    }

    private void toggleBold(SimpleAttributeSet attrs, AttributeSet current) {
        boolean isBold = StyleConstants.isBold(current);
        StyleConstants.setBold(attrs, !isBold);
    }

    private void toggleItalic(SimpleAttributeSet attrs, AttributeSet current) {
        boolean isItalic = StyleConstants.isItalic(current);
        StyleConstants.setItalic(attrs, !isItalic);
    }

    private void toggleUnderline(SimpleAttributeSet attrs, AttributeSet current) {
        boolean isUnderline = StyleConstants.isUnderline(current);
        StyleConstants.setUnderline(attrs, !isUnderline);
    }

}
