import actionListeners.ReadFileActionListener;
import components.StatTextArea;
import documentListeners.LetterCountListener;
import documentListeners.SentencesCountListener;
import documentListeners.SymbolsCountListener;
import mouseListeners.MouseTipTextListener;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;


public class Main {
    public static void saveFile(JTextArea textArea, JFileChooser fileChooser, JFrame jForm) {
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
        final JFrame jForm = new JFrame("Текстовый редактор");
        jForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit tlk = Toolkit.getDefaultToolkit(); //"мост" к OC
        Dimension dms = tlk.getScreenSize();
        int w = 1100, h = 800;
        jForm.setBounds(dms.width / 2 - w / 2, dms.height / 2 - h / 2, w, h);

        JFileChooser fileChooser = new JFileChooser();

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(1, 3));

        JTextArea textArea = new JTextArea("введите текст");
        textArea.setEnabled(false);

        StatTextArea symbolsCount = new StatTextArea("0", "кол-во символов");
        StatTextArea wordsCount = new StatTextArea("0", "кол-во слов");
        StatTextArea sentencesCount = new StatTextArea("0", "кол-во предложений");
        StatTextArea r4 = new StatTextArea("r4", "что-то ещё");
        List<StatTextArea> statAreaList = List.of(symbolsCount, wordsCount, sentencesCount, r4);

        for (StatTextArea statArea : statAreaList) {
            statArea.setEditable(false);
            statArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            statArea.setBackground(Color.LIGHT_GRAY);
            statArea.addMouseListener(new MouseTipTextListener(statArea));
            rightPanel.add(statArea);
        }
        textArea.getDocument().addDocumentListener(new SymbolsCountListener(textArea, symbolsCount));
        textArea.getDocument().addDocumentListener(new LetterCountListener(textArea, wordsCount));
        textArea.getDocument().addDocumentListener(new SentencesCountListener(textArea, sentencesCount));
        //todo
        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(textArea), rightPanel);
        split.setResizeWeight(0.985);
        jForm.add(split);

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
        openFile.addActionListener(new ReadFileActionListener(fileChooser, jForm, textArea));
        saveFile.addActionListener(e -> saveFile(textArea, fileChooser, jForm));
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
                saveFile(textArea, fileChooser, jForm);
            }
            textArea.setEnabled(false);
            textArea.setText("");
        });

    }
}