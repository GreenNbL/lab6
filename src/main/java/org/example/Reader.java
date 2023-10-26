package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static java.awt.SystemColor.window;

public class Reader extends JFrame
{
    Button b1 = new Button("Add");
    Button b2 = new Button("Clear list");
    DefaultListModel listModelLeft= new DefaultListModel();
    JList chLeft=new  JList(listModelLeft);
    DefaultListModel listModelCentral= new DefaultListModel();
    JList chCenter=new  JList(listModelCentral);
    DefaultListModel listModelRight= new DefaultListModel();
    JList chRight=new  JList(listModelRight);
    //Label label1 = new Label("Enter your text here:");
    JCheckBox leftList = new JCheckBox("Левый список");

    JCheckBox centerList = new JCheckBox("Центральный список");

    JCheckBox rightList = new JCheckBox("Правый список");
    private final String[] data1 = { "Чай" ,"Кофе"  ,"Минеральная","Морс", "Компот","Кока Кола","Алкоголь"  ,"Какао","Энергетик", "Вода"};
    private String data;
    private int position=0;
    private int numberOflist=0;
    public Reader()
    {
        setLayout(null); //отключение менеджера компоновки
        setSize(600,400); //установка размеров фрейма
        setTitle("Лаба 6-ПрогСП"); //установка заголовка фрейма
        setBackground(Color.pink); //установка цвета заднего фона фрейма
        add(b1);
        b1.setBounds(220,300,84,24); //установка размеров кнопки
        b1.setForeground(Color.black); //установка цвета переднего фона кнопки
        b1.setBackground(Color.magenta); //установка цвета заднего фона кнопки
        add(b2);
        b2.setBounds(350,300,84,24); //установка размеров кнопки
        b2.setForeground(Color.black); //установка цвета переднего фона кнопки
        b2.setBackground(Color.magenta); //установка цвета заднего фона кнопки
        add(chLeft); //добавление раскрывающегося списка к окну
        chLeft.setBounds(10,10,120,100); //установка размеров раскрывающегося
        add(chCenter); //добавление раскрывающегося списка к окну
        chCenter.setBounds(220,50,120,100); //установка размеров раскрывающегося
        add(chRight); //добавление раскрывающегося списка к окну
        chRight.setBounds(450,90,120,100); //установка размеров раскрывающегося
        add(leftList);
        leftList.setBounds(10,280,120,20);
        add(centerList);
        centerList.setBounds(10,300,170,20);
        add(rightList);
        rightList.setBounds(10,320,120,20);
        b1.addActionListener(new ButtonAdd());
        b2.addActionListener(new ButtonClear());
        leftList.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(leftList.isSelected())
                    numberOflist=1;
                else
                    if(0<CheckCheckBox() && CheckCheckBox()<4 )
                        numberOflist=CheckCheckBox();
                    else
                        numberOflist=0;
            }
        });
        centerList.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(centerList.isSelected())
                    numberOflist=2;
                else
                    if(0<CheckCheckBox() && CheckCheckBox()<4 )
                        numberOflist=CheckCheckBox();
                    else
                        numberOflist=0;
            }
        });
        rightList.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(rightList.isSelected())
                    numberOflist=3;
                else
                    if(0<CheckCheckBox() && CheckCheckBox()<4 )
                        numberOflist=CheckCheckBox();
                    else
                        numberOflist=0;
            }
        });
        chLeft.addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        data = (String)chLeft.getSelectedValue();
                        position=1;
                    }
                });
        chLeft.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent evt)
            {
                java.awt.Point point = evt.getPoint();
                int index = chLeft.locationToIndex(point);
                if (chLeft.isSelectedIndex(index)) {
                    chLeft.removeSelectionInterval(index, index);
                    position = 0;

            }
            }
        });
        chCenter.addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        data = (String) chCenter.getSelectedValue();
                        position=2;
                    }
                });
        chCenter.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent evt)
            {
                java.awt.Point point = evt.getPoint();
                int index =  chCenter.locationToIndex(point);
                if ( chCenter.isSelectedIndex(index)) {
                    chCenter.removeSelectionInterval(index, index);
                    position=0;
                }
            }
        });
        chRight.addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        data = (String)chRight.getSelectedValue();
                        position=3;
                    }
                });
        chRight.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent evt)
            {
                java.awt.Point point = evt.getPoint();
                int index = chRight.locationToIndex(point);
                if (chRight.isSelectedIndex(index)) {
                    chRight.removeSelectionInterval(index, index);
                    position=0;
                }
            }
        });
    }
    private int CheckCheckBox()
    {
        int number=0;
        if(leftList.isSelected())
            number=1;
        if(centerList.isSelected())
            number=2;
        if(rightList.isSelected())
            number=3;
        return number;
    }

    class ButtonAdd implements ActionListener
    {
        /*реализация метода,  который вызывается при наступлении action-события*/
        public void actionPerformed(ActionEvent event)
        {
            switch(numberOflist)
            {
                case 1:
                    for(int i=0;i<data1.length;i++)
                        listModelLeft.addElement(data1[i]);
                    break;
                case 2:
                    for(int i=0;i<data1.length;i++)
                        listModelCentral.addElement(data1[i]);
                    break;
                case 3:
                for(int i=0;i<data1.length;i++)
                    listModelRight.addElement(data1[i]);
                break;
                default:
                   // System.out.println(position);
                   // System.out.println(data);
                   if(position==1) {
                       listModelCentral.addElement(data);
                       break;
                   }
                    if(position==2) {
                        listModelRight.addElement(data);
                        break;
                    }

            }

        }
    }
    class ButtonClear implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.out.println(numberOflist);
            switch(numberOflist)
            {
                case 1:
                    listModelLeft.removeAllElements();
                    break;
                case 2:
                    listModelCentral.removeAllElements();
                    break;
                case 3:
                    listModelRight.removeAllElements();
                    break;
                default:
                    break;

            }
        }

    }



}
