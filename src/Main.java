import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Set;


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
        textArea.setEnabled(false);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(1, 3)); // например, 3 вертикально

        JTextArea r1 = new JTextArea("Right 1");
        JTextArea r2 = new JTextArea("Right 2");
        JTextArea r3 = new JTextArea("Right 3");
        Set<JTextArea> statAreaList = Set.of(r1, r2, r3);
        statAreaList.forEach(statArea -> {
            statArea.setText("none");
            statArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            rightPanel.add(statArea);
        });

        JSplitPane split = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(textArea),
                rightPanel
        );
        split.setResizeWeight(0.985);
        jForm.add(split);

/*        JTextArea textArea = new JTextArea();
        textArea.setBounds(dms.width / 2 - w / 2, dms.height / 2 - h / 2, w, h-20);
        textArea.setEnabled(false);
        jForm.add(new JScrollPane(textArea));

        JTextArea statArea = new JTextArea();
        statArea.setEnabled(true);
        statArea.setText("alisher top");
        statArea.setOpaque(true);
        statArea.setBackground(Color.YELLOW);
        jForm.add(statArea);*/


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
            jForm.setTitle("Текстовый редактор - Создание нового файла");
        });
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
            if (!textArea.isEnabled()) {
                JOptionPane.showMessageDialog(jForm, "Нечего закрывать");
                return;
            }
            if (textArea.getText().equals("")) {
                textArea.setEnabled(false);
                return;
            }
            int res = JOptionPane.showConfirmDialog(jForm, "Сохранить ли перед закрытием изменения?");
            if (res == JOptionPane.YES_OPTION) {
                program.saveFile(textArea, fileChooser, jForm);
            }
            textArea.setEnabled(false);
            textArea.setText("");
        });

    }
}