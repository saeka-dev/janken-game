import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JankenFrame {
	private static String[] hands = {"グー","チョキ","パー"}; //じゃんけんの手を配列で管理
	private static JLabel contentsLabel;

	public JankenFrame() {
		JFrame frame = new JFrame("じゃんけんゲーム");
		frame.setSize(640,480);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout()); //上・中央・下に部品を置ける
		frame.getContentPane().setBackground(Color.WHITE);
		
		contentsLabel = new JLabel("じゃんけん…", JLabel.CENTER);
		contentsLabel.setForeground(Color.BLACK);
		contentsLabel.setFont(contentsLabel.getFont().deriveFont(54f));
		frame.add(contentsLabel, BorderLayout.CENTER);
		
		//フッターパネル
		JPanel footerPanel = new JPanel();
		
		//ボタン作成・じゃんけん選択肢
		for (String hand : hands) {
			JButton button = new JButton(hand);
			button.setFont(new Font("MS ゴシック",Font.PLAIN,24));
			button.addActionListener(new ButtonActionListener());
			footerPanel.add(button);
		}
		
		//ボタンを画面下に配置
		frame.add(footerPanel,BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JankenFrame();
	}
	
	//ボタンが押されたら動くクラス
	static class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e ) { //押された瞬間に呼ばれるメソッド
			String playerHand = e.getActionCommand(); //押されたボタンの文字取得
			int cpu = ComputerHand.getComputerHand(); //cpuの手を決める
			String cpuHand = hands[cpu];
			
			String result;
			
			//勝敗判定
			if(playerHand.equals(cpuHand)) {
				result = "あいこ";
			} else if (
				(playerHand.equals("グー") && cpuHand.equals("チョキ")) ||
				(playerHand.equals("チョキ") && cpuHand.equals("パー")) ||
				(playerHand.equals("パー") && cpuHand.equals("グー"))
			) {
				result = "あなたの勝ち！";
			} else {
				result = "あなたの負け…";
			}
			
			//画面に結果表示
			contentsLabel.setText(
				"<html>" + "<div align='center'>" + "<b>" + result + "</b>" + "<br><br>" + "あなた：" + playerHand + "<br>CPU：" + cpuHand + "</html>");
		}
	}
}

//cpuの手を決める
class ComputerHand {
	static int getComputerHand() {
		Random random = new Random();
		int hand = random.nextInt(3);
		return hand;
	}
}