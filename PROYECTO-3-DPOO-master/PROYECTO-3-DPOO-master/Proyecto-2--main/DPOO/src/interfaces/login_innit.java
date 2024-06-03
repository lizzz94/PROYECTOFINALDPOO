package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaces.administrator_main;
import interfaces.buyer_main;
import interfaces.cajero_main;
import interfaces.operador_main;
import interfaces.propietario_main;
import logic.Cashier;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class login_innit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField FIELD_USUARIO;
	private JPasswordField FIELD_PASSWORD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_innit frame = new login_innit();
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
	public login_innit() {
		setResizable(false);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 590, 504);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel logo = new JLabel("");
		logo.setBounds(46, 50, 277, 96);
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setVerticalAlignment(SwingConstants.TOP);
		logo.setIcon(new ImageIcon(login_innit.class.getResource("/images/1 1.png")));
		panel.add(logo);
		
		JLabel label_password = new JLabel("");
		label_password.setBounds(55, 266, 91, 13);
		label_password.setHorizontalAlignment(SwingConstants.LEFT);
		label_password.setIcon(new ImageIcon(login_innit.class.getResource("/images/Contraseña_.png")));
		panel.add(label_password);
		
		JLabel label_user = new JLabel("");
		label_user.setBounds(55, 194, 61, 13);
		label_user.setVerticalAlignment(SwingConstants.BOTTOM);
		label_user.setHorizontalAlignment(SwingConstants.TRAILING);
		label_user.setIcon(new ImageIcon(login_innit.class.getResource("/images/Usuario_.png")));
		panel.add(label_user);
		
		JLabel lateral_azul = new JLabel("");
		lateral_azul.setBounds(437, 0, 153, 603);
		lateral_azul.setHorizontalAlignment(SwingConstants.RIGHT);
		lateral_azul.setVerticalAlignment(SwingConstants.TOP);
		lateral_azul.setIcon(new ImageIcon(login_innit.class.getResource("/images/Rectangle 1.png")));
		panel.add(lateral_azul);
		
		FIELD_USUARIO = new JTextField();
		FIELD_USUARIO.setFont(new Font("Arial", Font.PLAIN, 13));
		FIELD_USUARIO.setColumns(10);
		FIELD_USUARIO.setBounds(56, 218, 267, 20);
		panel.add(FIELD_USUARIO);
		
		FIELD_PASSWORD = new JPasswordField();
		FIELD_PASSWORD.setFont(new Font("Arial", Font.PLAIN, 13));
		FIELD_PASSWORD.setBounds(56, 290, 267, 20);
		panel.add(FIELD_PASSWORD);
		
		JLabel ingresar_button = new JLabel("");
		ingresar_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			 /// aquí se programa el acto de login al seleccionar ingreso
				
				String user = FIELD_USUARIO.getText();
				String password = FIELD_USUARIO.getText();
				
				String roll = Consolas.main.ingresar(user, password);
				
				if (roll.equals("nulo")){
					
					
					JOptionPane.showMessageDialog(null, "Este usuario no existe",
						      "¡Error!", JOptionPane.ERROR_MESSAGE);
					
				}else {
					
					
					if (roll.equals("ADMIN")) {
						
						
						
					}else if (roll.equals("BUYER")) {
						
						
						
					}else if (roll.equals("OWNER")) {
						
						
						
					}else if (roll.equals("CASHIER")) {
						
					
						cajero cajero = new cajero();
						cajero.setVisible(true);
						dispose();
						
					}else if (roll.equals("OPERATOR")){
						
						
						
					}
					
					
					
				}
				
				
				
				
				
			}
		});
		ingresar_button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ingresar_button.setIcon(new ImageIcon(login_innit.class.getResource("/images/ingresar_button.png")));
		ingresar_button.setBounds(66, 348, 248, 31);
		panel.add(ingresar_button);
		
		JLabel crear_cuenta = new JLabel("New label");
		crear_cuenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		crear_cuenta.setIcon(new ImageIcon(login_innit.class.getResource("/images/create.png")));
		crear_cuenta.setBounds(87, 387, 215, 14);
		panel.add(crear_cuenta);
	}
}
