package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import control.ServicoContatoImpl;
import control.UsuarioAtivo;
import model.Usuario;

public class TelaPrincipal extends JFrame {
	Usuario usuario = UsuarioAtivo.getUsuario();
	JFrame telaBusca;
	JFrame telaListagem;
	JFrame telaCadastro;

    public TelaPrincipal() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jButton2 = new JButton();
        jButton3 = new JButton();

        jButton1.setText("Buscar Contato");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jButton1ActionPerformed(arg0);
            }
        });

        jLabel1.setText("Op��es b�sicas da agenda de contatos.");

        jButton2.setText("Listar Contatos");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jButton2ActionPerformed(arg0);
            }
        });

        jButton3.setText("Criar Contatos");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jButton3ActionPerformed(arg0);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void jButton1ActionPerformed(ActionEvent arg0) {
    	new TelaBusca().setVisible(true);
    }
    
    private void jButton2ActionPerformed(ActionEvent arg0) {
        ServicoContatoImpl servicoContato = new ServicoContatoImpl(usuario.getNomeUsuario());
    	new TelaListagem(servicoContato.listarTodosContatos()).setVisible(true);
    }

    private void jButton3ActionPerformed(ActionEvent arg0) {
    	new TelaCadastro().setVisible(true);
    }

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
}
