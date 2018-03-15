/**
 * 项目题目：算24点
 * 创建时间：2017.02.27
 * 作者：150410231-杨宇奇
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
	/*主窗口*/
	private JFrame MainFrame = new JFrame("算24点");
	private JLabel MainPicture;
	private JPanel MainPanel = new JPanel();
	private CardLayout card = new CardLayout();
	/*导航面板*/
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
	/*退出游戏询问窗口*/
	private JDialog ExitGameDialog = new JDialog(MainFrame,"退出游戏",true);
	ImageIcon Exitimg = new ImageIcon("Image/ask.png");
	private JLabel ExitGameDialogimg = new JLabel(Exitimg);
	private JLabel ExitGameLabel = new JLabel("您确定退出游戏吗?");
	private JButton ExitGameSure = new JButton("确定退出");
	private JButton ExitGameCancel = new JButton("我还要玩");
	/*模式选择面板*/
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
	/*练习模式面板*/
	private JPanel ExercisePanel = new JPanel();
	private JDialog ExerciseTip = new JDialog(MainFrame,"练习模式",true);
	private JLabel ExerciseTipLabel = new JLabel("<html>练习模式，本模式供练习使用，"
			+ "<br/>不计时，提供正确与错误题数。</html>");//html语法实现标签换行
	ImageIcon BeginExerciseimg = new ImageIcon("Image/BeginExercise.png");
	private JButton BeginExercise = new JButton(BeginExerciseimg);
	private int Right = 0;
	private int Wrong = 0;
	private JLabel RightNum = new JLabel("答对题数: " +Right+ " ");
	private JLabel WrongNum = new JLabel("错误题数: " +Wrong+ " ");
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
	private JButton ExerciseSure = new JButton("确定");
	private JButton Exercisewujie = new JButton("无解");
	private JButton ExerciseClear = new JButton("清除");
	private JButton ExerciseView = new JButton("查看");
	private JButton ExercisePass = new JButton("下一题");
	private JButton ExerciseExit = new JButton("退出");
	/*闯关模式面板*/
	private JDialog BreakTip = new JDialog(MainFrame,"闯关模式",true);
	private JLabel BreakTipLabel = new JLabel("<html>闯关模式，本模式下在规定时间内，"
	+ "<br/>每关5道题目全部答对则进入下一关。<br/>试试看你能闯过几关~"
	+ "<br/><br/>请选择您想要进行的游戏难度：</html>");//html语法实现标签换行
	@SuppressWarnings("rawtypes")
	private JComboBox BreakDifficulty = new JComboBox();//难度选择框
	private JTextArea Breakintroduction = new JTextArea("关卡初始时间为200秒，"
    		+ "每2关时间缩短\n20秒，最低120秒。(不含JQK)");//难度介绍文本域
	ImageIcon BeginBreakimg = new ImageIcon("Image/BeginBreak.png");
	private JButton BeginBreak = new JButton(BeginBreakimg);
	private int Level = 1;//关卡数
	private int Correct = 5;//剩余题数
	private int BreakFlag = 1;//难度标识
	private JLabel LevelNum = new JLabel("第 "+ Level +" 关");
	private JLabel CorrectNum = new JLabel("剩余题数: " +Correct);
	private JLabel BreakTimeLabel = new JLabel("剩余时间: ");
	private int BreakTime;
	private Timer count = new Timer();
	/*速算模式面板*/
	private JDialog SpeedTip = new JDialog(MainFrame,"速算模式",true);
	private JLabel SpeedTipLabel = new JLabel("<html>速算模式，本模式下每道题<br/>都必须"
	+ "在固定时间内完成，<br/>否则就Game over了。<br/>准备好开启烧脑了吗？"
	+ "<br/><br/>请选择您想要进行的游戏难度：</html>");
	@SuppressWarnings("rawtypes")
	private JComboBox SpeedDifficulty = new JComboBox();
	private JTextArea Speedintroduction = new JTextArea("每道题40秒时间作答。(不含JQK)");
	ImageIcon BeginSpeedimg = new ImageIcon("Image/BeginSpeed.png");
	private JButton BeginSpeed = new JButton(BeginSpeedimg);
	private int SpeedNum = 0;//完成题数
	private int SpeedFlag = 1;//难度标识
	private JLabel Answered = new JLabel("已答对题数: " + SpeedNum);
	private JLabel SpeedTimeLabel = new JLabel("剩余时间: ");
	private int SpeedTime;
	/*限制输入合法的标识*/
	private int NumFlag = 1;
	private int ChFlag = 0;
	private int BrFlag = 0;
	/*退出询问窗口*/
	private JDialog Exitask = new JDialog(MainFrame,"退出确认",true);
	ImageIcon askimg = new ImageIcon("Image/ask.png");
	private JLabel Exitaskimg = new JLabel(askimg);
	private JLabel ExitaskLabel = new JLabel("您真的要退出吗?");
	private JButton ExitaskSure = new JButton("确定");
	private JButton ExitaskCancel = new JButton("我点错了");
	/*游戏道具窗口*/
	private JDialog GamedaojuDialog = new JDialog(MainFrame,"确认使用",true);
	private JLabel GamedaojuLabel = new JLabel("<html>确认作答本题时，解除使用数字的限制吗？"
			+ "<br/>(即四个数字不限制使用次数和个数，消耗一次次数，仅该题有效)</html>");
	ImageIcon GamedaojuSureimg = new ImageIcon("Image/daojuSure.png");
	private JButton GamedaojuSure = new JButton(GamedaojuSureimg);
	ImageIcon GamedaojuCancelimg = new ImageIcon("Image/daojuCancel.png");
	private JButton GamedaojuCancel = new JButton(GamedaojuCancelimg);
	private int daojuFlag = 0;
	/*游戏结算面板*/
	private JPanel GameoverPanel = new JPanel();
	private JLabel GameoverLabel;
	private JLabel YourScore = new JLabel("您的成绩");
	private JLabel FinalAnswerLabel = new JLabel("最终答案: ");
	private JLabel FinalAnswer = new JLabel("((a@b)@c)@d");
	private JLabel FinalScoreLabel = new JLabel("最终成绩: ");
	private JLabel FinalScore = new JLabel("X");
	ImageIcon GameoverReturnimg = new ImageIcon("Image/ReturnMenu.png");
	private JButton GameoverReturn = new JButton(GameoverReturnimg);
	ImageIcon GameoverAgainimg = new ImageIcon("Image/Again.png");
	private JButton GameoverAgain = new JButton(GameoverAgainimg);
	private JDialog NewRecord = new JDialog(MainFrame,"新纪录!",true);
	private JLabel NewRecordLabel = new JLabel("<html>您本次游戏已打破纪录!"
			+ "<br/><br/>请留尊姓大名: </html>");
	private JTextField NewRecordName = new JTextField();
	ImageIcon NewRecordSureimg = new ImageIcon("Image/Sure.png");
	private JButton NewRecordSure = new JButton(NewRecordSureimg);
	/*计算24点面板*/
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
	private JButton Answer = new JButton("结果");
	private JButton Delete = new JButton("清除");
	private JButton Calculation24Return = new JButton("返回");
	/*排行榜面板*/
	private JPanel RankingPanel = new JPanel();
	private JLabel RankingBreak = new JLabel("闯关模式: ");
	private JLabel RankingSpeed = new JLabel("速算模式: ");
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
	private String BreakTableHead[] = {"排名","姓名","关数"};
	private Object BreakTableObject[][];
	private Object BreakTableObjectnew[][];
	private JTable SpeedTable;
	private JScrollPane Speedtable;
	private String SpeedTableHead[] = {"排名","姓名","题数"};
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
	/*游戏设置面板*/
	private JPanel GameSettingPanel = new JPanel();
	private JLabel GameSettingLabel;
	private String GameFlag[] = new String[4];//背景音乐,游戏音效与JQK标识和游戏道具数量数组
	private JLabel BGMSwitch = new JLabel("背景音乐: ");
	private ButtonGroup BGMKind = new ButtonGroup();
	private JRadioButton BGMkai = new JRadioButton("开");
	private JRadioButton BGMguan = new JRadioButton("关");
	private JLabel Sound = new JLabel("游戏音效: ");
	private ButtonGroup SoundKind = new ButtonGroup();
	private JRadioButton Soundkai = new JRadioButton("开");
	private JRadioButton Soundguan = new JRadioButton("关");
	private JLabel HaveJQK = new JLabel("发牌含JQK: ");
	private ButtonGroup JQKKind = new ButtonGroup();
	private JRadioButton JQKyou = new JRadioButton("含");
	private JRadioButton JQKwu = new JRadioButton("不含 (仅练习模式)");
	private JLabel daojuNum = new JLabel("<html>数字不限使用剩余次数: " + GameFlag[3]
			+"<br/>(挑战排行榜可以获得更多次数奖励!)</html>");
	ImageIcon GameSettingSaveimg = new ImageIcon("Image/Save.png");
	private JButton GameSettingSave = new JButton(GameSettingSaveimg);
	ImageIcon GameSettingCancelimg = new ImageIcon("Image/Cancel.png");
	private JButton GameSettingCancel = new JButton(GameSettingCancelimg);
	private File BGMfile = new File("Music/BGM.wav");
	private File WINfile = new File("Music/WIN.wav");
	private File LOSEfile = new File("Music/LOSE.wav");
	private File BUTTONfile = new File("Music/Button.wav");
	private File NULLfile = new File("Music/000.wav");//空文件
	private AudioClip BGMClip;
	private AudioClip WINClip;
	private AudioClip LOSEClip;
	private AudioClip BUTTONClip;
	/*游戏帮助面板*/
	private JPanel GameHelpPanel = new JPanel();
	private JLabel GameHelpLabel;
	ImageIcon ISeeimg = new ImageIcon("Image/ISee.png");
	private JButton ISee = new JButton(ISeeimg);
	
	public static void main(String args[]) {
		show a = new show();
		a.RankingRead();//文件读取
		a.MUSIC();//加载音乐
		a.UI();//加载UI
		a.monitor();//加载监听
//		Expression b = new Expression();
//		b.CaveatUI();
	}
	/*计时器*/
		class MYTimerTask extends TimerTask{ 
		    @Override 
		    //此方法为具体要定时操作的方法  
		    public void run() { 
		    	if(ModeFlag == 2){
		    		ExercisePanel.remove(BreakTimeLabel);
		    		BreakTime--;
		    		if(BreakTime < 0){
		    			WrongReact();
		    		}
		    		BreakTimeLabel = new JLabel("剩余时间: " + BreakTime);
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
		    		SpeedTimeLabel = new JLabel("剩余时间: " + SpeedTime);
		    		SpeedTimeLabel.setFont(new Font("SpeedTimeLabel",Font.BOLD, 30));
					ExercisePanel.add(SpeedTimeLabel);
					SpeedTimeLabel.setBounds(470, 30, 200, 50);
		    	}
		    } 
		} 
		
	@SuppressWarnings("unchecked")
	void UI(){
		/*主窗口初始化与布局*/
		MainFrame.setSize(700,700);
		MainFrame.setVisible(true);
		MainFrame.setLocationRelativeTo(null);
		MainFrame.setResizable(false);
		MainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ImageIcon maintubiao = new ImageIcon("Image/24.jpg");//设置主图标
		MainFrame.setIconImage(maintubiao.getImage());
		MainFrame.setLayout(null);
		MainFrame.add(MainPanel);
		MainPanel.setBounds(0, 0, 700, 700);
		MainPanel.setOpaque(false);//面板透明以显示背景图片
		MainPanel.setLayout(card);
		ImageIcon background = new ImageIcon("Image/000.png"); 
		MainPicture = new JLabel(background);
		MainPicture.setBounds(0, 0, 700, 700);
		JPanel imagePanel = (JPanel) MainFrame.getContentPane();  
        imagePanel.setOpaque(false);
		MainFrame.getLayeredPane().add(MainPicture, new Integer(Integer.MIN_VALUE));
		/*导航面板*/
		daohangPanel.setLayout(null);
		daohangPanel.setOpaque(false);
		ImageIcon daohangimg = new ImageIcon("Image/001.png"); 
		daohangLabel = new JLabel(daohangimg);
		daohangPanel.add(daohangLabel);
		daohangLabel.setBounds(30, 100, 548, 100);//24点图片
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
		
		/*退出游戏询问窗口*/
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
		/*模式选择面板*/
		ModeChoosePanel.setLayout(null);
		ModeChoosePanel.setOpaque(false);
		Exercise.setFont(new Font("Exercise",Font.BOLD, 30));
		Exercise.setBorderPainted(false);
		Exercise.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ModeChoosePanel.add(Exercise);
		Exercise.setBounds(350, 30, 300, 40);
		ImageIcon Exerciseimg = new ImageIcon("Image/练习.png"); 
		ExerciseLabel = new JLabel(Exerciseimg);
		ModeChoosePanel.add(ExerciseLabel);
		ExerciseLabel.setBounds(50, 75, 500, 100);
		Break.setFont(new Font("Break_through",Font.BOLD, 30));
		Break.setBorderPainted(false);
		Break.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ModeChoosePanel.add(Break);
		Break.setBounds(50, 195, 300, 40);
		ImageIcon Break_throughimg = new ImageIcon("Image/闯关.png"); 
		BreakLabel = new JLabel(Break_throughimg);
		ModeChoosePanel.add(BreakLabel);
		BreakLabel.setBounds(150, 250, 500, 100);
		Speed.setFont(new Font("Speed_Cal",Font.BOLD, 30));
		Speed.setBorderPainted(false);
		Speed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ModeChoosePanel.add(Speed);
		Speed.setBounds(350, 370, 300, 40);
		ImageIcon Speed_Calimg = new ImageIcon("Image/速算.png"); 
		SpeedLabel = new JLabel(Speed_Calimg);
		ModeChoosePanel.add(SpeedLabel);
		SpeedLabel.setBounds(50, 420, 500, 100);
		ModeChooseReturn.setFont(new Font("ModeChooseReturn",Font.BOLD, 30));
		ModeChooseReturn.setBorderPainted(false);
		ModeChooseReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ModeChoosePanel.add(ModeChooseReturn);
		ModeChooseReturn.setBounds(200, 540, 300, 40);
		MainPanel.add("ModeChoosePanel", ModeChoosePanel);
		
		
		/*练习模式面板*/
		//练习模式提示对话框
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
		
		//练习模式主面板
		ExercisePanel.setLayout(null);
		ExercisePanel.setOpaque(false);
		ExerciseCards1 = new JLabel("");//扑克牌标签初始化
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
		ExerciseArea.setEditable(false);//只供显示，不允许编辑操作
		ExerciseArea.setOpaque(false);
		ExerciseArea.setHorizontalAlignment(JTextField.CENTER);//文本居中
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
		
		
		/*闯关模式面板*/
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
		BreakDifficulty.addItem("初级难度");
		BreakDifficulty.addItem("中级难度");
		BreakDifficulty.addItem("高级难度");
		BreakDifficulty.addItem("噩梦难度(请三思)");
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
		/*速算模式面板*/
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
		SpeedDifficulty.addItem("初级难度");
		SpeedDifficulty.addItem("中级难度");
		SpeedDifficulty.addItem("高级难度");
		SpeedDifficulty.addItem("噩梦难度(请谨慎选择)");
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
		//游戏道具窗口
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
        
		/*退出询问窗口*/
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
        
		/*游戏结算面板*/
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
		
		
		//新纪录窗口
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
		
		/*计算24点面板*/
		Calculation24Panel.setLayout(null);
		Calculation24Panel.setOpaque(false);
		ImageIcon Calculation24img = new ImageIcon("Image/001.png"); 
		CalculationLabel = new JLabel(Calculation24img);
		Calculation24Panel.add(CalculationLabel);
		CalculationLabel.setBounds(12, 100, 548, 100);
		DisplayArea.setFont(new Font("DisplayArea",Font.BOLD, 30));
		DisplayArea.setEditable(true);//只供显示，不允许编辑操作
		DisplayArea.setOpaque(false);//设置控件是否透明的。true表示不透明,false表示透明。
		DisplayArea.setHorizontalAlignment(JTextField.CENTER);//文本居中
		Calculation24Panel.add(DisplayArea);
		DisplayArea.setBounds(18, 240, 649, 60);
		ValueArea1.setFont(new Font("ValueArea1",Font.BOLD, 20));
		ValueArea1.setEditable(false);
		ValueArea1.setHorizontalAlignment(JTextField.CENTER);//文本居中
		Calculation24Panel.add(ValueArea1);
		ValueArea1.setBounds(18, 310, 140, 50);
		ValueArea2.setFont(new Font("ValueArea2",Font.BOLD, 20));
		ValueArea2.setEditable(false);
		ValueArea2.setHorizontalAlignment(JTextField.CENTER);//文本居中
		Calculation24Panel.add(ValueArea2);
		ValueArea2.setBounds(187, 310, 140, 50);
		ValueArea3.setFont(new Font("ValueArea3",Font.BOLD, 20));
		ValueArea3.setEditable(false);
		ValueArea3.setHorizontalAlignment(JTextField.CENTER);//文本居中
		Calculation24Panel.add(ValueArea3);
		ValueArea3.setBounds(357, 310, 140, 50);
		ValueArea4.setFont(new Font("ValueArea4",Font.BOLD, 20));
		ValueArea4.setEditable(false);
		ValueArea4.setHorizontalAlignment(JTextField.CENTER);//文本居中
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
		
		/*游戏设置面板*/
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
		
		
		/*游戏帮助面板*/
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
		
		/*排行榜面板*/
		RankingPanel.setLayout(null);
		RankingPanel.setOpaque(false);
		RankingBreak.setFont(new Font("RankingBreak",Font.BOLD, 30));
		RankingPanel.add(RankingBreak);
		RankingBreak.setBounds(15, 10, 200, 40);
		RankingBreakBox.setFont(new Font("RankingBreakBox",Font.BOLD, 30));
		RankingBreakBox.addItem("初级难度");
		RankingBreakBox.addItem("中级难度");
		RankingBreakBox.addItem("高级难度");
		RankingBreakBox.addItem("噩梦难度");
		RankingPanel.add(RankingBreakBox);
		RankingBreakBox.setBounds(225, 10, 450, 40);
		BreakTableObject = new String[100][3];
		for(int i=0; i<100; i++){//得到闯关榜单信息
			if(RankingArray1[i][0] != null){
				BreakTableObject[i][0] =  RankingArray1[i][0];
				BreakTableObject[i][1] =  RankingArray1[i][1];
				BreakTableObject[i][2] =  RankingArray1[i][2];
			}
		}
		int real = 0;//排行榜数组内容不为空的数目
		for(int i=0;i<BreakTableObject.length;i++) {
			if(null != BreakTableObject[i][0])real++;
		}
		
		BreakTableObjectnew = new String[real][3];
		for(int i=0;i<BreakTableObjectnew.length;i++) {
			BreakTableObjectnew[i] = BreakTableObject[i];
		}
		BreakTable = new JTable(BreakTableObjectnew,BreakTableHead);//将信息与表头装到表中
		BreakTable.setRowHeight(40);//行高
		BreakTable.setEnabled(false);//不可编辑
		BreakTable.getTableHeader().setReorderingAllowed(false);//不可整列移动   
		BreakTable.getTableHeader().setResizingAllowed(false);//不可拉动表格
		BreakTable.getTableHeader().setFont(new Font("BreakTable",Font.BOLD, 20));
		BreakTable.setFont(new Font("BreakTable",Font.BOLD, 30));
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		BreakTable.setDefaultRenderer(Object.class, tcr);
		BreakTable.setOpaque(false);
		Breaktable = new JScrollPane(BreakTable);//定义一个带表头的表格
		Breaktable.setOpaque(false);
		Breaktable.setFont(new Font("Breaktable",Font.BOLD, 30));
		RankingPanel.add(Breaktable);
		Breaktable.setBounds(15, 70, 660, 230);
		
		
		RankingSpeed.setFont(new Font("RankingSpeed",Font.BOLD, 30));
		RankingPanel.add(RankingSpeed);
		RankingSpeed.setBounds(15, 320, 200, 40);
		RankingSpeedBox.addItem("初级难度");
		RankingSpeedBox.addItem("中级难度");
		RankingSpeedBox.addItem("高级难度");
		RankingSpeedBox.addItem("噩梦难度");
		RankingSpeedBox.setFont(new Font("RankingSpeedBox",Font.BOLD, 30));
		RankingPanel.add(RankingSpeedBox);
		RankingSpeedBox.setBounds(225,320, 450, 50);
		SpeedTableObject = new String[100][3];
		for(int i=0; i<100; i++){//得到速算榜单信息
			if(RankingArray5[i][0] != null){
				SpeedTableObject[i][0] =  RankingArray5[i][0];
				SpeedTableObject[i][1] =  RankingArray5[i][1];
				SpeedTableObject[i][2] =  RankingArray5[i][2];
			}
		}
		int real2 = 0;//排行榜数组内容不为空的数目
		for(int i=0;i<SpeedTableObject.length;i++) {
			if(null != SpeedTableObject[i][0])real2++;
		}
		SpeedTableObjectnew = new String[real2][3];
		for(int i=0;i<SpeedTableObjectnew.length;i++) {
			SpeedTableObjectnew[i] = SpeedTableObject[i];
		}
		SpeedTable = new JTable(SpeedTableObjectnew,SpeedTableHead);//将信息与表头装到表中
		SpeedTable.setRowHeight(40);//行高
		SpeedTable.setEnabled(false);//不可编辑
		SpeedTable.getTableHeader().setReorderingAllowed(false);//不可整列移动   
		SpeedTable.getTableHeader().setResizingAllowed(false);//不可拉动表格
		SpeedTable.getTableHeader().setFont(new Font("BreakTable",Font.BOLD, 20));
		SpeedTable.setFont(new Font("SpeedTable",Font.BOLD, 30));
		SpeedTable.setDefaultRenderer(Object.class, tcr);
		SpeedTable.setOpaque(false);
		Speedtable = new JScrollPane(SpeedTable);//定义一个带表头的表格
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
	/*刷新排行榜榜单函数*/
	void RankingTable(){
		RankingPanel.remove(Breaktable);
		RankingPanel.remove(Speedtable);
		RankingRead();
		
		BreakTableObject = new String[100][3];
		for(int i=0; i<100; i++){//得到闯关榜单信息
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
		int real = 0;//排行榜数组内容不为空的数目
		for(int i=0;i<BreakTableObject.length;i++) {
			if(null != BreakTableObject[i][0])real++;
		}
		BreakTableObjectnew = new String[real][3];
		for(int i=0;i<BreakTableObjectnew.length;i++) {
			BreakTableObjectnew[i] = BreakTableObject[i];
		}
		BreakTable = new JTable(BreakTableObjectnew,BreakTableHead);//将信息与表头装到表中
		BreakTable.setRowHeight(40);//行高
		BreakTable.setEnabled(false);//不可编辑
		BreakTable.getTableHeader().setReorderingAllowed(false);//不可整列移动   
		BreakTable.getTableHeader().setResizingAllowed(false);//不可拉动表格
		BreakTable.getTableHeader().setFont(new Font("BreakTable",Font.BOLD, 20));
		BreakTable.setFont(new Font("BreakTable",Font.BOLD, 20));
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		BreakTable.setDefaultRenderer(Object.class, tcr);
		BreakTable.setOpaque(false);
		Breaktable = new JScrollPane(BreakTable);//定义一个带表头的表格
		Breaktable.setOpaque(false);
		Breaktable.setFont(new Font("Breaktable",Font.BOLD, 30));
		RankingPanel.add(Breaktable);
		Breaktable.setBounds(15, 70, 660, 230);
		
		SpeedTableObject = new String[100][3];
		for(int i=0; i<100; i++){//得到速算榜单信息
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
		int real2 = 0;//排行榜数组内容不为空的数目
		for(int i=0;i<SpeedTableObject.length;i++) {
			if(null != SpeedTableObject[i][0])real2++;
		}
		SpeedTableObjectnew = new String[real2][3];
		for(int i=0;i<SpeedTableObjectnew.length;i++) {
			SpeedTableObjectnew[i] = SpeedTableObject[i];
		}
		SpeedTable = new JTable(SpeedTableObjectnew,SpeedTableHead);//将信息与表头装到表中
		SpeedTable.setRowHeight(40);//行高
		SpeedTable.setEnabled(false);//不可编辑
		SpeedTable.getTableHeader().setReorderingAllowed(false);//不可整列移动   
		SpeedTable.getTableHeader().setResizingAllowed(false);//不可拉动表格
		SpeedTable.getTableHeader().setFont(new Font("BreakTable",Font.BOLD, 20));
		SpeedTable.setFont(new Font("SpeedTable",Font.BOLD, 30));
		SpeedTable.setDefaultRenderer(Object.class, tcr);
		SpeedTable.setOpaque(false);
		Speedtable = new JScrollPane(SpeedTable);//定义一个带表头的表格
		Speedtable.setOpaque(false);
		Speedtable.setFont(new Font("Speedtable",Font.BOLD, 20));
		RankingPanel.add(Speedtable);
		Speedtable.setBounds(15, 390, 660, 230);
	}
	@SuppressWarnings("deprecation")
	/*背景音乐及音效*/
	void MUSIC(){
		try { 
			BGMClip = Applet.newAudioClip(BGMfile.toURL());  
			WINClip = Applet.newAudioClip(WINfile.toURL());
			LOSEClip = Applet.newAudioClip(LOSEfile.toURL());
        } catch(OutOfMemoryError e){  
            System.out.println("内存溢出");  
            e.printStackTrace();  
        } catch(Exception e){  
            e.printStackTrace();  
        }  
	}
	/*不同模式下面板计数功能更改*/
	void DiffMode(){
		if(ModeFlag == 1){//练习模式计数
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
			RightNum = new JLabel("答对题数: " +Right+ " ");
			RightNum.setFont(new Font("RightNum",Font.BOLD, 30));
			ExercisePanel.add(RightNum);
			RightNum.setBounds(30, 30, 200, 50);
			WrongNum = new JLabel("错误题数: " +Wrong+ " ");
			WrongNum.setFont(new Font("WrongNum",Font.BOLD, 30));
			ExercisePanel.add(WrongNum);
			WrongNum.setBounds(470, 30, 200, 50);
		}
		else if(ModeFlag == 2){//闯关模式计数
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
			if(!GameFlag[3].equals("0"))//若使用次数不为0，则可见
				Gamedaoju.setVisible(false);//关闭道具
			
			ExercisePanel.remove(LevelNum);
			LevelNum = new JLabel("初级第"+Level+"关");
			LevelNum.setFont(new Font("LevelNum",Font.BOLD, 30));
			ExercisePanel.add(LevelNum);
			LevelNum.setBounds(30, 30, 150, 50);
			
			CorrectNum = new JLabel("剩余题数: " +Correct);
			CorrectNum.setFont(new Font("CorrectNum",Font.BOLD, 30));
			ExercisePanel.add(CorrectNum);
			CorrectNum.setBounds(200, 30, 200, 50);
			
			BreakTimeLabel = new JLabel("剩余时间: ");
			BreakTimeLabel.setFont(new Font("BreakTimeLabel",Font.BOLD, 30));
			ExercisePanel.add(BreakTimeLabel);
			BreakTimeLabel.setBounds(470, 30, 200, 50);
		}
		else if(ModeFlag == 3){//速算模式计数
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
			if(!GameFlag[3].equals("0"))//若使用次数不为0，则可见
				Gamedaoju.setVisible(false);
			
			ExercisePanel.remove(Answered);
			Answered = new JLabel("初级-已答对题数: " + SpeedNum);
			Answered.setFont(new Font("Answered",Font.BOLD, 30));
			ExercisePanel.add(Answered);
			Answered.setBounds(30, 30, 300, 50);
			
			SpeedTimeLabel = new JLabel("剩余时间: ");
			SpeedTimeLabel.setFont(new Font("SpeedTimeLabel",Font.BOLD, 30));
			ExercisePanel.add(SpeedTimeLabel);
			SpeedTimeLabel.setBounds(470, 30, 200, 50);
		}
	}
	/*随机出现四张扑克牌并赋值给标签和按钮*/
	void ExerciseCards(){
		/*存储扑克牌类型数组，下标0为花色，下标1为数字*/
		int cards[][] = new int[4][2];
		/*存储花色字符串数组，保存花色数字对应的花色字符*/
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
				if(cards[i][1] == cards[j][1])//若有两张牌数字相同
					while(cards[i][0] == cards[j][0]){//当它们花色也相同时，随机更改一张花色直到不同
						cards[j][0] = 1+(int)(Math.random()*10);
					}
			}
		}
		/*由花色数字得到花色字符*/
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
	/*把扑克牌标签和数字按钮放到对应面板上*/
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
	/*解答正确面板更改方法*/
	void RightReact(){
		if(ModeFlag == 1){//练习
			if(GameFlag[1].equals("1"))
				WINClip.play();
			Right++;
			ExercisePanel.remove(RightNum);
			RightNum = new JLabel("答对题数: " +Right+ " ");
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
				//闯关模式不同难度下时间更改不同
				if(BreakFlag == 1){//初级难度，初始200，每2关减20，最低120
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
				else if(BreakFlag == 2){//中级难度,初始160，每2关减30，最低100
					if(Level >= 1 && Level <=2)
			    		BreakTime = 161;
			    		else if(Level >= 3 && Level <= 4)
			    			BreakTime = 131;
			    		else if(Level >= 5)
			    			BreakTime = 101;
				}
				else if(BreakFlag == 3){//高级难度，初始120，每关减20，最低80
					if(Level == 1)
			    		BreakTime = 121;
			    		else if(Level == 2)
			    			BreakTime = 101;
			    		else if(Level >= 3)
			    			BreakTime = 81;
				}
				else if(BreakFlag == 4){//噩梦难度，初始80，每关减20，最低40
					if(Level == 1)
			    		BreakTime = 81;
			    		else if(Level == 2)
			    			BreakTime = 61;
			    		else if(Level >= 3)
			    			BreakTime = 41;
				}				
				MYTimerTask task = new MYTimerTask();
			      //安排指定的任务在指定的时间开始进行重复的固定延迟执行。  
				count.cancel();
				count = new Timer();
				count.schedule(task,new Date(),1000); 			
			}
			else Correct--;			
			ExercisePanel.remove(LevelNum);
			ExercisePanel.remove(CorrectNum);
			switch(BreakFlag){
			case 1: LevelNum = new JLabel("初级第"+Level+"关");break;
			case 2: LevelNum = new JLabel("中级第"+Level+"关");break;
			case 3: LevelNum = new JLabel("高级第"+Level+"关");break;
			case 4: LevelNum = new JLabel("噩梦第"+Level+"关");break;
			}
			CorrectNum = new JLabel("剩余题数: " +Correct);
			LevelNum.setFont(new Font("LevelNum",Font.BOLD, 30));
			ExercisePanel.add(LevelNum);
			LevelNum.setBounds(30, 30, 150, 50);
			CorrectNum.setFont(new Font("CorrectNum",Font.BOLD, 30));
			ExercisePanel.add(CorrectNum);
			CorrectNum.setBounds(200, 30, 200, 50);
			ExerciseCards();
			ExerciseCardsRefresh();
		}
		else if(ModeFlag == 3){//速算模式
			if(GameFlag[1].equals("1"))
				WINClip.play();
			daojuFlag = 0;
			if(GameFlag[3].equals("0")){
				Gamedaoju.setVisible(false);
			}
			SpeedNum++;
			//速算模式下不同难度的不同时间
			switch(SpeedFlag){
			case 1: SpeedTime = 41;break;
			case 2: SpeedTime = 31;break;
			case 3: SpeedTime = 21;break;
			case 4: SpeedTime = 11;break;
			}
			MYTimerTask task = new MYTimerTask();
		      //安排指定的任务在指定的时间开始进行重复的固定延迟执行。  
			count.cancel();
			count = new Timer();
			count.schedule(task,new Date(),1000);
			
			ExercisePanel.remove(Answered);
			switch(SpeedFlag){
			case 1: Answered = new JLabel("初级-已答对题数: " + SpeedNum);break;
			case 2: Answered = new JLabel("中级-已答对题数: " + SpeedNum);break;
			case 3: Answered = new JLabel("高级-已答对题数: " + SpeedNum);break;
			case 4: Answered = new JLabel("噩梦-已答对题数: " + SpeedNum);break;
			}
			Answered.setFont(new Font("Answered",Font.BOLD, 30));
			ExercisePanel.add(Answered);
			Answered.setBounds(30, 30, 300, 50);
			ExerciseCards();
			ExerciseCardsRefresh();
		}		
	}
	@SuppressWarnings("null")
	/*解答错误面板更改方法*/
	void WrongReact(){
		System.out.println("jiesuan");
		if(ModeFlag == 1){//练习
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
	        ExerciseArea.setText("正解为:"+s.Answer);
			ExercisePanel.remove(WrongNum);
			WrongNum = new JLabel("错误题数: " +Wrong+ " ");
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
		else if(ModeFlag == 2){//闯关
			System.out.println("闯关");
			count.cancel();//计时停止
			if(GameFlag[1].equals("1"))
				LOSEClip.play();
			BGMClip.stop();
			LastMode = 2;
			Calculate q = new Calculate();
			//计算未答出的题目的答案
			q.GiveAnswer(ExerciseNumber1.getText(), ExerciseNumber2.getText(), 
					ExerciseNumber3.getText(), ExerciseNumber4.getText());
			//刷新最终答案和最终成绩
			GameoverPanel.remove(FinalAnswer);
			GameoverPanel.remove(FinalScore);
			GameoverPanel.remove(FinalScoreLabel);
			FinalAnswer = new JLabel(q.Answer);
			switch(BreakFlag){
			case 1: FinalScore = new JLabel("初级第"+Level+"关");break;
			case 2: FinalScore = new JLabel("中级第"+Level+"关");break;
			case 3: FinalScore = new JLabel("高级第"+Level+"关");break;
			case 4: FinalScore = new JLabel("噩梦第"+Level+"关");break;
			}
			FinalScoreLabel = new JLabel("您的水平: ");
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
				String s = Level+"";//取得最终成绩
				System.out.println("成绩="+s);
				String ss[] = null;	//取出对应排行榜的成绩一栏				
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
//				if(a.t < 5){//玩家成绩成功上榜
					System.out.println("input name");
					NewRecord.setVisible(true);//新纪录窗口显示
//				}
		}
		else if(ModeFlag == 3){//速算
			count.cancel();//计时停止
			if(GameFlag[1].equals("1"))
				LOSEClip.play();	
			BGMClip.stop();
			LastMode = 3;
			Calculate q = new Calculate();
			//计算未答出的题目的答案
			q.GiveAnswer(ExerciseNumber1.getText(), ExerciseNumber2.getText(), 
					ExerciseNumber3.getText(), ExerciseNumber4.getText());
			//刷新最终答案和最终成绩
			GameoverPanel.remove(FinalAnswer);
			GameoverPanel.remove(FinalScore);
			GameoverPanel.remove(FinalScoreLabel);
			FinalAnswer = new JLabel(q.Answer);
			switch(SpeedFlag){
			case 1: FinalScore = new JLabel("初级"+SpeedNum+"题");break;
			case 2: FinalScore = new JLabel("中级"+SpeedNum+"题");break;
			case 3: FinalScore = new JLabel("高级"+SpeedNum+"题");break;
			case 4: FinalScore = new JLabel("噩梦"+SpeedNum+"题");break;
			}		
			FinalScoreLabel = new JLabel("完成题数: ");
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
			String s = SpeedNum+"";//取得最终成绩
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
			if(SpeedNum >= 1){//答题数超过一道
				NewRecord.setVisible(true);//新纪录窗口显示
			}
		}
	}
	/*按钮监听器*/
	void monitor(){
		/*导航面板按钮*/
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
		GameSetting.addActionListener(new ActionListener(){//设置
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
				daojuNum = new JLabel("<html>数字不限使用剩余次数: " + GameFlag[3]
						+"<br/>(挑战排行榜可以获得更多次数奖励!)</html>");
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
		
		/*退出游戏询问窗口*/
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
		
		/*模式选择面板按钮*/
		Exercise.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				//把计数器重置
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
				//初始化关数 题数 游戏模式 难度框
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
				//初始化题数 游戏模式 难度框
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
		
		/*排行榜面板按钮*/
		RankingBreakBox.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent event)
            {
                String s = (String) event.getItem();
                switch(s){
                case "初级难度": BUTTONClip.play();RankingBreakFlag = 1;
                RankingTable();break;
                case "中级难度": BUTTONClip.play();RankingBreakFlag = 2;
                RankingTable();break;
                case "高级难度": BUTTONClip.play();RankingBreakFlag = 3;
                RankingTable();break;
                case "噩梦难度": BUTTONClip.play();RankingBreakFlag = 4;
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
                case "初级难度": BUTTONClip.play();RankingSpeedFlag = 5;
                RankingTable();break;
                case "中级难度": BUTTONClip.play();RankingSpeedFlag = 6;
                RankingTable();break;
                case "高级难度": BUTTONClip.play();RankingSpeedFlag = 7;
                RankingTable();break;
                case "噩梦难度": BUTTONClip.play();RankingSpeedFlag = 8;
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
		
		/*游戏设置面板按钮*/
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
				if(GameFlag[1].equals("0"))//若玩家选择关闭游戏音效
					try {
						BUTTONClip =  Applet.newAudioClip(NULLfile.toURL());
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
				else if(GameFlag[1].equals("1"))//音效开启
					try {
						BUTTONClip =  Applet.newAudioClip(BUTTONfile.toURL());
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
				BUTTONClip.play();
				GameFlagWrite();//将更改的游戏标识写入文件
				card.show(MainPanel, "daohangPanel");
			}
		});
		GameSettingCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				card.show(MainPanel, "daohangPanel");
			}
		});
		/*游戏帮助面板按钮*/
		ISee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				BUTTONClip.play();
				card.show(MainPanel, "daohangPanel");
			}
		});
		/*游戏结算面板按钮*/
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
					String s = Level + "";//取得最终成绩
					String ss[] = new String[100];	//取出对应排行榜的成绩一栏				
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
						RankingArray1[i][2] = a.Ranking[i];//复制成绩到对应排行榜数组
						RankingArray1[i][0] = i+1+"";//排名
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//t位置之后的姓名往后移动一位
							RankingArray1[i-1][1] = RankingArray1[i-2][1];
						}			
						RankingArray1[a.t][1] = name;break;
					case 2:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray2[i][2] = a.Ranking[i];//复制成绩到对应排行榜数组
						RankingArray2[i][0] = i+1+"";//排名
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//t位置之后的姓名往后移动一位
							RankingArray2[i-1][1] = RankingArray2[i-2][1];
						}			
						RankingArray2[a.t][1] = name;break;
					case 3:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray3[i][2] = a.Ranking[i];//复制成绩到对应排行榜数组
						RankingArray3[i][0] = i+1+"";//排名
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//t位置之后的姓名往后移动一位
							RankingArray3[i-1][1] = RankingArray3[i-2][1];
						}			
						RankingArray3[a.t][1] = name;break;
					case 4:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray4[i][2] = a.Ranking[i];//复制成绩到对应排行榜数组
						RankingArray4[i][0] = i+1+"";//排名
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//t位置之后的姓名往后移动一位
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
					String ss[] = new String[100];	//取出对应排行榜的成绩一栏				
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
						RankingArray5[i][2] = a.Ranking[i];//复制成绩到对应排行榜数组
						RankingArray5[i][0] = i+1+"";//排名
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//t位置之后的姓名往后移动一位
							RankingArray5[i-1][1] = RankingArray5[i-2][1];
						}			
						RankingArray5[a.t][1] = name;break;
					case 2:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray6[i][2] = a.Ranking[i];//复制成绩到对应排行榜数组
						RankingArray6[i][0] = i+1+"";//排名
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//t位置之后的姓名往后移动一位
							RankingArray6[i-1][1] = RankingArray6[i-2][1];
						}			
						RankingArray6[a.t][1] = name;break;
					case 3:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray7[i][2] = a.Ranking[i];//复制成绩到对应排行榜数组
						RankingArray7[i][0] = i+1+"";//排名
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//t位置之后的姓名往后移动一位
							RankingArray7[i-1][1] = RankingArray7[i-2][1];
						}			
						RankingArray7[a.t][1] = name;break;
					case 4:
						for(int i=0; i<a.Ranking.length; i++){
						RankingArray8[i][2] = a.Ranking[i];//复制成绩到对应排行榜数组
						RankingArray8[i][0] = i+1+"";//排名
						}
						for(int i=a.Ranking.length;i>(a.t+1);i--) {//t位置之后的姓名往后移动一位
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
		/*游戏主面板按钮*/
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
                case "初级难度": BUTTONClip.play();Breakintroduction.setText(null);
                Breakintroduction.setText("关卡初始时间为200秒，"
                		+ "每2关时间缩短\n20秒，最低120秒。(不含JQK)");BreakFlag = 1;break;
                case "中级难度": BUTTONClip.play();Breakintroduction.setText(null);
                Breakintroduction.setText("关卡初始时间为160秒，"
            			+ "每2关时间缩短\n30秒，最低100秒。(不含JQK)");BreakFlag = 2;break;
                case "高级难度": BUTTONClip.play();Breakintroduction.setText(null);
                Breakintroduction.setText("关卡初始时间为120秒，"
            			+ "每关时间缩短\n20秒，最低80秒。(含JQK)");BreakFlag = 3;break;
                case "噩梦难度(请三思)": BUTTONClip.play();Breakintroduction.setText(null);
                Breakintroduction.setText("关卡初始时间为80秒，"
            			+ "每关时间缩短\n20秒，最低40秒。(含JQK)");BreakFlag = 4;break;
                }
      
                ExercisePanel.remove(LevelNum);               
                switch(BreakFlag){
    			case 1: LevelNum = new JLabel("初级第"+Level+"关");break;
    			case 2: LevelNum = new JLabel("中级第"+Level+"关");break;
    			case 3: LevelNum = new JLabel("高级第"+Level+"关");break;
    			case 4: LevelNum = new JLabel("噩梦第"+Level+"关");break;
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
                case "初级难度": BUTTONClip.play();Speedintroduction.setText(null);
                Speedintroduction.setText("每道题40秒时间作答。(不含JQK)");SpeedFlag = 1;break;
                case "中级难度": BUTTONClip.play();Speedintroduction.setText(null);
                Speedintroduction.setText("每道题30秒时间作答。(不含JQK)");SpeedFlag = 2;break;
                case "高级难度": BUTTONClip.play();Speedintroduction.setText(null);
                Speedintroduction.setText("每道题20秒时间作答。(含JQK)");SpeedFlag = 3;break;
                case "噩梦难度(请谨慎选择)": BUTTONClip.play();Speedintroduction.setText(null);
                Speedintroduction.setText("每道题10秒时间作答。(含JQK)");SpeedFlag = 4;break;
                }
                if(ModeFlag == 3){
                ExercisePanel.remove(Answered);
    			switch(SpeedFlag){
    			case 1: Answered = new JLabel("初级-已答对题数: " + SpeedNum);break;
    			case 2: Answered = new JLabel("中级-已答对题数: " + SpeedNum);break;
    			case 3: Answered = new JLabel("高级-已答对题数: " + SpeedNum);break;
    			case 4: Answered = new JLabel("噩梦-已答对题数: " + SpeedNum);break;
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
		//游戏使用道具窗口
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
				//点击确定时，四个按钮必须全部为不可用即四个数字全部被用上了
				if(ExerciseNumber1.isEnabled() || ExerciseNumber2.isEnabled()||
						ExerciseNumber3.isEnabled() || ExerciseNumber4.isEnabled()){
					BUTTONClip.play();
					if(daojuFlag == 1){//使用了不限制数字的道具
						String ss = ExerciseArea.getText();
						Expression EX = new Expression();
						if(MyMath.round(EX.CalculateDirectly(ss), 8) == 24){//如果表达式结果为24
							RightReact();//给出解答正确的反应				
						}
						else{
							WrongReact();//给出解答错误的反应
						}
					}
				}
				else{
				String ss = ExerciseArea.getText();
				Expression EX = new Expression();
				if(MyMath.round(EX.CalculateDirectly(ss), 8) == 24){//如果表达式结果为24
					RightReact();//给出解答正确的反应				
				}
				else{
					WrongReact();//给出解答错误的反应
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
		         if(s.Answer.equals("该四数无法得到24!")){
		        	 RightReact();//给出解答正确的反应 
		         }
		         else{
		        	WrongReact();//给出解答错误的反应
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
		        ExerciseArea.setText("答案为:"+s.Answer);
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
		
		/*退出询问窗口按钮*/
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
		/*计算24点面板按钮*/
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
	
	/*排行榜和游戏设置信息读取*/
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
		if(GameFlag[1].equals("0"))//若玩家选择关闭游戏音效
			try {
				BUTTONClip =  Applet.newAudioClip(NULLfile.toURL());
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
		else if(GameFlag[1].equals("1"))//音效开启
			try {
				BUTTONClip =  Applet.newAudioClip(BUTTONfile.toURL());
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
	}
	/*游戏设置信息写入*/
	void GameFlagWrite(){
        try {
			File fileout = new File("Txt/GameSetting.txt");
			FileWriter write = new FileWriter(fileout,false);//覆盖之前的内容再次写入文件
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
	/*排行榜信息写入*/
	void RankingWrite() {
        try {
        	if(ModeFlag == 2) {
        	File fileout = new File("Txt/Ranking"+BreakFlag+".txt");
			FileWriter write = new FileWriter(fileout,false);//覆盖之前的内容再次写入文件
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
    			FileWriter write = new FileWriter(fileout,false);//覆盖之前的内容再次写入文件
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
