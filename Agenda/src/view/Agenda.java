package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DAO;

public class Agenda extends JFrame {
	// Criação de objetos (JDBC)
	DAO dao = new DAO();
	private Connection con;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtEmail;
	private JTextField txtNome;
	private JTextField txtFone;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	public Agenda() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setResizable(false);
		setTitle("Agenda de contatos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Agenda.class.getResource("/img/notepad.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(32, 25, 46, 14);
		contentPane.add(lblNewLabel);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(73, 22, 121, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(32, 50, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Fone:");
		lblNewLabel_3.setBounds(32, 105, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("E-mail:");
		lblNewLabel_5.setBounds(32, 133, 46, 14);
		contentPane.add(lblNewLabel_5);

		txtEmail = new JTextField();
		txtEmail.setBounds(73, 130, 246, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtNome = new JTextField();
		txtNome.setBounds(73, 50, 246, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtFone = new JTextField();
		txtFone.setBounds(73, 102, 121, 20);
		contentPane.add(txtFone);
		txtFone.setColumns(10);

		JButton btnCreate = new JButton("");
		btnCreate.setToolTipText("Adicionar Contato");
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setContentAreaFilled(false);
		btnCreate.setBorder(null);
		btnCreate.setIcon(new ImageIcon(Agenda.class.getResource("/img/add.png")));
		btnCreate.setBounds(32, 173, 48, 48);
		contentPane.add(btnCreate);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff1.png")));
		lblStatus.setBounds(493, 202, 48, 48);
		contentPane.add(lblStatus);

		JButton btnSobre = new JButton("");
		btnSobre.setIcon(new ImageIcon(Agenda.class.getResource("/img/about.png")));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setBackground(new Color(240, 240, 240));
		btnSobre.setBounds(493, 22, 48, 48);
		contentPane.add(btnSobre);
	} // fim do construtor

	/**
	 * Método para verificar o status de conexão
	 */
	private void status() {
		// System.out.println("teste janela ativada");
		try {
			// Abrir a conexão com o banco
			con = dao.conectar();
			if (con == null) {// Mudar o ícone da jlabel
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff1.png")));
			} else {
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dbon11.png")));
			}
			// Fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}// fim do código
