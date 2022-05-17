/*Instructions Frame - Second Frame, displays the instructions user needs to know how to transition to the main frame and provides detail on the services the app provides
 Developer: Kinjal Kamboj
 Date Started: May 20, 2021
 Date Ended: May 23, 2021
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;


public class Instructions extends JFrame {
	JPanel title, text, button, overallPanel;
	JLabel label, instructions;
	JButton back;

	public Instructions() {
		getContentPane().setBackground(Color.white);
		
		File textFile; 
    	FileReader intake;
        BufferedReader readFile;
        String instructionsText;
        
		//Title Panel
		title = new JPanel();
		label = new JLabel("Instructions");
		label.setFont(new Font("Castellar", Font.ITALIC, 29));
		title.setBackground(Color.white);
		title.add(label);
		title.setMaximumSize(new Dimension(300,200));
		title.setBackground(Color.white);
		this.setBackground(Color.white);
		label.setForeground(Color.red);
		
		//Text Panel
		text = new JPanel();
		instructions = new JLabel();
		instructions.setMaximumSize(new Dimension(100,200));
		text.setBackground(Color.white);
		this.setBackground(Color.white);
		getContentPane().add(text, BorderLayout.CENTER);
		
		//Button Panel
		button = new JPanel();
		back = new JButton("Go Back");
		button.add(back);
		button.setBackground(Color.white);
		this.setBackground(Color.white);
		
		//Adding previous panels to the overall Panel
		overallPanel = new JPanel();
		overallPanel.setLayout(new BoxLayout(overallPanel, BoxLayout.Y_AXIS));
		overallPanel.add(title);
		overallPanel.add(text);
		overallPanel.add(button);
		overallPanel.setBackground(Color.white);
		this.setBackground(Color.white);
		
		
		//Reading Notepad file with instructions and displaying on JLabel
		textFile = new File("instructions.txt");
        try {           
        	intake = new FileReader (textFile);
        	readFile = new BufferedReader (intake);
        	while ((instructionsText = readFile.readLine()) != null){
        		instructions = new JLabel(instructionsText);
        		text.add(instructions);  		
      }
	
        	readFile.close();
    }
       catch (FileNotFoundException e){
    	   System.out.println("File not found");
    }
        catch (IOException e){
        	System.out.println("Exception-ERROR");
    }
        
        //Adding action listener for back button
        back.addActionListener(a -> {
        	TitleFrame frame1 = new TitleFrame();
        	this.setVisible(false);
        	validate();
        	
        });
    
		getContentPane().add(overallPanel);
		
		setSize(450, 350);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       
        }
	}
