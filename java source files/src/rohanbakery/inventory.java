//Class for adding and deleting inventory
package rohanbakery;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class inventory extends javax.swing.JFrame {

    //Global variables of the class
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //Constructor for initialising components
    public inventory() {
        initComponents();   //Initialise components
        centerFrame();  //Set frame in the center of the screen
        conn = ConnectToDatabase.getConnection();   //Get connection to the database
        generateBillTable();    //Generate table data for bill
    }
    
    //Functin to set frame in the center of the screen
    public void centerFrame() {
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width/2 - getWidth()/2),(size.height/2 - getHeight()/2));
    }
    
    //Fuction to generate table data for bill
    public void generateBillTable() {
        try {
            //Only those items are shown that have not been removed from the billing list
            String sql ="select * from inventory where inActive=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,"Yes");
            rs=pst.executeQuery();
            tbl_Inventory.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally {
            try {
                pst.close();
                rs.close();
            } catch(Exception e) {}
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_main = new javax.swing.JPanel();
        btn_backToMainMenu = new javax.swing.JButton();
        btn_addInventory = new javax.swing.JButton();
        btn_removeInventory = new javax.swing.JButton();
        jScrollPaneForTable = new javax.swing.JScrollPane();
        tbl_Inventory = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventory details");
        setAlwaysOnTop(true);
        setResizable(false);

        pnl_main.setLayout(null);

        btn_backToMainMenu.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_backToMainMenu.setText("Back to main menu");
        btn_backToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backToMainMenuActionPerformed(evt);
            }
        });
        pnl_main.add(btn_backToMainMenu);
        btn_backToMainMenu.setBounds(480, 10, 200, 30);

        btn_addInventory.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_addInventory.setText("Add inventory");
        btn_addInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addInventoryActionPerformed(evt);
            }
        });
        pnl_main.add(btn_addInventory);
        btn_addInventory.setBounds(210, 430, 140, 30);

        btn_removeInventory.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_removeInventory.setText("Remove inventory");
        btn_removeInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeInventoryActionPerformed(evt);
            }
        });
        pnl_main.add(btn_removeInventory);
        btn_removeInventory.setBounds(370, 430, 140, 30);

        tbl_Inventory.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbl_Inventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Inventory.setEnabled(false);
        tbl_Inventory.setRowSelectionAllowed(false);
        jScrollPaneForTable.setViewportView(tbl_Inventory);

        pnl_main.add(jScrollPaneForTable);
        jScrollPaneForTable.setBounds(20, 50, 660, 370);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Inventory details : ");
        pnl_main.add(jLabel1);
        jLabel1.setBounds(20, 20, 150, 23);

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.images/Background image.jpeg"))); // NOI18N
        pnl_main.add(lbl_background);
        lbl_background.setBounds(0, 0, 700, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Code to go back to main menu
    private void btn_backToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backToMainMenuActionPerformed
        mainMenu mm = new mainMenu();
        mm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_backToMainMenuActionPerformed

    //Code to add inventory to the table
    private void btn_addInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addInventoryActionPerformed
        addInventory ai = new addInventory();
        ai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_addInventoryActionPerformed

    //Code to remove inventory from the table
    private void btn_removeInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeInventoryActionPerformed
        removeInventory ri = new removeInventory();
        ri.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_removeInventoryActionPerformed

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
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addInventory;
    private javax.swing.JButton btn_backToMainMenu;
    private javax.swing.JButton btn_removeInventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPaneForTable;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JTable tbl_Inventory;
    // End of variables declaration//GEN-END:variables
}
