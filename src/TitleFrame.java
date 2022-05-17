/*Title Frame - First Frame, allows user to login with appropriate username and password along with transitioning to the instructions and main frame
 Developer: Kinjal Kamboj
 Date Started: May 20, 2021
 Date Ended: 
 */

import javax.swing.*;
import java.awt.*;
 
public class TitleFrame extends JFrame {
	JPanel firstTitlePanel, picPanel, logInInput, buttonsInput;
	JLabel title, pic, username, password;
	JTextField inputUsername;
	JPasswordField inputPassword;
	JButton login, instructions;

	public static void main(String[] args) {
		new TitleFrame();

	}

	public TitleFrame() {
		
		//Title Panel
		firstTitlePanel = new JPanel();
		firstTitlePanel.setLayout(new BoxLayout(firstTitlePanel, BoxLayout.Y_AXIS));
		title = new JLabel("St. Marcellinus Grade 12 Calculator");
		title.setFont(new Font("Castellar", Font.BOLD, 18));
		title.setBorder(BorderFactory.createCompoundBorder(
		title.getBorder(), 
		BorderFactory.createEmptyBorder(3, 0, 0, 0))); 
		firstTitlePanel.add(title);
		
		pic = new JLabel(); //Adding school's arms code
		ImageIcon img = new ImageIcon(getClass().getResource("arms.jpg"));
		Image image = img.getImage(); 
		Image newImage = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH); 
		img = new ImageIcon(newImage);
		pic.setIcon(img);
		picPanel = new JPanel();
		picPanel.add(pic, BorderLayout.SOUTH);
		picPanel.setBackground(Color.WHITE);
		this.setBackground(Color.WHITE);
		
		firstTitlePanel.add(picPanel);
		firstTitlePanel.setBackground(Color.WHITE);
		this.setBackground(Color.WHITE);
		
		//Adding input panel - username and password
		logInInput = new JPanel();
		logInInput.setLayout(new BoxLayout(logInInput, BoxLayout.Y_AXIS));
		
		username = new JLabel("Username:");
		inputUsername = new JTextField(8);
		inputUsername.setMaximumSize(new Dimension(150, 20));
		
		password = new JLabel("Password:");
		inputPassword = new JPasswordField(8);
		inputPassword.setMaximumSize(new Dimension(150, 20));

		logInInput.add(username);
		logInInput.add(inputUsername);
		logInInput.add(password);
		logInInput.add(inputPassword);
		
		logInInput.setBackground(Color.WHITE);
		this.setBackground(Color.WHITE);
		
		//Adding buttons
		buttonsInput = new JPanel();
		buttonsInput.setLayout(new BoxLayout(buttonsInput, BoxLayout.X_AXIS));
		buttonsInput.setBackground(Color.WHITE);
		this.setBackground(Color.WHITE);
				
		login = new JButton("Login");
		instructions = new JButton("Instructions");
		
		buttonsInput.add(login);
		buttonsInput.add(instructions);
		logInInput.add(buttonsInput);
		
		buttonsInput.setBorder(BorderFactory.createCompoundBorder(
	    buttonsInput.getBorder(), 
		BorderFactory.createEmptyBorder(15, 0, 0, 0))); 
		
		logInInput.setBorder(BorderFactory.createCompoundBorder(
		logInInput.getBorder(), 
		BorderFactory.createEmptyBorder(13, 90, 0, 90))); 		
		
		getContentPane().add(firstTitlePanel, BorderLayout.NORTH);
		getContentPane().add(logInInput, BorderLayout.CENTER);
		
		//Adding action listeners for login and instruction buttons
		try {
		login.addActionListener(a -> {
			if (inputUsername.getText().equals("marciestudent") && (new String (inputPassword.getPassword()).equals("8896754"))) {
				GradeCalculator frame3 = new GradeCalculator();
				frame3.GradeCalculator();
				this.setVisible(false);
				frame3.setVisible(true);
				validate();
			}
			else {
				JOptionPane.showMessageDialog(this, "Incorrect username/password", "Failed Login", JOptionPane.OK_OPTION);
			}		
		});

		instructions.addActionListener(a -> {
			Instructions frame2 = new Instructions();
			this.setVisible(false);
			frame2.setVisible(true);
			validate();	
		});
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error — try again", "ERROR", JOptionPane.OK_OPTION);
		}
		
		setSize(520,300);
		setTitle("St. Marcellinus Grade 12 Calculator");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		}
