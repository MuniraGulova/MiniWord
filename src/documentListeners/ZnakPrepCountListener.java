package documentListeners;

import components.StatTextArea;
import utils.TextUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ZnakPrepCountListener implements DocumentListener {
    private final JTextArea sourceTxtArea;
    private final JTextArea outputTxtArea;
    public ZnakPrepCountListener(JTextArea sourceTxtArea, JTextArea outputTxtArea) {
        this.sourceTxtArea = sourceTxtArea;
        this.outputTxtArea = outputTxtArea;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {outputTxtArea.setText(ZnakCountasStr());}

    @Override
    public void removeUpdate(DocumentEvent e) {outputTxtArea.setText(ZnakCountasStr());}

    @Override
    public void changedUpdate(DocumentEvent e) {outputTxtArea.setText(ZnakCountasStr());}
    public String ZnakCountasStr(){
        return " " + TextUtils.ZnakPrepCount(sourceTxtArea.getText());
    }
}
