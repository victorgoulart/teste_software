package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import control.ServicoContatoImpl;
import control.UsuarioAtivo;
import model.Usuario;

public class TelaBusca extends JFrame {

	Usuario usuario = UsuarioAtivo.getUsuario();
    public TelaBusca() {
        initComponents();
    }
    
    public void fecharTela(){
    	this.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Busca de Contatos");

        jLabel2.setText("Nome ou parte do nome:");

        jButton1.setText("Buscar");
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
                .addGap(148, 148, 148)
                .addComponent(jLabel1)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    private void jButton1ActionPerformed(ActionEvent arg0) {
        if(!jTextField1.getText().trim().isEmpty()){
            ServicoContatoImpl servicoContato = new ServicoContatoImpl(usuario.getNomeUsuario());
            new TelaListagem(servicoContato.buscarPorParteNome(jTextField1.getText())).setVisible(true);
            fecharTela();
        }
    }
    
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField jTextField1;
}
