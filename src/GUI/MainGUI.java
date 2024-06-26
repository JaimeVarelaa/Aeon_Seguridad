package GUI;

import Filters.IPFilter;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import javax.swing.ImageIcon;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import javax.swing.SwingUtilities;
import Renders.ButtonRenderer;
import java.awt.CardLayout;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author jaime
 */
public class MainGUI extends javax.swing.JFrame {

    public static String[] Interfaces = new String[3];
    public static String globalIP = "";

    public MainGUI() {
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

        jPanel5 = new javax.swing.JPanel();
        gifLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        IPLabel = new javax.swing.JLabel();
        InterfaceLabel = new javax.swing.JLabel();
        SPKButton = new ButtonRenderer("Solicitar PK");
        MacLabel = new javax.swing.JLabel();
        ExitButton = new ButtonRenderer("Salir");
        jPanel4 = new javax.swing.JPanel();
        IPSLabel = new javax.swing.JLabel();
        SPKButton1 = new ButtonRenderer("Solicitar PK");
        ExitButton1 = new ButtonRenderer("Regresar");
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aeon");
        setIconImage(new ImageIcon(getClass().getResource("/Assets/icon.png")).getImage());
        setMaximumSize(new java.awt.Dimension(250, 290));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(250, 290));
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        gifLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gifLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/346.gif"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        IPLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        IPLabel.setForeground(new java.awt.Color(197, 218, 250));
        IPLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IPLabel.setText("IP");
        IPLabel.setToolTipText("Guardar en el portapapeles");
        IPLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IPLabel.setMaximumSize(new java.awt.Dimension(230, 17));
        IPLabel.setMinimumSize(new java.awt.Dimension(230, 17));
        IPLabel.setPreferredSize(new java.awt.Dimension(230, 17));
        IPLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IPLabelMouseClicked(evt);
            }
        });

        InterfaceLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        InterfaceLabel.setForeground(new java.awt.Color(197, 218, 250));
        InterfaceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InterfaceLabel.setText("Interface");
        InterfaceLabel.setMaximumSize(new java.awt.Dimension(200, 17));
        InterfaceLabel.setMinimumSize(new java.awt.Dimension(200, 17));
        InterfaceLabel.setPreferredSize(new java.awt.Dimension(200, 17));

        SPKButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SPKButtonMouseClicked(evt);
            }
        });
        SPKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPKButtonActionPerformed(evt);
            }
        });

        MacLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        MacLabel.setForeground(new java.awt.Color(197, 218, 250));
        MacLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MacLabel.setText("MacAdress");

        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MacLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InterfaceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IPLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(SPKButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InterfaceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MacLabel)
                .addGap(18, 18, 18)
                .addComponent(SPKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, "await");

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        IPSLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        IPSLabel.setForeground(new java.awt.Color(197, 218, 250));
        IPSLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IPSLabel.setText("IP:");
        IPSLabel.setMaximumSize(new java.awt.Dimension(200, 17));
        IPSLabel.setMinimumSize(new java.awt.Dimension(200, 17));
        IPSLabel.setPreferredSize(new java.awt.Dimension(200, 17));

        SPKButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SPKButton1MouseClicked(evt);
            }
        });
        SPKButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPKButton1ActionPerformed(evt);
            }
        });

        ExitButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButton1MouseClicked(evt);
            }
        });
        ExitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButton1ActionPerformed(evt);
            }
        });

        ((AbstractDocument) jTextField1.getDocument()).setDocumentFilter(new IPFilter());
        jTextField1.setBackground(new java.awt.Color(197, 218, 250));
        jTextField1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 51, 51));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IPSLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(SPKButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExitButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(IPSLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SPKButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, "ask");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gifLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(gifLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SPKButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SPKButtonMouseClicked

    }//GEN-LAST:event_SPKButtonMouseClicked

    private void ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitButtonMouseClicked

    private void SPKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPKButtonActionPerformed
        CardLayout card = (CardLayout) this.jPanel2.getLayout();
        card.show(this.jPanel2, "ask");
        jTextField1.requestFocus();
    }//GEN-LAST:event_SPKButtonActionPerformed

    private void SPKButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SPKButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SPKButton1MouseClicked

    private void ExitButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitButton1MouseClicked

    private void ExitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButton1ActionPerformed
        CardLayout card = (CardLayout) this.jPanel2.getLayout();
        card.show(this.jPanel2, "await");
        jTextField1.setText("");
    }//GEN-LAST:event_ExitButton1ActionPerformed

    private void IPLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IPLabelMouseClicked
        new Thread(new Runnable() {
            @Override
            public void run() {
                String ip = IPLabel.getText();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        IPLabel.setText("Guardado");
                    }
                });
                try {
                    Thread.sleep(700);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(ip), null);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        IPLabel.setText(ip);
                    }
                });
            }
        }).start();
    }//GEN-LAST:event_IPLabelMouseClicked

    private void SPKButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPKButton1ActionPerformed
        String ip = jTextField1.getText();
        if (ip.chars().filter(ch -> ch == '.').count() == 3) {
            Thread t = new Thread(() -> {
                globalIP = ip;
                PseudoChat.chat(ip);
            });
            t.start();
        }
    }//GEN-LAST:event_SPKButton1ActionPerformed

    /**
     * 5
     */
    public static void MainGUI() {
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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                    while (interfaces.hasMoreElements()) {
                        NetworkInterface networkInterface = interfaces.nextElement();
                        Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                        while (addresses.hasMoreElements()) {
                            InetAddress address = addresses.nextElement();
                            if (address instanceof java.net.Inet4Address) {
                                String ip = address.getHostAddress();
                                if (!ip.endsWith(".1")) {
                                    Interfaces[0] = networkInterface.getDisplayName();
                                    Interfaces[1] = ip;
                                    byte[] mac = networkInterface.getHardwareAddress();
                                    if (mac != null) {
                                        StringBuilder macAddress = new StringBuilder();
                                        for (int i = 0; i < mac.length; i++) {
                                            macAddress.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                                        }
                                        Interfaces[2] = macAddress.toString();
                                    }
                                }
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }

                new MainGUI().setVisible(true);

                InterfaceLabel.setText(Interfaces[0]);
                IPLabel.setText(Interfaces[1]);
                MacLabel.setText(Interfaces[2]);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton ExitButton1;
    private static javax.swing.JLabel IPLabel;
    private static javax.swing.JLabel IPSLabel;
    private static javax.swing.JLabel InterfaceLabel;
    private static javax.swing.JLabel MacLabel;
    private javax.swing.JButton SPKButton;
    private javax.swing.JButton SPKButton1;
    private javax.swing.JLabel gifLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
