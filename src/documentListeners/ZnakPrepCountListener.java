package documentListeners;

import components.StatTextArea;
import utils.TextUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ZnakPrepCountListener implements DocumentListener {
    private final JTextPane sourceTxtArea;
    private final JTextPane outputTxtArea;
    public ZnakPrepCountListener(JTextPane sourceTxtArea, StatTextArea outputTxtArea) {
        this.sourceTxtArea = sourceTxtArea;
        this.outputTxtArea = outputTxtArea;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {outputTxtArea.setText(JTextPane());}

    @Override
    public void removeUpdate(DocumentEvent e) {outputTxtArea.setText(JTextPane());}

    @Override
    public void changedUpdate(DocumentEvent e) {outputTxtArea.setText(JTextPane());}
    public String JTextPane(){
        return " " + TextUtils.ZnakPrepCount(sourceTxtArea.getText());
    }
}
