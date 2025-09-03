/*
Mô tả: hoàn chỉnh các chức năng:
    - Kết nối CSDL SQL Server
    - Hiển thị dữ liệu từ bảng Item
    - Thêm, sửa, xóa dữ liệu qua giao diện
    - Dùng PreparedStatement để tránh lỗi SQL Injection
    - Cập nhật JTable sau mỗi thao tác

 */
package session04_JDBC;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//class chính
public class Ex07_StrongHold_Swing extends javax.swing.JFrame {

    //1. Properties
        //1.1. Database information
        Connection cnn;
        String user = "sa";
        String password = "127897";
        String database = "stronghold";
        //1.2. JDBC Object
        PreparedStatement st;
        ResultSet rs;
        DefaultTableModel model;
        //1.3. Button status
        int insert = 0;
        
    //2. Constructor
    public Ex07_StrongHold_Swing() {
        initComponents();
        cnn = zEx01_SQL.doConnect(user, password, database);
        model = new DefaultTableModel();
        String[] cols = {"Code", "Name", "Price"};
        model.setColumnIdentifiers(cols);
        tbItem.setModel(model); // add model to table
        
        tbItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbItemMouseClicked(evt);
            }
        });
        
        setState(false, false, false);
        try {
            loadData();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItem = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Item_Management_System");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Item Management System (IMS)");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Code:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Price:");

        txtPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPrice.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCode.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        btnOK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOK.setText("Add New");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        tbItem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbItem.setToolTipText("");
        tbItem.setMinimumSize(new java.awt.Dimension(40, 120));
        tbItem.setRowHeight(30);
        jScrollPane1.setViewportView(tbItem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .addComponent(txtPrice)
                    .addComponent(txtCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //3. User-defined methods
        //3.1. setState() method: đặt trạng thái các field
        private void setState(boolean x, boolean y, boolean z) {
            txtCode.setText("");
            txtName.setText("");
            txtPrice.setText("");
            txtCode.setEditable(x);
            txtName.setEditable(y);
            txtPrice.setEditable(z);

        }

        //3.2. loadData() method: lấy dữ liệu từ bảng Item
        private void loadData() throws SQLException {
            //3.2.1. Query String
            String query = "select * from Item";
            //3.2.2. ResultSet
            try {
                st = cnn.prepareStatement(query);
                rs = st.executeQuery();
                model.setRowCount(0); // để không thêm dòng lặp
                while (rs.next()) {
                    Vector tmp = new Vector();
                    tmp.add(rs.getString(1));
                    tmp.add(rs.getString(2));
                    tmp.add(rs.getInt(3));
                    model.addRow(tmp);

                }

                tbItem.setModel(model);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        //3.3. insert() method
        void insert(String code, String name, int price) {
            String query = "insert into Item values (?, ?, ?)";
            try {
                st = cnn.prepareStatement(query);
                st.setString(1, code);
                st.setString(2, name);
                st.setInt(3, price);
                int cnt = st.executeUpdate();
                if (cnt > 0) {
                    System.out.println("Insert successful!");
                    loadData();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        //3.4. update() method
        void update(String code, String newName, int newPrice) {
            String query = "update Item set ItemName = ? , Rate = ? where ICode = ?";
            try {
                st = cnn.prepareStatement(query);
                st.setString(2, newName);
                st.setInt(3, newPrice);
                st.setString(1, code);
                int cnt = st.executeUpdate();
                if (cnt == 0) {
                    System.err.println("No record found to update with code: " + code);
                } else {
                    System.out.println("Updated successfully!");
                    select();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        //3.5. delete() method
        void delete(String code) throws SQLException {
            String query = "delete from Item where ICode = ?";
            try {
                st = cnn.prepareStatement(query);
                st.setString(1, code);
                int cnt = st.executeUpdate();
                if (cnt == 0) {
                    System.err.println("No record found to delete with code: " + code);
                } else {
                    System.out.println("Deleted successfully!");
                    select();
                }
            } catch (SQLException e) {
                System.err.println(e.toString());
            }
        }

        void select() {
            try {
                loadData();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

    //4. System methods
        //4.1. TxtName event
    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

        //4.2. btnOK event
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
            //4.2.1. Label => "Add New"
            if (evt.getActionCommand().equals("Add New")) {
                setState(true, true, true);
                txtCode.grabFocus();
                btnOK.setText("Save");
                insert++;
            }
            //4.2.2. Label => "Save"
            if (evt.getActionCommand().equals("Save")) {
                String code = txtCode.getText().trim();
                String name = txtName.getText().trim();

                String s = txtPrice.getText().trim();
                int price = Integer.parseInt(s);
                //4.2.2.1 Status insert > 0\

                if (insert > 0) {
                    insert(code, name, price);
                    setState(false, false, false);
                    btnOK.setText("Add New");

                }
                //4.2.2.2 Status insert == 0
                if (insert == 0) {
                    update(code, name, price);
                    setState(false, false, false);
                    btnOK.setText("Add New");
                }
        }
    }//GEN-LAST:event_btnOKActionPerformed
        // 4.3. MouseClick event on tbItem
        private void tbItemMouseClicked(java.awt.event.MouseEvent evt) {
            // Xác định dòng được chọn
            int row = tbItem.getSelectedRow();

            // Đọc giá trị từng cell
            String code = (String) tbItem.getValueAt(row, 0);
            String name = (String) tbItem.getValueAt(row, 1);
            int price = (int) tbItem.getValueAt(row, 2);

            // Gán giá trị lên các textfield
            txtCode.setText(code);
            txtName.setText(name);
            txtPrice.setText(String.valueOf(price));

            // Cho phép chỉnh sửa các trường
            txtName.setEditable(true);
            txtPrice.setEditable(true);

            btnOK.setText("Update");
            insert = 0;
        }

        //4.4.delete event on btnDelete
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure delete?", "Delete confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                delete(txtCode.getText().trim());
                loadData();
                setState(false, false, false);
                btnOK.setText("Add New");
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
        //4.5.btnExit
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    //5. main() method
    // <editor-fold defaultstate="collapsed" desc="Main() method">
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Ex07_StrongHold_Swing().setVisible(true));
    }
    //</editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbItem;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
