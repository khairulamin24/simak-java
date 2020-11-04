/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DataGuru.java
 *
 * Created on Feb 5, 2014, 3:09:02 PM
 */

package Frame;

import Connection.Koneksi;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class DataGuru extends javax.swing.JFrame {

    /** Creates new form DataGuru */
    public DataGuru() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
        try
        {
            int kodee = 0;

            Koneksi objkoneksi = new Koneksi();
            Connection con =objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String SQL = "select kode from enabled";
            ResultSet RS=st.executeQuery(SQL);
            while(RS.next())
                {
                    kodee=RS.getInt(1);
                }
           if (kodee==2)
                {
                    edit.setEnabled(false);
                    hapus.setEnabled(false);
                }
          else if(kodee==5)
                {
                    simpan.setEnabled(false);
                    edit.setEnabled(false);
                }
          else if(kodee==8)
                {
                    simpan.setEnabled(false);
                    hapus.setEnabled(false);
                }
        }
        catch (SQLException e){}
        bersih();
    }

    void bersih()
    {
        kode.setText("");
        nip.setText("");
        nama.setText("");
        alamat.setText("");
        telp.setText("");
        kode.setEditable(true);
    }

    void simpan()
    {
         try {
            Koneksi objkoneksi = new Koneksi();
            Connection con =objkoneksi.bukakoneksi();
            Statement st = con.createStatement();

            String sql = "insert into guru (KodeGuru, NIP, Nama, Alamat, Telepon)"
                    + "values ('"+kode.getText()+"','"+nip.getText()+"','"+nama.getText()+"'"
                    + ",'"+alamat.getText()+"','"+telp.getText()+"')";
            int row =st.executeUpdate(sql);
            if (row==1)
            {
                JOptionPane.showMessageDialog(null,"Data sudah ditambahkan ke database","informasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"data tidak ditambahkan ke database"+e,"informasi",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kode = new javax.swing.JTextField();
        nip = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        telp = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Guru");

        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel1.setText("Kode Guru");

        jLabel2.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel2.setText("NIP");

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel4.setText("Telepon");

        jLabel5.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel5.setText("Alamat");

        kode.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        kode.setText(" ");
        kode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeActionPerformed(evt);
            }
        });
        kode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodeKeyPressed(evt);
            }
        });

        nip.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        nip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nipActionPerformed(evt);
            }
        });

        nama.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N

        alamat.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N

        telp.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N

        simpan.setBackground(new java.awt.Color(0, 204, 255));
        simpan.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Addnew toolbar.png"))); // NOI18N
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        edit.setBackground(new java.awt.Color(0, 204, 255));
        edit.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit toolbar.png"))); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        hapus.setBackground(new java.awt.Color(0, 204, 255));
        hapus.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete toolbar.png"))); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        batal.setBackground(new java.awt.Color(0, 204, 255));
        batal.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove_32.png"))); // NOI18N
        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 204, 255));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DATA GURU SMK NEGERI 1 TAPEN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(alamat, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(nip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(telp, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(hapus)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(batal)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {batal, edit, hapus, simpan});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpan)
                            .addComponent(edit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hapus)
                            .addComponent(batal))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {batal, edit, hapus, simpan});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nipActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
       simpan();
        bersih();
    }//GEN-LAST:event_simpanActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        new MenuUtama().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try
        {
            Koneksi objkoneksi = new Koneksi();
            Connection con =objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "update guru set nip='"+nip.getText()+"', "
                    + "nama = '"+nama.getText()+"',"
                    + "alamat = '"+alamat.getText()+"',"
                    + "telepon = '"+telp.getText()+"'"
                    + "where kodeguru ='" +kode.getText()+"'";
            int row =st.executeUpdate(sql);
            if (row==1)
            {
                JOptionPane.showMessageDialog(null,"Data sudah diupdate","informasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"data tidak diubah"+ e,"informasi",JOptionPane.INFORMATION_MESSAGE);
        }
        bersih();
    }//GEN-LAST:event_editActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        bersih();
    }//GEN-LAST:event_batalActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        try
        {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "delete from guru where kodeguru= '"+kode.getText()+"'";
            int confirm =JOptionPane.showConfirmDialog(this,
            "Yakin untuk menghapus data ini?",
            "Konfirmasi Hapus ",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            if (confirm==JOptionPane.YES_OPTION) {
            int row = st.executeUpdate(sql);
            if (row ==1)
            {
                JOptionPane.showMessageDialog(null,"data sudah dihapus dari database","informasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }}}

        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "data tidak dihapus"+e,"informasi",JOptionPane.INFORMATION_MESSAGE);
        }
        bersih();
    }//GEN-LAST:event_hapusActionPerformed

    private void kodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER)

        {
                try
                {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/Akademik", "root", "");
                Statement state = koneksi.createStatement();
                String query = "select *from guru where kodeguru = '"+kode.getText()+"'";
                ResultSet rs = state.executeQuery(query);
                if(rs.next())
                {
                    nip.setText(rs.getString(2));
                    nama.setText(rs.getString(3));
                    alamat.setText(rs.getString(4));
                    telp.setText(rs.getString(5));

                    kode.setEditable(false);
                }
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
        }
    }//GEN-LAST:event_kodeKeyPressed

    private void kodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataGuru().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JButton back;
    private javax.swing.JButton batal;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField kode;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nip;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField telp;
    // End of variables declaration//GEN-END:variables

}
