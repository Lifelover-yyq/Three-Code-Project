package CLUB_management;

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
	/* ���������ֲ�*/
	private JFrame ClubFrame = new JFrame("ѧ��������Ϣ����ϵͳ");
	private JPanel simplePanel = new JPanel();	
	private JPanel daohangPanel = new JPanel();
	private JPanel putongPanel = new JPanel();
	private JPanel guanliPanel = new JPanel();
	private JPanel TimePanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	/*������ʱ�����*/
	final JLabel TimeLabel = new JLabel();
	final SimpleDateFormat format = new SimpleDateFormat(
			"��ǰʱ��: y��M��d��E H:m:s",Locale.CHINA);
	private Timer t=new Timer();
	private JLabel ClubwelcomeLabel;
	private String Clubwelcome;
	/*�����ڼ�����Ϣ���*/
	private JLabel WelcomeLabel1 = new JLabel("�û�:");
	private String WelcomeKind1;
	private String WelcomeKind2;
	private JLabel WelcomeLabel2 = new JLabel();
	private JLabel WelcomeLabel3 = new JLabel();
	/*���ܵ������*/
	private CardLayout card1 = new CardLayout();
	private JLabel ClubSystem = new JLabel("�û��˵�");
	private JButton ModifyPassword = new JButton("���޸�����");
	private JButton ExitClub = new JButton("����������");
	private JButton ExitLogin = new JButton("���˳���¼");
	private JButton ExitSystem = new JButton("���˳�ϵͳ");
	private JLabel InfView = new JLabel("������Ϣ");
	private JButton Perinf = new JButton("��������Ϣ");
	private JButton Clubinf = new JButton("��������Ϣ");
	private JButton Meminf = new JButton("����Ա��Ϣ");
	private JLabel ClubAct = new JLabel("������Ϣ");
	private JButton kaoping = new JButton("���������");
	private JButton Clubpost = new JButton("�����Ź���");
	private JButton liuyan = new JButton("������Ⱥ��");
	private JButton last = new JButton("����");
	/*չʾ�����*/
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
	/*�޸��������*/
	private JLabel OldPWLabel = new JLabel("������:");
	private JLabel NewPWLabel = new JLabel("������:");
	private JLabel ConfirmPWLabel = new JLabel("ȷ��������:");
	private JPasswordField OldPWLabelText = new JPasswordField();
	private JPasswordField NewPWLabelText = new JPasswordField();
	private JPasswordField ConfirmPWLabelText = new JPasswordField();
	private JButton ModifyPWSure = new JButton("ȷ���޸�");
	private JButton ModifyPWCancel = new JButton("��������");
	private JDialog ModifyPWSuccess = new JDialog(ClubFrame,"�޸ĳɹ�!",true);
	private JLabel ModifyPWSuccessLabel = new JLabel("�����޸ĳɹ�!");
	private JButton ModifyPWSuccessClose = new JButton("ȷ��");
	private JDialog ModifyPWError = new JDialog(ClubFrame,"��������!",true);
	private JLabel ModifyPWErrorLabel = new JLabel("������������!");
	private JButton ModifyPWErrorClose = new JButton("�ر�");
	/*�����������*/
	private JButton ExitClubcheck = new JButton("�������");
	private JLabel ExitClubLabel = new JLabel("����д�����������ɣ�(15-100��)");
	private JTextArea ExitClubText = new JTextArea(500,250);
	private JButton ExitClubSure = new JButton("�ύ����");
	private JButton ExitClubCancel = new JButton("ȡ������");
	private JDialog ExitClubDialog = new JDialog(ClubFrame,"�ύ�ɹ�",true);
	private JLabel ExitClubDialogLabel = new JLabel("�������ύ����ȴ�����Ա���!");
	private JButton ExitClubDialogSure = new JButton("ȷ��");
	 /*����������*/
	int Exitflag = 0;
	private JLabel Applicant = new JLabel("������");
	private JTextField ApplicantText = new JTextField();
	private JLabel Applicantion = new JLabel("��������");
	private JTextArea ApplicantionText = new JTextArea(500,250);
	private JButton PassApplicantion = new JButton("��׼����");
	private JButton RefuseApplicantion = new JButton("�ܾ�����");
	/*�������˳�ϵͳ��ʾ����*/
	private JDialog ExitFrame = new JDialog(ClubFrame,"�˳�ϵͳ",true);
	private JLabel ExitimgLabel;
	private JLabel ExitLabel = new JLabel("ȷ���˳�ϵͳ��");
	private JButton ExitSure = new JButton("ȷ��");
	private JButton ExitCancel = new JButton("ȡ��");
	/*�������˳���¼��ʾ����*/
	private JDialog ExitLoginFrame = new JDialog(ClubFrame,"�˳���¼",true);
	private JLabel ExitLoginimgLabel;
	private JLabel ExitLoginLabel = new JLabel("ȷ���˳���¼��");
	private JButton ExitLoginSure = new JButton("ȷ��");
	private JButton ExitLoginCancel = new JButton("ȡ��");
	/*������Ϣ���*/
	int Num = -1;
	private JPanel GenderPanel = new JPanel();
	private JLabel ShowID = new JLabel("ѧ ��:");
	private JTextField ShowIDText = new JTextField(10);
	private JLabel PerName = new JLabel("�� ��:");
	private JTextField PerNameText = new JTextField(5);
	private JLabel Gender = new JLabel("�� ��:");
	private ButtonGroup GenderKind = new ButtonGroup();
	private JRadioButton Male = new JRadioButton("��");
	private JRadioButton Female = new JRadioButton("Ů");
	private JLabel Profession = new JLabel("ѧ Ժ:");
	private JTextField ProfessionText = new JTextField(10);
	private JLabel Telephone = new JLabel("�� ��:");
	private JTextField TelephoneText = new JTextField(11);
	private JLabel QQ = new JLabel("Q Q:");
	private JTextField QQText = new JTextField(10);
	private JLabel JoinTime = new JLabel("���� ʱ��:");
	private JTextField JoinTimeText = new JTextField(10);
	private JLabel Department = new JLabel("���� ����:");
	private JTextField DepartmentText = new JTextField(5);
	private JLabel Duty = new JLabel("ְ ��:");
	private JTextField DutyText = new JTextField(5);
	private JButton PerModify = new JButton("�޸�");
	private JButton PerSave = new JButton("����");
	/*������Ϣ���*/
	private JLabel ClubName = new JLabel("��������:");
	private JTextField ClubNameText = new JTextField(10);
	private JLabel SetTime = new JLabel("����ʱ��:");
	private JTextField SetTimeText = new JTextField(10);
	private JLabel ClubKind = new JLabel("�������:");
	private JTextField ClubKindText = new JTextField(10);
	private JLabel ClubMemNum = new JLabel("��������:");
	private JTextField ClubMemNumText = new JTextField(3);
	private JLabel ClubTel = new JLabel("������ϵ��ʽ:");
	private JTextField ClubTelText = new JTextField(11);
	private JLabel ClubBoss = new JLabel("�糤����:");
	private JTextField ClubBossText = new JTextField(10);
	private JLabel ClubCharge2 = new JLabel("�ڶ�������:");
	private JTextField ClubCharge2Text = new JTextField();
	private JLabel ClubCharge3 = new JLabel("����������:");
	private JTextField ClubCharge3Text = new JTextField();
	private JButton ClubModify = new JButton("�޸�");
	private JButton ClubSave = new JButton("����");
	/*��Ա��Ϣ��ʾ���*/
	private JTable MeminfTable;
	private DefaultTableModel Meminfmodel;
	private String MeminfTableHead[] = {"ѧ��","����","�Ա�","ѧԺ","�ֻ���","QQ",
			"����ʱ��","����","ְ��"};
	private Object MeminfTabelObject[][];
	private JButton AddMem = new JButton("�����Ա");
	private JButton DeleteMem = new JButton("ɾ����Ա");
	private JButton SaveModify = new JButton("�����޸�");
	private JButton SearchMem = new JButton("������Ա");
	private JLabel SearchName = new JLabel("��������ҵ�ID:");
	private JTextField SearchNameText = new JTextField();
	private JLabel MemNumLabel;
	private int MemNum;
	/*���ſ���������*/
	private JTable kaopingTable;
	private DefaultTableModel kaopingmodel;
	private String kaopingTableHead[] = {"ѧ��","����","������(����100)","�ۺ�������"};
	private Object kaopingTabelObject[][];
	private JButton givekaoping = new JButton("��Ա����");
	private JButton Savekaoping = new JButton("���濼��");
	/*���Ź������*/
	private JButton issuepost = new JButton("�����¹���");
	private JButton Deletepost = new JButton("ɾ������");
	private JLabel Showposttitle = new JLabel("����");
	private JLabel Showpostmainbody = new JLabel("����");
	private JTextField ShowposttitleText = new JTextField();
	private JTextArea ShowpostmainbodyText = new JTextArea();
	private JButton previouspost = new JButton("��һҳ");
	private JButton nextpost = new JButton("��һҳ");
	private JLabel postnum = new JLabel("��ǰҳ��:");
	@SuppressWarnings("rawtypes")
	private JComboBox postnumbox = new JComboBox();
	/*�����������*/
	int Postflag = 0;
	private JLabel posttitle = new JLabel("����(����)");
	private JLabel postmainbody = new JLabel("����(����,15-250��)");
	private JTextField posttitleText = new JTextField();
	private JTextArea postmainbodyText = new JTextArea();
	private JButton issuepostSure = new JButton("��������");
	private JButton issuepostCancel = new JButton("ȡ������");
	/*����Ⱥ�����*/
	private JLabel liuyanLabel = new JLabel("�������Խ��顢�г����죬�벻Ҫˢ������Ҫ�����������ۣ�");
	private JTextArea liuyanArea = new JTextArea();
	private JTextField liuyanText = new JTextField();
	private JButton liuyanOK = new JButton("�Һ�");
	private JButton liuyanCancel = new JButton("���");
	private Timer count = new Timer();
	/* ��¼������� */
	private JFrame LoginFrame = new JFrame("��¼ϵͳ");
	private JLabel ID = new JLabel("ID(ѧ��):");
	private JTextField IDText = new JTextField(10);
	private JLabel PassWord = new JLabel("��¼����:");
	private JPasswordField PassWordText = new JPasswordField(10);
	private JButton LoginButton = new JButton("ȷ�ϵ�¼");
	private JButton ResetButton = new JButton("��������");
	private ButtonGroup LoginKind = new ButtonGroup();
	private JRadioButton putong = new JRadioButton("��ͨ�û�");
	private JRadioButton guanli = new JRadioButton("����Ա�û�");
	private JLabel LoginLabel = new JLabel("��ʼ���뼴Ϊѧ�ţ���½���������޸�!");
	/*������׼��ʾ����*/
	private JDialog ExitClubSuccessDialog = new JDialog(ClubFrame,"�ɹ�����",true);
	private JLabel ExitClubSuccessLabel1 = new JLabel("����Ա��׼�������������룬");
	private JLabel ExitClubSuccessLabel2 = new JLabel("�����˳�������!");
	private JButton ExitClubSuccessSure = new JButton("ȷ��");
	/*����ܾ���ʾ����*/
	private JDialog ExitClubDefaultDialog = new JDialog(ClubFrame,"���뱻�ܾ�",true);
	private JLabel ExitClubDefaultLabel = new JLabel("����Ա�ܾ���������������!");
	private JButton ExitClubDefaultSure = new JButton("ȷ��");
	/*���󴰿���� */
	private JDialog ErrorFrame = new JDialog(LoginFrame,"����",true);
	private JPanel ErrorPanel = new JPanel();
	private JLabel ErrorLabel = new JLabel("ID���������������û�ѡ�����!");
	private JButton ErrorSure = new JButton("ȷ��");
	/*�����Ա�û�ֻ���������糤���������糤*/
	/*��ͨ�û�������ȷ��*/
	private String userArray[][]= new String[20][13];// �洢�û���Ϣ
	private String kaopingArray[][] = new String[20][4];//�洢������Ϣ
	private String ExitClubArray[][] = new String[20][2];//�洢������Ϣ
	private String ClubpostArray[][] = new String[20][2];//�洢������Ϣ
	private String liuyanArray[] = new String[20];
	/*�洢������Ϣ������*/
	private String ClubArray[] = new String[8];
	public static void main(String args[]) {
		display a = new display();
		a.ClubSystem();
	}
	//��ʱˢ����̳�TimeTask��
	class NFDFlightDataTimerTask extends TimerTask{ 
	    @Override 
	    //�˷���Ϊ����Ҫ��ʱ�����ķ���  
	    public void run() { 
	     FileRead();
	     Setliuyan();
	    } 
	} 
	void ClubSystem(){
		FileRead();//�ļ���ȡ
		init();//��ʼ������
		monitor();//ʵ�ּ���
		NFDFlightDataTimerTask task = new NFDFlightDataTimerTask();
	      //����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�  
	              count.schedule(task,new Date(),100); 
	}
	/*�Ը����ڡ������г�ʼ�����ֵ�*/
	void init(){
		/*�����ڳ�ʼ��*/
		ClubFrame.setSize(800, 600);//�����ڴ�С
		ClubFrame.setVisible(false);//����Ϊ���ɼ�
		ClubFrame.setResizable(false);//��С���ɵ���
		ClubFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ClubFrame.setLocationRelativeTo(null);
		ClubFrame.setLayout(null);//������ʹ��null����
		ImageIcon maintubiao = new ImageIcon("��ͼ��.jpg");//����ϵͳͼ��
		ClubFrame.setIconImage(maintubiao.getImage());
        /*���ܵ������*/
		daohangPanel.setLayout(card1);//ʹ�ò�������
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
        /*ʱ����岼�֣�ÿ���Ӹ���һ�ε�ǰʱ�����¸�ֵ��TimeLabel*/
        t.scheduleAtFixedRate(new TimerTask() {
        	public void run() {
        	TimeLabel.setText(format.format(new Date(System.currentTimeMillis())));
        	TimeLabel.setFont(new Font("Time",Font.BOLD, 20));//����ʱ���ǩ�����С
        	}
        	}, 0, 1000);
        TimePanel.add(TimeLabel);
        TimeLabel.setBounds(120, 0, 600, 30);
        ClubFrame.add(TimePanel);
        TimePanel.setOpaque(false);
        TimePanel.setLayout(null);
        TimePanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        TimePanel.setBounds(150, 0, 650, 100);
        /*����ʾ���*/
        mainPanel.setLayout(card2);//ʹ�ò�������
		mainPanel.setOpaque(false);
		mainPanel.setBorder(BorderFactory.createEtchedBorder());
		ClubFrame.add(mainPanel);
		mainPanel.setBounds(150, 100, 650, 500);
        /*�޸��������*/
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
        /*�����������*/
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
        ExitClubText.setLineWrap(true);//�Զ�����
        ExitClubText.setBorder(BorderFactory.createEtchedBorder());//�߿�����
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
        /*����������*/
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
		ApplicantionText.setLineWrap(true);//�Զ�����
		ExitClubcheckPanel.add(ApplicantionText);
		ApplicantionText.setBounds(100, 170, 450, 200);
		PassApplicantion.setFont(new Font("PassApplicantion",Font.BOLD, 15));
		ExitClubcheckPanel.add(PassApplicantion);
		PassApplicantion.setBounds(100, 380, 220, 30);
		RefuseApplicantion.setFont(new Font("RefuseApplicantion",Font.BOLD, 15));
		ExitClubcheckPanel.add(RefuseApplicantion);
		RefuseApplicantion.setBounds(330, 380, 220, 30);
		mainPanel.add("ExitClubcheckPanel", ExitClubcheckPanel);
		/*������׼����*/
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
		/*����ܾ�����*/
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
        /*�������˳���ʾ����*/
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
        /*�������˳���¼��ʾ����*/
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
		/*������Ϣ���*/
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
		/*������Ϣ���*/
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
		/*���Ź������*/
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
		ShowpostmainbodyText.setLineWrap(true);//�Զ�����
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
        /*�����������*/
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
		postmainbodyText.setLineWrap(true);//�Զ�����
		issuepostPanel.add(postmainbodyText);
		postmainbodyText.setBounds(100, 170, 450, 200);
		issuepostSure.setFont(new Font("issuepostSure",Font.BOLD, 15));
		issuepostPanel.add(issuepostSure);
		issuepostSure.setBounds(100, 380, 220, 30);
		issuepostCancel.setFont(new Font("issuepostCancel",Font.BOLD, 15));
		issuepostPanel.add(issuepostCancel);
		issuepostCancel.setBounds(330, 380, 220, 30);
		mainPanel.add("issuepostPanel", issuepostPanel);
		/*����Ⱥ�����*/
		liuyanPanel.setLayout(null);
		liuyanLabel.setFont(new Font("liuyanLabel",Font.BOLD, 15));
		liuyanPanel.add(liuyanLabel);
		liuyanLabel.setBounds(10,10, 640, 30);
		liuyanArea.setFont(new Font("liuyanArea",Font.BOLD, 15));
		liuyanArea.setBorder(BorderFactory.createEtchedBorder());
		liuyanArea.setLineWrap(true);//�Զ�����
		liuyanArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(liuyanArea);//��ӹ�����
		//�������Զ�����
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
		/*��¼���ڳ�ʼ��*/
		LoginFrame.setSize(400, 300);//��¼���ڴ�С
		LoginFrame.setVisible(true);//����Ϊ�ɼ�
		LoginFrame.setResizable(false);//����Ϊ��С���ɵ���
		LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginFrame.setLocationRelativeTo(null);
		LoginFrame.setLayout(null);
		ImageIcon Logintubiao = new ImageIcon("��½ͼ��.png");//����ϵͳͼ��
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
		/*���󴰿ڳ�ʼ��*/
		ErrorFrame.setSize(220, 130);//���󴰿ڴ�С
		ErrorFrame.setVisible(false);//����Ϊ���ɼ�
		ErrorFrame.setResizable(false);
		ErrorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ErrorFrame.setLocationRelativeTo(null);
		ErrorLabel.setSize(100, 10);
		ErrorFrame.add(ErrorLabel,BorderLayout.CENTER);
		ErrorSure.setSize(100, 20);
		ErrorPanel.add(ErrorSure);
		ErrorFrame.add(ErrorPanel,BorderLayout.SOUTH);
	}
	/*��Ա��Ϣ���*/
	void MeminfShow(){
		MemNum = 0;
		MeminfPanel.setLayout(null);
		MeminfTabelObject = new String[userArray.length][9];
		for(int i=0; i<userArray.length; i++){//�õ��û���9����Ϣ
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
		MeminfTable = new JTable(Meminfmodel);//����Ϣ���ͷװ������
		/*���÷��ϴ�С���п�*/
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
		MeminfTable.setEnabled(false);//���ɱ༭
		MeminfTable.getTableHeader().setReorderingAllowed(false);//���������ƶ�   
		MeminfTable.getTableHeader().setResizingAllowed(false);//�����������
		MemNumLabel = new JLabel("�����Ź���  "+MemNum+"  ��");
		JScrollPane Meminftable = new JScrollPane(MeminfTable);//����һ������ͷ�ı��
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
	/*����������*/
	void kaopingShow(){
		kaopingPanel.setLayout(null);
		kaopingTabelObject = new String[kaopingArray.length][4];
		for(int i=0; i<kaopingArray.length; i++){//�õ�������Ϣ��4����Ϣ
			if(kaopingArray[i][0] != null){
			kaopingTabelObject[i][0] =  kaopingArray[i][0];
			kaopingTabelObject[i][1] =  kaopingArray[i][1];
			kaopingTabelObject[i][2] =  kaopingArray[i][2];
			kaopingTabelObject[i][3] =  kaopingArray[i][3];
			}
		}
		kaopingmodel = new DefaultTableModel(kaopingTabelObject, kaopingTableHead);
		kaopingTable = new JTable(kaopingmodel);//����Ϣ���ͷװ������
		/*���÷��ϴ�С���п�*/
		kaopingTable.getColumn(kaopingTableHead[0]).setPreferredWidth(75);
		kaopingTable.getColumn(kaopingTableHead[1]).setPreferredWidth(50);
		kaopingTable.getColumn(kaopingTableHead[2]).setPreferredWidth(100);
		kaopingTable.getColumn(kaopingTableHead[3]).setPreferredWidth(450);
		kaopingTable.setRowHeight(25);
		kaopingTable.setEnabled(false);//���ɱ༭
		kaopingTable.getTableHeader().setReorderingAllowed(false);//���������ƶ�   
		kaopingTable.getTableHeader().setResizingAllowed(false);//�����������
		JScrollPane kaopingtable = new JScrollPane(kaopingTable);//����һ������ͷ�ı��
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
		/*��ʼ�ı�����ʾ��Ϣ*/
		void TextShow(){
			//��������ȡ������Ϣ�����õ���Ӧ�ı���ͬʱ����Ϊ���ɱ༭
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
			if(userArray[Num][3].equals("��")){
				Male.setSelected(true);
				Female.setSelected(false);
				Male.setEnabled(false);
				Female.setEnabled(false);
			}
			else if(userArray[Num][3].equals("Ů")){
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
			Clubwelcome = ClubArray[0] + "��ӭ��";
			/*������Ϣ���*/
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
			/*ʱ�䡢���Ż�ӭ���*/
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
			if(userArray[Num][3].equals("��")){
				Male.setSelected(true);
				Female.setSelected(false);			
			}
			else if(userArray[Num][3].equals("Ů")){
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
		/*������Ϣ ������ϢsetText����*/
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
		/*����Ⱥ����ʾ��д�뷽��*/
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
		/*����Ա�û�Ȩ��*/
		void GuanliPower(){
			ExitClubcheck.setVisible(true);
			ClubModify.setEnabled(true);
			Deletepost.setVisible(true);
			issuepost.setVisible(true);
			}
		/*��ʼ��ֵ����*/
		void initpower(){
			ExitClubcheck.setVisible(false);
			ClubModify.setEnabled(false);
			Deletepost.setVisible(false);
			issuepost.setVisible(false);
			MeminfTable.setEnabled(false);//���ɱ༭
			AddMem.setVisible(false);
			DeleteMem.setVisible(false);
			SaveModify.setVisible(false);
			givekaoping.setEnabled(false);
			SearchNameText.setText(null);
			Num = -1;
			WelcomeLabel2.setText(null);
			WelcomeLabel3.setText(null);
			}
		/*��ť���������Ϻ���*/
		void monitor(){
		/*��¼���ڵ�¼��ť������*/
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
						if(userArray[i][11].equals("t")&&//���û��ύ����������
								userArray[i][12].equals("f")){//����Ա�Ѳ��Ǳ����ų�Ա
								ExitClubSuccessDialog.setVisible(true);
							}
						if(userArray[i][11].equals("t")&&//���û��ύ����������
								userArray[i][12].equals("t")){//����Ա��Ȼ�Ǳ����ų�Ա
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
							if(userArray[i][11].equals("t")&&//���û��ύ����������
									userArray[i][12].equals("f")){//����Ա�Ѳ��Ǳ����ų�Ա
									ExitClubSuccessDialog.setVisible(true);
								}
							if(userArray[i][11].equals("t")&&//���û��ύ����������
									userArray[i][12].equals("t")){//����Ա��Ȼ�Ǳ����ų�Ա
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
		/*��¼�����������밴ť������*/
		ResetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				IDText.setText(null);
				PassWordText.setText(null);
				LoginKind.clearSelection();
			}
		});
		/*���󴰿�ȷ����ť������*/
		ErrorSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ErrorFrame.dispose();
			}
		});
		/*������׼����ȷ����ť������*/
		ExitClubSuccessSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<userArray[Num].length; i++){//�Ѹ��û���Ϣȫ��ɾ��
					userArray[Num][i] = null;
				}
				yonghuFileWrite();
				ExitClubSuccessDialog.dispose();
				ClubFrame.dispose();
			}
		});
		/*����ܾ�����ȷ����ť������*/
		ExitClubDefaultSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				userArray[Num][11] = "f";//�û��ύ���������Ϊδ�ύ
				yonghuFileWrite();
				FileRead();
				ExitClubDefaultDialog.dispose();
			}
		});
		/*�޸����밴ť������*/
		ModifyPassword.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				card2.show(mainPanel, "ModifyPWPanel");
			}
		});
		/*�������簴ť������*/
		ExitClub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				card2.show(mainPanel, "ExitClubPanel");
			}
		});
		/*�˳���¼������*/
		ExitLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitLoginFrame.setVisible(true);
			}
		});
		/*�˳�ϵͳ������*/
		ExitSystem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitFrame.setVisible(true);
				
			}
		});
		/*�˳������ڼ�����*/
		ClubFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				ExitFrame.setVisible(true);
			}
		});
		/*�˳�ϵͳ��ʾ����ȷ�ϰ�ť������*/
		ExitSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitFrame.dispose();
				ClubFrame.dispose();
			}
		});
		/*�˳�ϵͳ��ʾ����ȡ����ť������*/
		ExitCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitFrame.dispose();
			}
		});
		/*�˳���¼��ʾ����ȷ�ϰ�ť������*/
		ExitLoginSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitLoginFrame.dispose();
				ClubFrame.dispose();
				IDText.setText(null);
				PassWordText.setText(null);
				LoginKind.clearSelection();	
				LoginFrame.setVisible(true);
				/*�˳���¼���¼�û���Ϣ�ı�����㣬��ӭ��ǩ����*/
				initpower();
			}
		});
		/*�˳���¼��ʾ����ȡ����ť������*/
		ExitLoginCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitLoginFrame.dispose();
			}
		});
		/*������Ϣ��ť������*/
		Perinf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FileRead();
				TextShowrefresh();
				card2.show(mainPanel, "PerinfPanel");
			}
		});
		/*������Ϣ��ť������*/
		Clubinf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FileRead();
				TextShowrefresh();
				card2.show(mainPanel, "ClubinfPanel");
			}
		});
		/*��Ա��Ϣ��ť������*/
		Meminf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FileRead();
				MeminfPanel.removeAll();
				MeminfShow();
				if(userArray[Num][10].equals("1")){
					MeminfTable.setEnabled(true);//�ɱ༭
					AddMem.setVisible(true);
					DeleteMem.setVisible(true);
					SaveModify.setVisible(true);
				}
				card2.show(mainPanel, "MeminfPanel");
			}
		});
		/*���������ť������*/
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
		/*���Ź��水ť������*/
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
		/*���Ź�����嵱ǰҳ��ѡ��������*/
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
		/*����Ⱥ�İ�ť������*/
		liuyan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FileRead();
				Setliuyan();
				card2.show(mainPanel, "liuyanPanel");
			}
		});
		/*���Ź��������һ��������*/
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
		/*���Ź��������һ��������*/
		previouspost.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ShowposttitleText.setText(null);
				ShowpostmainbodyText.setText(null);
				Postflag--;
				if(Postflag < 0)Postflag = 0;
				SetText();
			}
		});
		/*ɾ�����水ť������*/
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
		/*�����¹��水ť������*/
		issuepost.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				card2.show(mainPanel, "issuepostPanel");
			}
		});
		/*���ذ�ť������*/
		last.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				card1.show(daohangPanel, "putongPanel");
			}
		});
		/*�޸����봰��ȷ���޸İ�ť������*/
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
		/*�޸����봰���������ð�ť������*/
		ModifyPWCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				OldPWLabelText.setText(null);
				NewPWLabelText.setText(null);
				ConfirmPWLabelText.setText(null);
			}
		});
		/*�޸�������󴰿ڹرհ�ť������*/
		ModifyPWErrorClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				OldPWLabelText.setText(null);
				NewPWLabelText.setText(null);
				ConfirmPWLabelText.setText(null);
				ModifyPWError.dispose();
			}
		});
		/*�޸�������󴰿��˳�������*/
		ModifyPWError.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				OldPWLabelText.setText(null);
				NewPWLabelText.setText(null);
				ConfirmPWLabelText.setText(null);
				ModifyPWError.dispose();
			}
		});
		/*�޸�����ɹ����ڹرհ�ť������*/
		ModifyPWSuccessClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ModifyPWSuccess.dispose();
				OldPWLabelText.setText(null);
				NewPWLabelText.setText(null);
				ConfirmPWLabelText.setText(null);
			}
		});
		/*�޸�����ɹ������˳�������*/
		ModifyPWSuccess.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				ModifyPWSuccess.dispose();
				OldPWLabelText.setText(null);
				NewPWLabelText.setText(null);
				ConfirmPWLabelText.setText(null);
			}
		});
		/*�����������������˰�ť������*/
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
		/*������������ύ���밴ť������*/
		ExitClubSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if((ExitClubText.getText().length() >= 15)&&
				(ExitClubText.getText().length() <= 100))
				{
				String s1 = userArray[Num][2];
				long now = System.currentTimeMillis();// ����ǰȡ�õ�ǰʱ��  
			    Calendar c = Calendar.getInstance();  
			    c.setTimeInMillis(now);
			    String s2 = ("����ʱ��:" + c.get(Calendar.YEAR) + "��" 
			     + (c.get(Calendar.MONTH) + 1) + "��" + c.get(Calendar.DATE)  
			     + "��"+ (c.get(Calendar.HOUR)+12) + "ʱ" + c.get(Calendar.MINUTE)+"��");
			    String s3 = ExitClubText.getText()+" "+s2;
			    int i = 0;
			    while(ExitClubArray[i][0] != null){
			        i++;
			    }
			        ExitClubArray[i][0] = s1;
			        ExitClubArray[i][1] = s3;
				userArray[Num][11] = "t";//���û����ύ��������
				yonghuFileWrite();//�ύ��Ϣд��
				ExitClubinfWrite();//������Ϣд��
				ExitClubDialog.setVisible(true);
				ExitClubText.setText(null);
				}
			}
		});
		/*�����������ȡ�����밴ť������*/
		ExitClubCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitClubText.setText(null);
			}
		});
		/*������������ύ�ɹ�����ȷ����ť������*/
		ExitClubDialogSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ExitClubDialog.dispose();
			}
		});
		/*������������׼���밴ť������*/
		PassApplicantion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<userArray.length; i++){
					if(ApplicantText.getText().equals(userArray[i][2])){
						userArray[i][12] = "f";//f��ʾ���û��Ѳ��ڸ�����
						yonghuFileWrite();
						break;
					}
				}
				ApplicantText.setText(null);
				ApplicantionText.setText(null);
				SetText();
			}
		});
		/*����������ܾ����밴ť������*/
		RefuseApplicantion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ApplicantText.setText(null);
				ApplicantionText.setText(null);
				SetText();
			}
		});
		/*������Ϣ�����޸İ�ť������*/
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
		/*������Ϣ���ڱ��水ť������*/
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
				if(Male.isSelected())userArray[Num][3] = "��";
				else if(Female.isSelected())userArray[Num][3] = "Ů";
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
		/*������Ϣ�����޸İ�ť������*/
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
		/*������Ϣ���ڱ��水ť������*/
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
		/*��Ա��Ϣ��������Ա��ť������*/
		SearchMem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
	          String s = SearchNameText.getText();
	          int flag = 0;
	          for(int i=0; i<MeminfTable.getRowCount(); i++){
	        	  if(s.equals(Meminfmodel.getValueAt(i, 0))){//��i+1�е�1��
	        		  MeminfTable.setRowSelectionInterval(i,i);//����ʹ��i+1�и���
	        		  flag = 1;
	        		  break;
	        	  }
	          }
	          if(flag == 0)MeminfTable.clearSelection();//���ѡ����Ϣ
			}
		});
		/*��Ա��Ϣ��������Ա��ť������*/
		AddMem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Meminfmodel.addRow(new Object[]{" "});
			}
		});
		/*��Ա��Ϣ���ɾ����Ա��ť������*/
		DeleteMem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int selectRows[] = MeminfTable.getSelectedRows();
				if(selectRows.length > 0){//��ȷʵѡ���˱���ĳ����
					for(int i=0; i<selectRows.length; i++){
						if(selectRows[i] > -1)
				Meminfmodel.removeRow(selectRows[0]);
					}
				}
			}
		});
		/*��Ա��Ϣ��屣���޸İ�ť������*/
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
					if(i > 2){//�������������Ȩ�޾�Ϊ��ͨ(0)����ʼ��������Ϣ��Ϊδ�ύ(f),��������(t)
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
				MemNumLabel = new JLabel("�����Ź���  "+MemNum+"  ��");
				MemNumLabel.setFont(new Font("MemNumLabel",Font.BOLD, 15));
				MeminfPanel.add(MemNumLabel);
				MemNumLabel.setBounds(0, 0, 150, 30);
				ClubArray[3] =  ""+MemNum;//������MemNumתΪ�ַ���
				yonghuFileWrite();
				ClubFileWrite();
				kaopingWrite();
				MeminfTable.clearSelection();//ȡ��ѡ��
			}
		});
		/*������������Ա������ť������*/
		givekaoping.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Savekaoping.setEnabled(true);
				kaopingTable.setEnabled(true);
				givekaoping.setEnabled(false);
			}
		});
		/*���������屣�濼����ť������*/
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
				kaopingTable.clearSelection();//ȡ��ѡ��
				givekaoping.setEnabled(true);
				kaopingTable.setEnabled(false);
				Savekaoping.setEnabled(false);
			}
		});
		/*����������巢����ť*/
		issuepostSure.addActionListener(new ActionListener(){
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if((posttitleText.getText().length() > 0)&&
				(postmainbodyText.getText().length() >= 15)&&
				(postmainbodyText.getText().length() <= 250)){
				String s1 = posttitleText.getText();
				long now = System.currentTimeMillis(); // ����ǰȡ�õ�ǰʱ�� 
			     Calendar c = Calendar.getInstance();  
			    c.setTimeInMillis(now);
			    String s2 = (userArray[Num][2]+"������" + c.get(Calendar.YEAR) + "��" 
			     + (c.get(Calendar.MONTH) + 1) + "��" + c.get(Calendar.DATE)  
			     + "��"+ (c.get(Calendar.HOUR)+12) + "ʱ" + c.get(Calendar.MINUTE)+"��");
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
		/*�����������ȡ����ť*/
		issuepostCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				posttitleText.setText(null);
				postmainbodyText.setText(null);
				card2.show(mainPanel, "ClubpostPanel");
			}
		});
		/*���԰�������԰�ť*/
		liuyanOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(liuyanText.getText().length() > 0){
				long now = System.currentTimeMillis(); // ����ǰȡ�õ�ǰʱ�� 
				  Calendar c = Calendar.getInstance();  
				  c.setTimeInMillis(now);
				  String s = ("["+c.get(Calendar.YEAR) + "��" 
				 + (c.get(Calendar.MONTH) + 1) + "��" + c.get(Calendar.DATE)  
				 + "��"+ (c.get(Calendar.HOUR)+12) + "ʱ" + c.get(Calendar.MINUTE)+"��"
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
		/*���԰������հ�ť*/
		liuyanCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				liuyanText.setText(null);
			}
		});
		
	}
	/*��ȡ�����û���Ϣ*/
	void FileRead() {
		try {
			FileInputStream file1 = new FileInputStream("�û���Ϣ.txt");
			InputStreamReader file11 = new InputStreamReader(file1);
			BufferedReader reader1 = new BufferedReader(file11);
			FileInputStream file2 = new FileInputStream("������Ϣ.txt");
			InputStreamReader file22 = new InputStreamReader(file2);
			BufferedReader reader2 = new BufferedReader(file22);
			FileInputStream file3 = new FileInputStream("������Ϣ.txt");
			InputStreamReader file33 = new InputStreamReader(file3);
			BufferedReader reader3 = new BufferedReader(file33);
			FileInputStream file4 = new FileInputStream("������Ϣ.txt");
			InputStreamReader file44 = new InputStreamReader(file4);
			BufferedReader reader4 = new BufferedReader(file44);
			FileInputStream file5 = new FileInputStream("������Ϣ.txt");
			InputStreamReader file55 = new InputStreamReader(file5);
			BufferedReader reader5 = new BufferedReader(file55);
			FileInputStream file6 = new FileInputStream("������Ϣ.txt");
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
	
	/*�ļ���Ϣд�뺯��*/
	/*������Ϣд��*/
	void ExitClubinfWrite(){
        try {
			File fileout = new File("������Ϣ.txt");
			FileWriter write = new FileWriter(fileout,false);//����֮ǰ�������ٴ�д���ļ�
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
	/*�û���Ϣд��*/
	void yonghuFileWrite(){
			try {
				File fileout = new File("�û���Ϣ.txt");
				FileWriter write = new FileWriter(fileout,false);//����֮ǰ�������ٴ�д���ļ�
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
	/*������Ϣд��*/
	void ClubFileWrite(){
		try{
			File fileout = new File("������Ϣ.txt");
			FileWriter write = new FileWriter(fileout,false);//����֮ǰ�������ٴ�д���ļ�
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
	/*������Ϣд��*/
	void ClubpostWrite(){
        try {
			File fileout = new File("������Ϣ.txt");
			FileWriter write = new FileWriter(fileout,false);//����֮ǰ�������ٴ�д���ļ�
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
	/*������Ϣд��*/
	void kaopingWrite(){
        try {
			File fileout = new File("������Ϣ.txt");
			FileWriter write = new FileWriter(fileout,false);//����֮ǰ�������ٴ�д���ļ�
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
	/*������Ϣд��*/
	void liuyanWrite(){
        try {
			File fileout = new File("������Ϣ.txt");
			FileWriter write = new FileWriter(fileout,false);//����֮ǰ�������ٴ�д���ļ�//�ַ���
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

	�޸����� ֻ�о�������ȷ�������� �ظ�������ͬ�ſ���ɸ���
	��������
	���Ѿ�����ƣ�������æ��ѧϰ�����裬�����Ĺ�ע���Ż�������˳����ţ������Ա��׼��лл��
	����Ա����һ�� �ܾ�
	��ͨ�û�����һ�� ��׼
	������Ϣ ������Ϣ�������� ��Ա��Ϣҳ ��Ϣͬ��
	��Ա��Ϣҳ��Ĳ��Ҹ���  �޸� ɾ����Ϣ ���� ɾ���� ������Ϣҳ����Ϣͬ����ɾ��
	����ҳ�Ŀ�����Ϣ�޸� 
	����һ���¹���
	��������
	�������������о�Ժ405���տ��裬û����ɵ���������ͬ��ʱ��ص㡣
	ɾ������ ҳ���仯
	����ķ�ҳ ֱ�Ӷ�λҳ��
	Ⱥ�����
	��ͬ�û�֮�����Ϣͬ��
	
*/
















