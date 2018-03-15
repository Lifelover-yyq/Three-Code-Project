package CLUB_management;
/*just test*/
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;
import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;

public class display {
	/* 主窗口面板分布*/
	private JFrame ClubFrame = new JFrame("学生社团信息管理系统");
	private JPanel simplePanel = new JPanel();	
	private JPanel daohangPanel = new JPanel();
	private JPanel putongPanel = new JPanel();
	private JPanel guanliPanel = new JPanel();
	private JPanel TimePanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	/*主窗口时间面板*/
	final JLabel TimeLabel = new JLabel();
	final SimpleDateFormat format = new SimpleDateFormat(
			"当前时间: y年M月d日E H:m:s",Locale.CHINA);
	private Timer t=new Timer();
	private JLabel ClubwelcomeLabel;
	private String Clubwelcome;
	/*主窗口简略信息面板*/
	private JLabel WelcomeLabel1 = new JLabel("用户:");
	private String WelcomeKind1;
	private String WelcomeKind2;
	private JLabel WelcomeLabel2 = new JLabel();
	private JLabel WelcomeLabel3 = new JLabel();
	/*功能导航面板*/
	private CardLayout card1 = new CardLayout();
	private JLabel ClubSystem = new JLabel("用户菜单");
	private JButton ModifyPassword = new JButton("┝修改密码");
	private JButton ExitClub = new JButton("┝申请退社");
	private JButton ExitLogin = new JButton("┝退出登录");
	private JButton ExitSystem = new JButton("┕退出系统");
	private JLabel InfView = new JLabel("基本信息");
	private JButton Perinf = new JButton("┝个人信息");
	private JButton Clubinf = new JButton("┝社团信息");
	private JButton Meminf = new JButton("┕社员信息");
	private JLabel ClubAct = new JLabel("更多信息");
	private JButton kaoping = new JButton("┝考评情况");
	private JButton Clubpost = new JButton("┝社团公告");
	private JButton liuyan = new JButton("┕留言群聊");
	private JButton last = new JButton("返回");
	/*展示主面板*/
	private CardLayout card2 = new CardLayout();
	private JPanel ModifyPWPanel = new JPanel();
	private JPanel ExitClubPanel = new JPanel();
	private JPanel ExitClubcheckPanel = new JPanel();
	private JPanel PerinfPanel = new JPanel();
	private JPanel ClubinfPanel = new JPanel();
	private JPanel MeminfPanel = new JPanel();
	private JPanel kaopingPanel = new JPanel();
	private JPanel ClubpostPanel = new JPanel();
	private JPanel issuepostPanel = new JPanel();
	private JPanel liuyanPanel = new JPanel();
	/*修改密码面板*/
	private JLabel OldPWLabel = new JLabel("旧密码:");
	private JLabel NewPWLabel = new JLabel("新密码:");
	private JLabel ConfirmPWLabel = new JLabel("确认新密码:");
	private JPasswordField OldPWLabelText = new JPasswordField();
	private JPasswordField NewPWLabelText = new JPasswordField();
	private JPasswordField ConfirmPWLabelText = new JPasswordField();
	private JButton ModifyPWSure = new JButton("确认修改");
	private JButton ModifyPWCancel = new JButton("密码重置");
	private JDialog ModifyPWSuccess = new JDialog(ClubFrame,"修改成功!",true);
	private JLabel ModifyPWSuccessLabel = new JLabel("密码修改成功!");
	private JButton ModifyPWSuccessClose = new JButton("确定");
	private JDialog ModifyPWError = new JDialog(ClubFrame,"输入有误!",true);
	private JLabel ModifyPWErrorLabel = new JLabel("密码输入有误!");
	private JButton ModifyPWErrorClose = new JButton("关闭");
	/*申请退社面板*/
	private JButton ExitClubcheck = new JButton("退社审核");
	private JLabel ExitClubLabel = new JLabel("请填写您的申请理由：(15-100字)");
	private JTextArea ExitClubText = new JTextArea(500,250);
	private JButton ExitClubSure = new JButton("提交申请");
	private JButton ExitClubCancel = new JButton("取消申请");
	private JDialog ExitClubDialog = new JDialog(ClubFrame,"提交成功",true);
	private JLabel ExitClubDialogLabel = new JLabel("申请已提交，请等待管理员审核!");
	private JButton ExitClubDialogSure = new JButton("确定");
	 /*退社审核面板*/
	int Exitflag = 0;
	private JLabel Applicant = new JLabel("申请人");
	private JTextField ApplicantText = new JTextField();
	private JLabel Applicantion = new JLabel("申请理由");
	private JTextArea ApplicantionText = new JTextArea(500,250);
	private JButton PassApplicantion = new JButton("批准申请");
	private JButton RefuseApplicantion = new JButton("拒绝申请");
	/*主窗口退出系统提示窗口*/
	private JDialog ExitFrame = new JDialog(ClubFrame,"退出系统",true);
	private JLabel ExitimgLabel;
	private JLabel ExitLabel = new JLabel("确认退出系统吗？");
	private JButton ExitSure = new JButton("确认");
	private JButton ExitCancel = new JButton("取消");
	/*主窗口退出登录提示窗口*/
	private JDialog ExitLoginFrame = new JDialog(ClubFrame,"退出登录",true);
	private JLabel ExitLoginimgLabel;
	private JLabel ExitLoginLabel = new JLabel("确认退出登录吗？");
	private JButton ExitLoginSure = new JButton("确认");
	private JButton ExitLoginCancel = new JButton("取消");
	/*个人信息面板*/
	int Num = -1;
	private JPanel GenderPanel = new JPanel();
	private JLabel ShowID = new JLabel("学 号:");
	private JTextField ShowIDText = new JTextField(10);
	private JLabel PerName = new JLabel("姓 名:");
	private JTextField PerNameText = new JTextField(5);
	private JLabel Gender = new JLabel("性 别:");
	private ButtonGroup GenderKind = new ButtonGroup();
	private JRadioButton Male = new JRadioButton("男");
	private JRadioButton Female = new JRadioButton("女");
	private JLabel Profession = new JLabel("学 院:");
	private JTextField ProfessionText = new JTextField(10);
	private JLabel Telephone = new JLabel("手 机:");
	private JTextField TelephoneText = new JTextField(11);
	private JLabel QQ = new JLabel("Q Q:");
	private JTextField QQText = new JTextField(10);
	private JLabel JoinTime = new JLabel("入社 时间:");
	private JTextField JoinTimeText = new JTextField(10);
	private JLabel Department = new JLabel("所属 部门:");
	private JTextField DepartmentText = new JTextField(5);
	private JLabel Duty = new JLabel("职 务:");
	private JTextField DutyText = new JTextField(5);
	private JButton PerModify = new JButton("修改");
	private JButton PerSave = new JButton("保存");
	/*社团信息面板*/
	private JLabel ClubName = new JLabel("社团名称:");
	private JTextField ClubNameText = new JTextField(10);
	private JLabel SetTime = new JLabel("成立时间:");
	private JTextField SetTimeText = new JTextField(10);
	private JLabel ClubKind = new JLabel("社团类别:");
	private JTextField ClubKindText = new JTextField(10);
	private JLabel ClubMemNum = new JLabel("社团人数:");
	private JTextField ClubMemNumText = new JTextField(3);
	private JLabel ClubTel = new JLabel("社团联系方式:");
	private JTextField ClubTelText = new JTextField(11);
	private JLabel ClubBoss = new JLabel("社长姓名:");
	private JTextField ClubBossText = new JTextField(10);
	private JLabel ClubCharge2 = new JLabel("第二负责人:");
	private JTextField ClubCharge2Text = new JTextField();
	private JLabel ClubCharge3 = new JLabel("第三负责人:");
	private JTextField ClubCharge3Text = new JTextField();
	private JButton ClubModify = new JButton("修改");
	private JButton ClubSave = new JButton("保存");
	/*社员信息显示面板*/
	private JTable MeminfTable;
	private DefaultTableModel Meminfmodel;
	private String MeminfTableHead[] = {"学号","姓名","性别","学院","手机号","QQ",
			"入社时间","部门","职务"};
	private Object MeminfTabelObject[][];
	private JButton AddMem = new JButton("添加社员");
	private JButton DeleteMem = new JButton("删除社员");
	private JButton SaveModify = new JButton("保存修改");
	private JButton SearchMem = new JButton("查找社员");
	private JLabel SearchName = new JLabel("请输入查找的ID:");
	private JTextField SearchNameText = new JTextField();
	private JLabel MemNumLabel;
	private int MemNum;
	/*社团考评情况面板*/
	private JTable kaopingTable;
	private DefaultTableModel kaopingmodel;
	private String kaopingTableHead[] = {"学号","姓名","考评分(满分100)","综合评价语"};
	private Object kaopingTabelObject[][];
	private JButton givekaoping = new JButton("社员考评");
	private JButton Savekaoping = new JButton("保存考评");
	/*社团公告面板*/
	private JButton issuepost = new JButton("发布新公告");
	private JButton Deletepost = new JButton("删除公告");
	private JLabel Showposttitle = new JLabel("标题");
	private JLabel Showpostmainbody = new JLabel("正文");
	private JTextField ShowposttitleText = new JTextField();
	private JTextArea ShowpostmainbodyText = new JTextArea();
	private JButton previouspost = new JButton("上一页");
	private JButton nextpost = new JButton("下一页");
	private JLabel postnum = new JLabel("当前页数:");
	@SuppressWarnings("rawtypes")
	private JComboBox postnumbox = new JComboBox();
	/*发布公告面板*/
	int Postflag = 0;
	private JLabel posttitle = new JLabel("标题(必填)");
	private JLabel postmainbody = new JLabel("正文(必填,15-250字)");
	private JTextField posttitleText = new JTextField();
	private JTextArea postmainbodyText = new JTextArea();
	private JButton issuepostSure = new JButton("发布公告");
	private JButton issuepostCancel = new JButton("取消发布");
	/*留言群聊面板*/
	private JLabel liuyanLabel = new JLabel("接受留言建议、闲扯聊天，请不要刷屏，不要发表不当的言论！");
	private JTextArea liuyanArea = new JTextArea();
	private JTextField liuyanText = new JTextField();
	private JButton liuyanOK = new JButton("我喊");
	private JButton liuyanCancel = new JButton("清空");
	private Timer count = new Timer();
	/* 登录窗口组件 */
	private JFrame LoginFrame = new JFrame("登录系统");
	private JLabel ID = new JLabel("ID(学号):");
	private JTextField IDText = new JTextField(10);
	private JLabel PassWord = new JLabel("登录密码:");
	private JPasswordField PassWordText = new JPasswordField(10);
	private JButton LoginButton = new JButton("确认登录");
	private JButton ResetButton = new JButton("重新输入");
	private ButtonGroup LoginKind = new ButtonGroup();
	private JRadioButton putong = new JRadioButton("普通用户");
	private JRadioButton guanli = new JRadioButton("管理员用户");
	private JLabel LoginLabel = new JLabel("初始密码即为学号，登陆后请自行修改!");
	/*退社批准提示窗口*/
	private JDialog ExitClubSuccessDialog = new JDialog(ClubFrame,"成功退社",true);
	private JLabel ExitClubSuccessLabel1 = new JLabel("管理员批准了您的退社申请，");
	private JLabel ExitClubSuccessLabel2 = new JLabel("您已退出本社团!");
	private JButton ExitClubSuccessSure = new JButton("确定");
	/*退社拒绝提示窗口*/
	private JDialog ExitClubDefaultDialog = new JDialog(ClubFrame,"申请被拒绝",true);
	private JLabel ExitClubDefaultLabel = new JLabel("管理员拒绝了您的退社申请!");
	private JButton ExitClubDefaultSure = new JButton("确定");
	/*错误窗口组件 */
	private JDialog ErrorFrame = new JDialog(LoginFrame,"错误！",true);
	private JPanel ErrorPanel = new JPanel();
	private JLabel ErrorLabel = new JLabel("ID、密码输入错误或用户选择错误!");
	private JButton ErrorSure = new JButton("确定");
	/*设管理员用户只有三名：社长及两名副社长*/
	/*普通用户数量不确定*/
	private String userArray[][]= new String[20][13];// 存储用户信息
	private String kaopingArray[][] = new String[20][4];//存储考评信息
	private String ExitClubArray[][] = new String[20][2];//存储退社信息
	private String ClubpostArray[][] = new String[20][2];//存储公告信息
	private String liuyanArray[] = new String[20];
	/*存储社团信息的数组*/
	private String ClubArray[] = new String[8];
	public static void main(String args[]) {
		display a = new display();
		a.ClubSystem();
	}
	//计时刷新类继承TimeTask类
	class NFDFlightDataTimerTask extends TimerTask{ 
	    @Override 
	    //此方法为具体要定时操作的方法  
	    public void run() { 
	     FileRead();
	     Setliuyan();
	    } 
	} 
	void ClubSystem(){
		FileRead();//文件读取
		init();//初始化布局
		monitor();//实现监听
		NFDFlightDataTimerTask task = new NFDFlightDataTimerTask();
	      //安排指定的任务在指定的时间开始进行重复的固定延迟执行。  
	              count.schedule(task,new Date(),100); 
	}
	/*对各窗口、面板进行初始化布局等*/
	void init(){
		/*主窗口初始化*/
		ClubFrame.setSize(800, 600);//主窗口大小
		ClubFrame.setVisible(false);//设置为不可见
		ClubFrame.setResizable(false);//大小不可调整
		ClubFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ClubFrame.setLocationRelativeTo(null);
		ClubFrame.setLayout(null);//主窗口使用null布局
		ImageIcon maintubiao = new ImageIcon("主图标.jpg");//设置系统图标
		ClubFrame.setIconImage(maintubiao.getImage());
        /*功能导航面板*/
		daohangPanel.setLayout(card1);//使用层叠型组件
		daohangPanel.setOpaque(false);
        putongPanel.setOpaque(false);
        putongPanel.setLayout(null);//null
        daohangPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        ClubSystem.setFont(new Font("ClubSystem",Font.BOLD, 15));
        putongPanel.add(ClubSystem);
        ClubSystem.setBounds(0, 0, 70, 20);
        ModifyPassword.setFont(new Font("ModifyPassword",Font.BOLD, 15));
        ModifyPassword.setContentAreaFilled(false);
        ModifyPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        putongPanel.add(ModifyPassword);
        ModifyPassword.setBounds(10, 25, 130, 30);
        ExitClub.setFont(new Font("ExitClub",Font.BOLD, 15));
        ExitClub.setContentAreaFilled(false);
        ExitClub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        putongPanel.add(ExitClub);
        ExitClub.setBounds(10, 60, 130, 30);
        ExitLogin.setFont(new Font("ExitLogin",Font.BOLD, 15));
        ExitLogin.setContentAreaFilled(false);
        ExitLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        putongPanel.add(ExitLogin);
        ExitLogin.setBounds(10, 95, 130, 30);
        ExitSystem.setFont(new Font("ExitSystem",Font.BOLD, 15));
        ExitSystem.setContentAreaFilled(false);
        ExitSystem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        putongPanel.add(ExitSystem);
        ExitSystem.setBounds(10, 130, 130, 30);
        InfView.setFont(new Font("InfView",Font.BOLD, 15));
        putongPanel.add(InfView);
        InfView.setBounds(0, 165, 70, 20);
        Perinf.setFont(new Font("Perinf",Font.BOLD, 15));
        Perinf.setContentAreaFilled(false);
        Perinf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        putongPanel.add(Perinf);
        Perinf.setBounds(10, 190, 130, 30);
        Clubinf.setFont(new Font("Clubinf",Font.BOLD, 15));
        Clubinf.setContentAreaFilled(false);
        Clubinf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        putongPanel.add(Clubinf);
        Clubinf.setBounds(10, 225, 130, 30);
        Meminf.setFont(new Font("Meminf",Font.BOLD, 15));
        Meminf.setContentAreaFilled(false);
        Meminf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        putongPanel.add(Meminf);
        Meminf.setBounds(10, 260, 130, 30);
        ClubAct.setFont(new Font("ClubAct",Font.BOLD, 15));
        putongPanel.add(ClubAct);
        ClubAct.setBounds(0, 295, 70, 20);
        kaoping.setFont(new Font("kaoping",Font.BOLD, 15));
        kaoping.setContentAreaFilled(false);
        kaoping.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        putongPanel.add(kaoping);
        kaoping.setBounds(10, 320, 130, 30);
        Clubpost.setFont(new Font("Clubpost",Font.BOLD, 15));
        Clubpost.setContentAreaFilled(false);
        Clubpost.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        putongPanel.add(Clubpost);
        Clubpost.setBounds(10, 355, 130, 30);
        liuyan.setFont(new Font("liuyan",Font.BOLD, 15));
        liuyan.setContentAreaFilled(false);
        liuyan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        putongPanel.add(liuyan);
        liuyan.setBounds(10, 390, 130, 30);
//        next.setFont(new Font("next",Font.BOLD, 15));
//        next.setContentAreaFilled(false);
//        next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        putongPanel.add(next);
//        next.setBounds(10, 370, 130, 30);
        guanliPanel.setOpaque(false);
        guanliPanel.setLayout(null);//null
        last.setFont(new Font("last",Font.BOLD, 15));
        last.setContentAreaFilled(false);
        last.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        guanliPanel.add(last);
        last.setBounds(10, 120, 130, 30);
        ClubFrame.add(daohangPanel);
        daohangPanel.setBounds(0, 100, 150, 500);
        daohangPanel.add("putongPanel",putongPanel);
        daohangPanel.add("guanliPanel",guanliPanel);
        /*时间面板布局，每秒钟更新一次当前时间重新赋值给TimeLabel*/
        t.scheduleAtFixedRate(new TimerTask() {
        	public void run() {
        	TimeLabel.setText(format.format(new Date(System.currentTimeMillis())));
        	TimeLabel.setFont(new Font("Time",Font.BOLD, 20));//设置时间标签字体大小
        	}
        	}, 0, 1000);
        TimePanel.add(TimeLabel);
        TimeLabel.setBounds(120, 0, 600, 30);
        ClubFrame.add(TimePanel);
        TimePanel.setOpaque(false);
        TimePanel.setLayout(null);
        TimePanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        TimePanel.setBounds(150, 0, 650, 100);
        /*主显示面板*/
        mainPanel.setLayout(card2);//使用层叠型组件
		mainPanel.setOpaque(false);
		mainPanel.setBorder(BorderFactory.createEtchedBorder());
		ClubFrame.add(mainPanel);
		mainPanel.setBounds(150, 100, 650, 500);
        /*修改密码面板*/
        ModifyPWPanel.setLayout(null);
        OldPWLabel.setFont(new Font("OldPWLabel",Font.BOLD, 15));
        ModifyPWPanel.add(OldPWLabel);
        OldPWLabel.setBounds(100, 100, 90, 30);
        OldPWLabelText.setFont(new Font("OldPWLabelText",Font.BOLD, 15));
        ModifyPWPanel.add(OldPWLabelText);
        OldPWLabelText.setBounds(200, 100, 200, 30);
        NewPWLabel.setFont(new Font("NewPWLabel",Font.BOLD, 15));
        ModifyPWPanel.add(NewPWLabel);
        NewPWLabel.setBounds(100, 140, 90, 30);
        NewPWLabelText.setFont(new Font("NewPWLabelText",Font.BOLD, 15));
        ModifyPWPanel.add(NewPWLabelText);
        NewPWLabelText.setBounds(200, 140, 200, 30);
        ConfirmPWLabel.setFont(new Font("ConfirmPWLabel",Font.BOLD, 15));
        ModifyPWPanel.add(ConfirmPWLabel);
        ConfirmPWLabel.setBounds(100, 180, 90, 30); 
        ConfirmPWLabelText.setFont(new Font("ConfirmPWLabelText",Font.BOLD, 15));
        ModifyPWPanel.add(ConfirmPWLabelText);
        ConfirmPWLabelText.setBounds(200, 180, 200, 30);
        ModifyPWSure.setFont(new Font("ModifyPWSure",Font.BOLD, 15));
        ModifyPWPanel.add(ModifyPWSure);
        ModifyPWSure.setBounds(170, 220, 100, 30); 
        ModifyPWCancel.setFont(new Font("ModifyPWCancel",Font.BOLD, 15));
        ModifyPWPanel.add(ModifyPWCancel);
        ModifyPWCancel.setBounds(290, 220, 100, 30);
        mainPanel.add("ModifyPWPanel", ModifyPWPanel);
        ModifyPWSuccess.setSize(300,200);
        ModifyPWSuccess.setResizable(false);
        ModifyPWSuccess.setVisible(false);
        ModifyPWSuccess.setLocationRelativeTo(null);
        ModifyPWSuccess.setLayout(null);
        ModifyPWSuccess.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ModifyPWSuccessLabel.setFont(new Font("ModifyPWSuccessLabel",Font.BOLD, 15));
        ModifyPWSuccess.add(ModifyPWSuccessLabel);
        ModifyPWSuccessLabel.setBounds(90, 50, 100, 30);
        ModifyPWSuccessClose.setFont(new Font("ModifyPWSuccessClose",Font.BOLD, 15));
        ModifyPWSuccess.add(ModifyPWSuccessClose);
        ModifyPWSuccessClose.setBounds(90, 130, 100, 30);
        ModifyPWError.setSize(300,200);
        ModifyPWError.setResizable(false);
        ModifyPWError.setVisible(false);
        ModifyPWError.setLocationRelativeTo(null);
        ModifyPWError.setLayout(null);
        ModifyPWError.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ModifyPWErrorLabel.setFont(new Font("ModifyPWErrorLabel",Font.BOLD, 15));
        ModifyPWError.add(ModifyPWErrorLabel);
        ModifyPWErrorLabel.setBounds(90, 50, 100, 30);
        ModifyPWErrorClose.setFont(new Font("ModifyPWErrorClose",Font.BOLD, 15));
        ModifyPWError.add(ModifyPWErrorClose);
        ModifyPWErrorClose.setBounds(90, 130, 100, 30);
        /*申请退社面板*/
        ExitClubPanel.setLayout(null);
        ExitClubcheck.setFont(new Font("ExitClubcheck",Font.BOLD, 15));
        ExitClubcheck.setContentAreaFilled(false);
        ExitClubcheck.setVisible(false);
        ExitClubcheck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ExitClubPanel.add(ExitClubcheck);
        ExitClubcheck.setBounds(420, 40, 130, 30);
        ExitClubLabel.setFont(new Font("ExitClubLabel",Font.BOLD, 15));
        ExitClubPanel.add(ExitClubLabel);
        ExitClubLabel.setBounds(100, 80, 450, 30);
        ExitClubText.setFont(new Font("ExitClubText",Font.PLAIN, 15));
        ExitClubText.setLineWrap(true);//自动换行
        ExitClubText.setBorder(BorderFactory.createEtchedBorder());//边框设置
        ExitClubPanel.add(ExitClubText);
        ExitClubText.setBounds(100, 120, 450, 250);
        ExitClubSure.setFont(new Font("ExitClubSure",Font.BOLD, 15));
        ExitClubPanel.add(ExitClubSure);
        ExitClubSure.setBounds(100, 380, 220, 30);
        ExitClubCancel.setFont(new Font("ExitClubCancel",Font.BOLD, 15));
        ExitClubPanel.add(ExitClubCancel);
        ExitClubCancel.setBounds(330, 380, 220, 30);
        mainPanel.add("ExitClubPanel", ExitClubPanel);
        ExitClubDialog.setSize(300, 200);
        ExitClubDialog.setResizable(false);
        ExitClubDialog.setVisible(false);
        ExitClubDialog.setLocationRelativeTo(null);
        ExitClubDialog.setLayout(null);
        ExitClubDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ExitClubDialogLabel.setFont(new Font("ExitClubDialogLabel",Font.BOLD, 15));
        ExitClubDialog.add(ExitClubDialogLabel);
        ExitClubDialogLabel.setBounds(30, 50, 250, 30);
        ExitClubDialogSure.setFont(new Font("ExitClubDialogSure",Font.BOLD, 15));
        ExitClubDialog.add(ExitClubDialogSure);
        ExitClubDialogSure.setBounds(90, 130, 100, 30);
        /*退社审核面板*/
        ExitClubcheckPanel.setLayout(null);
        Applicant.setFont(new Font("Applicant",Font.BOLD, 15));
        ExitClubcheckPanel.add(Applicant);
		Applicant.setBounds(100, 50, 450, 30);
		ApplicantText.setFont(new Font("ApplicantText",Font.PLAIN, 15));
		ApplicantText.setEditable(false);
		ExitClubcheckPanel.add(ApplicantText);
		ApplicantText.setBounds(100, 90, 450, 30);
		Applicantion.setFont(new Font("Applicantion",Font.BOLD, 15));
		ExitClubcheckPanel.add(Applicantion);
		Applicantion.setBounds(100, 130, 450, 30);
		ApplicantionText.setFont(new Font("ApplicantionText",Font.PLAIN, 15));
		ApplicantionText.setEditable(false);
		ApplicantionText.setBorder(BorderFactory.createEtchedBorder());
		ApplicantionText.setLineWrap(true);//自动换行
		ExitClubcheckPanel.add(ApplicantionText);
		ApplicantionText.setBounds(100, 170, 450, 200);
		PassApplicantion.setFont(new Font("PassApplicantion",Font.BOLD, 15));
		ExitClubcheckPanel.add(PassApplicantion);
		PassApplicantion.setBounds(100, 380, 220, 30);
		RefuseApplicantion.setFont(new Font("RefuseApplicantion",Font.BOLD, 15));
		ExitClubcheckPanel.add(RefuseApplicantion);
		RefuseApplicantion.setBounds(330, 380, 220, 30);
		mainPanel.add("ExitClubcheckPanel", ExitClubcheckPanel);
		/*退社批准窗口*/
		ExitClubSuccessDialog.setSize(300, 200);
		ExitClubSuccessDialog.setVisible(false);
		ExitClubSuccessDialog.setResizable(false);
		ExitClubSuccessDialog.setLocationRelativeTo(null);
		ExitClubSuccessDialog.setLayout(null);
		ExitClubSuccessDialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ExitClubSuccessLabel1.setFont(new Font("ExitClubSuccessLabel1",Font.BOLD, 15));
		ExitClubSuccessDialog.add(ExitClubSuccessLabel1);
		ExitClubSuccessLabel1.setBounds(50, 20, 250, 30);
		ExitClubSuccessLabel2.setFont(new Font("ExitClubSuccessLabel2",Font.BOLD, 15));
		ExitClubSuccessDialog.add(ExitClubSuccessLabel2);
		ExitClubSuccessLabel2.setBounds(50, 60, 250, 30);
		ExitClubSuccessSure.setFont(new Font("ExitClubSuccessSure",Font.BOLD, 15));
		ExitClubSuccessDialog.add(ExitClubSuccessSure);
		ExitClubSuccessSure.setBounds(100, 100, 100, 30);
		/*退社拒绝窗口*/
		ExitClubDefaultDialog.setSize(300, 200);
		ExitClubDefaultDialog.setVisible(false);
		ExitClubDefaultDialog.setResizable(false);
		ExitClubDefaultDialog.setLocationRelativeTo(null);
		ExitClubDefaultDialog.setLayout(null);
		ExitClubDefaultDialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ExitClubDefaultLabel.setFont(new Font("ExitClubDefaultLabel",Font.BOLD, 15));
		ExitClubDefaultDialog.add(ExitClubDefaultLabel);
		ExitClubDefaultLabel.setBounds(50, 50, 250, 30);
		ExitClubDefaultSure.setFont(new Font("ExitClubDefaultSure",Font.BOLD, 15));
		ExitClubDefaultDialog.add(ExitClubDefaultSure);
		ExitClubDefaultSure.setBounds(100, 100, 100, 30);
        /*主窗口退出提示窗口*/
        ExitFrame.setSize(300, 200);
        ExitFrame.setVisible(false);
        ExitFrame.setResizable(false);
        ExitFrame.setLocationRelativeTo(null);
        ExitFrame.setLayout(null);
        ImageIcon Exitimg = new ImageIcon("Exitimg.png");
        ExitimgLabel = new JLabel(Exitimg);
        ExitFrame.add(ExitimgLabel);
        ExitimgLabel.setBounds(20, 20, 30, 30);
        ExitLabel.setFont(new Font("ExitLabel",Font.BOLD, 15));
        ExitFrame.add(ExitLabel);
        ExitLabel.setBounds(60, 20, 200, 20);
        ExitSure.setFont(new Font("ExitSure",Font.BOLD, 15));
        ExitFrame.add(ExitSure);
        ExitSure.setBounds(50, 130, 100, 30);
        ExitCancel.setFont(new Font("ExitCancel",Font.BOLD, 15));
        ExitFrame.add(ExitCancel);
        ExitCancel.setBounds(160, 130, 100, 30);
        /*主窗口退出登录提示窗口*/
        ExitLoginFrame.setSize(300, 200);
        ExitLoginFrame.setVisible(false);
        ExitLoginFrame.setResizable(false);
        ExitLoginFrame.setLocationRelativeTo(null);
        ExitLoginFrame.setLayout(null);
        ImageIcon ExitLoginimg = new ImageIcon("Exitimg.png");
        ExitLoginimgLabel = new JLabel(ExitLoginimg);
        ExitLoginFrame.add(ExitLoginimgLabel);
        ExitLoginimgLabel.setBounds(20, 20, 30, 30);
        ExitLoginLabel.setFont(new Font("ExitLoginLabel",Font.BOLD, 15));
        ExitLoginFrame.add(ExitLoginLabel);
        ExitLoginLabel.setBounds(60, 20, 200, 20);
        ExitLoginSure.setFont(new Font("ExitLoginSure",Font.BOLD, 15));
        ExitLoginFrame.add(ExitLoginSure);
        ExitLoginSure.setBounds(50, 130, 100, 30);
        ExitLoginCancel.setFont(new Font("ExitLoginCancel",Font.BOLD, 15));
        ExitLoginFrame.add(ExitLoginCancel);
        ExitLoginCancel.setBounds(160, 130, 100, 30);
		/*个人信息面板*/
        ShowID.setFont(new Font("ShowID",Font.BOLD, 15));
		PerinfPanel.add(ShowID);
		ShowID.setBounds(100, 10, 100, 30);
		PerName.setFont(new Font("PerName",Font.BOLD, 15));
		PerinfPanel.add(PerName);
		PerName.setBounds(100, 50, 100, 30);
		Gender.setFont(new Font("Gender",Font.BOLD, 15));
		PerinfPanel.add(Gender);
		Gender.setBounds(100, 90, 100, 30);
		Profession.setFont(new Font("Profession",Font.BOLD, 15));
		PerinfPanel.add(Profession);
		Profession.setBounds(100, 130, 100, 30);
		Telephone.setFont(new Font("Telephone",Font.BOLD, 15));
		PerinfPanel.add(Telephone);
		Telephone.setBounds(100, 170, 100, 30);
		QQ.setFont(new Font("QQ",Font.BOLD, 15));
		PerinfPanel.add(QQ);
		QQ.setBounds(100, 210, 100, 30);
		JoinTime.setFont(new Font("JoinTime",Font.BOLD, 15));
		PerinfPanel.add(JoinTime);
		JoinTime.setBounds(100, 250, 100, 30);
		Department.setFont(new Font("Department",Font.BOLD, 15));
		PerinfPanel.add(Department);
		Department.setBounds(100, 290, 100, 30);
		Duty.setFont(new Font("Duty",Font.BOLD, 15));
		PerinfPanel.add(Duty);
		Duty.setBounds(100, 330, 100, 30);
		ShowIDText.setFont(new Font("ShowIDText",Font.PLAIN, 15));
		PerinfPanel.add(ShowIDText);
		ShowIDText.setBounds(210, 10, 200, 30);
		PerNameText.setFont(new Font("PerNameText",Font.PLAIN, 15));
		PerinfPanel.add(PerNameText);
		PerNameText.setBounds(210, 50, 200, 30);
		GenderKind.add(Male);
		GenderKind.add(Female);
		GenderPanel.add(Male);
		GenderPanel.add(Female);
		GenderPanel.setFont(new Font("GenderPanel",Font.PLAIN, 15));
		PerinfPanel.add(GenderPanel);
		GenderPanel.setBounds(210, 90, 200, 30);
		ProfessionText.setFont(new Font("ProfessionText",Font.PLAIN, 15));
		PerinfPanel.add(ProfessionText);
		ProfessionText.setBounds(210, 130, 200, 30);
		TelephoneText.setFont(new Font("TelephoneText",Font.PLAIN, 15));
		PerinfPanel.add(TelephoneText);
		TelephoneText.setBounds(210, 170, 200, 30);
		QQText.setFont(new Font("QQText",Font.PLAIN, 15));
		PerinfPanel.add(QQText);
		QQText.setBounds(210, 210, 200, 30);
		JoinTimeText.setFont(new Font("JoinTimeText",Font.PLAIN, 15));
		PerinfPanel.add(JoinTimeText);
		JoinTimeText.setBounds(210, 250, 200, 30);
		DepartmentText.setFont(new Font("DepartmentText",Font.PLAIN, 15));
		PerinfPanel.add(DepartmentText);
		DepartmentText.setBounds(210, 290, 200, 30);
		DutyText.setFont(new Font("DutyText",Font.PLAIN, 15));
		PerinfPanel.add(DutyText);
		DutyText.setBounds(210, 330, 200, 30);
		PerModify.setFont(new Font("PerModify",Font.BOLD, 15));	
		PerinfPanel.add(PerModify);
		PerModify.setBounds(100, 400, 150, 30);
		PerSave.setEnabled(false);
		PerSave.setFont(new Font("PerSave",Font.BOLD, 15));
		PerinfPanel.add(PerSave);
		PerSave.setBounds(260, 400, 150, 30);
		PerinfPanel.setLayout(null);
		mainPanel.add("PerinfPanel", PerinfPanel);
		/*社团信息面板*/
		ClubinfPanel.setLayout(null);
		ClubName.setFont(new Font("ClubName",Font.BOLD, 15));
		ClubinfPanel.add(ClubName);
		ClubName.setBounds(100, 10, 100, 30);
		SetTime.setFont(new Font("SetTime",Font.BOLD, 15));
		ClubinfPanel.add(SetTime);
		SetTime.setBounds(100, 50, 100, 30);
		ClubKind.setFont(new Font("ClubKind",Font.BOLD, 15));
		ClubinfPanel.add(ClubKind);
		ClubKind.setBounds(100, 90, 100, 30);
		ClubMemNum.setFont(new Font("ClubMemNum",Font.BOLD, 15));
		ClubinfPanel.add(ClubMemNum);
		ClubMemNum.setBounds(100, 130, 100, 30);
		ClubTel.setFont(new Font("ClubTel",Font.BOLD, 15));
		ClubinfPanel.add(ClubTel);
		ClubTel.setBounds(100, 170, 100, 30);
		ClubBoss.setFont(new Font("ClubBoss",Font.BOLD, 15));
		ClubinfPanel.add(ClubBoss);
		ClubBoss.setBounds(100, 210, 100, 30);
		ClubCharge2.setFont(new Font("ClubCharge2",Font.BOLD, 15));
		ClubinfPanel.add(ClubCharge2);
		ClubCharge2.setBounds(100, 250, 100, 30);
		ClubCharge3.setFont(new Font("ClubCharge3",Font.BOLD, 15));
		ClubinfPanel.add(ClubCharge3);
		ClubCharge3.setBounds(100, 290, 100, 30);
		ClubNameText.setFont(new Font("ClubNameText",Font.PLAIN, 15));
		ClubinfPanel.add(ClubNameText);
		ClubNameText.setBounds(210, 10, 200, 30);
		SetTimeText.setFont(new Font("SetTimeText",Font.PLAIN, 15));
		ClubinfPanel.add(SetTimeText);
		SetTimeText.setBounds(210, 50, 200, 30);
		ClubKindText.setFont(new Font("ClubKindText",Font.PLAIN, 15));
		ClubinfPanel.add(ClubKindText);
		ClubKindText.setBounds(210, 90, 200, 30);
		ClubMemNumText.setFont(new Font("ClubMemNumText",Font.PLAIN, 15));
		ClubinfPanel.add(ClubMemNumText);
		ClubMemNumText.setBounds(210, 130, 200, 30);
		ClubTelText.setFont(new Font("ClubTelText",Font.PLAIN, 15));
		ClubinfPanel.add(ClubTelText);
		ClubTelText.setBounds(210, 170, 200, 30);
		ClubBossText.setFont(new Font("ClubBossText",Font.PLAIN, 15));
		ClubinfPanel.add(ClubBossText);
		ClubBossText.setBounds(210, 210, 200, 30);
		ClubCharge2Text.setFont(new Font("ClubCharge2Text",Font.PLAIN, 15));
		ClubinfPanel.add(ClubCharge2Text);
		ClubCharge2Text.setBounds(210, 250, 200, 30);
		ClubCharge3Text.setFont(new Font("ClubCharge3Text",Font.PLAIN, 15));
		ClubinfPanel.add(ClubCharge3Text);
		ClubCharge3Text.setBounds(210, 290, 200, 30);
		ClubModify.setFont(new Font("ClubModify",Font.BOLD, 15));
		ClubModify.setEnabled(false);
		ClubinfPanel.add(ClubModify);
		ClubModify.setBounds(100, 400, 150, 30);
		ClubSave.setEnabled(false);
		ClubSave.setFont(new Font("ClubSave",Font.BOLD, 15));
		ClubinfPanel.add(ClubSave);
		ClubSave.setBounds(260, 400, 150, 30);
		mainPanel.add("ClubinfPanel", ClubinfPanel);
		/*社团公告面板*/
		ClubpostPanel.setLayout(null);
		Deletepost.setFont(new Font("Deletepost",Font.BOLD, 15));
		Deletepost.setContentAreaFilled(false);
		Deletepost.setVisible(false);
		Deletepost.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ClubpostPanel.add(Deletepost);
        Deletepost.setBounds(280, 10, 130, 30);
		issuepost.setFont(new Font("issuepost",Font.BOLD, 15));
        issuepost.setContentAreaFilled(false);
        issuepost.setVisible(false);
        issuepost.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ClubpostPanel.add(issuepost);
        issuepost.setBounds(420, 10, 130, 30);
		Showposttitle.setFont(new Font("Showposttitle",Font.BOLD, 15));
		ClubpostPanel.add(Showposttitle);
		Showposttitle.setBounds(100, 50, 200, 30);
		ShowposttitleText.setFont(new Font("ShowposttitleText",Font.PLAIN, 15));
		ShowposttitleText.setEditable(false);
		ClubpostPanel.add(ShowposttitleText);
		ShowposttitleText.setBounds(100, 90, 450, 30);
		Showpostmainbody.setFont(new Font("Showpostmainbody",Font.BOLD, 15));
		ClubpostPanel.add(Showpostmainbody);
		Showpostmainbody.setBounds(100, 130, 200, 30);
		ShowpostmainbodyText.setFont(new Font("ShowpostmainbodyText",Font.PLAIN, 15));
		ShowpostmainbodyText.setEditable(false);
		ShowpostmainbodyText.setBorder(BorderFactory.createEtchedBorder());
		ShowpostmainbodyText.setLineWrap(true);//自动换行
		ClubpostPanel.add(ShowpostmainbodyText);
		ShowpostmainbodyText.setBounds(100, 170, 450, 200);
		previouspost.setFont(new Font("previouspost",Font.BOLD, 15));
		ClubpostPanel.add(previouspost);
		previouspost.setBounds(100, 380, 150, 30);
		postnum.setFont(new Font("postnum",Font.BOLD, 15));
		ClubpostPanel.add(postnum);
		postnum.setBounds(260, 380, 70, 30);
		postnumbox.setFont(new Font("postnumbox",Font.BOLD, 15));
		ClubpostPanel.add(postnumbox);
		postnumbox.setBounds(340, 380, 50, 30);
		nextpost.setFont(new Font("nextpost",Font.BOLD, 15));
		ClubpostPanel.add(nextpost);
		nextpost.setBounds(400, 380, 150, 30);
		mainPanel.add("ClubpostPanel", ClubpostPanel);
        /*发布公告面板*/
        issuepostPanel.setLayout(null);
        posttitle.setFont(new Font("posttitle",Font.BOLD, 15));
		issuepostPanel.add(posttitle);
		posttitle.setBounds(100, 50, 450, 30);
		posttitleText.setFont(new Font("posttitleText",Font.PLAIN, 15));
		issuepostPanel.add(posttitleText);
		posttitleText.setBounds(100, 90, 450, 30);
		postmainbody.setFont(new Font("postmainbody",Font.BOLD, 15));
		issuepostPanel.add(postmainbody);
		postmainbody.setBounds(100, 130, 450, 30);
		postmainbodyText.setFont(new Font("postmainbodyText",Font.PLAIN, 15));
		postmainbodyText.setBorder(BorderFactory.createEtchedBorder());
		postmainbodyText.setLineWrap(true);//自动换行
		issuepostPanel.add(postmainbodyText);
		postmainbodyText.setBounds(100, 170, 450, 200);
		issuepostSure.setFont(new Font("issuepostSure",Font.BOLD, 15));
		issuepostPanel.add(issuepostSure);
		issuepostSure.setBounds(100, 380, 220, 30);
		issuepostCancel.setFont(new Font("issuepostCancel",Font.BOLD, 15));
		issuepostPanel.add(issuepostCancel);
		issuepostCancel.setBounds(330, 380, 220, 30);
		mainPanel.add("issuepostPanel", issuepostPanel);
		/*留言群聊面板*/
		liuyanPanel.setLayout(null);
		liuyanLabel.setFont(new Font("liuyanLabel",Font.BOLD, 15));
		liuyanPanel.add(liuyanLabel);
		liuyanLabel.setBounds(10,10, 640, 30);
		liuyanArea.setFont(new Font("liuyanArea",Font.BOLD, 15));
		liuyanArea.setBorder(BorderFactory.createEtchedBorder());
		liuyanArea.setLineWrap(true);//自动换行
		liuyanArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(liuyanArea);//添加滚动条
		//滚动条自动出现
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		liuyanPanel.add(scroll);
		scroll.setBounds(10, 50, 620, 300);
		liuyanText.setFont(new Font("liuyanText",Font.BOLD, 15));
		liuyanPanel.add(liuyanText);
		liuyanText.setBounds(10, 360, 400, 30);
		liuyanOK.setFont(new Font("liuyanOK",Font.BOLD, 15));
		liuyanPanel.add(liuyanOK);
		liuyanOK.setBounds(420, 360, 100, 30);
		liuyanCancel.setFont(new Font("liuyanCancel",Font.BOLD, 15));
		liuyanPanel.add(liuyanCancel);
		liuyanCancel.setBounds(530, 360, 100, 30);
		mainPanel.add("liuyanPanel", liuyanPanel);
		/*登录窗口初始化*/
		LoginFrame.setSize(400, 300);//登录窗口大小
		LoginFrame.setVisible(true);//设置为可见
		LoginFrame.setResizable(false);//设置为大小不可调整
		LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginFrame.setLocationRelativeTo(null);
		LoginFrame.setLayout(null);
		ImageIcon Logintubiao = new ImageIcon("登陆图标.png");//设置系统图标
		LoginFrame.setIconImage(Logintubiao.getImage());
		ID.setFont(new Font("ID",Font.BOLD, 15));
		LoginFrame.add(ID);
		ID.setBounds(50, 60, 70, 20);
		PassWord.setFont(new Font("PassWord",Font.BOLD, 15));
		LoginFrame.add(PassWord);
		PassWord.setBounds(50, 100, 70, 20);
		IDText.setFont(new Font("IDText",Font.PLAIN, 15));
		LoginFrame.add(IDText);
		IDText.setBounds(130, 50, 200, 30);
		PassWordText.setFont(new Font("PassWordText",Font.PLAIN, 15));
		LoginFrame.add(PassWordText);
		PassWordText.setBounds(130, 90, 200, 30);
		LoginKind.add(putong);
		LoginKind.add(guanli);
		putong.setFont(new Font("putong",Font.BOLD, 15));
		LoginFrame.add(putong);
		putong.setBounds(80, 130, 100, 20);
		guanli.setFont(new Font("guanli",Font.BOLD, 15));
		LoginFrame.add(guanli);
		guanli.setBounds(200, 130, 120, 20);
		LoginButton.setFont(new Font("LoginButton",Font.BOLD, 15));
		LoginFrame.add(LoginButton);
		LoginButton.setBounds(80, 170, 100, 30);
		ResetButton.setFont(new Font("ResetButton",Font.BOLD, 15));
		LoginFrame.add(ResetButton);
		ResetButton.setBounds(200, 170, 100, 30);
		LoginLabel.setFont(new Font("LoginLabel",Font.BOLD, 15));
		LoginFrame.add(LoginLabel);
		LoginLabel.setBounds(50, 220, 400, 20);
		/*错误窗口初始化*/
		ErrorFrame.setSize(220, 130);//错误窗口大小
		ErrorFrame.setVisible(false);//设置为不可见
		ErrorFrame.setResizable(false);
		ErrorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ErrorFrame.setLocationRelativeTo(null);
		ErrorLabel.setSize(100, 10);
		ErrorFrame.add(ErrorLabel,BorderLayout.CENTER);
		ErrorSure.setSize(100, 20);
		ErrorPanel.add(ErrorSure);
		ErrorFrame.add(ErrorPanel,BorderLayout.SOUTH);
	}
	/*社员信息面板*/
	void MeminfShow(){
		MemNum = 0;
		MeminfPanel.setLayout(null);
		MeminfTabelObject = new String[userArray.length][9];
		for(int i=0; i<userArray.length; i++){//得到用户的9项信息
			if(userArray[i][0] != null){
				MemNum++;
			MeminfTabelObject[i][0] =  userArray[i][0];
			MeminfTabelObject[i][1] =  userArray[i][2];
			MeminfTabelObject[i][2] =  userArray[i][3];
			MeminfTabelObject[i][3] =  userArray[i][4];
			MeminfTabelObject[i][4] =  userArray[i][5];
			MeminfTabelObject[i][5] =  userArray[i][6];
			MeminfTabelObject[i][6] =  userArray[i][7];
			MeminfTabelObject[i][7] =  userArray[i][8];
			MeminfTabelObject[i][8] =  userArray[i][9];
			}
		}
		Meminfmodel = new DefaultTableModel(MeminfTabelObject, MeminfTableHead);
		MeminfTable = new JTable(Meminfmodel);//将信息与表头装到表中
		/*设置符合大小的列宽*/
		MeminfTable.getColumn(MeminfTableHead[0]).setPreferredWidth(75);
		MeminfTable.getColumn(MeminfTableHead[1]).setPreferredWidth(40);
		MeminfTable.getColumn(MeminfTableHead[2]).setPreferredWidth(25);
		MeminfTable.getColumn(MeminfTableHead[3]).setPreferredWidth(75);
		MeminfTable.getColumn(MeminfTableHead[4]).setPreferredWidth(90);
		MeminfTable.getColumn(MeminfTableHead[5]).setPreferredWidth(80);
		MeminfTable.getColumn(MeminfTableHead[6]).setPreferredWidth(75);
		MeminfTable.getColumn(MeminfTableHead[7]).setPreferredWidth(45);
		MeminfTable.getColumn(MeminfTableHead[8]).setPreferredWidth(50);
		MeminfTable.setRowHeight(25);
		MeminfTable.setEnabled(false);//不可编辑
		MeminfTable.getTableHeader().setReorderingAllowed(false);//不可整列移动   
		MeminfTable.getTableHeader().setResizingAllowed(false);//不可拉动表格
		MemNumLabel = new JLabel("本社团共有  "+MemNum+"  人");
		JScrollPane Meminftable = new JScrollPane(MeminfTable);//定义一个带表头的表格
		MeminfPanel.add(Meminftable);
		Meminftable.setBounds(0, 80, 650, 300);
		MemNumLabel.setFont(new Font("MemNumLabel",Font.BOLD, 15));
		MeminfPanel.add(MemNumLabel);
		MemNumLabel.setBounds(0, 0, 150, 30);
		SearchName.setFont(new Font("SearchName",Font.BOLD, 15));
		MeminfPanel.add(SearchName);
		SearchName.setBounds(100, 40, 150, 30);
		SearchNameText.setFont(new Font("SearchNameText",Font.PLAIN, 15));
		MeminfPanel.add(SearchNameText);
		SearchNameText.setBounds(250, 40, 150, 30);
		SearchMem.setFont(new Font("SearchMem",Font.BOLD, 15));
		MeminfPanel.add(SearchMem);
		SearchMem.setBounds(410, 40, 150, 30);
		AddMem.setFont(new Font("AddMem",Font.BOLD, 15));
		AddMem.setVisible(false);
		MeminfPanel.add(AddMem);
		AddMem.setBounds(100, 390, 150, 30);		
		DeleteMem.setFont(new Font("DeleteMem",Font.BOLD, 15));
		DeleteMem.setVisible(false);
		MeminfPanel.add(DeleteMem);
		DeleteMem.setBounds(260, 390, 150, 30);
		SaveModify.setFont(new Font("ModifyMem",Font.BOLD, 15));
		SaveModify.setVisible(false);
		MeminfPanel.add(SaveModify);
		SaveModify.setBounds(420, 390, 150, 30);
		mainPanel.add("MeminfPanel", MeminfPanel);
	}
	/*考评情况面板*/
	void kaopingShow(){
		kaopingPanel.setLayout(null);
		kaopingTabelObject = new String[kaopingArray.length][4];
		for(int i=0; i<kaopingArray.length; i++){//得到考评信息的4项信息
			if(kaopingArray[i][0] != null){
			kaopingTabelObject[i][0] =  kaopingArray[i][0];
			kaopingTabelObject[i][1] =  kaopingArray[i][1];
			kaopingTabelObject[i][2] =  kaopingArray[i][2];
			kaopingTabelObject[i][3] =  kaopingArray[i][3];
			}
		}
		kaopingmodel = new DefaultTableModel(kaopingTabelObject, kaopingTableHead);
		kaopingTable = new JTable(kaopingmodel);//将信息与表头装到表中
		/*设置符合大小的列宽*/
		kaopingTable.getColumn(kaopingTableHead[0]).setPreferredWidth(75);
		kaopingTable.getColumn(kaopingTableHead[1]).setPreferredWidth(50);
		kaopingTable.getColumn(kaopingTableHead[2]).setPreferredWidth(100);
		kaopingTable.getColumn(kaopingTableHead[3]).setPreferredWidth(450);
		kaopingTable.setRowHeight(25);
		kaopingTable.setEnabled(false);//不可编辑
		kaopingTable.getTableHeader().setReorderingAllowed(false);//不可整列移动   
		kaopingTable.getTableHeader().setResizingAllowed(false);//不可拉动表格
		JScrollPane kaopingtable = new JScrollPane(kaopingTable);//定义一个带表头的表格
		kaopingPanel.add(kaopingtable);
		kaopingtable.setBounds(0, 0, 650, 350);
		givekaoping.setFont(new Font("givekaoping",Font.BOLD, 15));
		givekaoping.setEnabled(false);
		kaopingPanel.add(givekaoping);
		givekaoping.setBounds(100, 400, 150, 30);
		Savekaoping.setFont(new Font("Savekaoping",Font.BOLD, 15));
		Savekaoping.setEnabled(false);
		kaopingPanel.add(Savekaoping);
		Savekaoping.setBounds(260, 400, 150, 30);
		mainPanel.add("kaopingPanel", kaopingPanel);
	}
		/*初始文本框显示信息*/
		void TextShow(){
			//从数组提取社团信息并设置到对应文本框同时设置为不可编辑
			ClubNameText.setText(ClubArray[0]);
			ClubNameText.setEditable(false);
			SetTimeText.setText(ClubArray[1]);
			SetTimeText.setEditable(false);
			ClubKindText.setText(ClubArray[2]);
			ClubKindText.setEditable(false);
			ClubMemNumText.setText(ClubArray[3]);
			ClubMemNumText.setEditable(false);
			ClubTelText.setText(ClubArray[4]);
			ClubTelText.setEditable(false);
			ClubBossText.setText(ClubArray[5]);
			ClubBossText.setEditable(false);
			ClubCharge2Text.setText(ClubArray[6]);
			ClubCharge2Text.setEditable(false);
			ClubCharge3Text.setText(ClubArray[7]);
			ClubCharge3Text.setEditable(false);	
			ShowIDText.setText(userArray[Num][0]);
			ShowIDText.setEditable(false);
			PerNameText.setText(userArray[Num][2]);
			PerNameText.setEditable(false);
			if(userArray[Num][3].equals("男")){
				Male.setSelected(true);
				Female.setSelected(false);
				Male.setEnabled(false);
				Female.setEnabled(false);
			}
			else if(userArray[Num][3].equals("女")){
				Male.setSelected(false);
				Female.setSelected(true);
				Male.setEnabled(false);
				Female.setEnabled(false);
			}
			ProfessionText.setText(userArray[Num][4]);
			ProfessionText.setEditable(false);
			TelephoneText.setText(userArray[Num][5]);
			TelephoneText.setEditable(false);
			QQText.setText(userArray[Num][6]);
			QQText.setEditable(false);
			JoinTimeText.setText(userArray[Num][7]);
			JoinTimeText.setEditable(false);
			DepartmentText.setText(userArray[Num][8]);
			DepartmentText.setEditable(false);
			DutyText.setText(userArray[Num][9]);
			DutyText.setEditable(false);
			WelcomeKind1 = userArray[Num][8]+" "+userArray[Num][9];
			WelcomeKind2 = userArray[Num][2];
			Clubwelcome = ClubArray[0] + "欢迎您";
			/*简略信息面板*/
			simplePanel.removeAll();
			simplePanel.setOpaque(false);
			simplePanel.setBorder(BorderFactory.createRaisedBevelBorder());
			simplePanel.setLayout(null);
			WelcomeLabel1.setFont(new Font("WelcomeLabel1",Font.BOLD, 15));
			simplePanel.add(WelcomeLabel1);
			WelcomeLabel1.setBounds(30, 20, 150, 20);
			WelcomeLabel2 = new JLabel(WelcomeKind1);
			WelcomeLabel3 = new JLabel(WelcomeKind2);
			WelcomeLabel2.setFont(new Font("WelcomeLabel2",Font.BOLD, 15));
			simplePanel.add(WelcomeLabel2);
			WelcomeLabel2.setBounds(30, 40, 150, 20);
			WelcomeLabel3.setFont(new Font("WelcomeLabel3",Font.BOLD, 15));
			simplePanel.add(WelcomeLabel3);
			WelcomeLabel3.setBounds(30, 60, 150, 20);
			ClubFrame.add(simplePanel);
			simplePanel.setBounds(0, 0, 150, 100);
			/*时间、社团欢迎面板*/
			ClubwelcomeLabel = new JLabel(Clubwelcome);
			ClubwelcomeLabel.setFont(new Font("WelcomeLabel3",Font.BOLD, 30));
			TimePanel.add(ClubwelcomeLabel);
			ClubwelcomeLabel.setBounds(120, 40, 600, 60);
		}
		/**/
		void TextShowrefresh(){
			ClubNameText.setText(ClubArray[0]);
			SetTimeText.setText(ClubArray[1]);
			ClubKindText.setText(ClubArray[2]);
			ClubMemNumText.setText(ClubArray[3]);
			ClubTelText.setText(ClubArray[4]);
			ClubBossText.setText(ClubArray[5]);
			ClubCharge2Text.setText(ClubArray[6]);
			ClubCharge3Text.setText(ClubArray[7]);	
			ShowIDText.setText(userArray[Num][0]);
			PerNameText.setText(userArray[Num][2]);
			if(userArray[Num][3].equals("男")){
				Male.setSelected(true);
				Female.setSelected(false);			
			}
			else if(userArray[Num][3].equals("女")){
				Male.setSelected(false);
				Female.setSelected(true);
			}
			ProfessionText.setText(userArray[Num][4]);
			TelephoneText.setText(userArray[Num][5]);
			QQText.setText(userArray[Num][6]);
			JoinTimeText.setText(userArray[Num][7]);
			DepartmentText.setText(userArray[Num][8]);
			DutyText.setText(userArray[Num][9]);
		}
		/*退社信息 公告信息setText方法*/
		void SetText(){
			if(ExitClubArray[Exitflag][0] != null){
			ApplicantText.setText(ExitClubArray[Exitflag][0]);
			ApplicantionText.setText(ExitClubArray[Exitflag][1]);
			Exitflag++;
			}
			else {
				for(int i=0; i<ExitClubArray.length; i++){
				ExitClubArray[i][0] = null;
				ExitClubArray[i][1] = null;
				}
				ExitClubinfWrite();
				Exitflag = 0;
			}
			if(ClubpostArray[Postflag][0] != null){
			postnumbox.setSelectedItem(Postflag+1);
			ShowposttitleText.setText(ClubpostArray[Postflag][0]);
			ShowpostmainbodyText.setText(ClubpostArray[Postflag][1]);
			}
		}
		/*留言群聊显示区写入方法*/
		void Setliuyan(){
			liuyanArea.setText(null);
			String s;
			if(liuyanArray[0] != null){
				s = liuyanArray[0] + "\n";
			for(int i=1; i<liuyanArray.length; i++){
				if(liuyanArray[i] != null){
					s = s + liuyanArray[i] + "\n";
				}
			}
			liuyanArea.setText(s);
		}
	}	
		/*管理员用户权限*/
		void GuanliPower(){
			ExitClubcheck.setVisible(true);
			ClubModify.setEnabled(true);
			Deletepost.setVisible(true);
			issuepost.setVisible(true);
			}
		/*初始赋值函数*/
		void initpower(){
			ExitClubcheck.setVisible(false);
			ClubModify.setEnabled(false);
			Deletepost.setVisible(false);
			issuepost.setVisible(false);
			MeminfTable.setEnabled(false);//不可编辑
			AddMem.setVisible(false);
			DeleteMem.setVisible(false);
			SaveModify.setVisible(false);
			givekaoping.setEnabled(false);
			SearchNameText.setText(null);
			Num = -1;
			WelcomeLabel2.setText(null);
			WelcomeLabel3.setText(null);
			}
		/*按钮监听器集合函数*/
		void monitor(){
		/*登录窗口登录按钮监听器*/
		LoginButton.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int i,flag;
				if(guanli.isSelected()){
					flag = 0;
				for(i=0;i<userArray.length;i++){	
					if(userArray[i][0] != null){
				if((userArray[i][10].equals("1"))&&
					(IDText.getText().equals(userArray[i][0]))&&
					(PassWordText.getText().equals(userArray[i][1]))){
						Num = i;
						FileRead();
						LoginFrame.setVisible(false);
						ClubFrame.setVisible(true);
						if(userArray[i][11].equals("t")&&//该用户提交了退社申请
								userArray[i][12].equals("f")){//该社员已不是本社团成员
								ExitClubSuccessDialog.setVisible(true);
							}
						if(userArray[i][11].equals("t")&&//该用户提交了退社申请
								userArray[i][12].equals("t")){//该社员仍然是本社团成员
								ExitClubDefaultDialog.setVisible(true);
							}
						TextShow();
						GuanliPower();
						flag = 1;
						break;
					}
					}
				}
				if(flag == 0){
					ErrorFrame.setVisible(true);
				}
			}
				else if(putong.isSelected()){
					flag = 0;
				for(i=0;i<userArray.length;i++){
					if(userArray[i][0] != null){
					if((userArray[i][10].equals("0"))&&
						(IDText.getText().equals(userArray[i][0]))&&
						(PassWordText.getText().equals(userArray[i][1]))){
							Num = i;
							FileRead();
							LoginFrame.setVisible(false);
							ClubFrame.setVisible(true);
							if(userArray[i][11].equals("t")&&//该用户提交了退社申请
									userArray[i][12].equals("f")){//该社员已不是本社团成员
									ExitClubSuccessDialog.setVisible(true);
								}
							if(userArray[i][11].equals("t")&&//该用户提交了退社申请
									userArray[i][12].equals("t")){//该社员仍然是本社团成员
									ExitClubDefaultDialog.setVisible(true);
								}
							TextShow();
							flag = 1;
							break;							
						}
					}
					}
					if(flag == 0){
						ErrorFrame.setVisible(true);
					}
				}
				else ErrorFrame.setVisible(true);
		    }	
		});
		/*登录窗口重新输入按钮监听器*/
		ResetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				IDText.setText(null);
				PassWordText.setText(null);
				LoginKind.clearSelection();
			}
		});
		/*错误窗口确定按钮监听器*/
		ErrorSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ErrorFrame.dispose();
			}
		});
		/*退社批准窗口确定按钮监听器*/
		ExitClubSuccessSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<userArray[Num].length; i++){//把该用户信息全部删除
					userArray[Num][i] = null;
				}
				yonghuFileWrite();
				ExitClubSuccessDialog.dispose();
				ClubFrame.dispose();
			}
		});
		/*退社拒绝窗口确定按钮监听器*/
		ExitClubDefaultSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				userArray[Num][11] = "f";//用户提交退社申请改为未提交
				yonghuFileWrite();
				FileRead();
				ExitClubDefaultDialog.dispose();
			}
		});
		/*修改密码按钮监听器*/
		ModifyPassword.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				card2.show(mainPanel, "ModifyPWPanel");
			}
		});
		/*申请退社按钮监听器*/
		ExitClub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				card2.show(mainPanel, "ExitClubPanel");
			}
		});
		/*退出登录监听器*/
		ExitLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitLoginFrame.setVisible(true);
			}
		});
		/*退出系统监听器*/
		ExitSystem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitFrame.setVisible(true);
				
			}
		});
		/*退出主窗口监听器*/
		ClubFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				ExitFrame.setVisible(true);
			}
		});
		/*退出系统提示窗口确认按钮监听器*/
		ExitSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitFrame.dispose();
				ClubFrame.dispose();
			}
		});
		/*退出系统提示窗口取消按钮监听器*/
		ExitCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitFrame.dispose();
			}
		});
		/*退出登录提示窗口确认按钮监听器*/
		ExitLoginSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitLoginFrame.dispose();
				ClubFrame.dispose();
				IDText.setText(null);
				PassWordText.setText(null);
				LoginKind.clearSelection();	
				LoginFrame.setVisible(true);
				/*退出登录则记录用户信息的标记清零，欢迎标签清零*/
				initpower();
			}
		});
		/*退出登录提示窗口取消按钮监听器*/
		ExitLoginCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitLoginFrame.dispose();
			}
		});
		/*个人信息按钮监听器*/
		Perinf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FileRead();
				TextShowrefresh();
				card2.show(mainPanel, "PerinfPanel");
			}
		});
		/*社团信息按钮监听器*/
		Clubinf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FileRead();
				TextShowrefresh();
				card2.show(mainPanel, "ClubinfPanel");
			}
		});
		/*社员信息按钮监听器*/
		Meminf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FileRead();
				MeminfPanel.removeAll();
				MeminfShow();
				if(userArray[Num][10].equals("1")){
					MeminfTable.setEnabled(true);//可编辑
					AddMem.setVisible(true);
					DeleteMem.setVisible(true);
					SaveModify.setVisible(true);
				}
				card2.show(mainPanel, "MeminfPanel");
			}
		});
		/*考评情况按钮监听器*/
		kaoping.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FileRead();
				kaopingPanel.removeAll();
				kaopingShow();
				if(userArray[Num][10].equals("1")){
					givekaoping.setEnabled(true);
				}
				card2.show(mainPanel, "kaopingPanel");
			}
		});
		/*社团公告按钮监听器*/
		Clubpost.addActionListener(new ActionListener(){
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				FileRead();
				int PostNum = 0;
				for(int i=0; i<ClubpostArray.length; i++){
					if(ClubpostArray[i][0] != null){
						PostNum++;
					}
				}
				postnumbox.removeAllItems();
				for(int k=1; k<=PostNum; k++){
					postnumbox.addItem(k);
				}
				SetText();
				card2.show(mainPanel, "ClubpostPanel");
			}
		});
		/*社团公告面板当前页数选择框监听器*/
		postnumbox.addPopupMenuListener(new PopupMenuListener(){    
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {  
                int x=(int) postnumbox.getSelectedItem();  
                Postflag = x-1;
                SetText();
            }
			@Override
			public void popupMenuCanceled(PopupMenuEvent arg0) {
				
			}
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
				
			}   
        }); 
		/*留言群聊按钮监听器*/
		liuyan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FileRead();
				Setliuyan();
				card2.show(mainPanel, "liuyanPanel");
			}
		});
		/*社团公告面板下一条监听器*/
		nextpost.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ShowposttitleText.setText(null);
				ShowpostmainbodyText.setText(null);
				int max = Postflag;
				Postflag++;
				if(ClubpostArray[Postflag][0] != null)
					SetText();
				else {
					Postflag = max;
					SetText();
				}
			}
		});
		/*社团公告面板上一条监听器*/
		previouspost.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ShowposttitleText.setText(null);
				ShowpostmainbodyText.setText(null);
				Postflag--;
				if(Postflag < 0)Postflag = 0;
				SetText();
			}
		});
		/*删除公告按钮监听器*/
		Deletepost.addActionListener(new ActionListener(){
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				ClubpostArray[Postflag][0] = null;
				ClubpostArray[Postflag][1] = null;
				ClubpostWrite();
				FileRead();
				int PostNum = 0;
				for(int i=0; i<ClubpostArray.length; i++){
					if(ClubpostArray[i][0] != null){
						PostNum++;
					}
				}
				postnumbox.removeAllItems();
				for(int k=1; k<=PostNum; k++){
					postnumbox.addItem(k);
				}
				ShowposttitleText.setText(null);
				ShowpostmainbodyText.setText(null);
				Postflag--;
				if(Postflag < 0)Postflag = 0;
				SetText();
			}
		});
		/*发布新公告按钮监听器*/
		issuepost.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				card2.show(mainPanel, "issuepostPanel");
			}
		});
		/*返回按钮监听器*/
		last.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				card1.show(daohangPanel, "putongPanel");
			}
		});
		/*修改密码窗口确认修改按钮监听器*/
		ModifyPWSure.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if((OldPWLabelText.getText().equals(userArray[Num][1]))
					&&(NewPWLabelText.getText().equals(ConfirmPWLabelText.getText()))
					&&(NewPWLabelText.getText().length() > 0)
					&&(ConfirmPWLabelText.getText().length() > 0)){
					userArray[Num][1] = NewPWLabelText.getText();
					yonghuFileWrite();
					ModifyPWSuccess.setVisible(true);
				}
				else ModifyPWError.setVisible(true);
				
			}
		});
		/*修改密码窗口密码重置按钮监听器*/
		ModifyPWCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				OldPWLabelText.setText(null);
				NewPWLabelText.setText(null);
				ConfirmPWLabelText.setText(null);
			}
		});
		/*修改密码错误窗口关闭按钮监听器*/
		ModifyPWErrorClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				OldPWLabelText.setText(null);
				NewPWLabelText.setText(null);
				ConfirmPWLabelText.setText(null);
				ModifyPWError.dispose();
			}
		});
		/*修改密码错误窗口退出监听器*/
		ModifyPWError.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				OldPWLabelText.setText(null);
				NewPWLabelText.setText(null);
				ConfirmPWLabelText.setText(null);
				ModifyPWError.dispose();
			}
		});
		/*修改密码成功窗口关闭按钮监听器*/
		ModifyPWSuccessClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ModifyPWSuccess.dispose();
				OldPWLabelText.setText(null);
				NewPWLabelText.setText(null);
				ConfirmPWLabelText.setText(null);
			}
		});
		/*修改密码成功窗口退出监听器*/
		ModifyPWSuccess.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				ModifyPWSuccess.dispose();
				OldPWLabelText.setText(null);
				NewPWLabelText.setText(null);
				ConfirmPWLabelText.setText(null);
			}
		});
		/*申请退社面板退社审核按钮监听器*/
		ExitClubcheck.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FileRead();
				if(ExitClubArray[Exitflag][0] != null){
					ApplicantText.setText(ExitClubArray[Exitflag][0]);
					ApplicantionText.setText(ExitClubArray[Exitflag][1]);
					Exitflag++;
					}
				card2.show(mainPanel, "ExitClubcheckPanel");
			}
		});
		/*申请退社面板提交申请按钮监听器*/
		ExitClubSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if((ExitClubText.getText().length() >= 15)&&
				(ExitClubText.getText().length() <= 100))
				{
				String s1 = userArray[Num][2];
				long now = System.currentTimeMillis();// 排序前取得当前时间  
			    Calendar c = Calendar.getInstance();  
			    c.setTimeInMillis(now);
			    String s2 = ("申请时间:" + c.get(Calendar.YEAR) + "年" 
			     + (c.get(Calendar.MONTH) + 1) + "月" + c.get(Calendar.DATE)  
			     + "日"+ (c.get(Calendar.HOUR)+12) + "时" + c.get(Calendar.MINUTE)+"分");
			    String s3 = ExitClubText.getText()+" "+s2;
			    int i = 0;
			    while(ExitClubArray[i][0] != null){
			        i++;
			    }
			        ExitClubArray[i][0] = s1;
			        ExitClubArray[i][1] = s3;
				userArray[Num][11] = "t";//该用户已提交退社申请
				yonghuFileWrite();//提交信息写入
				ExitClubinfWrite();//退社信息写入
				ExitClubDialog.setVisible(true);
				ExitClubText.setText(null);
				}
			}
		});
		/*申请退社面板取消申请按钮监听器*/
		ExitClubCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitClubText.setText(null);
			}
		});
		/*申请退社面板提交成功窗口确定按钮监听器*/
		ExitClubDialogSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitClubDialog.dispose();
			}
		});
		/*退社审核面板批准申请按钮监听器*/
		PassApplicantion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<userArray.length; i++){
					if(ApplicantText.getText().equals(userArray[i][2])){
						userArray[i][12] = "f";//f表示该用户已不在该社团
						yonghuFileWrite();
						break;
					}
				}
				ApplicantText.setText(null);
				ApplicantionText.setText(null);
				SetText();
			}
		});
		/*退社审核面板拒绝申请按钮监听器*/
		RefuseApplicantion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ApplicantText.setText(null);
				ApplicantionText.setText(null);
				SetText();
			}
		});
		/*个人信息窗口修改按钮监听器*/
		PerModify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				PerSave.setEnabled(true);
				ShowIDText.setEditable(true);		
				PerNameText.setEditable(true);
				Male.setEnabled(true);
				Female.setEnabled(true);
				ProfessionText.setEditable(true);			
				TelephoneText.setEditable(true);				
				QQText.setEditable(true);				
				JoinTimeText.setEditable(true);				
				DepartmentText.setEditable(true);				
				DutyText.setEditable(true);
				PerModify.setEnabled(false);
			}
		});
		/*个人信息窗口保存按钮监听器*/
		PerSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				userArray[Num][0] = IDText.getText();
				userArray[Num][2] = PerNameText.getText();
				userArray[Num][4] = ProfessionText.getText();
				userArray[Num][5] = TelephoneText.getText();
				userArray[Num][6] = QQText.getText();
				userArray[Num][7] = JoinTimeText.getText();
				userArray[Num][8] = DepartmentText.getText();
				userArray[Num][9] = DutyText.getText();
				if(Male.isSelected())userArray[Num][3] = "男";
				else if(Female.isSelected())userArray[Num][3] = "女";
				yonghuFileWrite();
				ShowIDText.setEditable(false);			
				PerNameText.setEditable(false);	
				Male.setEnabled(false);
				Female.setEnabled(false);
				ProfessionText.setEditable(false);			
				TelephoneText.setEditable(false);				
				QQText.setEditable(false);				
				JoinTimeText.setEditable(false);				
				DepartmentText.setEditable(false);				
				DutyText.setEditable(false);
				PerSave.setEnabled(false);
				PerModify.setEnabled(true);
			}
		});
		/*社团信息窗口修改按钮监听器*/
		ClubModify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ClubSave.setEnabled(true);
				ClubNameText.setEditable(true);			
				SetTimeText.setEditable(true);				
				ClubKindText.setEditable(true);			
				ClubMemNumText.setEditable(true);				
				ClubTelText.setEditable(true);				
				ClubBossText.setEditable(true);				
				ClubCharge2Text.setEditable(true);				
				ClubCharge3Text.setEditable(true);
				ClubModify.setEnabled(false);
			}
		});
		/*社团信息窗口保存按钮监听器*/
		ClubSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ClubArray[0] = ClubNameText.getText();
				ClubArray[1] = SetTimeText.getText();
				ClubArray[2] = ClubKindText.getText();
				ClubArray[3] = ClubMemNumText.getText();
				ClubArray[4] = ClubTelText.getText();
				ClubArray[5] = ClubBossText.getText();
				ClubArray[6] = ClubCharge2Text.getText();
				ClubArray[7] = ClubCharge3Text.getText();
				ClubFileWrite();
				ClubSave.setEnabled(false);
				ClubNameText.setEditable(false);			
				SetTimeText.setEditable(false);				
				ClubKindText.setEditable(false);			
				ClubMemNumText.setEditable(false);				
				ClubTelText.setEditable(false);				
				ClubBossText.setEditable(false);				
				ClubCharge2Text.setEditable(false);				
				ClubCharge3Text.setEditable(false);
				ClubModify.setEnabled(true);
				ClubSave.setEnabled(false);
			}
		});
		/*社员信息面板查找社员按钮监听器*/
		SearchMem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
	          String s = SearchNameText.getText();
	          int flag = 0;
	          for(int i=0; i<MeminfTable.getRowCount(); i++){
	        	  if(s.equals(Meminfmodel.getValueAt(i, 0))){//第i+1行第1列
	        		  MeminfTable.setRowSelectionInterval(i,i);//设置使第i+1行高亮
	        		  flag = 1;
	        		  break;
	        	  }
	          }
	          if(flag == 0)MeminfTable.clearSelection();//清除选择信息
			}
		});
		/*社员信息面板添加社员按钮监听器*/
		AddMem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Meminfmodel.addRow(new Object[]{" "});
			}
		});
		/*社员信息面板删除社员按钮监听器*/
		DeleteMem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int selectRows[] = MeminfTable.getSelectedRows();
				if(selectRows.length > 0){//若确实选择了表格的某几行
					for(int i=0; i<selectRows.length; i++){
						if(selectRows[i] > -1)
				Meminfmodel.removeRow(selectRows[0]);
					}
				}
			}
		});
		/*社员信息面板保存修改按钮监听器*/
		SaveModify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MemNum = 0;
				for(int i=0; i<Meminfmodel.getRowCount(); i++){
					if(Meminfmodel.getValueAt(i, 0) != null){
						MemNum++;
					userArray[i][0] = (String) Meminfmodel.getValueAt(i, 0);
					userArray[i][1] = (String) Meminfmodel.getValueAt(i, 0);
					userArray[i][2] = (String) Meminfmodel.getValueAt(i, 1);
					userArray[i][3] = (String) Meminfmodel.getValueAt(i, 2);
					userArray[i][4] = (String) Meminfmodel.getValueAt(i, 3);
					userArray[i][5] = (String) Meminfmodel.getValueAt(i, 4);
					userArray[i][6] = (String) Meminfmodel.getValueAt(i, 5);
					userArray[i][7] = (String) Meminfmodel.getValueAt(i, 6);
					userArray[i][8] = (String) Meminfmodel.getValueAt(i, 7);
					userArray[i][9] = (String) Meminfmodel.getValueAt(i, 8);
					if(i > 2){//除管理层其他人权限均为普通(0)，初始化退社信息均为未提交(f),在社团里(t)
					userArray[i][10] = "0";
					userArray[i][11] = "f";
					userArray[i][12] = "t";
					}
					kaopingArray[i][0] = (String) Meminfmodel.getValueAt(i, 0);
					kaopingArray[i][1] = (String) Meminfmodel.getValueAt(i, 1);
					
				}
					else {
						for(int k=0; k<userArray[i].length; k++){
							userArray[i][k] = null;
						}
						for(int x=0; x<kaopingArray[i].length; x++){
							kaopingArray[i][x] = null;
						}
					}
			}
				MeminfPanel.remove(MemNumLabel);
				MemNumLabel = new JLabel("本社团共有  "+MemNum+"  人");
				MemNumLabel.setFont(new Font("MemNumLabel",Font.BOLD, 15));
				MeminfPanel.add(MemNumLabel);
				MemNumLabel.setBounds(0, 0, 150, 30);
				ClubArray[3] =  ""+MemNum;//将整型MemNum转为字符串
				yonghuFileWrite();
				ClubFileWrite();
				kaopingWrite();
				MeminfTable.clearSelection();//取消选择
			}
		});
		/*考评情况面板社员考评按钮监听器*/
		givekaoping.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Savekaoping.setEnabled(true);
				kaopingTable.setEnabled(true);
				givekaoping.setEnabled(false);
			}
		});
		/*考评情况面板保存考评按钮监听器*/
		Savekaoping.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<kaopingArray.length; i++){
					if(kaopingmodel.getValueAt(i, 0) != null){
						kaopingArray[i][0] = (String) kaopingmodel.getValueAt(i, 0);
						kaopingArray[i][1] = (String) kaopingmodel.getValueAt(i, 1);
						kaopingArray[i][2] = (String) kaopingmodel.getValueAt(i, 2);
						kaopingArray[i][3] = (String) kaopingmodel.getValueAt(i, 3);
					}
					kaopingWrite();
				}
				kaopingTable.clearSelection();//取消选择
				givekaoping.setEnabled(true);
				kaopingTable.setEnabled(false);
				Savekaoping.setEnabled(false);
			}
		});
		/*发布公告面板发布按钮*/
		issuepostSure.addActionListener(new ActionListener(){
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if((posttitleText.getText().length() > 0)&&
				(postmainbodyText.getText().length() >= 15)&&
				(postmainbodyText.getText().length() <= 250)){
				String s1 = posttitleText.getText();
				long now = System.currentTimeMillis(); // 排序前取得当前时间 
			     Calendar c = Calendar.getInstance();  
			    c.setTimeInMillis(now);
			    String s2 = (userArray[Num][2]+"发表于" + c.get(Calendar.YEAR) + "年" 
			     + (c.get(Calendar.MONTH) + 1) + "月" + c.get(Calendar.DATE)  
			     + "日"+ (c.get(Calendar.HOUR)+12) + "时" + c.get(Calendar.MINUTE)+"分");
			    String s3 = postmainbodyText.getText()+" "+s2;
			     int i = 0;
			     while(ClubpostArray[i][0] != null){
			        	i++;
			        }
			        ClubpostArray[i][0] = s1;
			        ClubpostArray[i][1] = s3;
				ClubpostWrite();
				FileRead();
				int PostNum = 0;
				for(int v=0; v<ClubpostArray.length; v++){
					if(ClubpostArray[v][0] != null){
						PostNum++;
					}
				}
				postnumbox.removeAllItems();
				for(int k=1; k<=PostNum; k++){
					postnumbox.addItem(k);
				}
				SetText();
				posttitleText.setText(null);
				postmainbodyText.setText(null);
				card2.show(mainPanel, "ClubpostPanel");
				}
			}
		});
		/*发布公告面板取消按钮*/
		issuepostCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				posttitleText.setText(null);
				postmainbodyText.setText(null);
				card2.show(mainPanel, "ClubpostPanel");
			}
		});
		/*留言板面板留言按钮*/
		liuyanOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(liuyanText.getText().length() > 0){
				long now = System.currentTimeMillis(); // 排序前取得当前时间 
				  Calendar c = Calendar.getInstance();  
				  c.setTimeInMillis(now);
				  String s = ("["+c.get(Calendar.YEAR) + "年" 
				 + (c.get(Calendar.MONTH) + 1) + "月" + c.get(Calendar.DATE)  
				 + "日"+ (c.get(Calendar.HOUR)+12) + "时" + c.get(Calendar.MINUTE)+"分"
				 +"]"+userArray[Num][2]+":");
					for(int i=0; i<liuyanArray.length; i++){
						if(liuyanArray[i] != null){}
						else {
							liuyanArray[i] = s+liuyanText.getText();
							break;
						}
					}
					liuyanWrite();
					FileRead();
					Setliuyan();
					liuyanText.setText(null);
					
				}
			}
		});
		/*留言板面板清空按钮*/
		liuyanCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				liuyanText.setText(null);
			}
		});
		
	}
	/*读取所有用户信息*/
	void FileRead() {
		try {
			FileInputStream file1 = new FileInputStream("用户信息.txt");
			InputStreamReader file11 = new InputStreamReader(file1);
			BufferedReader reader1 = new BufferedReader(file11);
			FileInputStream file2 = new FileInputStream("考评信息.txt");
			InputStreamReader file22 = new InputStreamReader(file2);
			BufferedReader reader2 = new BufferedReader(file22);
			FileInputStream file3 = new FileInputStream("社团信息.txt");
			InputStreamReader file33 = new InputStreamReader(file3);
			BufferedReader reader3 = new BufferedReader(file33);
			FileInputStream file4 = new FileInputStream("退社信息.txt");
			InputStreamReader file44 = new InputStreamReader(file4);
			BufferedReader reader4 = new BufferedReader(file44);
			FileInputStream file5 = new FileInputStream("公告信息.txt");
			InputStreamReader file55 = new InputStreamReader(file5);
			BufferedReader reader5 = new BufferedReader(file55);
			FileInputStream file6 = new FileInputStream("留言信息.txt");
			InputStreamReader file66 = new InputStreamReader(file6);
			BufferedReader reader6 = new BufferedReader(file66);
			String s;
			int i = 0;
			int j = 0;
			int k = 0;
			int t = 0;
			int x = 0;
			while ((s = reader1.readLine()) != null) {
				userArray[i] = s.split("-");
				i++;
			}
			while ((s = reader2.readLine()) != null) {
				kaopingArray[j] = s.split("-");
				j++;
			}
			while ((s = reader4.readLine()) != null) {
				ExitClubArray[k] = s.split("-");
				
				k++;
			}
			while ((s = reader5.readLine()) != null) {
				ClubpostArray[t] = s.split("-");
				
				t++;
			}
			while ((s = reader6.readLine()) != null) {
				liuyanArray[x] = s;
				x++;
			}
//			for(int t=0; t<ExitClubArray.length; t++){
//				System.out.println(ExitClubArray[t][0]);
//			}
				
			while((s = reader3.readLine()) != null) {
				ClubArray = s.split("-");
			}
			file11.close();
			file22.close();
			file33.close();
			file44.close();
			file55.close();
			file66.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*文件信息写入函数*/
	/*退社信息写入*/
	void ExitClubinfWrite(){
        try {
			File fileout = new File("退社信息.txt");
			FileWriter write = new FileWriter(fileout,false);//覆盖之前的内容再次写入文件
			BufferedWriter writer = new BufferedWriter(write);
			for(int k=0; k<ExitClubArray.length; k++){
				if(ExitClubArray[k][0] != null){
				String ss = ExitClubArray[k][0]+"-"+ExitClubArray[k][1];
				writer.write(ss);
				writer.newLine();
				writer.flush();
				}
			}
			writer.close();
			write.close();
		} 
		 catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*用户信息写入*/
	void yonghuFileWrite(){
			try {
				File fileout = new File("用户信息.txt");
				FileWriter write = new FileWriter(fileout,false);//覆盖之前的内容再次写入文件
				BufferedWriter writer = new BufferedWriter(write);
				for(int i=0; i<userArray.length; i++){
					if(userArray[i][0] != null){
					String ss = userArray[i][0]+"-";
					for(int j=1; j<userArray[i].length-1; j++){
						ss = ss + userArray[i][j]+"-";
					}
					ss = ss + userArray[i][userArray[i].length-1];
					writer.write(ss);
					writer.newLine();
					writer.flush();
					}
				}
				writer.close();
				write.close();
			} 
			 catch (IOException e) {
				e.printStackTrace();
			}
			
	}
	/*社团信息写入*/
	void ClubFileWrite(){
		try{
			File fileout = new File("社团信息.txt");
			FileWriter write = new FileWriter(fileout,false);//覆盖之前的内容再次写入文件
				for(int i=0; i<ClubArray.length-1; i++){
				write.write(ClubArray[i]+"-");
				}
				write.write(ClubArray[7]);
			write.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*公告信息写入*/
	void ClubpostWrite(){
        try {
			File fileout = new File("公告信息.txt");
			FileWriter write = new FileWriter(fileout,false);//覆盖之前的内容再次写入文件
			BufferedWriter writer = new BufferedWriter(write);
			for(int k=0; k<ClubpostArray.length; k++){
				if(ClubpostArray[k][0] != null){
				String ss = ClubpostArray[k][0]+"-"+ClubpostArray[k][1];
				writer.write(ss);
				writer.newLine();
				writer.flush();
				}
			}
			writer.close();
			write.close();
		} 
		 catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*考评信息写入*/
	void kaopingWrite(){
        try {
			File fileout = new File("考评信息.txt");
			FileWriter write = new FileWriter(fileout,false);//覆盖之前的内容再次写入文件
			BufferedWriter writer = new BufferedWriter(write);
			for(int k=0; k<kaopingArray.length; k++){
				if(kaopingArray[k][0] != null){
				String ss = kaopingArray[k][0]+"-"+kaopingArray[k][1]
						+"-"+kaopingArray[k][2]+"-"+kaopingArray[k][3];
				writer.write(ss);
				writer.newLine();
				writer.flush();
				}
			}
			writer.close();
			write.close();
		} 
		 catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*留言信息写入*/
	void liuyanWrite(){
        try {
			File fileout = new File("留言信息.txt");
			FileWriter write = new FileWriter(fileout,false);//覆盖之前的内容再次写入文件//字符流
			BufferedWriter writer = new BufferedWriter(write);
			for(int k=0; k<liuyanArray.length; k++){
				if(liuyanArray[k] != null){
				String ss = liuyanArray[k];
				writer.write(ss);
				writer.newLine();
				writer.flush();
				}
			}
			writer.close();
			write.close();
		} 
		 catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
/*

	修改密码 只有旧密码正确，新密码 重复密码相同才可完成改密
	退社申请
	我已经身心疲惫，最近忙于学习、课设，已无心关注社团活动，打算退出社团，请管理员批准，谢谢！
	管理员申请一次 拒绝
	普通用户申请一次 批准
	个人信息 社团信息社团人数 社员信息页 信息同步
	社员信息页面的查找高亮  修改 删除信息 保存 删除后 考评信息页的信息同样被删除
	考评页的考评信息修改 
	发布一条新公告
	课设验收
	今天下午两点研究院405验收课设，没有完成的明天下午同样时间地点。
	删除公告 页数变化
	公告的翻页 直接定位页数
	群聊面板
	不同用户之间的信息同步
	
*/
















