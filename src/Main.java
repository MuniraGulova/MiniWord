import actionListeners.PrintToConsoleActionListener;
import actionListeners.PrintToTextAreaListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;


public class Main {
    void saveFile(JTextArea textArea, JFileChooser fileChooser, JFrame jForm) {
        int result = fileChooser.showSaveDialog(jForm);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.append(textArea.getText());
                bw.close();
                jForm.setTitle("Тествовый редактор - " + file.getName());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(jForm, "Ошибка при сохранении файла");
            }
        }
    }


    public static void main(String[] arga) {
        Main program = new Main();
        final JFrame jForm = new JFrame("Текстовый редактор");
        jForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit tlk = Toolkit.getDefaultToolkit(); //"мост" к OC
        Dimension dms = tlk.getScreenSize();
        int w = 1100, h = 800;
        jForm.setBounds(dms.width / 2 - w / 2, dms.height / 2 - h / 2, w, h);

        JFileChooser fileChooser = new JFileChooser();
        JTextArea textArea = new JTextArea();
        JTextArea countArea = new JTextArea();
        textArea.setBounds(dms.width / 2 - w / 2, dms.height / 2 - h / 2, w, h-20);
        countArea.setBounds(dms.width / 2 - w / 2 , dms.height - h , w, 20);
        countArea.setText("alisher top");
        textArea.setEnabled(false);//deactive textarea
        jForm.add(new JScrollPane(textArea));
        JMenuBar menuBar = new JMenuBar();//menu panel
        JMenu menuFile = new JMenu("Файл");//выпадающее меню
        JMenuItem openFile = new JMenuItem("Открыть");//пунты в меню
        JMenuItem newFile = new JMenuItem("Создать");
        JMenuItem saveFile = new JMenuItem("Сохранить");
        JMenuItem closeFile = new JMenuItem("Закрыть");
        /////
        JMenu menuRedactor = new JMenu("Панель инструментов");
        JMenu menuFront = new JMenu("Формат");
        JMenuItem Bold = new JMenuItem("Жирный");
        JMenuItem Italic = new JMenuItem("Курсивный");
        JMenuItem Strikethrough = new JMenuItem("Подчеркивание");
        JMenuItem Size = new JMenuItem("Размер");
        JMenuItem Front = new JMenuItem("Тип шрифта");

        menuFile.add(openFile);
        menuFile.add(newFile);
        menuFile.add(saveFile);
        menuFile.add(closeFile);
        menuBar.add(menuFile);
//        menuBar.add(openFile);
//        menuBar.add(saveFile);
//        menuBar.add(newFile);
//        menuBar.add(closeFile);
        menuFront.add(Bold);
        menuFront.add(Italic);
        menuFront.add(Strikethrough);
        menuRedactor.add(menuFront);
        menuRedactor.add(Size);
        menuRedactor.add(Front);

        menuBar.add(menuRedactor);
        jForm.setJMenuBar(menuBar);

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        jForm.add(toolBar, BorderLayout.NORTH);

        jForm.setVisible(true);
        newFile.addActionListener(e -> {
            textArea.setEnabled(true);
            textArea.setText(e.getActionCommand() + " test");
            jForm.setTitle("Текстовый редактор - Создание нового файла");
        });
        openFile.addActionListener(new PrintToTextAreaListener(textArea, "openFile pressed"));
        openFile.addActionListener(e -> {
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
        });
        saveFile.addActionListener(e -> program.saveFile(textArea, fileChooser, jForm));
        closeFile.addActionListener(e -> {
           if(!textArea.isEnabled()){
               JOptionPane.showMessageDialog(jForm, "Нечего закрывать");
               return;
           }
           if(textArea.getText().equals("")){
               textArea.setEnabled(false);
               return;
           }
           int res = JOptionPane.showConfirmDialog(jForm, "Сохранить ли перед закрытием изменения?");
           if(res == JOptionPane.YES_OPTION){
               program.saveFile(textArea, fileChooser, jForm);
           }
           textArea.setEnabled(false);
           textArea.setText("");
        });

    }
}