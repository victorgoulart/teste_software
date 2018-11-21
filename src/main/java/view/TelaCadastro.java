package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import control.ServicoContatoImpl;
import control.UsuarioAtivo;
import model.Contato;
import model.Usuario;

public class TelaCadastro extends JFrame {
	Usuario usuario = UsuarioAtivo.getUsuario(); 

    boolean edit = false;
	int index = 0;
	
    public TelaCadastro() {
        initComponents();
    }

    public TelaCadastro(String itemSelecionado, int index) {
    	initComponents();
    	String aux[] = itemSelecionado.split("; ");
    	jTextField1.setText(aux[0]);
    	jTextField2.setText(aux[1]);
    	jTextField3.setText(aux[2]);
    	jTextField4.setText(aux[3]);
    	edit = true;
    	this.index = index;
	}
    
    void fecharJanela(){
    	this.setVisible(false);
    }
	@SuppressWarnings("unchecked")
    private void initComponents() {

        jTextField1 = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Telefone");

        jLabel3.setText("Email");

        jLabel4.setText("Endere�o");

        jButton1.setText("Cadastrar");
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
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    private void jButton1ActionPerformed(ActionEvent arg0) {
        ServicoContatoImpl servicoContato = new ServicoContatoImpl(usuario.getNomeUsuario());
        Contato contato = new Contato(jTextField1.getText(), jTextField3.getText(), jTextField2.getText(), jTextField4.getText());
        if(servicoContato.inserir(contato) != null){
            new TelaListagem().setVisible(true);
            fecharJanela();
        }
    }
    
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
}
