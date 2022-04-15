/**
 * Adds names and marks of students to store  
 * 
 * modified     20220414
 * date         20220412
 * @filename    StudentGrades.java
 * @author      Oscar Lam
 * @version     1.0
 * @see         Unit 2 activity 4
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class StudentGrades extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFirst;
	private JTextField textFieldLast;
	private JTextField textFieldTestOne;
	private JTextField textFieldTestTwo;
	private JTextField textFieldTestThree;
	private JTextField textFieldTestFour;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	static String first, last;
	static int tOne, tTwo, tThree, tFour;
	static int averageOne = 0, averageTwo = 0, averageThree = 0, averageFour = 0;
	static int countOne = 0, countTwo = 0, countThree = 0, countFour = 0;
	static int total = 0;
	static Integer[][] grade = new Integer[15][4]; 
	static String[][] name = new String[15][2];
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentGrades frame = new StudentGrades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentGrades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 472, 504);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblFirst = new JLabel("First name:");
		lblFirst.setBounds(24, 54, 75, 14);
		panel.add(lblFirst);
		
		JLabel lblLast = new JLabel("Last name:");
		lblLast.setBounds(243, 54, 72, 14);
		panel.add(lblLast);
		
		JLabel lblTitle = new JLabel("Student grade");
		lblTitle.setBounds(191, 11, 92, 14);
		panel.add(lblTitle);

		JLabel lblTestOne = new JLabel("Test 1");
		lblTestOne.setBounds(24, 96, 48, 14);
		panel.add(lblTestOne);
		
		JLabel lblTestTwo = new JLabel("Test 2");
		lblTestTwo.setBounds(24, 127, 48, 14);
		panel.add(lblTestTwo);

		JLabel lblTestThree = new JLabel("Test 3");
		lblTestThree.setBounds(24, 158, 48, 14);
		panel.add(lblTestThree);

		JLabel lblTestFour = new JLabel("Test 4");
		lblTestFour.setBounds(24, 186, 48, 14);
		panel.add(lblTestFour);

		textFieldFirst = new JTextField();
		textFieldFirst.setBounds(109, 51, 106, 20);
		panel.add(textFieldFirst);
		textFieldFirst.setColumns(10);

		textFieldLast = new JTextField();
		textFieldLast.setBounds(325, 51, 106, 20);
		panel.add(textFieldLast);
		textFieldLast.setColumns(10);

		textFieldTestOne = new JTextField();
		textFieldTestOne.setBounds(82, 93, 61, 20);
		panel.add(textFieldTestOne);
		textFieldTestOne.setColumns(10);

		textFieldTestTwo = new JTextField();
		textFieldTestTwo.setBounds(82, 124, 61, 20);
		panel.add(textFieldTestTwo);
		textFieldTestTwo.setColumns(10);

		textFieldTestThree = new JTextField();
		textFieldTestThree.setBounds(82, 155, 61, 20);
		panel.add(textFieldTestThree);
		textFieldTestThree.setColumns(10);

		textFieldTestFour = new JTextField();
		textFieldTestFour.setBounds(82, 183, 61, 20);
		panel.add(textFieldTestFour);
		textFieldTestFour.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(-13, 6, 270, 268);
		panel.add(textArea);

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(82, 223, 319, 270);
		panel.add(scrollPane);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean fOne = false, lTwo = false;
					int err = 0, tally = 0;
					char ch;
					String one, two, three, four;
					
					textArea.setText("");
					
					first = textFieldFirst.getText();
					last = textFieldLast.getText();
					one = textFieldTestOne.getText();
					two = textFieldTestTwo.getText();
					three = textFieldTestThree.getText();
					four = textFieldTestFour.getText();
					
					tOne = Integer.parseInt(one);
					tTwo = Integer.parseInt(two);
					tThree = Integer.parseInt(three);
					tFour = Integer.parseInt(four);

					textFieldFirst.setText("");
					textFieldLast.setText("");
					textFieldTestOne.setText("");
					textFieldTestTwo.setText("");
					textFieldTestThree.setText("");
					textFieldTestFour.setText("");
					
					for(int i = 0; i<first.length();i++) { // checks for characters that are not letters
						ch = first.charAt(i);
						if((int)ch <65 || ((int)ch > 90 && (int)ch <97) || (int)ch >122) {
							err = 1/0;
						}
					}
					for(int i = 0; i<last.length();i++) { // checks for characters that are not letters
						ch = first.charAt(i);
						if((int)ch <65 || ((int)ch > 90 && (int)ch <97) || (int)ch >122) {
							err = 1/0;
						}
					}
					for(int i = 0; i<15; i++) { // checks if inputted name exists in list
						if(name[i][0]!=null && name[i][1]!=null && name[i][0].equals(first) && name[i][1].equals(last)) {
							fOne = true;
							lTwo = true;
							tally = i;
						}
					}
					if (total<15 && tOne < 101 && tTwo < 101 && tThree < 101 && tFour < 101 && tOne >= 0 && tTwo >= 0 && tThree >= 0 && tFour >= 0 && fOne == false && lTwo == false){ // min score is 0, max score is 100;
						name[total][0] = first;
						name[total][1] = last;
						grade[total][0] = tOne;
						grade[total][1] = tTwo;
						grade[total][2] = tThree;
						grade[total][3] = tFour;
						total++;
					}
					else if(fOne == true && lTwo == true) { // if person exists in list, but wants to change marks
						grade[tally][0] = tOne;
						grade[tally][1] = tTwo;
						grade[tally][2] = tThree;
						grade[tally][3] = tFour;
					}
					else {
						err = 1/0;
					}
				}catch(Exception err) {
					if(total == 15) {
						textArea.append("Max list size.");
					}
					else {
						textArea.append("Not proper input/no input. \n");
						textArea.append("Note: For first and last names, only letters are acceptable. \n");
						textArea.append("All test scores are required to have a value. \n");
						textArea.append("Values must be between 0 to 100.");
					}
				}
			}
		});
		btnAdd.setBounds(214, 89, 91, 23);
		panel.add(btnAdd);

		JButton btnList = new JButton("List");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				for(int i = 0; i<15; i++) {
					if(name[i][0]!=null && name[i][1]!=null) {
						textArea.append("Format: Test 1, Test 2, Test 3, Test 4 \n");
						textArea.append(name[i][0]+" "+name[i][1]+": "+grade[i][0]+"%, "+grade[i][1]+"%, "+grade[i][2]+"%, "+grade[i][3]+"%");
						textArea.append("\n");
					}
				}
			}
		});
		btnList.setBounds(214, 123, 91, 23);
		panel.add(btnList);

		JButton btnStudent = new JButton("Student average");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = 0;
					textArea.setText("");
					first = textFieldFirst.getText();
					last = textFieldLast.getText();
					for(int i = 0; i<15; i++) {
						if(name[i][0]!=null && name[i][1]!=null && name[i][0].equals(first) && name[i][1].equals(last)) {
								for(int j = 0; j<4; j++) {
									if(grade[i][j]!=null) {
										num++;
									}
								textArea.setText(name[i][0]+" "+name[i][1]+": "+(grade[i][0]+grade[i][1]+grade[i][2]+grade[i][3])/num+"%");
							}
						}
					}
					textFieldFirst.setText("");
					textFieldLast.setText("");
				}catch(Exception err) {
					textArea.setText("error");
				}
			}
		});
		btnStudent.setBounds(315, 88, 135, 23);
		panel.add(btnStudent);

		JButton btnCourse = new JButton("Test averages"); // from course averages to test averages
		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText("");
					countOne = 0;
					countTwo = 0;
					countThree = 0;
					averageOne = 0;
					averageTwo = 0;
					averageThree = 0;
					averageFour = 0;
					countFour = 0;
					for(int i = 0; i<15; i++) {
						if(grade[i][0]!=null) {
							averageOne += grade[i][0];
							countOne++;
						}
					}
					for(int i = 0; i<15; i++) {
						if(grade[i][1]!=null) {
							averageTwo += grade[i][1];
							countTwo++;
						}
					}
					for(int i = 0; i<15; i++) {
						if(grade[i][2]!=null) {
							averageThree += grade[i][2];
							countThree++;
						}
					}
					for(int i = 0; i<15; i++) {
						if(grade[i][3]!=null) {
							averageFour += grade[i][3];
							countFour++;
						}
					}
					textArea.append("Test 1 average: "+Math.round((double)averageOne/(double)countOne)+"% \n"); //rounds averages into whole numbers
					for(int i = 0; i<15; i++) {
						if(name[i][0]!=null && name[i][1]!=null) {
							textArea.append(name[i][0]+" "+name[i][1]+": "+grade[i][0]+"%");
							textArea.append("\n");
						}
					}
					textArea.append("\n");
					textArea.append("Test 2 average: "+Math.round((double)averageTwo/(double)countTwo)+"% \n");
					for(int i = 0; i<15; i++) {
						if(name[i][0]!=null && name[i][1]!=null) {
							textArea.append(name[i][0]+" "+name[i][1]+": "+grade[i][1]+"%");
							textArea.append("\n");
						}
					}
					textArea.append("\n");
					textArea.append("Test 3 average: "+Math.round((double)averageThree/(double)countThree)+"% \n");
					for(int i = 0; i<15; i++) {
						if(name[i][0]!=null && name[i][1]!=null) {
							textArea.append(name[i][0]+" "+name[i][1]+": "+grade[i][2]+"%");
							textArea.append("\n");
						}
					}
					textArea.append("\n");
					textArea.append("Test 4 average: "+Math.round((double)averageFour/(double)countFour)+"% \n");
					for(int i = 0; i<15; i++) {
						if(name[i][0]!=null && name[i][1]!=null) {
							textArea.append(name[i][0]+" "+name[i][1]+": "+grade[i][3]+"%");
							textArea.append("\n");
						}
					}
				}catch(Exception err) {
					textArea.setText("No marks recorded");
				}
			}
		});
		btnCourse.setBounds(315, 123, 135, 23);
		panel.add(btnCourse);
		
		JButton btnNewButton = new JButton("Instructions");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textArea.append("Add Button \n");
				textArea.append("For first and last names, only letters are acceptable. \n");
				textArea.append("All test scores are required to have a value. \n");
				textArea.append("Values must be between 0 to 100. \n");
				textArea.append("You can change a students score by putting in their name with their new score. \n");
				textArea.append("\n");
				textArea.append("List Button \n");
				textArea.append("Lists students with their scores that have been added when pressed. \n");
				textArea.append("Max list size is 15. \n");
				textArea.append("\n");
				textArea.append("Student Average Button \n");
				textArea.append("Press button when first and last names are in text box. \n");
				textArea.append("The name must be on the list in order to show the students average \n");
				textArea.append("\n");
				textArea.append("Test Average Button \n");
				textArea.append("Displays averages of each test and students score on that test. \n");
			}
		});
		btnNewButton.setBounds(263, 159, 106, 23);
		panel.add(btnNewButton);
	}
}