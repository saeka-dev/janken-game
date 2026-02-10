import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginFrame {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
		
		
			JFrame frame = new JFrame("ログイン画面");
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			
			JLabel idLabel = new JLabel("ID");
			JTextField idField = new JTextField(15);//文字入力の箱
			
			JLabel passLabel = new JLabel("PASS");
			JPasswordField pass1 = new JPasswordField(15);
			
			//エラーメッセージ用ラベル
			JLabel messageLabel = new JLabel(" ");//最初は空白
			messageLabel.setHorizontalAlignment(JLabel.CENTER);
			messageLabel.setForeground(Color.RED);
			
			JButton button1 = new JButton("OK");
			button1.setPreferredSize(new Dimension(120,30));
			button1.addActionListener(e -> { //押されたら何するか
				String inputId = idField.getText(); //ID欄の文字取得
				String inputPass = new String(pass1.getPassword()); //Pass取得
				if (inputId.equals("test") && inputPass.equals("1234")) { //正誤チェック
					JOptionPane.showMessageDialog(frame, "ログイン成功！");
					new JankenFrame();
					frame.dispose();
				} else {
					messageLabel.setText("IDかパスワードが違います");
				}
			});
			
			//入力欄をまとめるパネル
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(2,2,10,10));
			panel.add(idLabel);
			panel.add(idField);
			panel.add(passLabel);
			panel.add(pass1);
			
			//ボタンパネル
			JPanel buttonPanel = new JPanel(new BorderLayout());
			buttonPanel.add(messageLabel, BorderLayout.NORTH);
			buttonPanel.add(button1,BorderLayout.CENTER);
			
			//外枠
			JPanel outer = new JPanel(new BorderLayout());
			outer.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
			outer.add(panel, BorderLayout.CENTER);
			outer.add(buttonPanel, BorderLayout.SOUTH);
			
			//画面に表示
			frame.add(outer);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
		});
	}
}








