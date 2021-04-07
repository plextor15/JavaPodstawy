import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Okno extends JFrame implements ActionListener{
	private final JTextField useranme;
	private final JTextField password;
	private final JButton login;
	
	public Okno() {
		//super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setBackground(new Color(0, 0, 0));
		setLayout(new FlowLayout());
		
		useranme = new JTextField("login");
		add(useranme);
		
		password = new JTextField("password");
		add(password);
		
		login = new JButton("Login");
		login.setSize(220, 80);
		add(login);
		
		login.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent Evencik) {
		useranme.setText(" ");
		password.setText(" ");
	}
}
