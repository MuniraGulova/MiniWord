package actionListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFileActionListener implements ActionListener {
    private final JFileChooser fileChooser;
    private final JFrame jForm;
    private final JTextArea textArea;

    public ReadFileActionListener(JFileChooser fileChooser, JFrame jForm, JTextArea textArea) {
        this.fileChooser = fileChooser;
        this.jForm = jForm;
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = fileChooser.showOpenDialog(jForm);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                textArea.setText("");
                String line;
                while ((line = br.readLine()) != null) {
                    textArea.append(line + '\n');
                }
                br.close();
                textArea.setEnabled(true);
                jForm.setTitle("Текстовый редактор - " + file.getName());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(jForm, "Ошибка при открытии файла");
            }
        }
    }
}
