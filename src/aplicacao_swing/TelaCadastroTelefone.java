package aplicacao_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;

public class TelaCadastroTelefone {

	private JFrame frmCadastroDeTelefone;
	private JLabel label1;
	private JTextField textField;
	private JButton button2;
	private JLabel label2;
	private JLabel lblNumero;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroPessoa window = new TelaCadastroPessoa();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaCadastroTelefone() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeTelefone = new JFrame();
		frmCadastroDeTelefone.setTitle("Cadastro de Telefone");
		frmCadastroDeTelefone.setBounds(100, 100, 309, 175);
		frmCadastroDeTelefone.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeTelefone.getContentPane().setLayout(null);
		
		label1 = new JLabel("nome:");
		label1.setBounds(25, 11, 46, 14);
		frmCadastroDeTelefone.getContentPane().add(label1);
		
		label2 = new JLabel("");
		label2.setBounds(25, 103, 189, 14);
		frmCadastroDeTelefone.getContentPane().add(label2);
		
		textField = new JTextField();
		textField.setBounds(65, 8, 86, 20);
		frmCadastroDeTelefone.getContentPane().add(textField);
		textField.setColumns(10);
		
		button2 = new JButton("Cadastrar Telefone");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = textField.getText();
					String numero = textField_1.getText();
//					Fachada.adicionarTelefonePessoa(nome, numero);
					label2.setText("telefone cadastrado");
				}
				catch(Exception e) {
					label2.setText(e.getMessage());
				}
			}
		});
		button2.setBounds(54, 69, 145, 23);
		frmCadastroDeTelefone.getContentPane().add(button2);
		
		lblNumero = new JLabel("numero:");
		lblNumero.setBounds(25, 39, 78, 14);
		frmCadastroDeTelefone.getContentPane().add(lblNumero);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(75, 39, 86, 20);
		frmCadastroDeTelefone.getContentPane().add(textField_1);
		
		//mostrar a janela
		frmCadastroDeTelefone.setVisible(true);
	}
}
