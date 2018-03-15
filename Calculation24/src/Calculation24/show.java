/**
 * ��Ŀ��Ŀ����24��
 * ����ʱ�䣺2017.02.27
 * ���ߣ�150410231-������
 */
package Calculation24;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
//import java.io.InputStream;  
//import java.io.OutputStream;  
//import java.io.RandomAccessFile;  

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;


@SuppressWarnings("deprecation")
public class show {
	/*������*/
	private JFrame MainFrame = new JFrame("��24��");
	private JLabel MainPicture;
	private JPanel MainPanel = new JPanel();
	private CardLayout card = new CardLayout();
	/*�������*/
	private JPanel daohangPanel = new JPanel();
	private JLabel daohangLabel;
	ImageIcon BeginGameimg = new ImageIcon("Image/go.png");
	private JButton BeginGame = new JButton(BeginGameimg);
	ImageIcon Calculation24img = new ImageIcon("Image/Calculation24.png");
	private JButton Calculation24 = new JButton(Calculation24img);
	ImageIcon Rankingimg = new ImageIcon("Image/Ranking.png");
	private JButton Ranking = new JButton(Rankingimg);
	ImageIcon GameSettingimg = new ImageIcon("Image/GameSetting.png");
	private JButton GameSetting = new JButton(GameSettingimg);
	ImageIcon GameHelpimg = new ImageIcon("Image/GameHelp.png");
	private JButton GameHelp = new JButton(GameHelpimg);
	ImageIcon ExitGameimg = new ImageIcon("Image/ExitGame.png");
	private JButton ExitGame = new JButton(ExitGameimg);
	/*�˳���Ϸѯ�ʴ���*/
	private JDialog ExitGameDialog = new JDialog(MainFrame,"�˳���Ϸ",true);
	ImageIcon Exitimg = new ImageIcon("Image/ask.png");
	private JLabel ExitGameDialogimg = new JLabel(Exitimg);
	private JLabel ExitGameLabel = new JLabel("��ȷ���˳���Ϸ��?");
	private JButton ExitGameSure = new JButton("ȷ���˳�");
	private JButton ExitGameCancel = new JButton("�һ�Ҫ��");
	/*ģʽѡ�����*/
	private JPanel ModeChoosePanel = new JPanel();
	private int ModeFlag = 0;
	private int LastMode = 0;
	ImageIcon Exerciseimg = new ImageIcon("Image/Exercise.png");
	private JButton Exercise = new JButton(Exerciseimg);
	private JLabel ExerciseLabel;
	ImageIcon Breakimg = new ImageIcon("Image/Break.png");
	private JButton Break = new JButton(Breakimg);
	private JLabel BreakLabel;
	ImageIcon Speedimg = new ImageIcon("Image/Speed.png");
	private JButton Speed = new JButton(Speedimg);
	private JLabel SpeedLabel;
	ImageIcon ModeChooseReturnimg = new ImageIcon("Image/Return.png");
	private JButton ModeChooseReturn = new JButton(ModeChooseReturnimg);
	/*��ϰģʽ���*/
	private JPanel ExercisePanel = new JPanel();
	private JDialog ExerciseTip = new JDialog(MainFrame,"��ϰģʽ",true);
	private JLabel ExerciseTipLabel = new JLabel("<html>��ϰģʽ����ģʽ����ϰʹ�ã�"
			+ "<br/>����ʱ���ṩ��ȷ�����������</html>");//html�﷨ʵ�ֱ�ǩ����
	ImageIcon BeginExerciseimg = new ImageIcon("Image/BeginExercise.png");
	private JButton BeginExercise = new JButton(BeginExerciseimg);
	private int Right = 0;
	private int Wrong = 0;
	private JLabel RightNum = new JLabel("�������: " +Right+ " ");
	private JLabel WrongNum = new JLabel("��������: " +Wrong+ " ");
	private JLabel ExerciseCards1;
	private JLabel ExerciseCards2;
	private JLabel ExerciseCards3;
	private JLabel ExerciseCards4;
	private JTextField ExerciseArea = new JTextField();
	ImageIcon Gamedaojuimg = new ImageIcon("Image/Gamedaoju.png");
	private JButton Gamedaoju = new JButton(Gamedaojuimg);
	private JButton ExerciseNumber1;
	private JButton ExerciseNumber2;
	private JButton ExerciseNumber3;
	private JButton ExerciseNumber4;
	private JButton ExerciseLBracket = new JButton("(");
	private JButton ExerciseRBracket = new JButton(")");
	private JButton Exercisejia = new JButton("+");
	private JButton Exercisejian = new JButton("-");
	private JButton Exercisecheng = new JButton("*");
	private JButton Exercisechuyi = new JButton("/");
	private JButton ExerciseSure = new JButton("ȷ��");
	private JButton Exercisewujie = new JButton("�޽�");
	private JButton ExerciseClear = new JButton("���");
	private JButton ExerciseView = new JButton("�鿴");
	private JButton ExercisePass = new JButton("��һ��");
	private JButton ExerciseExit = new JButton("�˳�");
	/*����ģʽ���*/
	private JDialog BreakTip = new JDialog(MainFrame,"����ģʽ",true);
	private JLabel BreakTipLabel = new JLabel("<html>����ģʽ����ģʽ���ڹ涨ʱ���ڣ�"
	+ "<br/>ÿ��5����Ŀȫ������������һ�ء�<br/>���Կ����ܴ�������~"
	+ "<br/><br/>��ѡ������Ҫ���е���Ϸ�Ѷȣ�</html>");//html�﷨ʵ�ֱ�ǩ����
	@SuppressWarnings("rawtypes")
	private JComboBox BreakDifficulty = new JComboBox();//�Ѷ�ѡ���
	private JTextArea Breakintroduction = new JTextArea("�ؿ���ʼʱ��Ϊ200�룬"
    		+ "ÿ2��ʱ������\n20�룬���120�롣(����JQK)");//�ѶȽ����ı���
	ImageIcon BeginBreakimg = new ImageIcon("Image/BeginBreak.png");
	private JButton BeginBreak = new JButton(BeginBreakimg);
	private int Level = 1;//�ؿ���
	private int Correct = 5;//ʣ������
	private int BreakFlag = 1;//�Ѷȱ�ʶ
	private JLabel LevelNum = new JLabel("�� "+ Level +" ��");
	private JLabel CorrectNum = new JLabel("ʣ������: " +Correct);
	private JLabel BreakTimeLabel = new JLabel("ʣ��ʱ��: ");
	private int BreakTime;
	private Timer count = new Timer();
	/*����ģʽ���*/
	private JDialog SpeedTip = new JDialog(MainFrame,"����ģʽ",true);
	private JLabel SpeedTipLabel = new JLabel("<html>����ģʽ����ģʽ��ÿ����<br/>������"
	+ "�ڹ̶�ʱ������ɣ�<br/>�����Game over�ˡ�<br/>׼���ÿ�����������"
	+ "<br/><br/>��ѡ������Ҫ���е���Ϸ�Ѷȣ�</html>");
	@SuppressWarnings("rawtypes")
	private JComboBox SpeedDifficulty = new JComboBox();
	private JTextArea Speedintroduction = new JTextArea("ÿ����40��ʱ������(����JQK)");
	ImageIcon BeginSpeedimg = new ImageIcon("Image/BeginSpeed.png");
	private JButton BeginSpeed = new JButton(BeginSpeedimg);
	private int SpeedNum = 0;//�������
	private int SpeedFlag = 1;//�Ѷȱ�ʶ
	private JLabel Answered = new JLabel("�Ѵ������: " + SpeedNum);
	private JLabel SpeedTimeLabel = new JLabel("ʣ��ʱ��: ");
	private int SpeedTime;
	/*��������Ϸ��ı�ʶ*/
	private int NumFlag = 1;
	private int ChFlag = 0;
	private int BrFlag = 0;
	/*�˳�ѯ�ʴ���*/
	private JDialog Exitask = new JDialog(MainFrame,"�˳�ȷ��",true);
	ImageIcon askimg = new ImageIcon("Image/ask.png");
	private JLabel Exitaskimg = new JLabel(askimg);
	private JLabel ExitaskLabel = new JLabel("�����Ҫ�˳���?");
	private JButton ExitaskSure = new JButton("ȷ��");
	private JButton ExitaskCancel = new JButton("�ҵ����");
	/*��Ϸ���ߴ���*/
	private JDialog GamedaojuDialog = new JDialog(MainFrame,"ȷ��ʹ��",true);
	private JLabel GamedaojuLabel = new JLabel("<html>ȷ��������ʱ�����ʹ�����ֵ�������"
			+ "<br/>(���ĸ����ֲ�����ʹ�ô����͸���������һ�δ�������������Ч)</html>");
	ImageIcon GamedaojuSureimg = new ImageIcon("Image/daojuSure.png");
	private JButton GamedaojuSure = new JButton(GamedaojuSureimg);
	ImageIcon GamedaojuCancelimg = new ImageIcon("Image/daojuCancel.png");
	private JButton GamedaojuCancel = new JButton(GamedaojuCancelimg);
	private int daojuFlag = 0;
	/*��Ϸ�������*/
	private JPanel GameoverPanel = new JPanel();
	private JLabel GameoverLabel;
	private JLabel YourScore = new JLabel("���ĳɼ�");
	private JLabel FinalAnswerLabel = new JLabel("���մ�: ");
	private JLabel FinalAnswer = new JLabel("((a@b)@c)@d");
	private JLabel FinalScoreLabel = new JLabel("���ճɼ�: ");
	private JLabel FinalScore = new JLabel("X");
	ImageIcon GameoverReturnimg = new ImageIcon("Image/ReturnMenu.png");
	private JButton GameoverReturn = new JButton(GameoverReturnimg);
	ImageIcon GameoverAgainimg = new ImageIcon("Image/Again.png");
	private JButton GameoverAgain = new JButton(GameoverAgainimg);
	private JDialog NewRecord = new JDialog(MainFrame,"�¼�¼!",true);
	private JLabel NewRecordLabel = new JLabel("<html>��������Ϸ�Ѵ��Ƽ�¼!"
			+ "<br/><br/>�������մ���: </html>");
	private JTextField NewRecordName = new JTextField();
	ImageIcon NewRecordSureimg = new ImageIcon("Image/Sure.png");
	private JButton NewRecordSure = new JButton(NewRecordSureimg);
	/*����24�����*/
	private JPanel Calculation24Panel = new JPanel();
	private JLabel CalculationLabel;
	private JTextField DisplayArea = new JTextField();
	private JTextField ValueArea1 = new JTextField();
	private JTextField ValueArea2 = new JTextField();
	private JTextField ValueArea3 = new JTextField();
	private JTextField ValueArea4 = new JTextField();
	private JButton Number1 = new JButton("1");
	private JButton Number2 = new JButton("2");
	private JButton Number3 = new JButton("3");
	private JButton Number4 = new JButton("4");
	private JButton Number5 = new JButton("5");
	private JButton Number6 = new JButton("6");
	private JButton Number7 = new JButton("7");
	private JButton Number8 = new JButton("8");
	private JButton Number9 = new JButton("9");
	private JButton Number10 = new JButton("10");
	private JButton Number11 = new JButton("11");
	private JButton Number12 = new JButton("12");
	private JButton Number13 = new JButton("13");
	private JButton Answer = new JButton("���");
	private JButton Delete = new JButton("���");
	private JButton Calculation24Return = new JButton("����");
	/*���а����*/
	private JPanel RankingPanel = new JPanel();
	private JLabel RankingBreak = new JLabel("����ģʽ: ");
	private JLabel RankingSpeed = new JLabel("����ģʽ: ");
	@SuppressWarnings("rawtypes")
	private JComboBox RankingBreakBox = new JComboBox();
	private int RankingBreakFlag = 1;
	@SuppressWarnings("rawtypes")
	private JComboBox RankingSpeedBox = new JComboBox();
	private int RankingSpeedFlag = 5;
	ImageIcon WantListimg = new ImageIcon("Image/WantList.png");
	private JButton WantList = new JButton(WantListimg);
	ImageIcon RankingReturnimg = new ImageIcon("Image/Return1.png");
	private JButton RankingReturn = new JButton(RankingReturnimg);
	private JTable BreakTable;
	private JScrollPane Breaktable;
	private String BreakTableHead[] = {"����","����","����"};
	private Object BreakTableObject[][];
	private Object BreakTableObjectnew[][];
	private JTable SpeedTable;
	private JScrollPane Speedtable;
	private String SpeedTableHead[] = {"����","����","����"};
	private Object SpeedTableObject[][];
	private Object SpeedTableObjectnew[][];
	private String RankingArray1[][] = new String[100][3];
	private String RankingArray2[][] = new String[100][3];
	private String RankingArray3[][] = new String[100][3];
	private String RankingArray4[][] = new String[100][3];
	private String RankingArray5[][] = new String[100][3];
	private String RankingArray6[][] = new String[100][3];
	private String RankingArray7[][] = new String[100][3];
	private String RankingArray8[][] = new String[100][3];
	/*��Ϸ�������*/
	private JPanel GameSettingPanel = new JPanel();
	private JLabel GameSettingLabel;
	private String GameFlag[] = new String[4];//��������,��Ϸ��Ч��JQK��ʶ����Ϸ������������
	private JLabel BGMSwitch = new JLabel("��������: ");
	private ButtonGroup BGMKind = new ButtonGroup();
	private JRadioButton BGMkai = new JRadioButton("��");
	private JRadioButton BGMguan = new JRadioButton("��");
	private JLabel Sound = new JLabel("��Ϸ��Ч: ");
	private ButtonGroup SoundKind = new ButtonGroup();
	private JRadioButton Soundkai = new JRadioButton("��");
	private JRadioButton Soundguan = new JRadioButton("��");
	private JLabel HaveJQK = new JLabel("���ƺ�JQK: ");
	private ButtonGroup JQKKind = new ButtonGroup();
	private JRadioButton JQKyou = new JRadioButton("��");
	private JRadioButton JQKwu = new JRadioButton("���� (����ϰģʽ)");
	private JLabel daojuNum = new JLabel("<html>���ֲ���ʹ��ʣ�����: " + GameFlag[3]
			+"<br/>(��ս���а���Ի�ø����������!)</html>");
	ImageIcon GameSettingSaveimg = new ImageIcon("Image/Save.png");
	private JButton GameSettingSave = new JButton(GameSettingSaveimg);
	ImageIcon GameSettingCancelimg = new ImageIcon("Image/Cancel.png");
	private JButton GameSettingCancel = new JButton(GameSettingCancelimg);
	private File BGMfile = new File("Music/BGM.wav");
	private File WINfile = new File("Music/WIN.wav");
	private File LOSEfile = new File("Music/LOSE.wav");
	private File BUTTONfile = new File("Music/Button.wav");
	private File NULLfile = new File("Music/000.wav");//���ļ�
	private AudioClip BGMClip;
	private AudioClip WINClip;
	private AudioClip LOSEClip;
	private AudioClip BUTTONClip;
	/*��Ϸ�������*/
	private JPanel GameHelpPanel = new JPanel();
	private JLabel GameHelpLabel;
	ImageIcon ISeeimg = new ImageIcon("Image/ISee.png");
	private JButton ISee = new JButton(ISeeimg);
	
	public static void main(String args[]) {
		show a = new show();
		a.RankingRead();//�ļ���ȡ
		a.MUSIC();//��������
		a.UI();//����UI
		a.monitor();//���ؼ���
//		Expression b = new Expression();
//		b.CaveatUI();
	}
	/*��ʱ��*/
		class MYTimerTask extends TimerTask{ 
		    @Override 
		    //�˷���Ϊ����Ҫ��ʱ�����ķ���  
		    public void run() { 
		    	if(ModeFlag == 2){
		    		ExercisePanel.remove(BreakTimeLabel);
		    		BreakTime--;
		    		if(BreakTime < 0){
		    			WrongReact();
		    		}
		    		BreakTimeLabel = new JLabel("ʣ��ʱ��: " + BreakTime);
		    		BreakTimeLabel.setFont(new Font("BreakTimeLabel",Font.BOLD, 30));
					ExercisePanel.add(BreakTimeLabel);
					BreakTimeLabel.setBounds(470, 30, 200, 50);
		    	}
		    	else if(ModeFlag == 3){
		    		ExercisePanel.remove(SpeedTimeLabel);
		    		SpeedTime--;
		    		if(SpeedTime < 0){
		    			WrongReact();
		    		}
		    		SpeedTimeLabel = new JLabel("ʣ��ʱ��: " + SpeedTime);
		    		SpeedTimeLabel.setFont(new Font("SpeedTimeLabel",Font.BOLD, 30));
					ExercisePanel.add(SpeedTimeLabel);
					SpeedTimeLabel.setBounds(470, 30, 200, 50);
		    	}
		    } 
		} 
		
	@SuppressWarnings("unchecked")
	void UI(){
		/*�����ڳ�ʼ���벼��*/
		MainFrame.setSize(700,700);
		MainFrame.setVisible(true);
		MainFrame.setLocationRelativeTo(null);
		MainFrame.setResizable(false);
		MainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ImageIcon maintubiao = new ImageIcon("Image/24.jpg");//������ͼ��
		MainFrame.setIconImage(maintubiao.getImage());
		MainFrame.setLayout(null);
		MainFrame.add(MainPanel);
		MainPanel.setBounds(0, 0, 700, 700);
		MainPanel.setOpaque(false);//���͸������ʾ����ͼƬ
		MainPanel.setLayout(card);
		ImageIcon background = new ImageIcon("Image/000.png"); 
		MainPicture = new JLabel(background);
		MainPicture.setBounds(0, 0, 700, 700);
		JPanel imagePanel = (JPanel) MainFrame.getContentPane();  
        imagePanel.setOpaque(false);
		MainFrame.getLayeredPane().add(MainPicture, new Integer(Integer.MIN_VALUE));
		/*�������*/
		daohangPanel.setLayout(null);
		daohangPanel.setOpaque(false);
		ImageIcon daohangimg = new ImageIcon("Image/001.png"); 
		daohangLabel = new JLabel(daohangimg);
		daohangPanel.add(daohangLabel);
		daohangLabel.setBounds(30, 100, 548, 100);//24��ͼƬ
		BeginGame.setFont(new Font("BeginGame",Font.BOLD, 30));
		BeginGame.setBorderPainted(false);
		BeginGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		daohangPanel.add(BeginGame);
		BeginGame.setBounds(200, 220, 300, 40);
		Calculation24.setFont(new Font("Calculation24",Font.BOLD, 30));
		Calculation24.setBorderPainted(false);
		//Calculation24.setVisible(false);
		Calculation24.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		daohangPanel.add(Calculation24);
		Calculation24.setBounds(200, 280, 300, 40);
		Ranking.setFont(new Font("Ranking",Font.BOLD, 30));
		Ranking.setBorderPainted(false);
		Ranking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		daohangPanel.add(Ranking);
		Ranking.setBounds(200, 340, 300, 40);
		GameSetting.setFont(new Font("GameSetting",Font.BOLD, 30));
		GameSetting.setBorderPainted(false);
		GameSetting.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		daohangPanel.add(GameSetting);
		GameSetting.setBounds(200, 400, 300, 40);
		GameHelp.setFont(new Font("GameHelp",Font.BOLD, 30));
		GameHelp.setBorderPainted(false);
		GameHelp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		daohangPanel.add(GameHelp);
		GameHelp.setBounds(200, 460, 300, 40);
		ExitGame.setFont(new Font("ExitGame",Font.BOLD, 30));
		ExitGame.setBorderPainted(false);
		ExitGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		daohangPanel.add(ExitGame);
		ExitGame.setBounds(200, 520, 300, 40);
		MainPanel.add("daohangPanel", daohangPanel);
		
		/*�˳���Ϸѯ�ʴ���*/
		ExitGameDialog.setSize(400, 300);
		ExitGameDialog.setResizable(false);
		ExitGameDialog.setVisible(false);
		ExitGameDialog.setLocationRelativeTo(null);
		ExitGameDialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ExitGameDialog.setLayout(null);
		ExitGameDialog.add(ExitGameDialogimg);
		ExitGameDialogimg.setBounds(30, 30, 50, 50);
		ExitGameLabel.setFont(new Font("ExitGameLabel",Font.BOLD, 25));
		ExitGameDialog.add(ExitGameLabel);
        ExitGameLabel.setBounds(90, 30, 300, 50);
        ExitGameSure.setFont(new Font("ExitGameSure",Font.BOLD, 25));
        ExitGameDialog.add(ExitGameSure);
        ExitGameSure.setBounds(40, 200, 150, 50);
        ExitGameCancel.setFont(new Font("ExitGameCancel",Font.BOLD, 25));
        ExitGameDialog.add(ExitGameCancel);
        ExitGameCancel.setBounds(210, 200, 150, 50);
		/*ģʽѡ�����*/
		ModeChoosePanel.setLayout(null);
		ModeChoosePanel.setOpaque(false);
		Exercise.setFont(new Font("Exercise",Font.BOLD, 30));
		Exercise.setBorderPainted(false);
		Exercise.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ModeChoosePanel.add(Exercise);
		Exercise.setBounds(350, 30, 300, 40);
		ImageIcon Exerciseimg = new ImageIcon("Image/��ϰ.png"); 
		ExerciseLabel = new JLabel(Exerciseimg);
		ModeChoosePanel.add(ExerciseLabel);
		ExerciseLabel.setBounds(50, 75, 500, 100);
		Break.setFont(new Font("Break_through",Font.BOLD, 30));
		Break.setBorderPainted(false);
		Break.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ModeChoosePanel.add(Break);
		Break.setBounds(50, 195, 300, 40);
		ImageIcon Break_throughimg = new ImageIcon("Image/����.png"); 
		BreakLabel = new JLabel(Break_throughimg);
		ModeChoosePanel.add(BreakLabel);
		BreakLabel.setBounds(150, 250, 500, 100);
		Speed.setFont(new Font("Speed_Cal",Font.BOLD, 30));
		Speed.setBorderPainted(false);
		Speed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ModeChoosePanel.add(Speed);
		Speed.setBounds(350, 370, 300, 40);
		ImageIcon Speed_Calimg = new ImageIcon("Image/����.png"); 
		SpeedLabel = new JLabel(Speed_Calimg);
		ModeChoosePanel.add(SpeedLabel);
		SpeedLabel.setBounds(50, 420, 500, 100);
		ModeChooseReturn.setFont(new Font("ModeChooseReturn",Font.BOLD, 30));
		ModeChooseReturn.setBorderPainted(false);
		ModeChooseReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ModeChoosePanel.add(ModeChooseReturn);
		ModeChooseReturn.setBounds(200, 540, 300, 40);
		MainPanel.add("ModeChoosePanel", ModeChoosePanel);
		
		
		/*��ϰģʽ���*/
		//��ϰģʽ��ʾ�Ի���
		ExerciseTip.setSize(300, 250);
		ExerciseTip.setResizable(false);
		ExerciseTip.setVisible(false);
		ExerciseTip.setLocationRelativeTo(null);
		ExerciseTip.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ExerciseTip.setLayout(null);
		ImageIcon Exercisebgd = new ImageIcon("Image/003.png"); 
		JLabel ExercisePicture = new JLabel(Exercisebgd);
		ExercisePicture.setBounds(0, 0, 300, 250);
		JPanel ExercisePanel1 = (JPanel) ExerciseTip.getContentPane();  
		ExercisePanel1.setOpaque(false);
		ExerciseTip.getLayeredPane().add(ExercisePicture, new Integer(Integer.MIN_VALUE));
		ExerciseTipLabel.setFont(new Font("ExerciseTipLabel",Font.BOLD, 20));
		ExerciseTip.add(ExerciseTipLabel);
		ExerciseTipLabel.setBounds(10, 0, 300, 150);
		BeginExercise.setBorderPainted(false);
		BeginExercise.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ExerciseTip.add(BeginExercise);
		BeginExercise.setBounds(50, 160, 200, 40);
		
		//��ϰģʽ�����
		ExercisePanel.setLayout(null);
		ExercisePanel.setOpaque(false);
		ExerciseCards1 = new JLabel("");//�˿��Ʊ�ǩ��ʼ��
		ExerciseCards2 = new JLabel("");
		ExerciseCards3 = new JLabel("");
		ExerciseCards4 = new JLabel("");
		ExerciseNumber1 = new JButton("0");
		ExerciseNumber2 = new JButton("0");
		ExerciseNumber3 = new JButton("0");
		ExerciseNumber4 = new JButton("0");
		ExerciseCardsRefresh();
		Gamedaoju.setBorderPainted(false);
		Gamedaoju.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ExercisePanel.add(Gamedaoju);
		Gamedaoju.setBounds(18, 401, 100, 70);
		Gamedaoju.setVisible(false);
		ExerciseArea.setFont(new Font("ExerciseArea",Font.BOLD, 20));
		ExerciseArea.setEditable(false);//ֻ����ʾ��������༭����
		ExerciseArea.setOpaque(false);
		ExerciseArea.setHorizontalAlignment(JTextField.CENTER);//�ı�����
		ExercisePanel.add(ExerciseArea);
		ExerciseArea.setBounds(18, 400, 649, 50);
		Exercisejia.setFont(new Font("Exercisejia",Font.BOLD, 20));
		ExercisePanel.add(Exercisejia);
		Exercisejia.setBounds(18, 510, 140, 40);
		Exercisejian.setFont(new Font("Exercisejian",Font.BOLD, 20));
		ExercisePanel.add(Exercisejian);
		Exercisejian.setBounds(187, 510, 140, 40);
		Exercisecheng.setFont(new Font("Exercisecheng",Font.BOLD, 20));
		ExercisePanel.add(Exercisecheng);
		Exercisecheng.setBounds(357, 510, 140, 40);
		Exercisechuyi.setFont(new Font("Exercisechuyi",Font.BOLD, 20));
		ExercisePanel.add(Exercisechuyi);
		Exercisechuyi.setBounds(527, 510, 140, 40);
		ExerciseLBracket.setFont(new Font("ExerciseLBracket",Font.BOLD,20));
		ExercisePanel.add(ExerciseLBracket);
		ExerciseLBracket.setBounds(18, 560, 140, 40);
		ExerciseRBracket.setFont(new Font("ExerciseRBracket",Font.BOLD, 20));
		ExercisePanel.add(ExerciseRBracket);
		ExerciseRBracket.setBounds(187, 560, 140, 40);
		ExerciseSure.setFont(new Font("ExerciseSure",Font.BOLD, 20));
		ExercisePanel.add(ExerciseSure);
		ExerciseSure.setBounds(357, 560, 140, 40);
		Exercisewujie.setFont(new Font("Exercisewujie",Font.BOLD, 20));
		ExercisePanel.add(Exercisewujie);
		Exercisewujie.setBounds(527, 560, 140, 40);
		ExerciseClear.setFont(new Font("ExerciseClear",Font.BOLD, 20));
		ExercisePanel.add(ExerciseClear);
		ExerciseClear.setBounds(18, 610, 140, 40);
		ExerciseView.setFont(new Font("ExerciseView",Font.BOLD, 20));
		ExercisePanel.add(ExerciseView);
		ExerciseView.setBounds(187, 610, 140, 40);
		ExercisePass.setFont(new Font("ExercisePass",Font.BOLD, 20));
		ExercisePanel.add(ExercisePass);
		ExercisePass.setBounds(357, 610, 140, 40);
		ExerciseExit.setFont(new Font("ExerciseExit",Font.BOLD, 20));
		ExercisePanel.add(ExerciseExit);
		ExerciseExit.setBounds(527, 610, 140, 40);
		MainPanel.add("ExercisePanel", ExercisePanel);
		
		
		/*����ģʽ���*/
		BreakTip.setSize(400, 350);
		BreakTip.setResizable(false);
		BreakTip.setVisible(false);
		BreakTip.setLocationRelativeTo(null);
		BreakTip.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		BreakTip.setLayout(null);
		ImageIcon Breakbgd = new ImageIcon("Image/003.png"); 
		JLabel BreakPicture = new JLabel(Breakbgd);
		BreakPicture.setBounds(0, 0, 400, 350);
		JPanel BreakPanel = (JPanel) BreakTip.getContentPane();  
		BreakPanel.setOpaque(false);
		BreakTip.getLayeredPane().add(BreakPicture, new Integer(Integer.MIN_VALUE));
		BreakTipLabel.setFont(new Font("BreakTipLabel",Font.BOLD, 20));
		BreakTip.add(BreakTipLabel);
		BreakTipLabel.setBounds(10, 0, 390, 150);
		BreakDifficulty.addItem("�����Ѷ�");
		BreakDifficulty.addItem("�м��Ѷ�");
		BreakDifficulty.addItem("�߼��Ѷ�");
		BreakDifficulty.addItem("ج���Ѷ�(����˼)");
		BreakDifficulty.setFont(new Font("BreakDifficulty",Font.BOLD, 20));
		BreakTip.add(BreakDifficulty);
		BreakDifficulty.setBounds(10, 170, 375, 30);
		Breakintroduction.setFont(new Font("Breakintroduction",Font.BOLD, 20));
		Breakintroduction.setOpaque(false);
		Breakintroduction.setEditable(false);
		BreakTip.add(Breakintroduction);
		Breakintroduction.setBounds(10, 200, 390, 60);
		BeginBreak.setBorderPainted(false);
		BeginBreak.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BreakTip.add(BeginBreak);
		BeginBreak.setBounds(100, 270, 200, 40);
		/*����ģʽ���*/
		SpeedTip.setSize(400, 350);
		SpeedTip.setResizable(false);
		SpeedTip.setVisible(false);
		SpeedTip.setLocationRelativeTo(null);
		SpeedTip.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		SpeedTip.setLayout(null);
		ImageIcon Speedbgd = new ImageIcon("Image/003.png"); 
		JLabel SpeedPicture = new JLabel(Speedbgd);
		SpeedPicture.setBounds(0, 0, 400, 350);
		JPanel SpeedPanel = (JPanel) SpeedTip.getContentPane();  
		SpeedPanel.setOpaque(false);
		SpeedTip.getLayeredPane().add(SpeedPicture, new Integer(Integer.MIN_VALUE));
		SpeedTipLabel.setFont(new Font("SpeedTipLabel",Font.BOLD, 20));
		SpeedTip.add(SpeedTipLabel);
		SpeedTipLabel.setBounds(10, 0, 390, 170);
		SpeedDifficulty.addItem("�����Ѷ�");
		SpeedDifficulty.addItem("�м��Ѷ�");
		SpeedDifficulty.addItem("�߼��Ѷ�");
		SpeedDifficulty.addItem("ج���Ѷ�(�����ѡ��)");
		SpeedDifficulty.setFont(new Font("SpeedDifficulty",Font.BOLD, 20));
		SpeedTip.add(SpeedDifficulty);
		SpeedDifficulty.setBounds(10, 180, 375, 30);
		Speedintroduction.setFont(new Font("Speedintroduction",Font.BOLD, 20));
		Speedintroduction.setOpaque(false);
		Speedintroduction.setEditable(false);
		SpeedTip.add(Speedintroduction);
		Speedintroduction.setBounds(10, 210, 390, 60);
		BeginSpeed.setBorderPainted(false);
		BeginSpeed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SpeedTip.add(BeginSpeed);
		BeginSpeed.setBounds(100, 270, 200, 40);
		//��Ϸ���ߴ���
		GamedaojuDialog.setSize(400, 300);
		GamedaojuDialog.setResizable(false);
		GamedaojuDialog.setVisible(false);
		GamedaojuDialog.setLocationRelativeTo(null);
		GamedaojuDialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		GamedaojuDialog.setLayout(null);
		ImageIcon Gamedaojubgd = new ImageIcon("Image/003.png"); 
		JLabel GamedaojuPicture = new JLabel(Gamedaojubgd);
		GamedaojuPicture.setBounds(0, 0, 400, 300);
		JPanel GamedaojuPanel = (JPanel) GamedaojuDialog.getContentPane();  
		GamedaojuPanel.setOpaque(false);
		GamedaojuDialog.getLayeredPane().add(GamedaojuPicture, new Integer(Integer.MIN_VALUE));
		GamedaojuLabel.setFont(new Font("GamedaojuLabel",Font.BOLD, 25));
		GamedaojuDialog.add(GamedaojuLabel);
		GamedaojuLabel.setBounds(10, 0, 360, 180);
		GamedaojuSure.setBorderPainted(false);
		GamedaojuSure.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        GamedaojuDialog.add(GamedaojuSure);
        GamedaojuSure.setBounds(40, 200, 150, 50);
        GamedaojuCancel.setBorderPainted(false);
        GamedaojuCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        GamedaojuDialog.add(GamedaojuCancel);
        GamedaojuCancel.setBounds(210, 200, 150, 50);
        
		/*�˳�ѯ�ʴ���*/
		Exitask.setSize(400, 300);
		Exitask.setResizable(false);
		Exitask.setVisible(false);
		Exitask.setLocationRelativeTo(null);
		Exitask.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Exitask.setLayout(null);
		Exitask.add(Exitaskimg);
		Exitaskimg.setBounds(30, 30, 50, 50);
		ExitaskLabel.setFont(new Font("ExitaskLabel",Font.BOLD, 25));
        Exitask.add(ExitaskLabel);
        ExitaskLabel.setBounds(90, 30, 200, 50);
        ExitaskSure.setFont(new Font("ExitaskSure",Font.BOLD, 25));
        Exitask.add(ExitaskSure);
        ExitaskSure.setBounds(40, 200, 150, 50);
        ExitaskCancel.setFont(new Font("ExitaskCancel",Font.BOLD, 25));
        Exitask.add(ExitaskCancel);
        ExitaskCancel.setBounds(210, 200, 150, 50);
        
		/*��Ϸ�������*/
		GameoverPanel.setLayout(null);
		GameoverPanel.setOpaque(false);
		ImageIcon Gameoverimg = new ImageIcon("Image/001.png"); 
		GameoverLabel = new JLabel(Gameoverimg);
		GameoverPanel.add(GameoverLabel);
		GameoverLabel.setBounds(12, 100, 548, 100);
		YourScore.setFont(new Font("YourScore",Font.BOLD, 30));
		GameoverPanel.add(YourScore);
		YourScore.setBounds(280, 220, 200, 40);
		FinalAnswerLabel.setFont(new Font("FinalAnswerLabel",Font.BOLD, 30));
		GameoverPanel.add(FinalAnswerLabel);
		FinalAnswerLabel.setBounds(30, 280, 200, 40);
		FinalAnswer.setFont(new Font("FinalAnswer",Font.BOLD, 30));
		GameoverPanel.add(FinalAnswer);
		FinalAnswer.setBounds(250, 280, 400, 40);
		FinalScoreLabel.setFont(new Font("FinalScoreLabel",Font.BOLD, 30));
		GameoverPanel.add(FinalScoreLabel);
		FinalScoreLabel.setBounds(30, 340, 200, 40);
		FinalScore.setFont(new Font("FinalScore",Font.BOLD, 30));
		GameoverPanel.add(FinalScore);
		FinalScore.setBounds(250, 340, 400, 40);
		GameoverReturn.setBorderPainted(false);
		GameoverReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GameoverPanel.add(GameoverReturn);
		GameoverReturn.setBounds(125, 500, 200, 50);
		GameoverAgain.setBorderPainted(false);
		GameoverAgain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GameoverPanel.add(GameoverAgain);
		GameoverAgain.setBounds(375, 500, 200, 50);
		MainPanel.add("GameoverPanel", GameoverPanel);
		
		
		//�¼�¼����
		NewRecord.setSize(400, 300);
		NewRecord.setResizable(false);
		NewRecord.setVisible(false);
		NewRecord.setLocationRelativeTo(null);
		NewRecord.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		NewRecord.setLayout(null);
		ImageIcon NewRecordbgd = new ImageIcon("Image/003.png"); 
		JLabel NewRecordPicture = new JLabel(NewRecordbgd);
		NewRecordPicture.setBounds(0, 0, 400, 300);
		JPanel NewRecordPanel = (JPanel) NewRecord.getContentPane();  
		NewRecordPanel.setOpaque(false);
		NewRecord.getLayeredPane().add(NewRecordPicture, new Integer(Integer.MIN_VALUE));
		NewRecordLabel.setFont(new Font("NewRecordLabel",Font.BOLD, 25));
		NewRecord.add(NewRecordLabel);
		NewRecordLabel.setBounds(50, 10, 300, 100);
		NewRecordName.setFont(new Font("NewRecordName",Font.BOLD, 25));
		NewRecordName.setOpaque(false);
		NewRecord.add(NewRecordName);
		NewRecordName.setBounds(50, 130, 300, 50);
		NewRecordSure.setBorderPainted(false);
		NewRecordSure.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		NewRecord.add(NewRecordSure);
		NewRecordSure.setBounds(100, 200, 200, 50);
		
		/*����24�����*/
		Calculation24Panel.setLayout(null);
		Calculation24Panel.setOpaque(false);
		ImageIcon Calculation24img = new ImageIcon("Image/001.png"); 
		CalculationLabel = new JLabel(Calculation24img);
		Calculation24Panel.add(CalculationLabel);
		CalculationLabel.setBounds(12, 100, 548, 100);
		DisplayArea.setFont(new Font("DisplayArea",Font.BOLD, 30));
		DisplayArea.setEditable(true);//ֻ����ʾ��������༭����
		DisplayArea.setOpaque(false);//���ÿؼ��Ƿ�͸���ġ�true��ʾ��͸��,false��ʾ͸����
		DisplayArea.setHorizontalAlignment(JTextField.CENTER);//�ı�����
		Calculation24Panel.add(DisplayArea);
		DisplayArea.setBounds(18, 240, 649, 60);
		ValueArea1.setFont(new Font("ValueArea1",Font.BOLD, 20));
		ValueArea1.setEditable(false);
		ValueArea1.setHorizontalAlignment(JTextField.CENTER);//�ı�����
		Calculation24Panel.add(ValueArea1);
		ValueArea1.setBounds(18, 310, 140, 50);
		ValueArea2.setFont(new Font("ValueArea2",Font.BOLD, 20));
		ValueArea2.setEditable(false);
		ValueArea2.setHorizontalAlignment(JTextField.CENTER);//�ı�����
		Calculation24Panel.add(ValueArea2);
		ValueArea2.setBounds(187, 310, 140, 50);
		ValueArea3.setFont(new Font("ValueArea3",Font.BOLD, 20));
		ValueArea3.setEditable(false);
		ValueArea3.setHorizontalAlignment(JTextField.CENTER);//�ı�����
		Calculation24Panel.add(ValueArea3);
		ValueArea3.setBounds(357, 310, 140, 50);
		ValueArea4.setFont(new Font("ValueArea4",Font.BOLD, 20));
		ValueArea4.setEditable(false);
		ValueArea4.setHorizontalAlignment(JTextField.CENTER);//�ı�����
		Calculation24Panel.add(ValueArea4);
		ValueArea4.setBounds(527, 310, 140, 50);
		Number1.setFont(new Font("Number1",Font.BOLD, 30));
		Calculation24Panel.add(Number1);
		Number1.setBounds(18, 370, 140, 50);
		Number2.setFont(new Font("Number2",Font.BOLD, 30));
		Calculation24Panel.add(Number2);
		Number2.setBounds(187, 370, 140, 50);
		Number3.setFont(new Font("Number3",Font.BOLD, 30));
		Calculation24Panel.add(Number3);
		Number3.setBounds(357, 370, 140, 50);
		Number4.setFont(new Font("Number4",Font.BOLD, 30));
		Calculation24Panel.add(Number4);
		Number4.setBounds(527, 370, 140, 50);
		Number5.setFont(new Font("Number5",Font.BOLD, 30));
		Calculation24Panel.add(Number5);
		Number5.setBounds(18, 430, 140, 50);
		Number6.setFont(new Font("Number6",Font.BOLD, 30));
		Calculation24Panel.add(Number6);
		Number6.setBounds(187, 430, 140, 50);
		Number7.setFont(new Font("Number7",Font.BOLD, 30));
		Calculation24Panel.add(Number7);
		Number7.setBounds(357, 430, 140, 50);
		Number8.setFont(new Font("Number8",Font.BOLD, 30));
		Calculation24Panel.add(Number8);
		Number8.setBounds(527, 430, 140, 50);
		Number9.setFont(new Font("Number9",Font.BOLD, 30));
		Calculation24Panel.add(Number9);
		Number9.setBounds(18, 490, 140, 50);
		Number10.setFont(new Font("Number10",Font.BOLD, 30));
		Calculation24Panel.add(Number10);
		Number10.setBounds(187, 490, 140,50);
		Number11.setFont(new Font("Number11",Font.BOLD, 30));
		Calculation24Panel.add(Number11);
		Number11.setBounds(357,490, 140, 50);
		Number12.setFont(new Font("Number12",Font.BOLD, 30));
		Calculation24Panel.add(Number12);
		Number12.setBounds(527, 490, 140, 50);
		Number13.setFont(new Font("Number13",Font.BOLD, 30));
		Calculation24Panel.add(Number13);
		Number13.setBounds(18, 550, 140, 50);
		Answer.setFont(new Font("Answer",Font.BOLD, 30));
		Calculation24Panel.add(Answer);
		Answer.setBounds(187, 550, 140, 50);
		Delete.setFont(new Font("Delete",Font.BOLD, 30));
		Calculation24Panel.add(Delete);
		Delete.setBounds(357, 550, 140, 50);
		Calculation24Return.setFont(new Font("Calculation24Return",Font.BOLD, 30));
		Calculation24Panel.add(Calculation24Return);
		Calculation24Return.setBounds(527,550, 140, 50);
		MainPanel.add("Calculation24Panel", Calculation24Panel);
		
		/*��Ϸ�������*/
		GameSettingPanel.setLayout(null);
		GameSettingPanel.setOpaque(false);
		ImageIcon GameSettingimg = new ImageIcon("Image/001.png"); 
		GameSettingLabel = new JLabel(GameSettingimg);
		GameSettingPanel.add(GameSettingLabel);
		GameSettingLabel.setBounds(12, 100, 548, 100);
		BGMSwitch.setFont(new Font("BGMSwitch",Font.BOLD, 30));
		GameSettingPanel.add(BGMSwitch);
		BGMSwitch.setBounds(50, 250, 200, 40);
		BGMKind.add(BGMkai);
		BGMKind.add(BGMguan);
		BGMkai.setFont(new Font("BGMkai",Font.BOLD, 30));
		BGMkai.setOpaque(false);
		BGMkai.setSelected(true);
		GameSettingPanel.add(BGMkai);
		BGMkai.setBounds(260, 250, 100, 40);
		BGMguan.setFont(new Font("BGMguan",Font.BOLD, 30));
		BGMguan.setOpaque(false);
		GameSettingPanel.add(BGMguan);
		BGMguan.setBounds(400, 250, 100, 40);
		
		Sound.setFont(new Font("Sound",Font.BOLD, 30));
		GameSettingPanel.add(Sound);
		Sound.setBounds(50, 310, 200, 40);
		SoundKind.add(Soundkai);
		SoundKind.add(Soundguan);
		Soundkai.setFont(new Font("Soundkai",Font.BOLD, 30));
		Soundkai.setOpaque(false);
		Soundkai.setSelected(true);
		GameSettingPanel.add(Soundkai);
		Soundkai.setBounds(260, 310, 100, 40);
		Soundguan.setFont(new Font("Soundguan",Font.BOLD, 30));
		Soundguan.setOpaque(false);
		GameSettingPanel.add(Soundguan);
		Soundguan.setBounds(400, 310, 100, 40);
		HaveJQK.setFont(new Font("HaveJQK",Font.BOLD, 30));
		GameSettingPanel.add(HaveJQK);
		HaveJQK.setBounds(50, 370, 200, 40);
		JQKKind.add(JQKyou);
		JQKKind.add(JQKwu);
		JQKyou.setFont(new Font("JQKyou",Font.BOLD, 30));
		JQKyou.setOpaque(false);
		JQKyou.setSelected(true);
		GameSettingPanel.add(JQKyou);
		JQKyou.setBounds(260, 370, 100, 40);
		JQKwu.setFont(new Font("JQKwu",Font.BOLD, 30));
		JQKwu.setOpaque(false);
		GameSettingPanel.add(JQKwu);
		JQKwu.setBounds(400, 370, 300, 40);
		daojuNum.setFont(new Font("daojuNum",Font.BOLD, 30));
		GameSettingPanel.add(daojuNum);
		daojuNum.setBounds(50, 420, 550, 60);
		daojuNum.setVisible(true);
		
		GameSettingSave.setBorderPainted(false);
		GameSettingSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GameSettingPanel.add(GameSettingSave);
		GameSettingSave.setBounds(140,450, 200, 60);
		GameSettingCancel.setBorderPainted(false);
		GameSettingCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GameSettingPanel.add(GameSettingCancel);
		GameSettingCancel.setBounds(360, 450, 200, 60);
		MainPanel.add("GameSettingPanel", GameSettingPanel);
		
		
		/*��Ϸ�������*/
		GameHelpPanel.setLayout(null);
		GameHelpPanel.setOpaque(false);
		ImageIcon GameHelpimg = new ImageIcon("Image/002.png"); 
		GameHelpLabel = new JLabel(GameHelpimg);
		GameHelpPanel.add(GameHelpLabel);
		GameHelpLabel.setBounds(0, 0, 700, 600);
		ISee.setBorderPainted(false);
		ISee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GameHelpPanel.add(ISee);
		ISee.setBounds(250, 620, 200, 40);
		MainPanel.add("GameHelpPanel", GameHelpPanel);
		
		/*���а����*/
		RankingPanel.setLayout(null);
		RankingPanel.setOpaque(false);
		RankingBreak.setFont(new Font("RankingBreak",Font.BOLD, 30));
		RankingPanel.add(RankingBreak);
		RankingBreak.setBounds(15, 10, 200, 40);
		RankingBreakBox.setFont(new Font("RankingBreakBox",Font.BOLD, 30));
		RankingBreakBox.addItem("�����Ѷ�");
		RankingBreakBox.addItem("�м��Ѷ�");
		RankingBreakBox.addItem("�߼��Ѷ�");
		RankingBreakBox.addItem("ج���Ѷ�");
		RankingPanel.add(RankingBreakBox);
		RankingBreakBox.setBounds(225, 10, 450, 40);
		BreakTableObject = new String[100][3];
		for(int i=0; i<100; i++){//�õ����ذ���Ϣ
			if(RankingArray1[i][0] != null){
				BreakTableObject[i][0] =  RankingArray1[i][0];
				BreakTableObject[i][1] =  RankingArray1[i][1];
				BreakTableObject[i][2] =  RankingArray1[i][2];
			}
		}
		int real = 0;//���а��������ݲ�Ϊ�յ���Ŀ
		for(int i=0;i<BreakTableObject.length;i++) {
			if(null != BreakTableObject[i][0])real++;
		}
		
		BreakTableObjectnew = new String[real][3];
		for(int i=0;i<BreakTableObjectnew.length;i++) {
			BreakTableObjectnew[i] = BreakTableObject[i];
		}
		BreakTable = new JTable(BreakTableObjectnew,BreakTableHead);//����Ϣ���ͷװ������
		BreakTable.setRowHeight(40);//�и�
		BreakTable.setEnabled(false);//���ɱ༭
		BreakTable.getTableHeader().setReorderingAllowed(false);//���������ƶ�   
		BreakTable.getTableHeader().setResizingAllowed(false);//�����������
		BreakTable.getTableHeader().setFont(new Font("BreakTable",Font.BOLD, 20));
		BreakTable.setFont(new Font("BreakTable",Font.BOLD, 30));
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// ����table���ݾ���
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		BreakTable.setDefaultRenderer(Object.class, tcr);
		BreakTable.setOpaque(false);
		Breaktable = new JScrollPane(BreakTable);//����һ������ͷ�ı��
		Breaktable.setOpaque(false);
		Breaktable.setFont(new Font("Breaktable",Font.BOLD, 30));
		RankingPanel.add(Breaktable);
		Breaktable.setBounds(15, 70, 660, 230);
		
		
		RankingSpeed.setFont(new Font("RankingSpeed",Font.BOLD, 30));
		RankingPanel.add(RankingSpeed);
		RankingSpeed.setBounds(15, 320, 200, 40);
		RankingSpeedBox.addItem("�����Ѷ�");
		RankingSpeedBox.addItem("�м��Ѷ�");
		RankingSpeedBox.addItem("�߼��Ѷ�");
		RankingSpeedBox.addItem("ج���Ѷ�");
		RankingSpeedBox.setFont(new Font("RankingSpeedBox",Font.BOLD, 30));
		RankingPanel.add(RankingSpeedBox);
		RankingSpeedBox.setBounds(225,320, 450, 50);
		SpeedTableObject = new String[100][3];
		for(int i=0; i<100; i++){//�õ��������Ϣ
			if(RankingArray5[i][0] != null){
				SpeedTableObject[i][0] =  RankingArray5[i][0];
				SpeedTableObject[i][1] =  RankingArray5[i][1];
				SpeedTableObject[i][2] =  RankingArray5[i][2];
			}
		}
		int real2 = 0;//���а��������ݲ�Ϊ�յ���Ŀ
		for(int i=0;i<SpeedTableObject.length;i++) {
			if(null != SpeedTableObject[i][0])real2++;
		}
		SpeedTableObjectnew = new String[real2][3];
		for(int i=0;i<SpeedTableObjectnew.length;i++) {
			SpeedTableObjectnew[i] = SpeedTableObject[i];
		}
		SpeedTable = new JTable(SpeedTableObjectnew,SpeedTableHead);//����Ϣ���ͷװ������
		SpeedTable.setRowHeight(40);//�и�
		SpeedTable.setEnabled(false);//���ɱ༭
		SpeedTable.getTableHeader().setReorderingAllowed(false);//���������ƶ�   
		SpeedTable.getTableHeader().setResizingAllowed(false);//�����������
		SpeedTable.getTableHeader().setFont(new Font("BreakTable",Font.BOLD, 20));
		SpeedTable.setFont(new Font("SpeedTable",Font.BOLD, 30));
		SpeedTable.setDefaultRenderer(Object.class, tcr);
		SpeedTable.setOpaque(false);
		Speedtable = new JScrollPane(SpeedTable);//����һ������ͷ�ı��
		Speedtable.setOpaque(false);
		Speedtable.setFont(new Font("Speedtable",Font.BOLD, 20));
		RankingPanel.add(Speedtable);
		Speedtable.setBounds(15, 390, 660, 230);
		WantList.setBorderPainted(false);
		WantList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RankingPanel.add(WantList);
		
		
		WantList.setBounds(140, 630, 200, 40);
		RankingReturn.setBorderPainted(false);
		RankingReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RankingPanel.add(RankingReturn);
		RankingReturn.setBounds(360, 630, 200, 40);
		MainPanel.add("RankingPanel", RankingPanel);	
	}
	/*ˢ�����а�񵥺���*/
	void RankingTable(){
		RankingPanel.remove(Breaktable);
		RankingPanel.remove(Speedtable);
		RankingRead();
		
		BreakTableObject = new String[100][3];
		for(int i=0; i<100; i++){//�õ����ذ���Ϣ
			switch(RankingBreakFlag) {
			case 1:if(RankingArray1[i][0] != null){
				BreakTableObject[i][0] =  RankingArray1[i][0];
				BreakTableObject[i][1] =  RankingArray1[i][1];
				BreakTableObject[i][2] =  RankingArray1[i][2];
			}break;
			case 2:if(RankingArray2[i][0] != null){
				BreakTableObject[i][0] =  RankingArray2[i][0];
				BreakTableObject[i][1] =  RankingArray2[i][1];
				BreakTableObject[i][2] =  RankingArray2[i][2];
			}break;
			case 3:if(RankingArray3[i][0] != null){
				BreakTableObject[i][0] =  RankingArray3[i][0];
				BreakTableObject[i][1] =  RankingArray3[i][1];
				BreakTableObject[i][2] =  RankingArray3[i][2];
			}break;
			case 4:if(RankingArray4[i][0] != null){
				BreakTableObject[i][0] =  RankingArray4[i][0];
				BreakTableObject[i][1] =  RankingArray4[i][1];
				BreakTableObject[i][2] =  RankingArray4[i][2];
			}break;
			}
			
		}
		int real = 0;//���а��������ݲ�Ϊ�յ���Ŀ
		for(int i=0;i<BreakTableObject.length;i++) {
			if(null != BreakTableObject[i][0])real++;
		}
		BreakTableObjectnew = new String[real][3];
		for(int i=0;i<BreakTableObjectnew.length;i++) {
			BreakTableObjectnew[i] = BreakTableObject[i];
		}
		BreakTable = new JTable(BreakTableObjectnew,BreakTableHead);//����Ϣ���ͷװ������
		BreakTable.setRowHeight(40);//�и�
		BreakTable.setEnabled(false);//���ɱ༭
		BreakTable.getTableHeader().setReorderingAllowed(false);//���������ƶ�   
		BreakTable.getTableHeader().setResizingAllowed(false);//�����������
		BreakTable.getTableHeader().setFont(new Font("BreakTable",Font.BOLD, 20));
		BreakTable.setFont(new Font("BreakTable",Font.BOLD, 20));
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// ����table���ݾ���
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		BreakTable.setDefaultRenderer(Object.class, tcr);
		BreakTable.setOpaque(false);
		Breaktable = new JScrollPane(BreakTable);//����һ������ͷ�ı��
		Breaktable.setOpaque(false);
		Breaktable.setFont(new Font("Breaktable",Font.BOLD, 30));
		RankingPanel.add(Breaktable);
		Breaktable.setBounds(15, 70, 660, 230);
		
		SpeedTableObject = new String[100][3];
		for(int i=0; i<100; i++){//�õ��������Ϣ
			switch(RankingSpeedFlag) {
			case 5:if(RankingArray5[i][0] != null){
				SpeedTableObject[i][0] =  RankingArray5[i][0];
				SpeedTableObject[i][1] =  RankingArray5[i][1];
				SpeedTableObject[i][2] =  RankingArray5[i][2];
			}break;
			case 6:if(RankingArray6[i][0] != null){
				SpeedTableObject[i][0] =  RankingArray6[i][0];
				SpeedTableObject[i][1] =  RankingArray6[i][1];
				SpeedTableObject[i][2] =  RankingArray6[i][2];
			}break;
			case 7:if(RankingArray7[i][0] != null){
				SpeedTableObject[i][0] =  RankingArray7[i][0];
				SpeedTableObject[i][1] =  RankingArray7[i][1];
				SpeedTableObject[i][2] =  RankingArray7[i][2];
			}break;
			case 8:if(RankingArray8[i][0] != null){
				SpeedTableObject[i][0] =  RankingArray8[i][0];
				SpeedTableObject[i][1] =  RankingArray8[i][1];
				SpeedTableObject[i][2] =  RankingArray8[i][2];
			}break;
			}
			
		}
		int real2 = 0;//���а��������ݲ�Ϊ�յ���Ŀ
		for(int i=0;i<SpeedTableObject.length;i++) {
			if(null != SpeedTableObject[i][0])real2++;
		}
		SpeedTableObjectnew = new String[real2][3];
		for(int i=0;i<SpeedTableObjectnew.length;i++) {
			SpeedTableObjectnew[i] = SpeedTableObject[i];
		}
		SpeedTable = new JTable(SpeedTableObjectnew,SpeedTableHead);//����Ϣ���ͷװ������
		SpeedTable.setRowHeight(40);//�и�
		SpeedTable.setEnabled(false);//���ɱ༭
		SpeedTable.getTableHeader().setReorderingAllowed(false);//���������ƶ�   
		SpeedTable.getTableHeader().setResizingAllowed(false);//�����������
		SpeedTable.getTableHeader().setFont(new Font("BreakTable",Font.BOLD, 20));
		SpeedTable.setFont(new Font("SpeedTable",Font.BOLD, 30));
		SpeedTable.setDefaultRenderer(Object.class, tcr);
		SpeedTable.setOpaque(false);
		Speedtable = new JScrollPane(SpeedTable);//����һ������ͷ�ı��
		Speedtable.setOpaque(false);
		Speedtable.setFont(new Font("Speedtable",Font.BOLD, 20));
		RankingPanel.add(Speedtable);
		Speedtable.setBounds(15, 390, 660, 230);
	}
	@SuppressWarnings("deprecation")
	/*�������ּ���Ч*/
	void MUSIC(){
		try { 
			BGMClip = Applet.newAudioClip(BGMfile.toURL());  
			WINClip = Applet.newAudioClip(WINfile.toURL());
			LOSEClip = Applet.newAudioClip(LOSEfile.toURL());
        } catch(OutOfMemoryError e){  
            System.out.println("�ڴ����");  
            e.printStackTrace();  
        } catch(Exception e){  
            e.printStackTrace();  
        }  
	}
	/*��ͬģʽ�����������ܸ���*/
	void DiffMode(){
		if(ModeFlag == 1){//��ϰģʽ����
			if(LastMode == 1){
				ExercisePanel.remove(RightNum);
				ExercisePanel.remove(WrongNum);
			}
			else if(LastMode == 2){
				ExercisePanel.remove(LevelNum);
				ExercisePanel.remove(CorrectNum);
				ExercisePanel.remove(BreakTimeLabel);
			}
			else if(LastMode == 3){
				ExercisePanel.remove(Answered);
				ExercisePanel.remove(SpeedTimeLabel);
			}
			ExerciseView.setVisible(true);
			ExercisePass.setVisible(true);
			Gamedaoju.setVisible(false);
			RightNum = new JLabel("�������: " +Right+ " ");
			RightNum.setFont(new Font("RightNum",Font.BOLD, 30));
			ExercisePanel.add(RightNum);
			RightNum.setBounds(30, 30, 200, 50);
			WrongNum = new JLabel("��������: " +Wrong+ " ");
			WrongNum.setFont(new Font("WrongNum",Font.BOLD, 30));
			ExercisePanel.add(WrongNum);
			WrongNum.setBounds(470, 30, 200, 50);
		}
		else if(ModeFlag == 2){//����ģʽ����
			if(LastMode == 1){
				ExercisePanel.remove(RightNum);
				ExercisePanel.remove(WrongNum);
			}
			else if(LastMode == 2){
				ExercisePanel.remove(LevelNum);
				ExercisePanel.remove(CorrectNum);
				ExercisePanel.remove(BreakTimeLabel);
			}
			else if(LastMode == 3){
				ExercisePanel.remove(Answered);
				ExercisePanel.remove(SpeedTimeLabel);
			}
			ExerciseView.setVisible(false);
			ExercisePass.setVisible(false);
			if(!GameFlag[3].equals("0"))//��ʹ�ô�����Ϊ0����ɼ�
				Gamedaoju.setVisible(false);//�رյ���
			
			ExercisePanel.remove(LevelNum);
			LevelNum = new JLabel("������"+Level+"��");
			LevelNum.setFont(new Font("LevelNum",Font.BOLD, 30));
			ExercisePanel.add(LevelNum);
			LevelNum.setBounds(30, 30, 150, 50);
			
			CorrectNum = new JLabel("ʣ������: " +Correct);
			CorrectNum.setFont(new Font("CorrectNum",Font.BOLD, 30));
			ExercisePanel.add(CorrectNum);
			CorrectNum.setBounds(200, 30, 200, 50);
			
			BreakTimeLabel = new JLabel("ʣ��ʱ��: ");
			BreakTimeLabel.setFont(new Font("BreakTimeLabel",Font.BOLD, 30));
			ExercisePanel.add(BreakTimeLabel);
			BreakTimeLabel.setBounds(470, 30, 200, 50);
		}
		else if(ModeFlag == 3){//����ģʽ����
			if(LastMode == 1){
				ExercisePanel.remove(RightNum);
				ExercisePanel.remove(WrongNum);
			}
			else if(LastMode == 2){
				ExercisePanel.remove(LevelNum);
				ExercisePanel.remove(CorrectNum);
				ExercisePanel.remove(BreakTimeLabel);
			}
			else if(LastMode == 3){
				ExercisePanel.remove(Answered);
				ExercisePanel.remove(SpeedTimeLabel);
			}
			ExerciseView.setVisible(false);
			ExercisePass.setVisible(false);
			if(!GameFlag[3].equals("0"))//��ʹ�ô�����Ϊ0����ɼ�
				Gamedaoju.setVisible(false);
			
			ExercisePanel.remove(Answered);
			Answered = new JLabel("����-�Ѵ������: " + SpeedNum);
			Answered.setFont(new Font("Answered",Font.BOLD, 30));
			ExercisePanel.add(Answered);
			Answered.setBounds(30, 30, 300, 50);
			
			SpeedTimeLabel = new JLabel("ʣ��ʱ��: ");
			SpeedTimeLabel.setFont(new Font("SpeedTimeLabel",Font.BOLD, 30));
			ExercisePanel.add(SpeedTimeLabel);
			SpeedTimeLabel.setBounds(470, 30, 200, 50);
		}
	}
	/*������������˿��Ʋ���ֵ����ǩ�Ͱ�ť*/
	void ExerciseCards(){
		/*�洢�˿����������飬�±�0Ϊ��ɫ���±�1Ϊ����*/
		int cards[][] = new int[4][2];
		/*�洢��ɫ�ַ������飬���滨ɫ���ֶ�Ӧ�Ļ�ɫ�ַ�*/
		String Color[] = new String[4];
		switch(ModeFlag){
		case 1: if(GameFlag[2].equals("1")){
			 		cards[0][1] = 1+(int)(Math.random()*13);
			 		cards[1][1] = 1+(int)(Math.random()*13);
			 		cards[2][1] = 1+(int)(Math.random()*13);
			 		cards[3][1] = 1+(int)(Math.random()*13);
				}
				else if(GameFlag[2].equals("0")){
					cards[0][1] = 1+(int)(Math.random()*10);
					cards[1][1] = 1+(int)(Math.random()*10);
					cards[2][1] = 1+(int)(Math.random()*10);
					cards[3][1] = 1+(int)(Math.random()*10);
				}
		break;
		case 2: if(BreakFlag >= 1 && BreakFlag <=  2){
					cards[0][1] = 1+(int)(Math.random()*10);
					cards[1][1] = 1+(int)(Math.random()*10);
					cards[2][1] = 1+(int)(Math.random()*10);
					cards[3][1] = 1+(int)(Math.random()*10);
				}
				else if(BreakFlag >= 3 && BreakFlag <=  4){
					cards[0][1] = 1+(int)(Math.random()*13);
			 		cards[1][1] = 1+(int)(Math.random()*13);
			 		cards[2][1] = 1+(int)(Math.random()*13);
			 		cards[3][1] = 1+(int)(Math.random()*13);
				}
		break;
		case 3: if(SpeedFlag >= 1 && SpeedFlag <=  2){
					cards[0][1] = 1+(int)(Math.random()*10);
					cards[1][1] = 1+(int)(Math.random()*10);
					cards[2][1] = 1+(int)(Math.random()*10);
					cards[3][1] = 1+(int)(Math.random()*10);
				}
				else if(SpeedFlag >= 3 && SpeedFlag <=  4){
					cards[0][1] = 1+(int)(Math.random()*13);
					cards[1][1] = 1+(int)(Math.random()*13);
					cards[2][1] = 1+(int)(Math.random()*13);
					cards[3][1] = 1+(int)(Math.random()*13);
				}
		break;
		default:break;
		}
		
		cards[0][0] = 1+(int)(Math.random()*4);
		cards[1][0] = 1+(int)(Math.random()*4);
		cards[2][0] = 1+(int)(Math.random()*4);
		cards[3][0] = 1+(int)(Math.random()*4);
		for(int i=0; i<4; i++){
			for(int j=i+1; j<4; j++){
				if(cards[i][1] == cards[j][1])//����������������ͬ
					while(cards[i][0] == cards[j][0]){//�����ǻ�ɫҲ��ͬʱ���������һ�Ż�ɫֱ����ͬ
						cards[j][0] = 1+(int)(Math.random()*10);
					}
			}
		}
		/*�ɻ�ɫ���ֵõ���ɫ�ַ�*/
		for(int t=0; t<4; t++){
		switch(cards[t][0]){
		case 1: Color[t] = "F";break;
		case 2: Color[t] = "H";break;
		case 3: Color[t] = "M";break;
		default: Color[t] = "T";break;
		}
		}		        
        String path1 = "Image/Cards/" + Color[0] + cards[0][1] +".jpg";
        String path2 = "Image/Cards/" + Color[1] + cards[1][1] +".jpg";     		       
        String path3 = "Image/Cards/" + Color[2] + cards[2][1] +".jpg";       
        String path4 = "Image/Cards/" + Color[3] + cards[3][1] +".jpg";
        ExercisePanel.remove(ExerciseCards1);
		ExercisePanel.remove(ExerciseCards2);
		ExercisePanel.remove(ExerciseCards3);
		ExercisePanel.remove(ExerciseCards4);
		ExercisePanel.remove(ExerciseNumber1);
		ExercisePanel.remove(ExerciseNumber2);
		ExercisePanel.remove(ExerciseNumber3);
		ExercisePanel.remove(ExerciseNumber4);
        ImageIcon Labela = new ImageIcon(path1);
        ExerciseCards1 = new JLabel(Labela);		 
        ImageIcon Labelb = new ImageIcon(path2);
        ExerciseCards2 = new JLabel(Labelb);
        ImageIcon Labelc = new ImageIcon(path3);
        ExerciseCards3 = new JLabel(Labelc);
        ImageIcon Labeld = new ImageIcon(path4);
        ExerciseCards4 = new JLabel(Labeld);
        ExerciseNumber1.setText(cards[0][1]+"");
        ExerciseNumber2.setText(cards[1][1]+"");
        ExerciseNumber3.setText(cards[2][1]+"");
        ExerciseNumber4.setText(cards[3][1]+"");
	}
	/*���˿��Ʊ�ǩ�����ְ�ť�ŵ���Ӧ�����*/
	void ExerciseCardsRefresh(){
		ExercisePanel.add(ExerciseCards1);
		ExerciseCards1.setBounds(156, 100, 116, 130);
		ExercisePanel.add(ExerciseCards2);
		ExerciseCards2.setBounds(428, 100, 116, 130);
		ExercisePanel.add(ExerciseCards3);
		ExerciseCards3.setBounds(156, 260, 116, 130);
		ExercisePanel.add(ExerciseCards4);
		ExerciseCards4.setBounds(428, 260, 116, 130);
		ExerciseNumber1.setFont(new Font("ExerciseNumber1",Font.BOLD, 20));
		ExercisePanel.add(ExerciseNumber1);
		ExerciseNumber1.setBounds(18, 460, 140, 40);
		ExerciseNumber2.setFont(new Font("ExerciseNumber2",Font.BOLD, 20));
		ExercisePanel.add(ExerciseNumber2);
		ExerciseNumber2.setBounds(187, 460, 140, 40);
		ExerciseNumber3.setFont(new Font("ExerciseNumber3",Font.BOLD, 20));
		ExercisePanel.add(ExerciseNumber3);
		ExerciseNumber3.setBounds(357, 460, 140, 40);
		ExerciseNumber4.setFont(new Font("ExerciseNumber4",Font.BOLD, 20));
		ExercisePanel.add(ExerciseNumber4);
		ExerciseNumber4.setBounds(527, 460, 140, 40);
		ExerciseNumber1.setEnabled(false);
   	 	ExerciseNumber2.setEnabled(false);
   	 	ExerciseNumber3.setEnabled(false);
   	 	ExerciseNumber4.setEnabled(false);
		ExerciseNumber1.setEnabled(true);
		ExerciseNumber2.setEnabled(true);
		ExerciseNumber3.setEnabled(true);
		ExerciseNumber4.setEnabled(true);
		ExerciseLBracket.setEnabled(true);
		ExerciseRBracket.setEnabled(true);
		Exercisejia.setEnabled(true);
		Exercisejian.setEnabled(true);
		Exercisecheng.setEnabled(true);
		Exercisechuyi.setEnabled(true);
		ExerciseSure.setEnabled(true);
		Exercisewujie.setEnabled(true);
		ExerciseClear.setEnabled(true);
		ExerciseView.setEnabled(true);
		ExerciseArea.setText(null);
		NumFlag = 1;
		ChFlag = 0;
		BrFlag = 0;
	}
	/*�����ȷ�����ķ���*/
	void RightReact(){
		if(ModeFlag == 1){//��ϰ
			if(GameFlag[1].equals("1"))
				WINClip.play();
			Right++;
			ExercisePanel.remove(RightNum);
			RightNum = new JLabel("�������: " +Right+ " ");
			RightNum.setFont(new Font("RightNum",Font.BOLD, 30));
			ExercisePanel.add(RightNum);
			RightNum.setBounds(30, 30, 200, 50);
			ExerciseCards();
			ExerciseCardsRefresh();
		}
		else if(ModeFlag == 2){
			if(GameFlag[1].equals("1"))
				WINClip.play();
			daojuFlag = 0;
			if(GameFlag[3].equals("0")){
				Gamedaoju.setVisible(false);
			}
			if(Correct == 1){
				Level++;
				Correct = 5;
				//����ģʽ��ͬ�Ѷ���ʱ����Ĳ�ͬ
				if(BreakFlag == 1){//�����Ѷȣ���ʼ200��ÿ2�ؼ�20�����120
					if(Level >= 1 && Level <=2)
			    		BreakTime = 201;
			    		else if(Level >= 3 && Level <= 4)
			    			BreakTime = 181;
			    		else if(Level >= 5 && Level <= 6)
			    			BreakTime = 161;
			    		else if(Level >= 7 && Level <= 8)
			    			BreakTime = 141;
			    		else if(Level >= 9)
			    			BreakTime = 121;
				}
				else if(BreakFlag == 2){//�м��Ѷ�,��ʼ160��ÿ2�ؼ�30�����100
					if(Level >= 1 && Level <=2)
			    		BreakTime = 161;
			    		else if(Level >= 3 && Level <= 4)
			    			BreakTime = 131;
			    		else if(Level >= 5)
			    			BreakTime = 101;
				}
				else if(BreakFlag == 3){//�߼��Ѷȣ���ʼ120��ÿ�ؼ�20�����80
					if(Level == 1)
			    		BreakTime = 121;
			    		else if(Level == 2)
			    			BreakTime = 101;
			    		else if(Level >= 3)
			    			BreakTime = 81;
				}
				else if(BreakFlag == 4){//ج���Ѷȣ���ʼ80��ÿ�ؼ�20�����40
					if(Level == 1)
			    		BreakTime = 81;
			    		else if(Level == 2)
			    			BreakTime = 61;
			    		else if(Level >= 3)
			    			BreakTime = 41;
				}				
				MYTimerTask task = new MYTimerTask();
			      //����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�  
				count.cancel();
				count = new Timer();
				count.schedule(task,new Date(),1000); 			
			}
			else Correct--;			
			ExercisePanel.remove(LevelNum);
			ExercisePanel.remove(CorrectNum);
			switch(BreakFlag){
			case 1: LevelNum = new JLabel("������"+Level+"��");break;
			case 2: LevelNum = new JLabel("�м���"+Level+"��");break;
			case 3: LevelNum = new JLabel("�߼���"+Level+"��");break;
			case 4: LevelNum = new JLabel("ج�ε�"+Level+"��");break;
			}
			CorrectNum = new JLabel("ʣ������: " +Correct);
			LevelNum.setFont(new Font("LevelNum",Font.BOLD, 30));
			ExercisePanel.add(LevelNum);
			LevelNum.setBounds(30, 30, 150, 50);
			CorrectNum.setFont(new Font("CorrectNum",Font.BOLD, 30));
			ExercisePanel.add(CorrectNum);
			CorrectNum.setBounds(200, 30, 200, 50);
			ExerciseCards();
			ExerciseCardsRefresh();
		}
		else if(ModeFlag == 3){//����ģʽ
			if(GameFlag[1].equals("1"))
				WINClip.play();
			daojuFlag = 0;
			if(GameFlag[3].equals("0")){
				Gamedaoju.setVisible(false);
			}
			SpeedNum++;
			//����ģʽ�²�ͬ�ѶȵĲ�ͬʱ��
			switch(SpeedFlag){
			case 1: SpeedTime = 41;break;
			case 2: SpeedTime = 31;break;
			case 3: SpeedTime = 21;break;
			case 4: SpeedTime = 11;break;
			}
			MYTimerTask task = new MYTimerTask();
		      //����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�  
			count.cancel();
			count = new Timer();
			count.schedule(task,new Date(),1000);
			
			ExercisePanel.remove(Answered);
			switch(SpeedFlag){
			case 1: Answered = new JLabel("����-�Ѵ������: " + SpeedNum);break;
			case 2: Answered = new JLabel("�м�-�Ѵ������: " + SpeedNum);break;
			case 3: Answered = new JLabel("�߼�-�Ѵ������: " + SpeedNum);break;
			case 4: Answered = new JLabel("ج��-�Ѵ������: " + SpeedNum);break;
			}
			Answered.setFont(new Font("Answered",Font.BOLD, 30));
			ExercisePanel.add(Answered);
			Answered.setBounds(30, 30, 300, 50);
			ExerciseCards();
			ExerciseCardsRefresh();
		}		
	}
	@SuppressWarnings("null")
	/*�����������ķ���*/
	void WrongReact(){
		System.out.println("jiesuan");
		if(ModeFlag == 1){//��ϰ
			if(GameFlag[1].equals("1"))
				LOSEClip.play();
			Wrong++;	
			String a = ExerciseNumber1.getText();
			String b = ExerciseNumber2.getText();
			String c = ExerciseNumber3.getText();
			String d = ExerciseNumber4.getText();
			Calculate s = new Calculate();
	        s.GiveAnswer(a, b, c, d);
	        ExerciseArea.setText(null);
	        ExerciseArea.setText("����Ϊ:"+s.Answer);
			ExercisePanel.remove(WrongNum);
			WrongNum = new JLabel("��������: " +Wrong+ " ");
			WrongNum.setFont(new Font("WrongNum",Font.BOLD, 30));
			ExercisePanel.add(WrongNum);
			WrongNum.setBounds(470, 30, 200, 50);
			ExerciseNumber1.setEnabled(false);
			ExerciseNumber2.setEnabled(false);
			ExerciseNumber3.setEnabled(false);
			ExerciseNumber4.setEnabled(false);
			ExerciseLBracket.setEnabled(false);
			ExerciseRBracket.setEnabled(false);
			Exercisejia.setEnabled(false);
			Exercisejian.setEnabled(false);
			Exercisecheng.setEnabled(false);
			Exercisechuyi.setEnabled(false);
			ExerciseSure.setEnabled(false);
			Exercisewujie.setEnabled(false);
			ExerciseClear.setEnabled(false);
			ExerciseView.setEnabled(false);
		}
		else if(ModeFlag == 2){//����
			System.out.println("����");
			count.cancel();//��ʱֹͣ
			if(GameFlag[1].equals("1"))
				LOSEClip.play();
			BGMClip.stop();
			LastMode = 2;
			Calculate q = new Calculate();
			//����δ�������Ŀ�Ĵ�
			q.GiveAnswer(ExerciseNumber1.getText(), ExerciseNumber2.getText(), 
					ExerciseNumber3.getText(), ExerciseNumber4.getText());
			//ˢ�����մ𰸺����ճɼ�
			GameoverPanel.remove(FinalAnswer);
			GameoverPanel.remove(FinalScore);
			GameoverPanel.remove(FinalScoreLabel);
			FinalAnswer = new JLabel(q.Answer);
			switch(BreakFlag){
			case 1: FinalScore = new JLabel("������"+Level+"��");break;
			case 2: FinalScore = new JLabel("�м���"+Level+"��");break;
			case 3: FinalScore = new JLabel("�߼���"+Level+"��");break;
			case 4: FinalScore = new JLabel("ج�ε�"+Level+"��");break;
			}
			FinalScoreLabel = new JLabel("����ˮƽ: ");
			FinalAnswer.setFont(new Font("FinalAnswer",Font.BOLD, 30));
			GameoverPanel.add(FinalAnswer);
			FinalAnswer.setBounds(250, 280, 400, 40);
			FinalScore.setFont(new Font("FinalScore",Font.BOLD, 30));
			GameoverPanel.add(FinalScore);
			FinalScore.setBounds(250, 340, 400, 40);
			FinalScoreLabel.setFont(new Font("FinalScoreLabel",Font.BOLD, 30));
			GameoverPanel.add(FinalScoreLabel);
			FinalScoreLabel.setBounds(30, 340, 200, 40);
			card.show(MainPanel, "GameoverPanel");
				String s = Level+"";//ȡ�����ճɼ�
				System.out.println("�ɼ�="+s);
				String ss[] = null;	//ȡ����Ӧ���а�ĳɼ�һ��				
				switch(BreakFlag) {
				case 1: 
					for(int i = 0;i<RankingArray1.length;i++)
						ss[i] = RankingArray1[i][2];				
					break;
				case 2: 
					for(int i = 0;i<RankingArray2.length;i++)
						ss[i] = RankingArray2[i][2];				
					break;
				case 3: 
					for(int i = 0;i<RankingArray3.length;i++)
						ss[i] = RankingArray3[i][2];				
					break;
				case 4: 
					for(int i = 0;i<RankingArray4.length;i++)
						ss[i] = RankingArray4[i][2];				
					break;
				}			
				Sort a = new Sort(ss,s);
				System.out.println("a.t="+a.t);
//				if(a.t < 5){//��ҳɼ��ɹ��ϰ�
					System.out.println("input name");
					NewRecord.setVisible(true);//�¼�¼������ʾ
//				}
		}
		else if(ModeFlag == 3){//����
			count.cancel();//��ʱֹͣ
			if(GameFlag[1].equals("1"))
				LOSEClip.play();	
			BGMClip.stop();
			LastMode = 3;
			Calculate q = new Calculate();
			//����δ�������Ŀ�Ĵ�
			q.GiveAnswer(ExerciseNumber1.getText(), ExerciseNumber2.getText(), 
					ExerciseNumber3.getText(), ExerciseNumber4.getText());
			//ˢ�����մ𰸺����ճɼ�
			GameoverPanel.remove(FinalAnswer);
			GameoverPanel.remove(FinalScore);
			GameoverPanel.remove(FinalScoreLabel);
			FinalAnswer = new JLabel(q.Answer);
			switch(SpeedFlag){
			case 1: FinalScore = new JLabel("����"+SpeedNum+"��");break;
			case 2: FinalScore = new JLabel("�м�"+SpeedNum+"��");break;
			case 3: FinalScore = new JLabel("�߼�"+SpeedNum+"��");break;
			case 4: FinalScore = new JLabel("ج��"+SpeedNum+"��");break;
			}		
			FinalScoreLabel = new JLabel("�������: ");
			FinalAnswer.setFont(new Font("FinalAnswer",Font.BOLD, 30));
			GameoverPanel.add(FinalAnswer);
			FinalAnswer.setBounds(250, 500, 400, 50);
			FinalScore.setFont(new Font("FinalScore",Font.BOLD, 30));
			GameoverPanel.add(FinalScore);
			FinalScore.setBounds(250, 650, 400, 50);
			FinalScoreLabel.setFont(new Font("FinalScoreLabel",Font.BOLD, 30));
			GameoverPanel.add(FinalScoreLabel);
			FinalScoreLabel.setBounds(30, 650, 200, 50);
			card.show(MainPanel, "GameoverPanel");
			String s = SpeedNum+"";//ȡ�����ճɼ�
			String ss[] = new String[100];
			switch(SpeedFlag) {
			case 1: 
				for(int i = 0;i<RankingArray5.length;i++)
					ss[i] = RankingArray5[i][2];				
				break;
			case 2: 
				for(int i = 0;i<RankingArray6.length;i++)
					ss[i] = RankingArray6[i][2];				
				break;
			case 3: 
				for(int i = 0;i<RankingArray7.length;i++)
					ss[i] = RankingArray7[i][2];				
				break;
			case 4: 
				for(int i = 0;i<RankingArray8.length;i++)
					ss[i] = RankingArray8[i][2];				
				break;
			}
//				Sort a = new Sort(ss,s);
			if(SpeedNum >= 1){//����������һ��
				NewRecord.setVisible(true);//�¼�¼������ʾ
			}
		}
	}
	/*��ť������*/
	void monitor(){
		/*������尴ť*/
		BeginGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				card.show(MainPanel, "ModeChoosePanel");
			}
		});
		Calculation24.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				card.show(MainPanel, "Calculation24Panel");
			}
		});
		Ranking.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				RankingRead();
				RankingBreakBox.setSelectedIndex(0);
				RankingSpeedBox.setSelectedIndex(0);
				RankingTable();
				card.show(MainPanel, "RankingPanel");
			}
		});
		GameSetting.addActionListener(new ActionListener(){//����
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				RankingRead();
				if(GameFlag[0].equals("1"))
					BGMkai.setSelected(true);
				else BGMguan.setSelected(true);
				if(GameFlag[1].equals("1"))
					Soundkai.setSelected(true);
				else Soundguan.setSelected(true);
				if(GameFlag[2].equals("1"))
					JQKyou.setSelected(true);
				else JQKwu.setSelected(true);
				GameSettingPanel.remove(daojuNum);
				daojuNum = new JLabel("<html>���ֲ���ʹ��ʣ�����: " + GameFlag[3]
						+"<br/>(��ս���а���Ի�ø����������!)</html>");
				daojuNum.setFont(new Font("daojuNum",Font.BOLD, 30));
				GameSettingPanel.add(daojuNum);
				daojuNum.setBounds(50, 700, 550, 120);
				daojuNum.setVisible(false);
				card.show(MainPanel, "GameSettingPanel");
			}
		});
		GameHelp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				card.show(MainPanel, "GameHelpPanel");
			}
		});
		ExitGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				ExitGameDialog.setVisible(true);
				
			}
		});
		MainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				BUTTONClip.play();
				ExitGameDialog.setVisible(true);
			}
		});
		
		/*�˳���Ϸѯ�ʴ���*/
		ExitGameSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				count.cancel();
				BGMClip.stop();
				ExitGameDialog.dispose();
				MainFrame.dispose();
			}
		});
		ExitGameCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				ExitGameDialog.dispose();
			}
		});
		ExitGameDialog.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				BUTTONClip.play();
				ExitGameDialog.dispose();
			}
		});
		
		/*ģʽѡ����尴ť*/
		Exercise.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				//�Ѽ���������
				Right = 0;
				Wrong = 0;
				ModeFlag = 1;
				ExerciseCards();
		        ExerciseCardsRefresh();
		        DiffMode();
		        if(GameFlag[0].equals("1"))
		        	BGMClip.loop();
		        card.show(MainPanel, "ExercisePanel");
		        ExerciseTip.setVisible(true);
			}
		});
		Break.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				//��ʼ������ ���� ��Ϸģʽ �Ѷȿ�
				Level = 1;
				Correct = 5;
				ModeFlag = 2;
				BreakDifficulty.setSelectedIndex(0);				
				ExerciseCards();
		        ExerciseCardsRefresh();
		        DiffMode();
		        if(GameFlag[0].equals("1"))
		        	BGMClip.loop();
		        card.show(MainPanel, "ExercisePanel");
		        BreakTip.setVisible(true);
			}
		});
		Speed.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				//��ʼ������ ��Ϸģʽ �Ѷȿ�
				SpeedNum = 0;
				ModeFlag = 3;
				SpeedDifficulty.setSelectedIndex(0);
				ExerciseCards();
		        ExerciseCardsRefresh();
		        DiffMode();
		        if(GameFlag[0].equals("1"))
		        	BGMClip.loop();
		        card.show(MainPanel, "ExercisePanel");
		        SpeedTip.setVisible(true);
			}
		});
		ModeChooseReturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				card.show(MainPanel, "daohangPanel");
			}
		});
		
		/*���а���尴ť*/
		RankingBreakBox.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent event)
            {
                String s = (String) event.getItem();
                switch(s){
                case "�����Ѷ�": BUTTONClip.play();RankingBreakFlag = 1;
                RankingTable();break;
                case "�м��Ѷ�": BUTTONClip.play();RankingBreakFlag = 2;
                RankingTable();break;
                case "�߼��Ѷ�": BUTTONClip.play();RankingBreakFlag = 3;
                RankingTable();break;
                case "ج���Ѷ�": BUTTONClip.play();RankingBreakFlag = 4;
                RankingTable();break;
                }    
            }
        });
		RankingSpeedBox.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent event)
            {
                String s = (String) event.getItem();
                switch(s){
                case "�����Ѷ�": BUTTONClip.play();RankingSpeedFlag = 5;
                RankingTable();break;
                case "�м��Ѷ�": BUTTONClip.play();RankingSpeedFlag = 6;
                RankingTable();break;
                case "�߼��Ѷ�": BUTTONClip.play();RankingSpeedFlag = 7;
                RankingTable();break;
                case "ج���Ѷ�": BUTTONClip.play();RankingSpeedFlag = 8;
                RankingTable();break;
                }    
            }
        });
		WantList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				card.show(MainPanel, "ModeChoosePanel");
			}
		});
		RankingReturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				card.show(MainPanel, "daohangPanel");
			}
		});
		
		/*��Ϸ������尴ť*/
		GameSettingSave.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(BGMkai.isSelected())
					GameFlag[0] = "1";
				else if(BGMguan.isSelected())
					GameFlag[0] = "0";	
				if(Soundkai.isSelected())
					GameFlag[1] = "1";
				else if(Soundguan.isSelected())
					GameFlag[1] = "0";	
				if(JQKyou.isSelected())
					GameFlag[2] = "1";
				else if(JQKwu.isSelected())
					GameFlag[2] = "0";
				if(GameFlag[1].equals("0"))//�����ѡ��ر���Ϸ��Ч
					try {
						BUTTONClip =  Applet.newAudioClip(NULLfile.toURL());
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
				else if(GameFlag[1].equals("1"))//��Ч����
					try {
						BUTTONClip =  Applet.newAudioClip(BUTTONfile.toURL());
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
				BUTTONClip.play();
				GameFlagWrite();//�����ĵ���Ϸ��ʶд���ļ�
				card.show(MainPanel, "daohangPanel");
			}
		});
		GameSettingCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				card.show(MainPanel, "daohangPanel");
			}
		});
		/*��Ϸ������尴ť*/
		ISee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				card.show(MainPanel, "daohangPanel");
			}
		});
		/*��Ϸ������尴ť*/
		GameoverReturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				card.show(MainPanel, "daohangPanel");
			}
		});
		GameoverAgain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				card.show(MainPanel, "ModeChoosePanel");
			}
		});
		NewRecordSure.addActionListener(new ActionListener(){
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();			
				if(ModeFlag == 2){
					String s = Level + "";//ȡ�����ճɼ�
					String ss[] = new String[100];	//ȡ����Ӧ���а�ĳɼ�һ��				
					switch(BreakFlag) {
					case 1: 
						for(int i = 0;i<RankingArray1.length;i++)
							ss[i] = RankingArray1[i][2];				
						break;
					case 2: 
						for(int i = 0;i<RankingArray2.length;i++)
							ss[i] = RankingArray2[i][2];				
						break;
					case 3: 
						for(int i = 0;i<RankingArray3.length;i++)
							ss[i] = RankingArray3[i][2];				
						break;
					case 4: 
						for(int i = 0;i<RankingArray4.length;i++)
							ss[i] = RankingArray4[i][2];				
						break;
					}			
					Sort a = new Sort(ss,s);					
					String name = NewRecordName.getText();
					switch(BreakFlag) {
					case 1:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray1[i][2] = a.Ranking[i];//���Ƴɼ�����Ӧ���а�����
						RankingArray1[i][0] = i+1+"";//����
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//tλ��֮������������ƶ�һλ
							RankingArray1[i-1][1] = RankingArray1[i-2][1];
						}			
						RankingArray1[a.t][1] = name;break;
					case 2:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray2[i][2] = a.Ranking[i];//���Ƴɼ�����Ӧ���а�����
						RankingArray2[i][0] = i+1+"";//����
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//tλ��֮������������ƶ�һλ
							RankingArray2[i-1][1] = RankingArray2[i-2][1];
						}			
						RankingArray2[a.t][1] = name;break;
					case 3:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray3[i][2] = a.Ranking[i];//���Ƴɼ�����Ӧ���а�����
						RankingArray3[i][0] = i+1+"";//����
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//tλ��֮������������ƶ�һλ
							RankingArray3[i-1][1] = RankingArray3[i-2][1];
						}			
						RankingArray3[a.t][1] = name;break;
					case 4:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray4[i][2] = a.Ranking[i];//���Ƴɼ�����Ӧ���а�����
						RankingArray4[i][0] = i+1+"";//����
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//tλ��֮������������ƶ�һλ
							RankingArray4[i-1][1] = RankingArray4[i-2][1];
						}			
						RankingArray4[a.t][1] = name;break;
					}					
					RankingWrite();
					NewRecordName.setText(null);
//					GameFlag[3] = (Integer.parseInt(GameFlag[3])+(5-a.t)+BreakFlag)+"";
					GameFlagWrite();
					NewRecord.dispose();
				}
				else if(ModeFlag == 3){
					String s = SpeedNum+""; 
					String ss[] = new String[100];	//ȡ����Ӧ���а�ĳɼ�һ��				
					switch(SpeedFlag) {
					case 1: 
						for(int i = 0;i<RankingArray5.length;i++)
							ss[i] = RankingArray5[i][2];				
						break;
					case 2: 
						for(int i = 0;i<RankingArray6.length;i++)
							ss[i] = RankingArray6[i][2];				
						break;
					case 3: 
						for(int i = 0;i<RankingArray7.length;i++)
							ss[i] = RankingArray7[i][2];				
						break;
					case 4: 
						for(int i = 0;i<RankingArray8.length;i++)
							ss[i] = RankingArray8[i][2];				
						break;
					}			
					Sort a = new Sort(ss,s);					
					String name = NewRecordName.getText();
					switch(SpeedFlag) {
					case 1:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray5[i][2] = a.Ranking[i];//���Ƴɼ�����Ӧ���а�����
						RankingArray5[i][0] = i+1+"";//����
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//tλ��֮������������ƶ�һλ
							RankingArray5[i-1][1] = RankingArray5[i-2][1];
						}			
						RankingArray5[a.t][1] = name;break;
					case 2:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray6[i][2] = a.Ranking[i];//���Ƴɼ�����Ӧ���а�����
						RankingArray6[i][0] = i+1+"";//����
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//tλ��֮������������ƶ�һλ
							RankingArray6[i-1][1] = RankingArray6[i-2][1];
						}			
						RankingArray6[a.t][1] = name;break;
					case 3:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray7[i][2] = a.Ranking[i];//���Ƴɼ�����Ӧ���а�����
						RankingArray7[i][0] = i+1+"";//����
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//tλ��֮������������ƶ�һλ
							RankingArray7[i-1][1] = RankingArray7[i-2][1];
						}			
						RankingArray7[a.t][1] = name;break;
					case 4:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray8[i][2] = a.Ranking[i];//���Ƴɼ�����Ӧ���а�����
						RankingArray8[i][0] = i+1+"";//����
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//tλ��֮������������ƶ�һλ
							RankingArray8[i-1][1] = RankingArray8[i-2][1];
						}			
						RankingArray8[a.t][1] = name;break;
					}					
					RankingWrite();
					NewRecordName.setText(null);
//					GameFlag[3] = (Integer.parseInt(GameFlag[3])+(5-a.t)+SpeedFlag)+"";
					GameFlagWrite();
					NewRecord.dispose();
				}
			}
		});
		/*��Ϸ����尴ť*/
		BeginExercise.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				ExerciseCards();
		        ExerciseCardsRefresh();
				ExerciseTip.dispose();
			}
		});
		BreakDifficulty.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent event)
            {
                String s = (String) event.getItem();
                switch(s){
                case "�����Ѷ�": BUTTONClip.play();Breakintroduction.setText(null);
                Breakintroduction.setText("�ؿ���ʼʱ��Ϊ200�룬"
                		+ "ÿ2��ʱ������\n20�룬���120�롣(����JQK)");BreakFlag = 1;break;
                case "�м��Ѷ�": BUTTONClip.play();Breakintroduction.setText(null);
                Breakintroduction.setText("�ؿ���ʼʱ��Ϊ160�룬"
            			+ "ÿ2��ʱ������\n30�룬���100�롣(����JQK)");BreakFlag = 2;break;
                case "�߼��Ѷ�": BUTTONClip.play();Breakintroduction.setText(null);
                Breakintroduction.setText("�ؿ���ʼʱ��Ϊ120�룬"
            			+ "ÿ��ʱ������\n20�룬���80�롣(��JQK)");BreakFlag = 3;break;
                case "ج���Ѷ�(����˼)": BUTTONClip.play();Breakintroduction.setText(null);
                Breakintroduction.setText("�ؿ���ʼʱ��Ϊ80�룬"
            			+ "ÿ��ʱ������\n20�룬���40�롣(��JQK)");BreakFlag = 4;break;
                }
      
                ExercisePanel.remove(LevelNum);               
                switch(BreakFlag){
    			case 1: LevelNum = new JLabel("������"+Level+"��");break;
    			case 2: LevelNum = new JLabel("�м���"+Level+"��");break;
    			case 3: LevelNum = new JLabel("�߼���"+Level+"��");break;
    			case 4: LevelNum = new JLabel("ج�ε�"+Level+"��");break;
    			} 
                LevelNum.setFont(new Font("LevelNum",Font.BOLD, 30));
    			ExercisePanel.add(LevelNum);
    			LevelNum.setBounds(30, 30, 150, 50);            
            }
        });
		BeginBreak.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				ExerciseCards();
		        ExerciseCardsRefresh();
				BreakTip.dispose();
				switch(BreakFlag){
				case 1: BreakTime = 201;break;
				case 2: BreakTime = 161;break;
				case 3: BreakTime = 121;break;
				case 4: BreakTime = 81;break;
				}
				MYTimerTask task = new MYTimerTask();
				count = new Timer();
				count.schedule(task,new Date(),1000);
				daojuFlag = 0;
			}
		});
		SpeedDifficulty.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent event)
            {
                String s = (String) event.getItem();
                switch(s){
                case "�����Ѷ�": BUTTONClip.play();Speedintroduction.setText(null);
                Speedintroduction.setText("ÿ����40��ʱ������(����JQK)");SpeedFlag = 1;break;
                case "�м��Ѷ�": BUTTONClip.play();Speedintroduction.setText(null);
                Speedintroduction.setText("ÿ����30��ʱ������(����JQK)");SpeedFlag = 2;break;
                case "�߼��Ѷ�": BUTTONClip.play();Speedintroduction.setText(null);
                Speedintroduction.setText("ÿ����20��ʱ������(��JQK)");SpeedFlag = 3;break;
                case "ج���Ѷ�(�����ѡ��)": BUTTONClip.play();Speedintroduction.setText(null);
                Speedintroduction.setText("ÿ����10��ʱ������(��JQK)");SpeedFlag = 4;break;
                }
                if(ModeFlag == 3){
                ExercisePanel.remove(Answered);
    			switch(SpeedFlag){
    			case 1: Answered = new JLabel("����-�Ѵ������: " + SpeedNum);break;
    			case 2: Answered = new JLabel("�м�-�Ѵ������: " + SpeedNum);break;
    			case 3: Answered = new JLabel("�߼�-�Ѵ������: " + SpeedNum);break;
    			case 4: Answered = new JLabel("ج��-�Ѵ������: " + SpeedNum);break;
    			}
    			Answered.setFont(new Font("Answered",Font.BOLD, 30));
    			ExercisePanel.add(Answered);
    			Answered.setBounds(30, 30, 300, 50);
                }
            }
        });
		BeginSpeed.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				ExerciseCards();
		        ExerciseCardsRefresh();
				SpeedTip.dispose();
				switch(SpeedFlag){
				case 1: SpeedTime = 41;break;
				case 2: SpeedTime = 31;break;
				case 3: SpeedTime = 21;break;
				case 4: SpeedTime = 11;break;
				}
				MYTimerTask task = new MYTimerTask();
				count = new Timer();
				count.schedule(task,new Date(),1000); 
				daojuFlag = 0;
			}
		});
		Gamedaoju.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				GamedaojuDialog.setVisible(true);
			}
		});
		//��Ϸʹ�õ��ߴ���
		GamedaojuDialog.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				BUTTONClip.play();
				GamedaojuDialog.dispose();
			}
		});
		GamedaojuSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();				
				GameFlag[3] = (Integer.parseInt(GameFlag[3]) - 1) +"";
				daojuFlag = 1;
				GameFlagWrite();			
				GamedaojuDialog.dispose();
			}
		});
		GamedaojuCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				GamedaojuDialog.dispose();
			}
		});
		/**/
		ExerciseNumber1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				if(NumFlag == 1){
				String s = ExerciseNumber1.getText();
				String ss = ExerciseArea.getText();
				ss = ss + s;
				ExerciseArea.setText(null);
				ExerciseArea.setText(ss);
				if(daojuFlag == 0)
					ExerciseNumber1.setEnabled(false);
				NumFlag = 0;
				ChFlag = 1;
				}
			}
		});
		ExerciseNumber2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				if(NumFlag == 1){
					String s = ExerciseNumber2.getText();
					String ss = ExerciseArea.getText();
					ss = ss + s;
					ExerciseArea.setText(null);
					ExerciseArea.setText(ss);
					if(daojuFlag == 0)
						ExerciseNumber2.setEnabled(false);
					NumFlag = 0;
					ChFlag = 1;
					}
			}
		});
		ExerciseNumber3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				if(NumFlag == 1){
					String s = ExerciseNumber3.getText();
					String ss = ExerciseArea.getText();
					ss = ss + s;
					ExerciseArea.setText(null);
					ExerciseArea.setText(ss);
					if(daojuFlag == 0)
						ExerciseNumber3.setEnabled(false);
					NumFlag = 0;
					ChFlag = 1;
					}
			}
		});
		ExerciseNumber4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				if(NumFlag == 1){
					String s = ExerciseNumber4.getText();
					String ss = ExerciseArea.getText();
					ss = ss + s;
					ExerciseArea.setText(null);
					ExerciseArea.setText(ss);
					if(daojuFlag == 0)
						ExerciseNumber4.setEnabled(false);
					NumFlag = 0;
					ChFlag = 1;
					}
			}
		});
		ExerciseLBracket.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				String ss = ExerciseArea.getText();
				ss = ss + "(";
				ExerciseArea.setText(null);
				ExerciseArea.setText(ss);
				BrFlag++;
			}
		});
		ExerciseRBracket.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				if(BrFlag > 0){
				String ss = ExerciseArea.getText();
				ss = ss + ")";
				ExerciseArea.setText(null);
				ExerciseArea.setText(ss);
				BrFlag--;
				}
			}
		});
		Exercisejia.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				if(ChFlag == 1){
				String s = "+";
				String ss = ExerciseArea.getText();
				ss = ss + s;
				ExerciseArea.setText(null);
				ExerciseArea.setText(ss);
				ChFlag = 0;
				NumFlag = 1;
				}
			}
		});
		Exercisejian.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				if(ChFlag == 1){
					String s = "-";
					String ss = ExerciseArea.getText();
					ss = ss + s;
					ExerciseArea.setText(null);
					ExerciseArea.setText(ss);
					ChFlag = 0;
					NumFlag = 1;
					}
			}
		});
		Exercisecheng.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				if(ChFlag == 1){
					String s = "*";
					String ss = ExerciseArea.getText();
					ss = ss + s;
					ExerciseArea.setText(null);
					ExerciseArea.setText(ss);
					ChFlag = 0;
					NumFlag = 1;
					}
			}
		});
		Exercisechuyi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				if(ChFlag == 1){
					String s = "/";
					String ss = ExerciseArea.getText();
					ss = ss + s;
					ExerciseArea.setText(null);
					ExerciseArea.setText(ss);
					ChFlag = 0;
					NumFlag = 1;
					}
			}
		});
		
		ExerciseSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {	
				//���ȷ��ʱ���ĸ���ť����ȫ��Ϊ�����ü��ĸ�����ȫ����������
				if(ExerciseNumber1.isEnabled() || ExerciseNumber2.isEnabled()||
						ExerciseNumber3.isEnabled() || ExerciseNumber4.isEnabled()){
					BUTTONClip.play();
					if(daojuFlag == 1){//ʹ���˲��������ֵĵ���
						String ss = ExerciseArea.getText();
						Expression EX = new Expression();
						if(MyMath.round(EX.CalculateDirectly(ss), 8) == 24){//������ʽ���Ϊ24
							RightReact();//���������ȷ�ķ�Ӧ				
						}
						else{
							WrongReact();//����������ķ�Ӧ
						}
					}
				}
				else{
				String ss = ExerciseArea.getText();
				Expression EX = new Expression();
				if(MyMath.round(EX.CalculateDirectly(ss), 8) == 24){//������ʽ���Ϊ24
					RightReact();//���������ȷ�ķ�Ӧ				
				}
				else{
					WrongReact();//����������ķ�Ӧ
				}
					
				}
			}
		});
		Exercisewujie.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String a = ExerciseNumber1.getText();
				String b = ExerciseNumber2.getText();
				String c = ExerciseNumber3.getText();
				String d = ExerciseNumber4.getText();
				Calculate s = new Calculate();
		         s.GiveAnswer(a, b, c, d);
		         if(s.Answer.equals("�������޷��õ�24!")){
		        	 RightReact();//���������ȷ�ķ�Ӧ 
		         }
		         else{
		        	WrongReact();//����������ķ�Ӧ
		        	ExerciseNumber1.setEnabled(false);
		        	ExerciseNumber2.setEnabled(false);
					ExerciseNumber3.setEnabled(false);
					ExerciseNumber4.setEnabled(false);
					ExerciseLBracket.setEnabled(false);
					ExerciseRBracket.setEnabled(false);
					Exercisejia.setEnabled(false);
					Exercisejian.setEnabled(false);
					Exercisecheng.setEnabled(false);
					Exercisechuyi.setEnabled(false);
					ExerciseSure.setEnabled(false);
					Exercisewujie.setEnabled(false);
					ExerciseClear.setEnabled(false);
					ExerciseView.setEnabled(false);
		         }	 
			}
		});
		ExerciseClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				ExerciseArea.setText(null);
				ExerciseNumber1.setEnabled(true);
				ExerciseNumber2.setEnabled(true);
				ExerciseNumber3.setEnabled(true);
				ExerciseNumber4.setEnabled(true);
				NumFlag = 1;
				ChFlag = 0;
			}
		});
		ExerciseView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				WrongReact();
				String a = ExerciseNumber1.getText();
				String b = ExerciseNumber2.getText();
				String c = ExerciseNumber3.getText();
				String d = ExerciseNumber4.getText();
				Calculate s = new Calculate();
		        s.GiveAnswer(a, b, c, d);
		        ExerciseArea.setText(null);
		        ExerciseArea.setText("��Ϊ:"+s.Answer);
		        ExerciseNumber1.setEnabled(false);
				ExerciseNumber2.setEnabled(false);
				ExerciseNumber3.setEnabled(false);
				ExerciseNumber4.setEnabled(false);
				ExerciseLBracket.setEnabled(false);
				ExerciseRBracket.setEnabled(false);
				Exercisejia.setEnabled(false);
				Exercisejian.setEnabled(false);
				Exercisecheng.setEnabled(false);
				Exercisechuyi.setEnabled(false);
				ExerciseSure.setEnabled(false);
				Exercisewujie.setEnabled(false);
				ExerciseClear.setEnabled(false);
				ExerciseView.setEnabled(false);
			}
		});
		ExercisePass.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				ExerciseCards();
				ExerciseCardsRefresh();
			}
		});
		ExerciseExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				Exitask.setVisible(true);
			}
		});
		
		/*�˳�ѯ�ʴ��ڰ�ť*/
		ExitaskSure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				count.cancel();
				BGMClip.stop();
				Exitask.dispose();
				LastMode = ModeFlag;
				ModeFlag = 0;
				card.show(MainPanel, "ModeChoosePanel");
			}
		});
		ExitaskCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				Exitask.dispose();
			}
		});
		Exitask.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				BUTTONClip.play();
				Exitask.dispose();
			}
		});
		/*����24����尴ť*/
		Number1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				while(true){
				if(ValueArea1.getText().equals("")){
					ValueArea1.setText("1");
					break;
			}
				else if(ValueArea2.getText().equals("")){
					ValueArea2.setText("1");
					break;
				}
				else if(ValueArea3.getText().equals("")){
					ValueArea3.setText("1");
					break;
				}
				else if(ValueArea4.getText().equals("")){
					ValueArea4.setText("1");
					break;
				}
				else break;
			}
		}
	});
		Number2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				while(true){
				if(ValueArea1.getText().equals("")){
					ValueArea1.setText("2");
					break;
			}
				else if(ValueArea2.getText().equals("")){
					ValueArea2.setText("2");
					break;
				}
				else if(ValueArea3.getText().equals("")){
					ValueArea3.setText("2");
					break;
				}
				else if(ValueArea4.getText().equals("")){
					ValueArea4.setText("2");
					break;
				}
				else break;
			}
		}
	});
		Number3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				while(true){
				if(ValueArea1.getText().equals("")){
					ValueArea1.setText("3");
					break;
			}
				else if(ValueArea2.getText().equals("")){
					ValueArea2.setText("3");
					break;
				}
				else if(ValueArea3.getText().equals("")){
					ValueArea3.setText("3");
					break;
				}
				else if(ValueArea4.getText().equals("")){
					ValueArea4.setText("3");
					break;
				}
				else break;
			}
		}
	});
		Number4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				while(true){
				if(ValueArea1.getText().equals("")){
					ValueArea1.setText("4");
					break;
			}
				else if(ValueArea2.getText().equals("")){
					ValueArea2.setText("4");
					break;
				}
				else if(ValueArea3.getText().equals("")){
					ValueArea3.setText("4");
					break;
				}
				else if(ValueArea4.getText().equals("")){
					ValueArea4.setText("4");
					break;
				}
				else break;
			}
		}
	});
		Number5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				while(true){
				if(ValueArea1.getText().equals("")){
					ValueArea1.setText("5");
					break;
			}
				else if(ValueArea2.getText().equals("")){
					ValueArea2.setText("5");
					break;
				}
				else if(ValueArea3.getText().equals("")){
					ValueArea3.setText("5");
					break;
				}
				else if(ValueArea4.getText().equals("")){
					ValueArea4.setText("5");
					break;
				}
				else break;
			}
		}
	});
		Number6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				while(true){
				if(ValueArea1.getText().equals("")){
					ValueArea1.setText("6");
					break;
			}
				else if(ValueArea2.getText().equals("")){
					ValueArea2.setText("6");
					break;
				}
				else if(ValueArea3.getText().equals("")){
					ValueArea3.setText("6");
					break;
				}
				else if(ValueArea4.getText().equals("")){
					ValueArea4.setText("6");
					break;
				}
				else break;
			}
		}
	});
		Number7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				while(true){
				if(ValueArea1.getText().equals("")){
					ValueArea1.setText("7");
					break;
			}
				else if(ValueArea2.getText().equals("")){
					ValueArea2.setText("7");
					break;
				}
				else if(ValueArea3.getText().equals("")){
					ValueArea3.setText("7");
					break;
				}
				else if(ValueArea4.getText().equals("")){
					ValueArea4.setText("7");
					break;
				}
				else break;
			}
		}
	});
		Number8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				while(true){
				if(ValueArea1.getText().equals("")){
					ValueArea1.setText("8");
					break;
			}
				else if(ValueArea2.getText().equals("")){
					ValueArea2.setText("8");
					break;
				}
				else if(ValueArea3.getText().equals("")){
					ValueArea3.setText("8");
					break;
				}
				else if(ValueArea4.getText().equals("")){
					ValueArea4.setText("8");
					break;
				}
				else break;
			}
		}
	});
		Number9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				while(true){
				if(ValueArea1.getText().equals("")){
					ValueArea1.setText("9");
					break;
			}
				else if(ValueArea2.getText().equals("")){
					ValueArea2.setText("9");
					break;
				}
				else if(ValueArea3.getText().equals("")){
					ValueArea3.setText("9");
					break;
				}
				else if(ValueArea4.getText().equals("")){
					ValueArea4.setText("9");
					break;
				}
				else break;
			}
		}
	});
		Number10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				while(true){
				if(ValueArea1.getText().equals("")){
					ValueArea1.setText("10");
					break;
			}
				else if(ValueArea2.getText().equals("")){
					ValueArea2.setText("10");
					break;
				}
				else if(ValueArea3.getText().equals("")){
					ValueArea3.setText("10");
					break;
				}
				else if(ValueArea4.getText().equals("")){
					ValueArea4.setText("10");
					break;
				}
				else break;
			}
		}
	});
		Number11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				while(true){
				if(ValueArea1.getText().equals("")){
					ValueArea1.setText("11");
					break;
			}
				else if(ValueArea2.getText().equals("")){
					ValueArea2.setText("11");
					break;
				}
				else if(ValueArea3.getText().equals("")){
					ValueArea3.setText("11");
					break;
				}
				else if(ValueArea4.getText().equals("")){
					ValueArea4.setText("11");
					break;
				}
				else break;
			}
		}
	});
		Number12.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				while(true){
				if(ValueArea1.getText().equals("")){
					ValueArea1.setText("12");
					break;
			}
				else if(ValueArea2.getText().equals("")){
					ValueArea2.setText("12");
					break;
				}
				else if(ValueArea3.getText().equals("")){
					ValueArea3.setText("12");
					break;
				}
				else if(ValueArea4.getText().equals("")){
					ValueArea4.setText("12");
					break;
				}
				else break;
			}
		}
	});
		Number13.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				while(true){
				if(ValueArea1.getText().equals("")){
					ValueArea1.setText("13");
					break;
			}
				else if(ValueArea2.getText().equals("")){
					ValueArea2.setText("13");
					break;
				}
				else if(ValueArea3.getText().equals("")){
					ValueArea3.setText("13");
					break;
				}
				else if(ValueArea4.getText().equals("")){
					ValueArea4.setText("13");
					break;
				}
				else break;
			}
		}
	});
		Answer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				if(DisplayArea.getText().equals("")){
					String a = ValueArea1.getText();
					String b = ValueArea2.getText();
					String c = ValueArea3.getText();
					String d = ValueArea4.getText();
						if(a.equals("") || b.equals("") || c.equals("") || d.equals("")){
						}	
						else
						{
							Calculate s = new Calculate();
							s.GiveAnswer(a,b,c,d);
							DisplayArea.setText(s.Answer);
						}
				}
				else{
					String s = DisplayArea.getText();
					Expression q = new Expression();
					DisplayArea.setText("");
					DisplayArea.setText(s+"="+q.CalculateDirectly(s));
				}
				
			
		}
	});

		Delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				ValueArea1.setText("");
				ValueArea2.setText("");
				ValueArea3.setText("");
				ValueArea4.setText("");
				DisplayArea.setText("");
		}
	});
		
		Calculation24Return.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				ValueArea1.setText("");
				ValueArea2.setText("");
				ValueArea3.setText("");
				ValueArea4.setText("");
				DisplayArea.setText("");
				card.show(MainPanel, "daohangPanel");
			}
		});
	}
	@SuppressWarnings("deprecation")
	
	/*���а����Ϸ������Ϣ��ȡ*/
	void RankingRead(){
		try{
			for(int n = 1; n <= 8; ++n) {
				FileInputStream file1 = new FileInputStream("Txt/Ranking"+n+".txt");
				InputStreamReader file11 = new InputStreamReader(file1);
				BufferedReader reader1 = new BufferedReader(file11);
				String s;
				int i = 0;
				while ((s = reader1.readLine()) != null) {
			//String namename=RankingArray[i][1];
			//namename=MD5Util.convertMD5(namename);
			//s = RankingArray[i][0] + "-" + namename + "-"
			//		+ RankingArray[i][2];
			//s=MD5Util.convertMD5(s);
					switch(n) {
					case 1: RankingArray1[i] = s.split("-");
					i++;break;
					case 2: RankingArray2[i] = s.split("-");
					i++;break;
					case 3: RankingArray3[i] = s.split("-");
					i++;break;
					case 4: RankingArray4[i] = s.split("-");
					i++;break;
					case 5: RankingArray5[i] = s.split("-");
					i++;break;
					case 6: RankingArray6[i] = s.split("-");
					i++;break;
					case 7: RankingArray7[i] = s.split("-");
					i++;break;
					case 8: RankingArray8[i] = s.split("-");
					i++;break;
					}			
				}
				reader1.close();
			}
		
		
		FileInputStream file2 = new FileInputStream("Txt/GameSetting.txt");
		InputStreamReader file22 = new InputStreamReader(file2);
		BufferedReader reader2 = new BufferedReader(file22);
		String s;
		while ((s = reader2.readLine()) != null) {
			GameFlag = s.split("-");
		}
		
		reader2.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		if(GameFlag[1].equals("0"))//�����ѡ��ر���Ϸ��Ч
			try {
				BUTTONClip =  Applet.newAudioClip(NULLfile.toURL());
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		else if(GameFlag[1].equals("1"))//��Ч����
			try {
				BUTTONClip =  Applet.newAudioClip(BUTTONfile.toURL());
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
	}
	/*��Ϸ������Ϣд��*/
	void GameFlagWrite(){
        try {
			File fileout = new File("Txt/GameSetting.txt");
			FileWriter write = new FileWriter(fileout,false);//����֮ǰ�������ٴ�д���ļ�
			BufferedWriter writer = new BufferedWriter(write);
				if(GameFlag != null){
				String ss = GameFlag[0]+"-"+GameFlag[1]+"-"+GameFlag[2]+"-"+GameFlag[3];
				writer.write(ss);
				}
			
			writer.close();
			write.close();
		} 
		 catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*���а���Ϣд��*/
	void RankingWrite() {
        try {
        	if(ModeFlag == 2) {
        	File fileout = new File("Txt/Ranking"+BreakFlag+".txt");
			FileWriter write = new FileWriter(fileout,false);//����֮ǰ�������ٴ�д���ļ�
			BufferedWriter writer = new BufferedWriter(write);
			switch(BreakFlag) {
			case 1:
				for(int i=0; i<RankingArray1.length; i++){		
					if(RankingArray1[i][0] != null){
					String name = RankingArray1[i][1];
					//name=MD5Util.string2MD5(name);
					String ss = RankingArray1[i][0] + "-" + name + "-"
						+ RankingArray1[i][2];
					writer.write(ss);
					writer.newLine();
					writer.flush();
					}
				}break;
			case 2:
				for(int i=0; i<RankingArray2.length; i++){		
					if(RankingArray2[i][0] != null){
					String name = RankingArray2[i][1];
					//name=MD5Util.string2MD5(name);
					String ss = RankingArray2[i][0] + "-" + name + "-"
						+ RankingArray2[i][2];
					writer.write(ss);
					writer.newLine();
					writer.flush();
					}
				}break;
			case 3:
				for(int i=0; i<RankingArray3.length; i++){		
					if(RankingArray3[i][0] != null){
					String name = RankingArray3[i][1];
					//name=MD5Util.string2MD5(name);
					String ss = RankingArray3[i][0] + "-" + name + "-"
						+ RankingArray3[i][2];
					writer.write(ss);
					writer.newLine();
					writer.flush();
					}
				}break;
			case 4:
				for(int i=0; i<RankingArray4.length; i++){		
					if(RankingArray4[i][0] != null){
					String name = RankingArray4[i][1];
					//name=MD5Util.string2MD5(name);
					String ss = RankingArray4[i][0] + "-" + name + "-"
						+ RankingArray4[i][2];
					writer.write(ss);
					writer.newLine();
					writer.flush();
					}
				}break;
			}
			writer.close();
			write.close();
        	}
        	else if(ModeFlag == 3) {
            	File fileout = new File("Txt/Ranking"+(SpeedFlag+4)+".txt");
    			FileWriter write = new FileWriter(fileout,false);//����֮ǰ�������ٴ�д���ļ�
    			BufferedWriter writer = new BufferedWriter(write);
    			switch(SpeedFlag) {
    			case 1:
    				for(int i=0; i<RankingArray5.length; i++){		
    					if(RankingArray5[i][0] != null){
    					String name = RankingArray5[i][1];
    					//name=MD5Util.string2MD5(name);
    					String ss = RankingArray5[i][0] + "-" + name + "-"
    						+ RankingArray5[i][2];
    					writer.write(ss);
    					writer.newLine();
    					writer.flush();
    					}
    				}break;
    			case 2:
    				for(int i=0; i<RankingArray6.length; i++){		
    					if(RankingArray6[i][0] != null){
    					String name = RankingArray6[i][1];
    					//name=MD5Util.string2MD5(name);
    					String ss = RankingArray6[i][0] + "-" + name + "-"
    						+ RankingArray6[i][2];
    					writer.write(ss);
    					writer.newLine();
    					writer.flush();
    					}
    				}break;
    			case 3:
    				for(int i=0; i<RankingArray7.length; i++){		
    					if(RankingArray7[i][0] != null){
    					String name = RankingArray7[i][1];
    					//name=MD5Util.string2MD5(name);
    					String ss = RankingArray7[i][0] + "-" + name + "-"
    						+ RankingArray7[i][2];
    					writer.write(ss);
    					writer.newLine();
    					writer.flush();
    					}
    				}break;
    			case 4:
    				for(int i=0; i<RankingArray8.length; i++){		
    					if(RankingArray8[i][0] != null){
    					String name = RankingArray8[i][1];
    					//name=MD5Util.string2MD5(name);
    					String ss = RankingArray8[i][0] + "-" + name + "-"
    						+ RankingArray8[i][2];
    					writer.write(ss);
    					writer.newLine();
    					writer.flush();
    					}
    				}break;
    			}
    			writer.close();
    			write.close();
            	}
			
			
		} 
		 catch (IOException e) {
			e.printStackTrace();
		}
	}
}
