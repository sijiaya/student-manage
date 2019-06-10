package com.sm.frame;

import com.eltima.components.ui.DatePicker;
import com.sm.entity.*;
import com.sm.factory.DAOFactory;
import com.sm.factory.ServiceFactory;
import com.sm.ui.ImgPanel;
import com.sm.ui.TimeThread;
import com.sm.utils.AliOSSUtil;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AdminMainFrame extends JFrame {

    private ImgPanel rootPanel;
    private JButton 院系管理Button;
    private JButton 班级管理Button;
    private JButton 学生管理Button;
    private JButton 奖惩管理Button;
    private JPanel centerPanel;
    private JPanel departmentPanel;
    private JPanel classPanel;
    private JPanel studentPanel;
    private JPanel rewardPunishPanel;
    private JPanel topPanel;
    private JButton 新增院系Button;
    private JPanel leftPanel;
    private JTextField depNameField;
    private JButton 选择logo图Button;
    private JButton 新增Button;
    private JButton 刷新数据Button;
    private JScrollPane scrollpane;
    private JPanel contentPanel;
    private JLabel adminNameLabel;
    private JLabel Label1;
    private JLabel timeLabel;
    private JLabel logoLabel;
    private JComboBox depComboBox;
    private JTextField classField;
    private JButton 新增班级Button;
    private JPanel treePanel;
    private JPanel classContentPanel;
    private JPanel stuTopPanel;
    private JComboBox<Department> comboBox1;
    private JComboBox<CClass> comboBox2;
    private JTextField searchField;
    private JButton 搜索Button;
    private JButton 新增学生Button;
    private JButton 批量导入Button;
    private ImgPanel infoPanel;
    private JPanel tablePanel;
    private JLabel stuAvatarLabel;
    private JButton 编辑Button;
    private JTextField stuAddressField;
    private JTextField stuPhoneField;
    private JLabel stuIdLabel;
    private JLabel stuDepLabel;
    private JLabel stuClassLabel;
    private JLabel stuNameLabel;
    private JLabel stuGenderLabel;
    private JLabel stuBirthLabel;
    private JButton 初始化数据Button;
    private JLabel 选择logo图Label;
    private JLabel 选择logoLabel;
    private JButton 首页Button;
    private JPanel zongPanel;
    private JButton 奖惩情况Button;
    private JButton 惩罚情况Button;
    private JButton 新增奖惩Button;
    private JButton 新增违纪Button;
    private JPanel headPanel;
    private JPanel rpPanel;
    private ImgPanel addRewPanel;
    private ImgPanel addPunishmentPanel;
    private JComboBox<StudentVO> rewIdComboBox;
//    private JComboBox<RewardPunish> rewEventComboBox;
//    private JComboBox<RewardPunish> rewRankComboBox;
        private JComboBox rewEventComboBox;
       private JComboBox rewRankComboBox;
    private JPanel timePanel;
    private JButton 确认新增Button;
    private JPanel time2Panel;
    private JTextArea ruleTextArea;
    private JTextField findTextField;
    private JButton 搜索Btn;
    private ImgPanel rewInfoPanel;
    private JPanel rewTablePanel;
    private JTextField rewField;
    private JLabel rewAvatarLabel;
    private JLabel rewIdLabel;
    private JLabel rewDepLabel;
    private JLabel rewClassLabel;
    private JLabel rewNameLabel;
    private JLabel rewGenderLabel;
    private JLabel rewDateLabel;
    private JButton 初始化Button;
    private JLabel rewGenreLabel;
    private JLabel rewContentLabel;
    private JLabel rewReasonLabel;
    private JButton 奖惩制度Button;
    private JButton 奖惩规则Button;
    private Admin admin;
    private String uploadFileUrl;
    private File file;
    private JComboBox<Department> depcomboBox;
    private int departmentId = 0;
    private int eventId = 0;
    private int rankId = 0;
    private int row;
    private int classId;
    private String studentId;
    private AdminMainFrame adminMainFrame;

    //通过构造方法传值
    public AdminMainFrame(Admin admin) {
        this.adminMainFrame = adminMainFrame;
        this.admin = admin;
        adminNameLabel.setText("当前管理员：" + admin.getAdminName());
        //获取系统时间
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();

        //设置需要的背景图
        rootPanel.setFileName("444.jpg");
        addRewPanel.setFileName("dd.jpg");
        //组件重绘
        rootPanel.repaint();
        addRewPanel.repaint();
        //窗体基本属性设置
        setTitle("管理员主界面");
        setContentPane(rootPanel);
        //全屏
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //调用显示所有院系的方法
        showDepartments();

        //获取centerPanel的布局,获取的是LayoutManager，向下转型为cardLayout
        final CardLayout cardLayout = (CardLayout) centerPanel.getLayout();
        //给按钮设置颜色、字体
        院系管理Button.setBackground(new Color(102, 187, 106));
        院系管理Button.setForeground(new Color(1, 1, 1));
        Font font = new Font("楷体", Font.BOLD, 21);
        院系管理Button.setFont(font);

        班级管理Button.setBackground(new Color(102, 187, 106));
        班级管理Button.setForeground(new Color(1, 1, 1));
        班级管理Button.setFont(font);

        学生管理Button.setBackground(new Color(102, 187, 106));
        学生管理Button.setForeground(new Color(1, 1, 1));
        学生管理Button.setFont(font);

        奖惩管理Button.setBackground(new Color(102, 187, 106));
        奖惩管理Button.setForeground(new Color(1, 1, 1));
        奖惩管理Button.setFont(font);
        Font font1 = new Font("楷体", Font.PLAIN, 19);
        新增院系Button.setBackground(new Color(165, 214, 167));
        新增院系Button.setForeground(new Color(1, 1, 1));
        新增院系Button.setFont(font1);

        刷新数据Button.setBackground(new Color(165, 214, 167));
        刷新数据Button.setForeground(new Color(1, 1, 1));
        刷新数据Button.setFont(font1);

        新增Button.setBackground(new Color(165, 214, 167));
        新增Button.setForeground(new Color(1, 1, 1));
        新增Button.setFont(font1);


        院系管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card1");
            }
        });
        班级管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card2");
                showClassPanel();
            }
        });
        //点击学生管理按钮切换卡片，右侧面板设置背景并重绘，调用封装的方法显示学生表格数据
        学生管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card3");
                //右侧个人信息面板加入背景图
                infoPanel.setFileName("666.jpg");
                infoPanel.repaint();
                //调用学生数据的方法
                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectAll();
                showStudentTable(studentList);

                //两个下拉框初始化提示数据，因为里面的元素都是对象，所有进行这样的处理
                Department tip1 = new Department();
                tip1.setDepartmentName("请选择院系");
                comboBox1.addItem(tip1);
                CClass tip2 = new CClass();
                tip2.setClassName("请选择班级");
                comboBox2.addItem(tip2);
                //初始化院系下拉框数据
                List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
                for (Department department : departmentList) {
                    comboBox1.addItem(department);
                }
                //初始化班级下拉框数据
                List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectAll();
                for (CClass cClass : cClassList) {
                    comboBox2.addItem(cClass);
                }

                //院系下拉框设置监听，选中哪一项表格中就显示该院系的所有学生，并级联查出该院系的所有班级，更新到班级下拉框
                comboBox1.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        //如果是选中状态
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            //得到选中项的索引
                            int index = comboBox1.getSelectedIndex();
                            //排除第一项（为提示信息），不能作为查询依据
                            if (index != 0) {
                                departmentId = comboBox1.getItemAt(index).getId();

                                //获取该院系的学生并显示在表格
                                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectByDepartmentId(departmentId);
                                showStudentTable(studentList);

                                //二级联动——班级下拉框的内容随着选择院系的不同而改变
                                List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectByDepartmentId(departmentId);
                                //先移除之前的数据，否则下拉框内容会不断增加
                                comboBox2.removeAllItems();
                                //重新加入下拉框初始化提示数据
                                CClass tip = new CClass();
                                tip.setClassName("请选择班级");
                                comboBox2.addItem(tip);
                                for (CClass cClass : cClassList) {
                                    comboBox2.addItem(cClass);
                                }
                            }
                        }
                    }
                });
                //班级下拉框设置监听，可根据选中班级显示所有学生
                comboBox2.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            int index = comboBox2.getSelectedIndex();
                            if (index != 0) {
                                int classId = comboBox2.getItemAt(index).getId();
                                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectByClassId(classId);
                                showStudentTable(studentList);
                            }
                        }
                    }
                });
            }
        });

        奖惩管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card4");
            }
        });



        //隐藏导航栏
        新增院系Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = leftPanel.isVisible();
                if (flag == false) {
                    leftPanel.setVisible(true);
                } else {
                    leftPanel.setVisible(false);
                }
            }
        });
        刷新数据Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //(刷新)重新请求所有院系数据
                showDepartments();
            }
        });

        depNameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                depNameField.setText("");
            }
        });
        //侧边栏新增
        新增Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //上传文件到OSS并返回外链
                uploadFileUrl = AliOSSUtil.ossUpload(file);
                //创建Department对象，并设置相应属性
                Department department = new Department();
                department.setDepartmentName(depNameField.getText().trim());
                department.setLogo(uploadFileUrl);
                //调用service实现新增功能
                int n = ServiceFactory.getDepartmentServiceInstance().addDepartment(department);
                if (n == 1) {
                    JOptionPane.showMessageDialog(rootPanel, "新增院系成功");
                    //新增成功后，将侧边栏隐藏
                    leftPanel.setVisible(false);
                    //刷新界面数据
                    showDepartments();
                    //将图片预览标签隐藏
                    logoLabel.setVisible(false);
                    //将选择图片的按钮可见
                    选择logo图Button.setVisible(true);
                    //清空文本框
                    depNameField.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPanel, "新增院系失败");
                }
            }
        });

        //院系下拉框
        depComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //得到选中项的索引
                int index = depComboBox.getSelectedIndex();
                //按照索引取出项，就是一个Department对象，然后取出其相应的id
                Department department = (Department) depComboBox.getItemAt(index);
                departmentId = department.getId();
//                departmentId = depcomboBox.getItemAt(index).getId();
            }
        });
        新增班级Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建cClass对象，并设置相应属性
                CClass cClass = new CClass();
                cClass.setDepartmentId(departmentId);
                cClass.setClassName(classField.getText().trim());
                //调用service实现新增功能
                int n = ServiceFactory.getCClassServiceInstance().addClass(cClass);
                if (n == 1) {
                    JOptionPane.showMessageDialog(rootPanel, "新增班级成功");
                    //刷新界面数据
                    showClassPanel();
                    新增班级Button.setVisible(true);
                    //清空文本框
                    classField.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPanel, "新增班级失败");
                }
            }
        });
        初始化数据Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //还原表格数据
                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectAll();
                showStudentTable(studentList);
                //院系下拉框还原
                comboBox1.setSelectedIndex(0);
                //班级下拉框数据还原
                comboBox2.removeAllItems();
                CClass tip2 = new CClass();
                tip2.setClassName("请选择班级");
                comboBox2.addItem(tip2);
                List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectAll();
                for (CClass cClass : cClassList) {
                    comboBox2.addItem(cClass);
                }
                //右侧显示个人信息区域数据还原
                stuAvatarLabel.setText("<html><img src = 'https://students-manage.oss-cn-beijing.aliyuncs.com/logo/avatar.jpg'/></html>");
                stuIdLabel.setText("未选择");
                stuDepLabel.setText("未选择");
                stuClassLabel.setText("未选择");
                stuNameLabel.setText("未选择");
                stuGenderLabel.setText("未选择");
                stuAddressField.setText("");
                stuPhoneField.setText("");
                stuBirthLabel.setText("未选择");
                //搜索框清空
                searchField.setText("");
                //编辑按钮隐藏
                编辑Button.setVisible(false);
            }
        });
        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                searchField.setText("");
            }
        });
        搜索Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords = searchField.getText().trim();
                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectByKeywords(keywords);
                if (studentList != null) {
                    showStudentTable(studentList);
                }
            }
        });

        新增学生Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStudentFrame(AdminMainFrame.this);
                AdminMainFrame.this.setEnabled(true);
            }
        });
        选择logoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("E:\\Img"));
                int result = fileChooser.showOpenDialog(rootPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    //选中文件
                    file = fileChooser.getSelectedFile();
                    //通过文件创建icon对象
//                    Icon icon = new ImageIcon(file.getAbsolutePath());
                    ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                    icon.setImage(icon.getImage().getScaledInstance(230, 200, Image.SCALE_DEFAULT));
                    //通过标签显示图片
                    logoLabel.setIcon(icon);
                    //设置标签可见
                    logoLabel.setVisible(true);
                    //将Label隐藏
                    选择logo图Label.setVisible(false);
                }
            }
        });

        classField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                classField.setText("");
            }
        });


        final CardLayout c1 = (CardLayout) zongPanel.getLayout();
        首页Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.show(zongPanel,"Card11");
            }
        });
        奖惩情况Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.show(zongPanel,"Card22");
                //调用学生数据的方法
                List<RewardPunish> rewardPunishList = ServiceFactory.getRewardPunishServiceInstance().selectAll();
                showRewardPanel(rewardPunishList);
            }
        });

        新增奖惩Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1.show(zongPanel,"Card44");
                //班级选择
                StudentVO tip = new StudentVO();
                tip.setId("请选择学号");
                rewIdComboBox.addItem(tip);
                List<StudentVO> studentVOList = ServiceFactory.getStudentServiceInstance().selectAll();
                for (StudentVO studentVO: studentVOList) {
                    rewIdComboBox.addItem(studentVO);
                }

                rewIdComboBox.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED){
                            int index = rewIdComboBox.getSelectedIndex();
                            if (index != 0 ){
                                studentId = rewIdComboBox.getItemAt(index).getId();
                            }
                        }
                    }
                });
            }

        });



        //日期设置
        DatePicker datepick1 = getDatePicker();
        timePanel.add(datepick1);
        timePanel.revalidate();


        RewardPunish tip1 = new RewardPunish();
        tip1.setEvent("请选择事件");
        rewEventComboBox.addItem(tip1);
        List<RewardPunish> rewardPunishList = ServiceFactory.getRewardPunishServiceInstance().selectAll();
        for (RewardPunish rewardPunish:rewardPunishList) {
            rewEventComboBox.addItem(rewardPunish.getEvent());
        }
        RewardPunish tip2 = new RewardPunish();
        tip2.setEvent("请选择奖项");
        rewRankComboBox.addItem(tip2);
        List<RewardPunish> rewardPunishList1 = ServiceFactory.getRewardPunishServiceInstance().selectAll();
        for (RewardPunish rPunishList:rewardPunishList1) {
            rewRankComboBox.addItem(rPunishList.getRank());
        }

        rewEventComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = rewEventComboBox.getSelectedIndex();
                RewardPunish rewardPunish = (RewardPunish) rewEventComboBox.getItemAt(index);
                eventId = rewardPunish.getId();

            }
        });
        rewRankComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = rewRankComboBox.getSelectedIndex();
                RewardPunish rewardPunish = (RewardPunish) rewRankComboBox.getItemAt(index);
                rankId = rewardPunish.getId();
            }
        });
        findTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                findTextField.setText("");
            }
        });
        搜索Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords = findTextField.getText().trim();
                List<RewardPunish> rewardPunishList1 = ServiceFactory.getRewardPunishServiceInstance().selectByKeywords(keywords);
                if (rewardPunishList1!= null){
                    showRewardPanel(rewardPunishList1);
                }
            }
        });
        确认新增Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

           RewardPunish rewardPunish = new RewardPunish();
                int index = rewIdComboBox.getSelectedIndex();
                StudentVO student=rewIdComboBox.getItemAt(index);
                rewardPunish.setStudentId(student.getId());


                int index1 = rewEventComboBox.getSelectedIndex();
                RewardPunish rewardPunish1 = (RewardPunish) rewEventComboBox.getItemAt(index1);
                eventId = rewardPunish1.getId();
                rewardPunish.setEventId(eventId);

                int index2 = rewRankComboBox.getSelectedIndex();
                RewardPunish rewardPunish2 = (RewardPunish) rewRankComboBox.getItemAt(index2);
                rankId = rewardPunish2.getId();
                rewardPunish.setRankId(rankId);

                rewardPunish.setRpDate((Date) datepick1.getValue());
                int n=ServiceFactory.getRewardPunishServiceInstance().insertReward(rewardPunish);
                if (n == 1){
                    JOptionPane.showMessageDialog(rootPanel,"新增成功");
                   List<RewardPunish> rewardPunishList1=ServiceFactory.getRewardPunishServiceInstance().selectAll();
                   showRewardPanel(rewardPunishList1);
                }else {
                    JOptionPane.showMessageDialog(rootPanel,"新增失败");
                }
            }
        });
    }
    //院系管理
    private void showDepartments() {
        //移除原有数据
        contentPanel.removeAll();
        List<Map> departmentList1 = ServiceFactory.getDepartmentServiceInstance().selectDepartmentInfo();
        //从service层获取到所有院系列表
//        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        GridLayout gridLayout = new GridLayout(0, 4, 10, 10);
        contentPanel.setLayout(gridLayout);
        for (Map map : departmentList1) {
            //给每个院系对象创建一个面板
            JPanel depPanel = new JPanel();
            Department department = (Department) map.get("department");
            int classCount = (int) map.get("classCount");
            int studentCount = (int) map.get("studentCount");
            depPanel.setBackground(new Color(235, 242, 249));
            depPanel.setPreferredSize(new Dimension(300, 300));
            depPanel.setBorder(BorderFactory.createTitledBorder(department.getDepartmentName()));
            JLabel logoLabel = new JLabel("<html><img src='" + department.getLogo() + "'/></html>");
            logoLabel.setPreferredSize(new Dimension(280, 280));
            depPanel.add(logoLabel);
            JLabel infoLabel = new JLabel("班级" + classCount + "个，学生" + studentCount + "人");

            JButton deleteBtn = new JButton("删除");
            deleteBtn.setPreferredSize(new Dimension(110, 42));
            deleteBtn.setBackground(new Color(83, 134, 66));
            deleteBtn.setForeground(new Color(1, 1, 1));
            deleteBtn.setFont(new Font(null, Font.BOLD, 20));
            deleteBtn.setSize(new Dimension(80, 40));
            deleteBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int n = JOptionPane.showConfirmDialog(contentPanel, "确认删除吗？", "确认对话框", JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        contentPanel.remove(depPanel);
                        //实时删除
                        contentPanel.repaint();
                        ServiceFactory.getDepartmentServiceInstance().deleteById(department.getId());
                        System.out.println("已删除");
                    } else if (n == JOptionPane.NO_OPTION) {
                        System.out.println("已取消");
                    }
                }
            });
            depPanel.add(infoLabel);
            depPanel.add(deleteBtn);
            contentPanel.add(depPanel);
            contentPanel.revalidate();
        }
    }
    //班级管理
    private void showClassPanel(){
        //获取所有院系信息
        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        //班级管理中的顶上的下拉框
        showCombobox(departmentList);
        //班级管理中左侧的树
        showTree(departmentList);
        //班级管理中的流式布局面板
        showClasses(departmentList);
    }
    private void showCombobox(List<Department> departmentList){
        for (Department department: departmentList) {
            depComboBox.addItem(department);
        }
    }
    private void showTree(List<Department> departmentList){
        treePanel.removeAll();
        //左侧树形结构根节点
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("南工院");
        //一级目录遍历
        for (Department department: departmentList) {
            //得到学院名称
            DefaultMutableTreeNode group = new DefaultMutableTreeNode(department.getDepartmentName());
            top.add(group);
            //根据学院的id得到班级
            List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectByDepartmentId(department.getId());
            //二级目录遍历
            for (CClass cClass: cClassList) {
                int num = ServiceFactory.getStudentServiceInstance().countStudentByClassId(cClass.getId());
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(cClass.getClassName() + "(" + num + "人)");
                group.add(node);
            }
        }
        final JTree tree = new JTree(top);
        //树的行高
        tree.setRowHeight(30);
        tree.setFont(new Font("楷体",Font.PLAIN,20));
        treePanel.add(tree);
        treePanel.revalidate();
    }
    private void showClasses(List<Department> departmentList){
        classContentPanel.removeAll();
        //右侧流式布局面板显示
        Font titleFont = new Font("微软雅黑",Font.PLAIN,23);
        for (Department department:departmentList) {
            //外边框背景图
            ImgPanel depPanel = new ImgPanel();
            depPanel.setFileName("border2.png");
            depPanel.repaint();
            depPanel.setPreferredSize(new Dimension(350,500));
            depPanel.setLayout(null);
            //加入院系名称
            JLabel depNameLabel = new JLabel(department.getDepartmentName());
            depNameLabel.setFont(titleFont);
            depNameLabel.setBounds(115,30,200,30);
            //获得该院系的所有班级
            List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectByDepartmentId(department.getId());
            //数据模型
            DefaultListModel listModel = new DefaultListModel();
            //遍历班级集合，依次加入到数据模型中
            for (CClass cClass: cClassList) {
                listModel.addElement(cClass);
            }
            //使用数据模型创建一个JList组件
            JList<CClass> jList = new JList<>(listModel);
            jList.setForeground(new Color(0,0,0));
            jList.setBackground(new Color(240,240,240));
            jList.setFont(new Font("微软雅黑",Font.PLAIN,20));
            //jList加入到滚动面板
            JScrollPane listScrollPane = new JScrollPane(jList);
            listScrollPane.setBounds(60,85,230,330);
            depPanel.add(depNameLabel);
            depPanel.add(listScrollPane);
            classContentPanel.add(depPanel);
            //每个院系的JList中，选中班级右键会显示弹出菜单（修改、删除）
            JPopupMenu jPopupMenu = new JPopupMenu();
            JMenuItem item1 = new JMenuItem("修改");
            JMenuItem item2 = new JMenuItem("删除");
            jPopupMenu.add(item1);
            jPopupMenu.add(item2);
            jList.add(jPopupMenu);
            jList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //选中项的下标
                    int index = jList.getSelectedIndex();
                    //点击鼠标右键
                    if (e.getButton() == 3){
                        //在鼠标位置弹出菜单
                        jPopupMenu.show(jList,e.getX(),e.getY());
                        //取出选中数据
                        CClass cClass = jList.getModel().getElementAt(index);
                        //对“删除”菜单项添加监听
                        item2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int choice = JOptionPane.showConfirmDialog(depPanel,"确认删除吗？");
                                if (choice == 0){
                                    ServiceFactory.getCClassServiceInstance().deleteClassById(cClass.getId());
                                    listModel.remove(index);
                                    showTree(ServiceFactory.getDepartmentServiceInstance().selectAll());
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void showStudentTable(List<StudentVO> studentList){
        tablePanel.removeAll();
        //创建表格
        JTable table = new JTable();
        //表格数据模型
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        //表头内容
        model.setColumnIdentifiers(new String[]{"学号","院系","班级","姓名","性别","地址","手机号","出生日期","头像"});
        //遍历List，集成object数据
        for (StudentVO s:studentList
        ) {
            Object[] objects = new Object[]{s.getId(),s.getDepartmentName(),s.getClassName(),
                    s.getStudentName(),s.getGender(),s.getAddress(),s.getPhone(),s.getBirthday(),
                    s.getAvatar()};
            model.addRow(objects);
        }
        //将最后一列隐藏头像地址不显示在表格中
        TableColumn tc = table.getColumnModel().getColumn(8);
        tc.setMinWidth(0);
        tc.setMaxWidth(0);
        //获得表头
        JTableHeader head = table.getTableHeader();
        //表头居中
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        head.setDefaultRenderer(hr);
        //设置表头大小
        head.setPreferredSize(new Dimension(head.getWidth(),30));
        //设置表头字体
        head.setFont(new Font("楷体",Font.PLAIN,22));
        //设置表头行高
        table.setRowHeight(35);
        //表格背景色
        table.setBackground(new Color(223,241,234));
        //表格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,r);
        //表格加入滚动面板，水平垂直方向带滚动条
        JScrollPane scrollPane = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablePanel.add(scrollPane);
        //表格刷新
        tablePanel.revalidate();

        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem item = new JMenuItem("删除");
        jPopupMenu.add(item);
        table.add(jPopupMenu);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = table.getSelectedRow();
                stuIdLabel.setText(table.getValueAt(row,0).toString());
                stuDepLabel.setText(table.getValueAt(row,1).toString());
                stuClassLabel.setText(table.getValueAt(row,2).toString());
                stuNameLabel.setText(table.getValueAt(row,3).toString());
                stuGenderLabel.setText(table.getValueAt(row,4).toString());
                stuAddressField.setText(table.getValueAt(row,5).toString());
                stuPhoneField.setText(table.getValueAt(row,6).toString());
                stuBirthLabel.setText(table.getValueAt(row,7).toString());
                stuAvatarLabel.setText("<html><img src='"+table.getValueAt(row,8).toString()+"'/></html>");
                编辑Button.setVisible(true);
                编辑Button.setText("编辑");
                编辑Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //如果按钮文字是“编辑”,则激活两个文本框
                        if (e.getActionCommand().equals("编辑")){
                            stuAddressField.setEditable(true);
                            stuAddressField.setEnabled(true);
                            stuPhoneField.setEnabled(true);
                            stuPhoneField.setEditable(true);
                            编辑Button.setText("保存");
                        }
                        //如果按钮文字是“保存”，则通过输入内容创建需要修改的student对象,调用service进行信息更新
                        if (e.getActionCommand().equals("保存")){
                            Student student = new Student();
                            student.setId(stuIdLabel.getText());
                            student.setAddress(stuAddressField.getText());
                            student.setPhone(stuPhoneField.getText());
                            int n = ServiceFactory.getStudentServiceInstance().updateStudent(student);
                            if (n == 1){
                                //更新表格中对应行的地址、电话，单元格里的内容
                                model.setValueAt(stuAddressField.getText(),row,5);
                                model.setValueAt(stuPhoneField.getText(),row,6);
                                //文本框恢复成不可用状态
                                stuAddressField.setEditable(false);
                                stuAddressField.setEnabled(false);
                                stuPhoneField.setEditable(false);
                                stuPhoneField.setEnabled(false);
                                //按钮文字恢复成“编辑”
                                编辑Button.setText("编辑");
                                table.revalidate();
                            }
                        }
                    }
                });
                if (e.getButton() == 3){
                    jPopupMenu.show(table,e.getX(),e.getY());
                }
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = (String) table.getValueAt(row,0);
                int choice = JOptionPane.showConfirmDialog(tablePanel,"确定删除吗？");
                if (choice == 0){
                    if (row != -1){
                        model.removeRow(row);
                    }
                    ServiceFactory.getStudentServiceInstance().deleteById(id);
                }
            }
        });
    }

    public void showRewardPanel(List<RewardPunish> rewardPunishList){
            rpPanel.removeAll();
            GridLayout gridLayout = new GridLayout(0,4,35,35);
            rpPanel.setLayout(gridLayout);
        GridLayout gridLayout1 = new GridLayout(0,1,200,0);
        for (RewardPunish rewardPunish: rewardPunishList) {
            Font jFont1 = new Font("微软雅黑",Font.BOLD,27);
            Font jFont = new Font("楷体",Font.PLAIN,20);
            JLabel jLabel1 = new JLabel("           院系："+rewardPunish.getDepartmentName());
            JLabel jLabel2 = new JLabel("           班级："+rewardPunish.getClassName());
            JLabel jLabel3 = new JLabel("           姓名："+rewardPunish.getStuName());
            JLabel jLabel4 = new JLabel("           事件："+rewardPunish.getEvent());
            JLabel jLabel5 = new JLabel("           明细："+rewardPunish.getRank());
            JLabel jLabel6 = new JLabel("           日期："+rewardPunish.getRpDate()) ;
            jLabel1.setForeground(new Color(1,1,1));
            jLabel1.setFont(jFont1);
            jLabel2.setFont(jFont);
            jLabel3.setFont(jFont);
            jLabel4.setFont(jFont);
            jLabel5.setFont(jFont);
            jLabel6.setFont(jFont);
            //外边框背景图
            ImgPanel rewPunPanel = new ImgPanel();
            rewPunPanel.setFileName("rew.jpg");
            rewPunPanel.repaint();
            rewPunPanel.setPreferredSize(new Dimension(0,570));
            rewPunPanel.setLayout(gridLayout1);
            JButton jButton = new JButton("删除");

            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int n = JOptionPane.showConfirmDialog(null,"确认删除吗？","确认对话框",
                            JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION){
                        ServiceFactory.getRewardPunishServiceInstance().deleteRewardById(rewardPunish.getId());
                        List<RewardPunish> rewardPunishList1 = ServiceFactory.getRewardPunishServiceInstance().selectAll();
                        showRewardPanel(rewardPunishList1);
                    }
                }
            });
            jButton.setBackground(new Color(215,239,239));
            jButton.setPreferredSize(new Dimension(120,40));
            rewPunPanel.add(jLabel1);
            rewPunPanel.add(jLabel2);
            rewPunPanel.add(jLabel3);
            rewPunPanel.add(jLabel4);
            rewPunPanel.add(jLabel5);
            rewPunPanel.add(jLabel6);
            //jLabel.setBounds(60,60,100,50);
            rewPunPanel.add(jButton);
            //jButton.setBounds(30,50,15,15);
            rpPanel.add(rewPunPanel);
            rpPanel.revalidate();
        }
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
        datepick.setHightlightdays(hilightDays,Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
//        datepick.setTimePanleVisible(true);
        return datepick;
    }

    public static void main(String[] args) throws Exception{
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        new AdminMainFrame(DAOFactory.getAdminDAOInstance().getAdminByAccount("222"));
    }


}
