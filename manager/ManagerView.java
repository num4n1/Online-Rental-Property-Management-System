package manager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * handles GUi for manager
 */
public class ManagerView {
    
    public JLabel report;
    public JFrame managerFrame;
    public JPanel managerPanel;
    public JLabel label1,passwordLabel,label2,label3;
    public JButton enterButton,enterButton2,enterButton3;
    public JTextField userText1, userText2;
    SpringLayout layout;
    
    /**getters and setters */

    public JButton getButton(){
        return this.enterButton;
    }
    public JButton getButton2(){
        return this.enterButton2;
    }
    public JButton getButton3(){
        return this.enterButton3;
    }




    /**
     * sets up the GUi components for this class
     */
    public void displayManagerView()
    {
        report = new JLabel("");
        //Frame for Manager
        managerFrame = new JFrame("Manager Homepage");
        managerPanel = new JPanel();
        layout = new SpringLayout();
        managerFrame.setSize(500,200);

        label1 = new JLabel("\nGet Report");
        label1.setBounds(10,20,80,25);
        managerPanel.add(label1);

        enterButton = new JButton("Yes!");
        enterButton.setBounds(10,100,80,25);
        managerPanel.add(enterButton);

        enterButton2 = new JButton("Enter!");
        enterButton2.setBounds(10,100,80,35);
        managerPanel.add(enterButton2);

        label2 = new JLabel("Enter the new Fees.");
        label2.setBounds(10,20,80,25);
        managerPanel.add(label2);
        //---------------------------------------------------
        userText1 = new JTextField(20);
        userText1.setBounds(50,20,40,25);
        managerPanel.add(userText1);

        label3 = new JLabel("Enter the new Period.");
        label3.setBounds(10,20,80,25);
        managerPanel.add(label3);
        //---------------------------------------------------
        userText2 = new JTextField(20);
        userText2.setBounds(50,20,40,25);
        managerPanel.add(userText2);

        enterButton3 = new JButton("Enter!");
        enterButton3.setBounds(10,100,80,35);
        managerPanel.add(enterButton3);

        managerPanel.setLayout(layout);
        layout.putConstraint(SpringLayout.WEST, label1, 6, SpringLayout.WEST, managerPanel);
        layout.putConstraint(SpringLayout.NORTH, label1, 10, SpringLayout.NORTH, managerPanel);

        layout.putConstraint(SpringLayout.WEST, enterButton, 75, SpringLayout.WEST, managerPanel);
        layout.putConstraint(SpringLayout.NORTH, enterButton, 6, SpringLayout.NORTH, managerPanel);

        layout.putConstraint(SpringLayout.WEST, label2, 6, SpringLayout.WEST, managerPanel);
        layout.putConstraint(SpringLayout.NORTH, label2, 40, SpringLayout.NORTH, managerPanel);

        layout.putConstraint(SpringLayout.WEST, userText1, 6, SpringLayout.WEST, managerPanel);
        layout.putConstraint(SpringLayout. NORTH, userText1, 60, SpringLayout.NORTH, managerPanel);

        layout.putConstraint(SpringLayout.WEST, enterButton2, 220, SpringLayout.WEST, managerPanel);
        layout.putConstraint(SpringLayout.NORTH, enterButton2, 55, SpringLayout.NORTH, managerPanel);

        layout.putConstraint(SpringLayout.WEST, label3, 6, SpringLayout.WEST, managerPanel);
        layout.putConstraint(SpringLayout.NORTH, label3, 90, SpringLayout.NORTH, managerPanel);

        layout.putConstraint(SpringLayout.WEST, userText2, 6, SpringLayout.WEST, managerPanel);
        layout.putConstraint(SpringLayout.NORTH, userText2, 110, SpringLayout.NORTH, managerPanel);

        layout.putConstraint(SpringLayout.WEST, enterButton3, 220, SpringLayout.WEST, managerPanel);
        layout.putConstraint(SpringLayout.NORTH, enterButton3, 105, SpringLayout.NORTH, managerPanel);

        layout.putConstraint(SpringLayout.WEST, report,6,SpringLayout.WEST, managerPanel);
		layout.putConstraint(SpringLayout.NORTH, report,6 + 7*30,SpringLayout.NORTH, managerPanel);

        managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        managerFrame.setVisible(true);
        addHomepage();
        setUpButtonListener();
        addActionListener(null);

        managerFrame.setSize(1200, 800);

    }
    /** setup the homepage  */
    public void addHomepage()
    {
        managerFrame.setTitle("Manager Homepage");
        managerFrame.add(managerPanel);
        managerFrame.revalidate();
        managerFrame.repaint();
    }
    /**remove the homepage from content pane */
    public void removeHomepage()
    {
    managerFrame.remove(managerPanel);
    managerFrame.revalidate();
    managerFrame.repaint();
    }

    /* getters for buttons and textfields */
    public JButton getEnterButton() {
        return enterButton;
    }
    public JButton getEnterButton2() {
        return enterButton2;
    }
    public JButton getEnterButton3() {
        return enterButton3;
    }
    public JTextField getUserText1() {
        return userText1;
    }
    public JTextField getUserText2() {
        return userText2;
    }
  

    /**
     * set up an internal listener 
     * not used
     * class fucntionality relies on the lambda expression 
     * in the controller
     */
    public void setUpButtonListener(){
		ActionListener buttonListner = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("helloooooo-----");
                // listener that doesn't affect the listener found in controller- could  be us
                
            }
		};
		enterButton.addActionListener(buttonListner);
		enterButton2.addActionListener(buttonListner);
		enterButton3.addActionListener(buttonListner);
	}


    /**
     * add action listener to each of the buttons to be 
     * controller from manager Controller
     * @param listenForButton
     */
    public void addActionListener(ActionListener listenForButton){
        enterButton.addActionListener(listenForButton);
        enterButton2.addActionListener(listenForButton);
        enterButton3.addActionListener(listenForButton);

    }


    /**
     * updates the results label to
     * what ever string is passed to this fucntion
     * @param a
     */
    public void changeReportLabel(String a){
		
		JLabel tmp = report;
		
		if(tmp !=null){
			managerPanel.remove(tmp);
		}
		
		report = new JLabel(a);
		
		managerPanel.add(report);

		layout.putConstraint(SpringLayout.WEST, report,6,SpringLayout.WEST, managerPanel);
		layout.putConstraint(SpringLayout.NORTH, report,6 + 7*30,SpringLayout.NORTH, managerPanel);
		
		managerPanel.revalidate();
		managerPanel.repaint();


	}


}//end class
