import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class makeCalc extends JFrame implements ActionListener{
	//creating the components
	private JTextField display;
	private String operator;
	private double firstOperand;
	
	public makeCalc() {
		setTitle("My Calculator");
		setSize(800,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		display = new JTextField();
		display.setEditable(false);
		display.setFont(new Font("Arial", Font.PLAIN, 40));
		add(display, BorderLayout.NORTH);
		
		// creating the buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,4));
		String[] buttonLabels = {
				"7", "8", "9", "/",
				"4", "5", "6", "*",
				"1", "2", "3", "-",
				"0", "C", "=", "+"
		};
		
		for(String label : buttonLabels) {
			JButton button = new JButton(label);
			button.addActionListener(this);
			buttonPanel.add(button);
		}
		
		add(buttonPanel, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		// Handling Button Presses
		if(command.charAt(0) >= '0' && command.charAt(0) <= '9') {
			display.setText(display.getText() + command);
		}else if(command.equals("C")) {
			display.setText("");
		}else if(command.equals("=")) {
			double secondOperand = Double.parseDouble(display.getText());
			double result = performOperation(firstOperand,secondOperand,operator);
			display.setText(String.valueOf(result));
		}else {
			firstOperand = Double.parseDouble(display.getText());
			operator = command;
			display.setText("");
		}
	}
	
	private double performOperation(double first, double second, String operator) {
		switch(operator) {
			case "+":
				return first + second;
			case "-":
				return first - second;
			case "*":
				return first * second;
			case "/":
				return first / second;
			default:
				return 0;
		}
	}
}
