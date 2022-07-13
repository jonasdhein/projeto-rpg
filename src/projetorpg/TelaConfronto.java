/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetorpg;

import ferramentas.CaixaDeDialogo;
import java.util.Random;
import modelos.Oponente;
import modelos.Personagem;

/**
 *
 * @author Jonas
 */
public class TelaConfronto extends javax.swing.JFrame {

    public static Personagem personagem;
    Oponente oponente = new Oponente();
    Random gerador = new Random();
    int maxVidaPersonagem;
    int maxVidaOponente;
            
    /**
     * Creates new form TelaConfronto
     */
    public TelaConfronto(Personagem personagem) {
        initComponents();
        
        this.personagem = personagem;
        this.maxVidaPersonagem = personagem.getVida();
        //Preenche os dados do personagem
        mostrarPersonagem();
        
        gerarOponente(); //Gerando um oponente com ataque e vida aleatorios
        mostrarOponente();
    }
    
    private void mostrarPersonagem(){
        prbVidaPersonagem.setMaximum(maxVidaPersonagem);
        prbVidaPersonagem.setValue(personagem.getVida());
        prbVidaPersonagem.setName(String.valueOf(personagem.getVida()));
            
        lblClasse.setText(personagem.getNome() + " - " + personagem.getClasse());
        lblVidaPersonagem.setText(String.valueOf(personagem.getVida()));
        lblAtaquePersonagem.setText(String.valueOf(personagem.getAtaque()));
        
    }
    
    private void gerarOponente(){
        try{
            oponente.setNome("");
            oponente.setAtaque(gerador.nextInt(135) + 1);
            oponente.setVida(gerador.nextInt(300) + 1);
            maxVidaOponente = oponente.getVida();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage().toString(), 'e');
        }
    }
    
    private void mostrarOponente(){
        prbVidaOponente.setMaximum(maxVidaOponente);
        prbVidaOponente.setValue(oponente.getVida());
        prbVidaOponente.setName(String.valueOf(oponente.getVida()));
        
        lblVidaOponente.setText(String.valueOf(oponente.getVida()));
        lblAtaqueOponente.setText(String.valueOf(oponente.getAtaque()));
    }
    
    private void ataque(){
        //personagem ataca o oponente
        int ataque = 0;
        int valorDado = gerador.nextInt(20) + 1;
        if(valorDado > 13){ //ataque crítico
            ataque = personagem.getAtaque();
        }else{
            ataque = personagem.getAtaque() / 3;
        }
        System.out.println("DADO = " + valorDado);
        System.out.println("ATAQUE = " + ataque);
        
        int vidaRestante = oponente.getVida() - ataque;
        oponente.setVida(vidaRestante);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblClasse = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblVidaPersonagem = new javax.swing.JLabel();
        lblAtaquePersonagem = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblVidaOponente = new javax.swing.JLabel();
        lblAtaqueOponente = new javax.swing.JLabel();
        btAtacar = new javax.swing.JButton();
        prbVidaPersonagem = new javax.swing.JProgressBar();
        prbVidaOponente = new javax.swing.JProgressBar();
        lblOponente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Personagem:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel2.setText("Vida Atual:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 28, -1, -1));

        lblClasse.setText("...");
        getContentPane().add(lblClasse, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel3.setText("Ataque:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 50, -1, -1));

        lblVidaPersonagem.setText("...");
        getContentPane().add(lblVidaPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 28, -1, -1));

        lblAtaquePersonagem.setText("...");
        getContentPane().add(lblAtaquePersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 50, -1, -1));

        jLabel4.setText("Oponente:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 6, -1, -1));

        jLabel5.setText("Vida Atual:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 28, -1, -1));

        jLabel6.setText("Ataque:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 50, -1, -1));

        lblVidaOponente.setText("...");
        getContentPane().add(lblVidaOponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 28, -1, -1));

        lblAtaqueOponente.setText("...");
        getContentPane().add(lblAtaqueOponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 50, -1, -1));

        btAtacar.setText("ATACAR");
        btAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtacarActionPerformed(evt);
            }
        });
        getContentPane().add(btAtacar, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 249, -1, -1));

        prbVidaPersonagem.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        prbVidaPersonagem.setForeground(new java.awt.Color(255, 51, 51));
        prbVidaPersonagem.setValue(100);
        prbVidaPersonagem.setString("100");
        prbVidaPersonagem.setStringPainted(true);
        getContentPane().add(prbVidaPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        prbVidaOponente.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        prbVidaOponente.setForeground(new java.awt.Color(255, 51, 51));
        prbVidaOponente.setValue(100);
        prbVidaOponente.setString("100");
        prbVidaOponente.setStringPainted(true);
        getContentPane().add(prbVidaOponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, -1));

        lblOponente.setText("...");
        getContentPane().add(lblOponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtacarActionPerformed
        // TODO add your handling code here:
        ataque();
        
        //Verificar se o oponente ainda esta vivo
        if(oponente.getVida() > 0){
            mostrarOponente();
        }else{
            gerarOponente();
            mostrarOponente();
        }
    }//GEN-LAST:event_btAtacarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaConfronto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConfronto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConfronto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConfronto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConfronto(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtacar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblAtaqueOponente;
    private javax.swing.JLabel lblAtaquePersonagem;
    private javax.swing.JLabel lblClasse;
    private javax.swing.JLabel lblOponente;
    private javax.swing.JLabel lblVidaOponente;
    private javax.swing.JLabel lblVidaPersonagem;
    private javax.swing.JProgressBar prbVidaOponente;
    private javax.swing.JProgressBar prbVidaPersonagem;
    // End of variables declaration//GEN-END:variables
}
