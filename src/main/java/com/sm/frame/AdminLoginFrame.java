package com.sm.frame;

import com.sm.entity.Admin;
import com.sm.factory.ServiceFactory;
import com.sm.ui.ImgPanel;
import com.sm.utils.ResultEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginFrame extends JFrame{
    private ImgPanel rootPanel;
    private JLabel loginLabel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JCheckBox remberCheckBox;
    private JButton loginBtn;
    private JButton resetBtn;

    public AdminLoginFrame() {
        //设置相应的背景图
        rootPanel.setFileName("border2.png");
        //组件重绘
        rootPanel.repaint();
        setTitle("管理员登录");
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(530, 655);
        setLocationRelativeTo(null);
        setVisible(true);

        //登录按钮
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获得输入的账号和密码，注意密码框组件的使用方法
                String account = accountField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account,password);
                JOptionPane.showMessageDialog(rootPanel,resultEntity.getMessage());
                //登录成功，进入主界面，并关闭登录界面
                if (resultEntity.getCode() == 0) {
                    new AdminMainFrame((Admin) resultEntity.getData());
//                    new AdminFrame();
                    AdminLoginFrame.this.dispose();

                } else if (resultEntity.getCode() == 1) {  //密码错误，清空密码框
                    passwordField.setText("");
                } else {   //账号错误，清空两个输入框
                    accountField.setText("");
                    passwordField.setText("");
                }
            }
        });

        //重置按钮
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountField.setText("");
                passwordField.setToolTipText("");
            }
        });
    }

    public static void main(String[] args) throws Exception{
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        new AdminLoginFrame();
    }
}
