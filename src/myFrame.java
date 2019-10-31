package kaisarasSipherGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class myFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	KaisarasDecode kc = new KaisarasDecode();
	
	private JPanel panel;
	private JLabel labelInput;
	private JLabel labelOutput;
	private JTextField textfieldinput;
	private JTextField textfieldoutput;
	private JButton buttonCode;
	private JButton buttonDeCode;
	private JButton Info;
	
	public myFrame() {
		panel = new JPanel();
		
		labelInput = new JLabel();
		labelInput.setText("Αρχικό Μήνυμα στα Ελληνικά");
		textfieldinput = new JTextField(35);
		labelOutput = new JLabel();
		labelOutput.setText("Τελικό Μύνημα");
		textfieldoutput = new JTextField(35);
		buttonCode = new JButton("Κωδικοποίηση στα Ελληνικά");
		buttonDeCode = new JButton("Αποκωδικοποίηση στα Ελληνικά");
		Info = new JButton("Πληροφορίες");
		
		panel.add(labelInput);
		panel.add(textfieldinput);
		panel.add(labelOutput);
		panel.add(textfieldoutput);
		panel.add(buttonCode);
		panel.add(buttonDeCode);
		panel.add(Info);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		buttonCode.addActionListener(listener);
		buttonDeCode.addActionListener(listener);
		Info.addActionListener(listener);
		
		this.setVisible(true);
		this.setSize(450,450);
		this.setTitle("Αλγόριθμος Κωδικοποίησης του ΚΑΊΣΑΡΑ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonCode) {
				textfieldoutput.setText(null);
				String minima = textfieldinput.getText();
				textfieldinput.setText(null);
				textfieldoutput.setText(kc.kodikopoioisi(minima));
			}else if (e.getSource() == buttonDeCode) {
				textfieldoutput.setText(null);
				String minima = textfieldinput.getText();
				textfieldinput.setText(null);
				textfieldoutput.setText(kc.apokodikopoioisi(minima));
			}else {
				JOptionPane.showMessageDialog(panel, "Προγραμματιστης : Ψαλτακης Νικολαος StormRideR "
						+ "(c)2019 \nΤο πρόγραμμα αυτό χρησιμοποίει τον Αλγόριθμο του Καίσαρα για να\n"
						+ "κωδικοποίηση και να αποδικοποιήσει ένα κείμενο.\nΣε κάθε χαρακτήρα προσθέτει 3.",
						"Πληροφορίες", JOptionPane.INFORMATION_MESSAGE);

			}
		}
	}
	
}
