package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.*;
import java.util.List;

import model.Contato;
import model.Usuario;
import control.UsuarioAtivo;

public class TelaListagem extends JFrame {
	Usuario usuario = UsuarioAtivo.getUsuario();
	
    public TelaListagem() {
        initComponents();
    }
    
    public TelaListagem(List<Contato> contatos) {
        initComponents();
        this.list1.removeAll();
        for(int i = 0; i < contatos.size(); i++){
        	this.list1.add(contatos.get(i).getNome() + "; " +
							contatos.get(i).getTelefone() + "; " +
							contatos.get(i).getEmail() + "; " +
							contatos.get(i).getEndereco());
        }
        
    }
    
    public void fecharTela(){
    	this.setVisible(false);
    }
        
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new JLabel();
        list1 = new java.awt.List();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Contatos existentes na agenda:");

        list1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                list1ItemStateChanged(evt);
            }
        });

        jButton1.setText("Editar");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jButton1ActionPerformed(arg0);
            }
        });

        jButton2.setText("Excluir");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jButton2ActionPerformed(arg0);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jLabel1)
                    .addComponent(list1, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addComponent(list1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    private void list1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_list1ItemStateChanged
    }

    private void jButton1ActionPerformed(ActionEvent arg0) {
    	fecharTela();
    }
    
    private void jButton2ActionPerformed(ActionEvent arg0) {
    	
    }

    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private java.awt.List list1;
}
