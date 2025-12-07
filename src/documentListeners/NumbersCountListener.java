package documentListeners;

import components.StatTextArea;
import utils.TextUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class NumbersCountListener implements DocumentListener {
    private final JTextArea sourceTxtArea;
    private final JTextArea outputTxtArea ;
    public NumbersCountListener(JTextArea textArea, StatTextArea numberCount) {
        this.sourceTxtArea = textArea;
        this.outputTxtArea = numberCount;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {outputTxtArea.setText(countNumberasStr());}

    @Override
    public void removeUpdate(DocumentEvent e) {outputTxtArea.setText(countNumberasStr());}

    @Override
    public void changedUpdate(DocumentEvent e) {outputTxtArea.setText(countNumberasStr());}

    public String countNumberasStr(){
        return " " + TextUtils.NumberCount(sourceTxtArea.getText());
    }

}
