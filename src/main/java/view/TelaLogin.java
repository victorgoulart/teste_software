package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import control.ServicoUsuarioImpl;
import control.UsuarioAtivo;
import model.Usuario;

public class TelaLogin extends JFrame {
	JFrame telaNovoUsuario = new TelaCadastroUsuarioAgenda();

    public TelaLogin() {
        initComponents();
    }
    
    public void fecharTela(){
    	this.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTextField1 = new JTextField();
        jPasswordField1 = new JPasswordField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jToggleButton1 = new JToggleButton();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nome de Usu�rio");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Senha");

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jToggleButton1.setText("OK");
        jToggleButton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				jToggleButton1ActionPerformed(arg0);
			}
        });
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Novo Usu�rio");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jButton1ActionPerformed(arg0);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField1)
                    .addComponent(jTextField1)
                    .addComponent(jToggleButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1)
                .addGap(27, 27, 27)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void jToggleButton1ActionPerformed(ActionEvent arg0) {
        ServicoUsuarioImpl servicoUsuario = new ServicoUsuarioImpl(jTextField1.getText());
        if(servicoUsuario.buscarPorNomeUsuario(jTextField1.getText()).equals(new Usuario(jTextField1.getText(), String.valueOf(jPasswordField1.getPassword())))){
            UsuarioAtivo.setUsuario(new Usuario(jTextField1.getText(), String.valueOf(jPasswordField1.getPassword())));
            new TelaPrincipal().setVisible(true);
            fecharTela();
        }
    }
    
    private void jButton1ActionPerformed(ActionEvent arg0) {
    	telaNovoUsuario.setVisible(true);
    }
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPasswordField jPasswordField1;
    private JTextField jTextField1;
    private JToggleButton jToggleButton1;
}
