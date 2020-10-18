package myGui02;

import java.awt.*;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPaneEx extends JFrame {
	public ContentPaneEx() {
		setTitle("ContentPaner과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로세스까지 깔끔하게 닫을 수 있다.
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(300, 150);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new ContentPaneEx();

	}

}
