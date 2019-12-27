package bsu.rfe.java.group9.lab2.Gomerov.varC5;// Импортируются классы, используемые в приложении

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit; //для взаимодействия с ОС (getimage and getsize)
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;//выключение включенной кнопки при активации новой.
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

// Главный класс приложения, он же класс фрейма
public class MainFrame extends JFrame {
    // Размеры окна приложения в виде констант
    private static final int WIDTH = 700;
    private static final int HEIGHT = 320;
    // Текстовые поля для считывания значений переменных,
// как компоненты, совместно используемые в различных методах
    private JTextField textFieldX; //текстовое поле
    private JTextField textFieldY; //текстовое поле
    private JTextField textFieldZ; //текстовое поле
    // Текстовое поле для отображения результата,
// как компонент, совместно используемый в различных методах
    private JTextField textFieldResult; //текстовое поле
    private JTextField textFieldM[] = new JTextField[3]; //текстовое поле
    private JLabel labelImage;
    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtonsF = new ButtonGroup();
    private ButtonGroup radioButtonsM = new ButtonGroup();
    // Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();//размещение элементов Ф в строку
    private Box hboxMemRB = Box.createHorizontalBox();//размещение элементов М в строку
    private int formulaId = 1;
    private int memid;
    private Double mem[]=new Double[3];
    private Toolkit kit;

    public Double calculate1(Double x, Double y, Double z) {
        return Math.pow(Math.log(Math.pow(1+x,2))+Math.cos(Math.PI*z*z*z),Math.sin(y))+
                Math.pow(Math.pow(Math.E,x*x)+Math.cos(Math.pow(Math.E,z))+Math.sqrt(1/y),(1/x));
    }

    public Double calculate2(Double x, Double y, Double z) {
        return Math.pow(Math.cos(Math.PI*Math.pow(x,3))+Math.log(Math.pow(1+y,2)),1/4)*
                (Math.pow(Math.E, z*z)+Math.sqrt(1/x)+Math.cos(Math.pow(Math.E, y)));
    }
// Вспомогательный метод для добавления кнопок на панель
    private void addRadioButtonF(String buttonName, final int formulaId) //поля для формула 1 и формула 2
    {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.formulaId = formulaId;
            }
        });
        radioButtonsF.add(button);
        hboxFormulaType.add(button);
    }

    private void addRadioButtonM(String buttonName, final int mid) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.memid = mid-1;
            }
        });
        radioButtonsM.add(button);
        hboxMemRB.add(button);
    }
    // Конструктор класса
    public MainFrame() {

        super("Вычисление формулы");
        mem[0]=0.;
        mem[1]=0.;
        mem[2]=0.;
        setSize(WIDTH, HEIGHT);
        kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH)/2,(kit.getScreenSize().height - HEIGHT)/2);// Отцентрировать окно приложения на экране
        hboxFormulaType.add(Box.createHorizontalGlue());//отдалить компоненты друг от друга на макс. расстояние
        addRadioButtonF("Формула 1", 1);// Создать радио-кнопку для формулы 1
        addRadioButtonF("Формула 2", 2);// Создать радио-кнопку для формулы 2
        radioButtonsF.setSelected(radioButtonsF.getElements().nextElement().getModel(), true);// Установить выделенной 1-ую кнопку из группы
        hboxFormulaType.add(Box.createHorizontalGlue());//отдалить компоненты друг от друга на макс. расстояние
        hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));//рамка для бокса

        hboxMemRB.add(Box.createHorizontalGlue());
        addRadioButtonM("M1", 1);
        addRadioButtonM("M2", 2);
        addRadioButtonM("M3", 3);
        radioButtonsM.setSelected(radioButtonsM.getElements().nextElement().getModel(), true);// Установить выделенной 1-ую кнопку из группы
        hboxMemRB.add(Box.createHorizontalGlue());
        hboxMemRB.setBorder(BorderFactory.createLineBorder(Color.ORANGE));

        JLabel labelForX = new JLabel("X:");//надпись
        textFieldX = new JTextField("0.0", 14);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0.0", 14);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0.0", 14);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());

        JLabel labelForM1 = new JLabel("M1:");
        textFieldM[0] = new JTextField("0.0", 14);
        textFieldM[0].setMaximumSize(textFieldM[0].getPreferredSize());
        JLabel labelForM2 = new JLabel("M2:");
        textFieldM[1] = new JTextField("0.0", 14);
        textFieldM[1].setMaximumSize(textFieldM[1].getPreferredSize());
        JLabel labelForM3 = new JLabel("M3:");
        textFieldM[2] = new JTextField("0.0", 14);
        textFieldM[2].setMaximumSize(textFieldM[2].getPreferredSize());

        Box hboxMem = Box.createHorizontalBox();
        hboxMem.setBorder(BorderFactory.createLineBorder(Color.RED));
        hboxMem.add(Box.createHorizontalGlue());
        hboxMem.add(labelForM1);
        hboxMem.add(Box.createHorizontalStrut(10));
        hboxMem.add(textFieldM[0]);
        hboxMem.add(Box.createHorizontalStrut(70));
        hboxMem.add(labelForM2);
        hboxMem.add(Box.createHorizontalStrut(10));
        hboxMem.add(textFieldM[1]);
        hboxMem.add(Box.createHorizontalStrut(70));
        hboxMem.add(labelForM3);
        hboxMem.add(Box.createHorizontalStrut(10));
        hboxMem.add(textFieldM[2]);
        hboxMem.add(Box.createHorizontalGlue());

        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(80));
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalStrut(80));
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalGlue());

        JLabel labelForResult = new JLabel("Результат:");
        textFieldResult = new JTextField("0.0", 15);
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());//убрать масштабирование поля
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));




        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Double x = Double.parseDouble(textFieldX.getText());
                Double y = Double.parseDouble(textFieldY.getText());
                Double z = Double.parseDouble(textFieldZ.getText());
                Double result;
                if (formulaId==1)
                    result = calculate1(x, y, z);
                else
                    result = calculate2(x, y, z);
                textFieldResult.setText(result.toString());
            }
        });
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("0.0");
                textFieldY.setText("0.0");
                textFieldZ.setText("0.0");
                textFieldResult.setText("0.0");
            }
        });



        JButton MC = new JButton("MC");
        MC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                mem[memid] = 0.;
                textFieldM[memid].setText(mem[memid].toString());
            }
        });

        JButton MP = new JButton("M+");
        MP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                mem[memid]+=Double.parseDouble(textFieldResult.getText());// parseDouble: String -> Double
                textFieldM[memid].setText(mem[memid].toString());
            }
        });
        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        Box hboxButtonsM = Box.createHorizontalBox();
        hboxButtonsM.add(Box.createHorizontalGlue());
        hboxButtonsM.add(MC);
        hboxButtonsM.add(Box.createHorizontalStrut(30));
        hboxButtonsM.add(MP);
        hboxButtonsM.add(Box.createHorizontalGlue());
        hboxButtonsM.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons);
        contentBox.add(hboxButtonsM);
        contentBox.add(hboxMemRB);
        contentBox.add(hboxMem);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);// Установить «вертикальную коробку» в область содержания главного окна
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

