package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;

public class TelaCadastroCliente {

	private JFrame frmCadastroDeCliente;
	private JLabel label1;
	private JTextField textField;
	private JButton button2;
	private JLabel label2;
	protected Object frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente window = new TelaCadastroCliente();
					((JComponent) window.frame).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeCliente = new JFrame();
		frmCadastroDeCliente.setTitle("Cadastro de Pessoa");
		frmCadastroDeCliente.setBounds(100, 100, 321, 181);
		frmCadastroDeCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeCliente.getContentPane().setLayout(null);
		
		label1 = new JLabel("nome:");
		label1.setBounds(25, 34, 46, 14);
		frmCadastroDeCliente.getContentPane().add(label1);
		
		label2 = new JLabel("");
		label2.setBounds(26, 109, 189, 14);
		frmCadastroDeCliente.getContentPane().add(label2);
		
		textField = new JTextField();
		textField.setBounds(62, 31, 86, 20);
		frmCadastroDeCliente.getContentPane().add(textField);
		textField.setColumns(10);
		
		button2 = new JButton("Cadastrar Cliente");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = textField.getText();
					String endereco = textField.getText();;
					String cpf= textField.getText();;
					String email= textField.getText();;
					String telefone= textField.getText();;
					Fachada.cadastrarCliente(cpf,nome,endereco,email,telefone);
					label2.setText("cliente cadastrada");
				}
				catch(Exception e) {
					label2.setText(e.getMessage());
				}
			}
		});
		button2.setBounds(54, 75, 145, 23);
		frmCadastroDeCliente.getContentPane().add(button2);
		
		//mostrar a janela
		frmCadastroDeCliente.setVisible(true);
	}
}
