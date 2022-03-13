package javaCodeGeeks;

// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class calculator extends JFrame implements ActionListener {
	// create a frame
	static JFrame f;

	// create a textfield
	static JTextField l;

	// store operator and operands
	String s0, s1, s2;

	// default constructor
	calculator()
	{
		s0 = s1 = s2 = "";
	}
	private int i  = 0;
	private int[] arr = new int[10];

	// main function
	public static void main(String args[])
	{
		// create a frame
		f = new JFrame("Data Value");

		try {
			// set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// create a object of class
		calculator c = new calculator();

		// create a textfield
		l = new JTextField(16);

		// set the textfield to non editable
		l.setEditable(false);

		// create number buttons and some operators
		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;
        
		
		// create number buttons
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		// equals button
		beq1 = new JButton("=");

		// create operator buttons
		ba = new JButton("+");
		bs = new JButton("-");
		bd = new JButton("/");
		bm = new JButton("*");
		beq = new JButton("C");

		// create . button
		be = new JButton(".");

		// create a panel
		JPanel p = new JPanel();

		// add action listeners
		bm.addActionListener(c);
		bd.addActionListener(c);
		bs.addActionListener(c);
		ba.addActionListener(c);
		b9.addActionListener(c);
		b8.addActionListener(c);
		b7.addActionListener(c);
		b6.addActionListener(c);
		b5.addActionListener(c);
		b4.addActionListener(c);
		b3.addActionListener(c);
		b2.addActionListener(c);
		b1.addActionListener(c);
		b0.addActionListener(c);
		be.addActionListener(c);
		beq.addActionListener(c);
		beq1.addActionListener(c);

		// add elements to panel
		p.add(l);
		// text field
		
		//add button
		p.add(b1);
		// number 1
		p.add(b2);
		p.add(b3);
		
		p.add(b4);
		p.add(b5);
		p.add(b6);
		
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(beq1);
		p.add(beq);
	
		// . button
		p.add(b0);
	
	

		// set Background of panel
		p.setBackground(Color.black);

		// add panel to frame
		f.add(p);

		f.setSize(200, 220);
		f.show();
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		// if the value is a number
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			// if operand is present then add to second no
			if (!s1.equals(""))
				s2 = s2 + s;
			else
				s0 = s0 + s;

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == 'C') {
			// clear the one letter
			s0 = s1 = s2 = "";

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == '=') {

			double te  = 0.0;

			// store the value in 1st
			// set the value of text
			String fullString = s0+s1+s2;
			System.out.println(fullString);
			int convertS  = Integer.parseInt(fullString);
			System.out.println("new int is: "+ convertS);
			arr[i] = convertS;
			i++;
			if(i == 9){
				f.setVisible(false);
				for(int i = 0; i< arr.length;i++){
					System.out.println("["+(i+1)+"]. "+arr[i]);
				  }
			}
			
			
			l.setText(s0 + s1 + s2 + "=");

			// convert it to string
			s0 = Double.toString(te);

			s1 = s2 = "";
		}

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
	}

