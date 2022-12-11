import com.cht.tas.ap.CallOut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;

public class DashboardForm extends JFrame {
    private JPanel dashboardPanel;
    private JLabel lbAdmin;
    private JButton btnCallout;
    private JButton btnCallout1;
    private JButton btnCallout2;
    private JButton btnCallout3;
    private JLabel btnHelp;

    Color color = new Color(255,255,255);

    public DashboardForm() {
        setTitle("語音訊息通知");
        setContentPane(dashboardPanel);
        setMinimumSize(new Dimension(500, 474));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        btnCallout.setBackground(color);
        btnCallout1.setBackground(color);
        btnCallout2.setBackground(color);
        btnCallout3.setBackground(color);

        boolean hasRegistredUsers = connectToDatabase();
        if (hasRegistredUsers) {

            LoginForm loginForm = new LoginForm(this);
            User user = loginForm.user;

            if (user != null) {
                lbAdmin.setText("目前的使用者： " + user.name);
                setLocationRelativeTo(null);
                setVisible(true);
            }
            else {
                dispose();
                new RegistrationForm(this);
            }
        }
        else {
            RegistrationForm registrationForm = new RegistrationForm(this);
            User user = registrationForm.user;

            if (user != null) {
                lbAdmin.setText("User: " + user.name);
                setLocationRelativeTo(null);
                setVisible(true);
            }
            else {
                dispose();
            }
        }
        btnCallout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CallOut callOut = new CallOut();
                try {
                    callOut.IsTest();
                    JOptionPane.showMessageDialog(DashboardForm.this,
                            "已發送通知",
                            "訊息",JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnCallout1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CallOut callOut1 = new CallOut();
                try {
                    callOut1.IsTest1();
                    JOptionPane.showMessageDialog(DashboardForm.this,
                            "已發送通知",
                            "訊息",JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnCallout2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CallOut callOut2 = new CallOut();
                try {
                    callOut2.IsTest2();
                    JOptionPane.showMessageDialog(DashboardForm.this,
                            "已發送通知",
                            "訊息",JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnCallout3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CallOut callOut3 = new CallOut();
                try {
                    callOut3.IsTest3();
                    JOptionPane.showMessageDialog(DashboardForm.this,
                            "已發送通知",
                            "訊息",JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnHelp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(DashboardForm.this,
                        "預設為備血",
                        "幫助",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private boolean connectToDatabase() {
        boolean hasRegistredUsers = false;

        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/Demo?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS Demo");
            statement.close();
            conn.close();

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT( 10 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "name VARCHAR(200) NOT NULL,"
                    + "phone VARCHAR(200),"
                    + "password VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);

            //檢查用戶是否存在
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");

            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }
            }

            statement.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return hasRegistredUsers;
    }

    public static void main(String[] args) {
        DashboardForm myForm = new DashboardForm();

    }

}
