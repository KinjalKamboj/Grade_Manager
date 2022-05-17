/*Main Frame - Third Frame, is the main interface that reads in user's grades and provides accurate calculations, button options, including writing to a file for the transcript
  Developer: Kinjal Kamboj
  Date Started: May 19, 2021
  Date Ended: May 21, 2021
 */

import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
  
public class GradeCalculator extends JFrame implements ActionListener {
	JPanel secondTitlePanel, inputPanel, buttonsPanel, outputMarkPanel, scholarshipPanel, conjoinPanel, conjoinPanel2, conjoinPanel3;
	JLabel title, titleImage1, titleImage2, input, input1, input2, input3, input4, input5, input6, finalGradeLabel, inputDesiredMark, weightLabel, outputDesiredMark, scholarshipLabel;
	JLabel scholarList;
	JTextField mark1, mark2, mark3, mark4, mark5, mark6, gradeOutput, inputDesired, inputWeight, outputDesired;
	JButton calculate, clear, logOut, calculateDesired;
	JComboBox grade;
	Font f1;
	double currentGrade, required, weight, goal;
	
	public void GradeCalculator() { 
		getContentPane().setLayout(new FlowLayout());
		getContentPane().setLayout(new BorderLayout()); 
		
		secondTitlePanel = new JPanel();
		
		//Title Image
		titleImage1 = new JLabel();
		ImageIcon img1 = new ImageIcon(getClass().getResource("marcellinus.jpg"));
		Image image1 = img1.getImage(); 
		Image newImage1 = image1.getScaledInstance(40, 40, Image.SCALE_SMOOTH); 
		img1 = new ImageIcon(newImage1);
		titleImage1.setIcon(img1); 
		secondTitlePanel.add(titleImage1, BoxLayout.X_AXIS);
		
		//Title
		f1 = new Font("Lucida Handwriting", Font.BOLD, 20);
		title = new JLabel("St. Marcellinus Grade 12 Grade Calculator");
		title.setFont(f1);
		title.setForeground(Color.red);
		secondTitlePanel.add(title, BoxLayout.X_AXIS);
		secondTitlePanel.setMaximumSize(new Dimension(200,200));
		
		titleImage2 = new JLabel();
		ImageIcon img2 = new ImageIcon(getClass().getResource("marcellinus.jpg"));
		Image image2 = img2.getImage(); 
		Image newImage2 = image2.getScaledInstance(40, 40, Image.SCALE_SMOOTH); 
		img2 = new ImageIcon(newImage2);
		titleImage2.setIcon(img2); 
		secondTitlePanel.add(titleImage2, BoxLayout.X_AXIS);
		
		secondTitlePanel.setBorder(BorderFactory.createCompoundBorder(
		secondTitlePanel.getBorder(), 
		BorderFactory.createEmptyBorder(5, 0, 0, 0))); 
		
		//User Input
		inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		
		String[] gradeOptions = {"Select a grade", "Grade 11", "Grade 12"}; //Combo box to select grade
		grade = new JComboBox (gradeOptions);
		grade.setMaximumSize(new Dimension(200,30));
		grade.setBorder(BorderFactory.createCompoundBorder(
		grade.getBorder(), 
		BorderFactory.createEmptyBorder(3, 0, 5, 0))); 
		inputPanel.add(grade);
		
		input = new JLabel("Enter your top 6 U/M final marks (%)..."); 
		input.setBorder(BorderFactory.createCompoundBorder(
		input.getBorder(), 
		BorderFactory.createEmptyBorder(15, 0, 5, 20)));
		inputPanel.add(input);
		
		input1 = new JLabel("Course 1:");
		mark1 = new JTextField(7);
		mark1.setMaximumSize(new Dimension(300,mark1.getPreferredSize().height));
		input2 = new JLabel("Course 2:");
		mark2 = new JTextField(7);
		mark2.setMaximumSize(new Dimension(300,mark1.getPreferredSize().height));
		input3 = new JLabel("Course 3:");
		mark3 = new JTextField(7);
		mark3.setMaximumSize(new Dimension(300,mark1.getPreferredSize().height));
		input4 = new JLabel("Course 4:");
		mark4 = new JTextField(7);
		mark4.setMaximumSize(new Dimension(300,mark1.getPreferredSize().height));
		input5 = new JLabel("Course 5:");
		mark5 = new JTextField(7);
		mark5.setMaximumSize(new Dimension(300,mark1.getPreferredSize().height));
		input6 = new JLabel("Course 6:");
		mark6 = new JTextField(7);
		mark6.setMaximumSize(new Dimension(300,mark1.getPreferredSize().height));
		
		inputPanel.add(input1);
		inputPanel.add(mark1);
		inputPanel.add(input2);
		inputPanel.add(mark2);
		inputPanel.add(input3);
		inputPanel.add(mark3);
		inputPanel.add(input4);
		inputPanel.add(mark4);
		inputPanel.add(input5);
		inputPanel.add(mark5);
		inputPanel.add(input6);
		inputPanel.add(mark6);
		
		inputPanel.setBorder(BorderFactory.createCompoundBorder(
	    inputPanel.getBorder(), 
		BorderFactory.createEmptyBorder(15, 0, 5, 0)));
		
		//Buttons
		buttonsPanel = new JPanel(new FlowLayout());
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		calculate = new JButton ("Calculate");
		clear = new JButton ("Clear");
		logOut = new JButton("Log Out");
		buttonsPanel.add(calculate);
		buttonsPanel.add(clear);
		buttonsPanel.add(logOut);
		buttonsPanel.setBorder(BorderFactory.createCompoundBorder(
		buttonsPanel.getBorder(), 
		BorderFactory.createEmptyBorder(15, 60, 10, 0))); //top, left, bottom, right
		
		conjoinPanel = new JPanel();
		conjoinPanel.setLayout(new BoxLayout(conjoinPanel, BoxLayout.Y_AXIS));
		conjoinPanel.add(inputPanel);
		conjoinPanel.add(buttonsPanel);
			
		//OutputMarkPanel
		conjoinPanel2 = new JPanel();
		conjoinPanel2.setLayout(new BoxLayout(conjoinPanel2, BoxLayout.X_AXIS));
		outputMarkPanel = new JPanel();
		outputMarkPanel.setLayout(new BoxLayout(outputMarkPanel, BoxLayout.Y_AXIS));
		
		finalGradeLabel = new JLabel("Your Final Average:"); //Avg grade 
		gradeOutput = new JTextField(5);
		gradeOutput.setMaximumSize(new Dimension(250, mark1.getPreferredSize().height));
		gradeOutput.setEditable(false);
		
		outputMarkPanel.add(finalGradeLabel);
		outputMarkPanel.add(gradeOutput);
		
		inputDesiredMark = new JLabel("Input Desired Mark:"); //Desired mark the user wishes to achieve
		inputDesiredMark.setBorder(BorderFactory.createCompoundBorder(
		inputDesiredMark.getBorder(), 
		BorderFactory.createEmptyBorder(10, 0, 0, 0)));
		
		inputDesired = new JTextField(5);
		inputDesired.setMaximumSize(new Dimension(250, mark1.getPreferredSize().height));
		
		outputMarkPanel.add(inputDesiredMark);
		outputMarkPanel.add(inputDesired);
		
		weightLabel = new JLabel("Weight of final (decimal):");
		weightLabel.setBorder(BorderFactory.createCompoundBorder(
		weightLabel.getBorder(), 
		BorderFactory.createEmptyBorder(10, 0, 0, 0)));
		
		inputWeight = new JTextField(5);
		inputWeight.setMaximumSize(new Dimension(250, mark1.getPreferredSize().height));
		
		outputMarkPanel.add(weightLabel);
		outputMarkPanel.add(inputWeight);
		
		outputDesiredMark = new JLabel("Mark needed for finals:");
		outputDesiredMark.setBorder(BorderFactory.createCompoundBorder(
		outputDesiredMark.getBorder(), 
		BorderFactory.createEmptyBorder(15, 0, 0, 0)));
		
		outputDesired = new JTextField(5);
		outputDesired.setMaximumSize(new Dimension(250, mark1.getPreferredSize().height));
		outputDesired.setEditable(false);
		
		outputMarkPanel.add(outputDesiredMark);
		outputMarkPanel.add(outputDesired);
		
		calculateDesired = new JButton("Calculate"); //button to calculate needed mark for desired average
		outputMarkPanel.add(calculateDesired);
	
		outputMarkPanel.setBorder(BorderFactory.createCompoundBorder(
		outputMarkPanel.getBorder(), 
		BorderFactory.createEmptyBorder(13, 0, 0, 0)));
		
		conjoinPanel2.add(outputMarkPanel);
		
		//Scholarship Panel
		scholarshipPanel = new JPanel();
		scholarshipPanel.setLayout(new BoxLayout(scholarshipPanel, BoxLayout.Y_AXIS));
		scholarshipLabel = new JLabel("Here are a list of scholarships you are eligible for:");
		scholarList = new JLabel("Select your grade...");
		
		scholarshipPanel.setBorder(BorderFactory.createCompoundBorder(
		scholarshipPanel.getBorder(), 
		BorderFactory.createEmptyBorder(13, 15, 0, 15)));
		
		scholarshipPanel.add(scholarshipLabel);
		conjoinPanel2.add(scholarshipPanel);
		
		//Adding both panels to one panel
		conjoinPanel3 = new JPanel();
		conjoinPanel3.setLayout(new BoxLayout(conjoinPanel3, BoxLayout.X_AXIS));
		conjoinPanel3.add(conjoinPanel);
		conjoinPanel3.add(conjoinPanel2);
		
		//Adding action listeners
		
		// Calculate button action listener
		calculate.addActionListener(a -> {
			try {
				double m1 = Double.parseDouble(new String(mark1.getText()));
				double m2 = Double.parseDouble(new String(mark2.getText()));
				double m3 = Double.parseDouble(new String(mark3.getText()));
				double m4 = Double.parseDouble(new String(mark4.getText()));
				double m5 = Double.parseDouble(new String(mark5.getText()));
				double m6 = Double.parseDouble(new String(mark6.getText()));
				calculateGrade(m1, m2, m3, m4, m5, m6);
			}
			catch (NumberFormatException e) { 
				JOptionPane.showMessageDialog(this, "Enter numerical values only.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			}		
		});
		
		//Clear button action listener
		clear.addActionListener(a -> {
			try {
				clearText();
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Enter numerical values only.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			}	
			
		});
		
		// Logout button action listener
		logOut.addActionListener(a -> {
			try {
				int option = JOptionPane.showConfirmDialog(this, "Are you sure you wish to log out?", "Log Out Confirmation", JOptionPane.YES_NO_OPTION);
				if (option == 0) {
					int option2 = JOptionPane.showConfirmDialog(this, "Before you go, would you like to make your transcript?", "Transcript Confirmation", JOptionPane.YES_NO_OPTION);
					if (option2 == 0) {
						printTranscript();
					}
					else {
						System.exit(0);
					}
					
				}
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Enter numerical values only.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		// Calculate desired mark action listener
		calculateDesired.addActionListener(a -> {
			try {
				calculateNeededMark();
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Enter numerical values only.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		//Combobox (current grade) action listener
		grade.addActionListener(this);
		
		//Adding panels
		getContentPane().add(secondTitlePanel, BorderLayout.NORTH); 
		getContentPane().add(conjoinPanel3);
		
		setSize(850, 450);
		setTitle("St.Marcellinus Grade Calculator");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
	}
	
	public void calculateGrade (double m1, double m2, double m3, double m4, double m5, double m6) {
		currentGrade = Math.round((m1 + m2 + m3 + m4 + m5 + m6)/ 6);
		gradeOutput.setText(currentGrade + "");
	}
	public void clearText () {
		mark1.setText("");
		mark2.setText("");
		mark3.setText("");
		mark4.setText("");
		mark5.setText("");
		mark6.setText("");
	}
	public void calculateNeededMark() {
		goal = Double.parseDouble(new String(inputDesired.getText()));
		weight = Double.parseDouble(new String(inputWeight.getText()));
		required = ((goal - currentGrade)/ weight) + currentGrade;
		if (required <= 100) {
			outputDesired.setText(required + "%");
		}
		else {
			outputDesired.setText("Not possible");
		}
}
	public void actionPerformed(ActionEvent e) { //Check which dropdown of the combo box is chosen to display scholarships
		if (e.getSource() == grade){
			if (grade.getSelectedIndex() == 0) {
				scholarshipPanel.remove(scholarList);
				scholarList.setText("Select your grade...");
				scholarshipPanel.add(scholarList);
				validate();
				repaint();	
			}
			
			else if (grade.getSelectedIndex() == 1) {
				scholarshipPanel.remove(scholarList);
				scholarList.setText("Wait for next year, keep up your grades and extracurriculars!");
				scholarshipPanel.add(scholarList);
				validate();
				repaint();
		     }
			
			else {
				scholarshipPanel.remove(scholarList);
				scholarList.setText("<html><i>Brampton CARP Bursary Award <br> Annual Clarkson Performing Arts Scholarship ($1000)<br>The Canadian Federation of University Women ($2000) <br> Nelson Scholarship ($10,000)");
				scholarshipPanel.add(scholarList);
				validate();
				repaint();
			}
		}
				
			}

	public void printTranscript() {
		 File dataFile = new File("transcript.txt");
	     FileWriter out;
	     BufferedWriter writeFile;
	     Scanner input = new Scanner(System.in);
	     double finalAvg;
	     String studentName;
	     String grade;
	     String courseName;
	     try {
	         out = new FileWriter(dataFile);
	         writeFile = new BufferedWriter(out);
	         
	         writeFile.write("St. Marcellinus Student Transcript");
	         writeFile.newLine();
	         System.out.print("Enter student name: ");
	         studentName = input.nextLine();
	         writeFile.write("Student Name: " + studentName);
	         writeFile.newLine();
	         System.out.print("Enter your grade:");
	         grade = input.nextLine();
	         writeFile.write("Grade: " + grade);
	         
	         for (int i = 1; i < 7; i++) {
	        	System.out.println("Enter course name:");
	        	courseName = input.next();
	            writeFile.newLine();
	            System.out.print("Enter course average: ");
	            finalAvg = input.nextDouble();
	            writeFile.newLine();
	            writeFile.write(courseName + ": " + String.valueOf(finalAvg));
	            writeFile.newLine();
	         } 
	         writeFile.close();
	         out.close();
	         System.out.println("Successful transfer of grades! Please refer to the transcript txt file.");
	         System.exit(0);
	      } 
	      catch (IOException e) {
	         System.out.println("Exception");
	      }
	     catch(NumberFormatException e) {
	    	 System.out.println("Enter a numerical value");
	     }
		
	}
}
