/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pariwisata;

/**
 *
 * @author Haris
 */
public class identitasPemesanan extends javax.swing.JFrame {
    koneksi con = new koneksi();
    /**
     * Creates new form identitasPemesanan
     */
    public identitasPemesanan() {
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

        txt_total = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        txt_telepon = new javax.swing.JTextField();
        txt_jumlahSeat = new javax.swing.JTextField();
        txt_harga = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_home = new javax.swing.JButton();
        btn_bayar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 170, 40));
        getContentPane().add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 300, 40));
        getContentPane().add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 300, 40));
        getContentPane().add(txt_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 300, 40));
        getContentPane().add(txt_jumlahSeat, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 180, 40));
        getContentPane().add(txt_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 170, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\Semester 2\\project\\UI\\MacBook Pro 14_ - 5.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btn_home.setText("jButton1");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 5, 50, 50));

        btn_bayar.setText("jButton2");
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 190, 70));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        new jadwalPemesanan().setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
        int getSesi = con.getSesi();
        
    }//GEN-LAST:event_btn_bayarActionPerformed

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
            java.util.logging.Logger.getLogger(identitasPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(identitasPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(identitasPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(identitasPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new identitasPemesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bayar;
    private javax.swing.JButton btn_home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_jumlahSeat;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_telepon;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
