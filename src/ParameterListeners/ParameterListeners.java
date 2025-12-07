package ParameterListeners;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParameterListeners implements ActionListener {
    private JTextPane textPane;

    public ParameterListeners(JTextPane textPane){
        this.textPane = textPane;
    }
    private void applyStyle(JTextPane textPane, AttributeSet attrs){
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        if(start != end){
            doc.setCharacterAttributes(start, end - start, attrs, false);
        }else{
            doc.setCharacterAttributes(0, doc.getLength(), attrs, false);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setBold(attrs, true);
        applyStyle(textPane, attrs);
    }
}
