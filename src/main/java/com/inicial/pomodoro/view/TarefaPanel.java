/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inicial.pomodoro.view;

import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author myhouse
 */
public class TarefaPanel extends javax.swing.JPanel {
    
    private DefaultTableModel dataModel;

    /**
     * Creates new form TarefaPanel
     */
    public TarefaPanel() {
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

        btnAddTask = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAddTask.setText("Add Task");
        btnAddTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTaskActionPerformed(evt);
            }
        });

        table();
        tableContent.setModel(dataModel);
        tableContent.setEnabled(false);
        int size = 120;
        int height = 20;

        tableContent
        .getColumnModel()
        .getColumn(1)
        .setMaxWidth(size);

        tableContent
        .getColumnModel()
        .getColumn(1)
        .setMinWidth(size);

        tableContent
        .getColumnModel()
        .getColumn(1)
        .setCellRenderer( new ButtonRenderTarefa("Remover") );

        tableContent.setRowHeight(height);
        tableContent.addMouseListener(onCellClick());
        jScrollPane1.setViewportView(tableContent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddTask)
                        .addGap(0, 254, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnAddTask)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTaskActionPerformed
        String tarefa = JOptionPane.showInputDialog("Descrição da tarefa");
        dataModel.addRow(new Object[]{ tarefa, "" });
    }//GEN-LAST:event_btnAddTaskActionPerformed
    
    private void table()
    {
        try {
            dataModel = new DefaultTableModel(
                new Object[][]{},
                new Object[]{"Descrição","Remover"}
            );
        } catch (Exception ex) {
            Logger.getLogger(TarefaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private java.awt.event.MouseAdapter onCellClick(){
        return new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int col = tableContent.columnAtPoint(evt.getPoint());
                int row = tableContent.rowAtPoint(evt.getPoint());
                if (col == 1) {
                    ((DefaultTableModel)tableContent.getModel()).removeRow(row);
                }
            }
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTask;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableContent;
    // End of variables declaration//GEN-END:variables
    class ButtonRenderTarefa implements TableCellRenderer {
        private JButton button;
        
        public ButtonRenderTarefa(String title) {
            button = new JButton(title);
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            return button;
        }
        
    }
}
