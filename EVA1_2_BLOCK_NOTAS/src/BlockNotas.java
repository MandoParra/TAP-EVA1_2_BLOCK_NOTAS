
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author invitado
 */
public class BlockNotas extends javax.swing.JFrame {

    /**
     * Creates new form BlockNotas
     */
    public BlockNotas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotas = new javax.swing.JTextArea();
        BtnGuardar = new javax.swing.JButton();
        BtnAbrir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNotas.setColumns(20);
        txtNotas.setRows(5);
        jScrollPane1.setViewportView(txtNotas);

        BtnGuardar.setText("Guardar");
        BtnGuardar.setName(""); // NOI18N
        BtnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnGuardarMouseClicked(evt);
            }
        });

        BtnAbrir.setText("Abrir");
        BtnAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAbrirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BtnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnGuardar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardar)
                    .addComponent(BtnAbrir))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAbrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAbrirMouseClicked
        // TODO add your handling code here:
        JFileChooser jfcAbrirArch = new JFileChooser("F:\\TEC2\\Topicos de programacion\\Unidad 1\\Carpeta");
        int resu = jfcAbrirArch.showOpenDialog(this);
        if(resu == JFileChooser.APPROVE_OPTION){
            BufferedReader br = null;
                InputStream is = null;
            try {
                System.out.println(jfcAbrirArch.getSelectedFile());
                //NECESITAMOS UN READER PARA PASARSELO AL TEXTAREA
                is = Files.newInputStream(jfcAbrirArch.getSelectedFile().toPath());
                InputStreamReader isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                txtNotas.read(br, "Abrir archivo");
            } catch (IOException ex) {
                ex.printStackTrace();
            }finally{
                try{
                if(br!=null){
                    br.close();
                    is.close();
                }
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_BtnAbrirMouseClicked

    private void BtnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnGuardarMouseClicked
        // TODO add your handling code here:
        JFileChooser jfcAbrirArch = new JFileChooser("F:\\TEC2\\Topicos de programacion\\Unidad 1\\Carpeta");
        int resu = jfcAbrirArch.showOpenDialog(this);
        if(resu == JFileChooser.APPROVE_OPTION){
            BufferedWriter bw = null;
            OutputStream os = null;
            
            try{
                os = Files.newOutputStream(jfcAbrirArch.getSelectedFile().toPath());
                OutputStreamWriter ow = new OutputStreamWriter(os);
                bw = new BufferedWriter(ow);
                txtNotas.write(bw);
            }catch(IOException ex){
                ex.printStackTrace();
            }finally{
                try{
                    if(bw!=null){
                    bw.close();
                    os.close();
                    }
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }  
    }//GEN-LAST:event_BtnGuardarMouseClicked

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
            java.util.logging.Logger.getLogger(BlockNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlockNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlockNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlockNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BlockNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAbrir;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtNotas;
    // End of variables declaration//GEN-END:variables
}
