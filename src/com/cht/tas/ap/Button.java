package com.cht.tas.ap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Button extends JFrame {
    JButton button = new JButton("發送會診通知");
    JButton button1 = new JButton("查看接聽狀況");
    Color color = new Color(211,211,211);
    Object[][] data = {{"陳OO", "0900000000", "否"},{"林OO","0900000000", "是"},{"吳OO", "0900000000", "是"},{"楊OO","0900000000", "是"}};
    String[] columns={"姓名","電話號碼","是否接聽電話"};
    JTable jt = new JTable(data,columns);

    public static void main(String[] args) {
        Button Buttonrun = new Button();
    }
    public Button(){
        super();
        setSize(600,400);
        setLocation(300,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("語音訊息通知");

        button.setBounds(200,50,200,100);
        button1.setBounds(200,200,200,100);

        setLayout(null);
        button.setBackground(color);
        button1.setBackground(color);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button1.setBorder(BorderFactory.createRaisedBevelBorder());
        add(button);
        add(button1);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //執行Callout程式
                CallOut callOut = new CallOut();
                try {
                    callOut.IsTest();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                //if有成功執行，就顯示下方訊息
                JOptionPane.showMessageDialog(null,
                        "已發送通知",
                        "訊息",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new List();
            }
        });
    }
    public class List extends JFrame {
        public List() {
            super();
            setSize(600, 400);
            setLocation(300, 200);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setTitle("接聽狀況");
            jt.setPreferredScrollableViewportSize(new Dimension(600,400));
            add(new JScrollPane(jt),BorderLayout.CENTER);
            add(button,BorderLayout.SOUTH);
            setVisible(true);
        }
    }
}
