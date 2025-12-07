package documentListeners;

import components.StatTextArea;
import utils.TextUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LatinCountListener implements DocumentListener {
    private final JTextArea sourceTxtArea;
    private final JTextArea outputTxtArea;

    public LatinCountListener(JTextArea sourceTxtArea, StatTextArea outputTxtArea) {
        this.sourceTxtArea = sourceTxtArea;
        this.outputTxtArea = outputTxtArea;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {outputTxtArea.setText(LatinCountasStr());}

    @Override
    public void removeUpdate(DocumentEvent e) {outputTxtArea.setText(LatinCountasStr());}

    @Override
    public void changedUpdate(DocumentEvent e) {outputTxtArea.setText(LatinCountasStr());}
    public String LatinCountasStr(){
        return " " + TextUtils.LatinCount(sourceTxtArea.getText());
    }
}
