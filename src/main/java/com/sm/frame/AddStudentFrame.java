package com.sm.frame;

import com.eltima.components.ui.DatePicker;
import com.sm.entity.CClass;
import com.sm.entity.Student;
import com.sm.entity.StudentVO;
import com.sm.factory.ServiceFactory;
import com.sm.ui.ImgPanel;
import com.sm.utils.AliOSSUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AddStudentFrame extends JFrame {
    private ImgPanel rootPanel;
    private JTextField idField;
    private JTextField nameField;
    private JComboBox<CClass> classComboBox;
    private JRadioButton 男RadioButton;
    private JRadioButton 女RadioButton;
    private JPanel datePanel;
    private JButton 新增Button;
    private JLabel avatarLabel;
    private JLabel closeLabel;
    private JTextField addressField;
    private JTextField phoneField;
    private String uploadFileUrl;
    private int classId;
    private File file;
    private AdminMainFrame adminMainFrame;

    public AddStudentFrame(AdminMainFrame adminMainFrame) {
        this.adminMainFrame = adminMainFrame;
        setContentPane(rootPanel);
        rootPanel.setFileName("n3.jpg");
        rootPanel.repaint();
        setUndecorated(true);
        setTitle("新增学生界面");
        setSize(1200,900);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //班级选择
        CClass tip = new CClass();
        tip.setClassName("请选择班级");
        classComboBox.addItem(tip);
        List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectAll();
        for (CClass cClass: cClassList) {
            classComboBox.addItem(cClass);
        }

        //关闭窗体
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddStudentFrame.this.dispose();
            }
        });

        //头像按钮
        avatarLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("E:\\Img\\avatarImg"));
                int result = fileChooser.showOpenDialog(rootPanel);
                if (result == JFileChooser.APPROVE_OPTION){
                    file = fileChooser.getSelectedFile();
                    ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                    icon.setImage(icon.getImage().getScaledInstance(150,150,150));
                    avatarLabel.setText("");
                    avatarLabel.setIcon(icon);
                }
            }
        });


        //班级复选框
        classComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED){
                    int index = classComboBox.getSelectedIndex();
                    if (index != 0 ){
                        classId = classComboBox.getItemAt(index).getId();
                    }
                }
            }
        });

        //单选按钮
        ButtonGroup group = new ButtonGroup();
        group.add(男RadioButton);
        group.add(女RadioButton);

        //出生日期
        DatePicker datepick = getDatePicker();
        datePanel.add(datepick);
        datePanel.revalidate();


        新增Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gender = null;
                if (男RadioButton.isSelected()){
                    gender = "男";
                }
                if (女RadioButton.isSelected()){
                    gender = "女";
                }
                Student student = new Student();
                student.setId(idField.getText());
                student.setClassId(classId);
                student.setStudentName(nameField.getText());
                student.setAvatar(AliOSSUtil.ossUpload(file));
                student.setGender(gender);
                student.setBirthday((Date) datepick.getValue());
                student.setAddress(addressField.getText());
                student.setPhone(phoneField.getText());
                int n  = ServiceFactory.getStudentServiceInstance().insertStudent(student);
                if (n == 1){
                    JOptionPane.showMessageDialog(rootPanel,"新增成功");
                    AddStudentFrame.this.dispose();
                    List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectAll();
                    adminMainFrame.showStudentTable(studentList);
                }
            }
        });
        新增Button.setBackground(new Color(134,219,71));
        新增Button.setForeground(new Color(0,0,0));
    }

    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.PLAIN, 18);
        Dimension dimension = new Dimension(200, 30);
        int[] hilightDays = {1, 3, 5, 7};
        int[] disabledDays = {4, 6, 5, 9};
        //构造方法（初始时间，时间显示格式，字体，控件大小）
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
//        datepick.setLocation(137, 83);//设置起始位置
        /*
        //也可用setBounds()直接设置大小与位置
        datepick.setBounds(137, 83, 177, 24);
        */
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
//        datepick.setTimePanleVisible(true);
        return datepick;
    }

}

