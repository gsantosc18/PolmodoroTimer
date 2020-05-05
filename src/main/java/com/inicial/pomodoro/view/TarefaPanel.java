/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.inicial.pomodoro.view;

import com.inicial.pomodoro.model.CronometroEvent;
import java.awt.Component;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author myhouse
 */
public class TarefaPanel extends javax.swing.JPanel {
    
    private DefaultTableModel dataModel;
    private int pointTask = 0;
    
    /**
     * Creates new form TarefaPanel
     */
    public TarefaPanel() {
        initComponents();
    }
    
    public CronometroEvent onNextStep()
    {
        return new CronometroEvent() {
            @Override
            public void onNextStep() {
                int countData = dataModel.getRowCount();
                if(countData > 0  && pointTask < countData) {
                    dataModel.setValueAt(true, pointTask, 0);
                    pointTask++;
                }
            }
        };
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
        setSizeColumn(0, 120);
        setSizeColumn(2, 120);

        setRenderColumn(2,new ButtonRenderTarefa("Remover") );

        setRenderColumn(0,new CheckBoxRenderTarefa() );

        setEditorColumn(0,new CheckEditorTarefa());

        tableContent.setRowHeight(20);
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
        if(tarefa!=null && !tarefa.isEmpty())
            dataModel.addRow(new Object[]{ false, tarefa, false });
    }//GEN-LAST:event_btnAddTaskActionPerformed
    
    private void table()
    {
        try {
            dataModel = new DefaultTableModel(
                    new Object[][]{},
                    new Object[]{"Editar","Descrição","Remover"}
            ){
                @Override
                public Class getColumnClass(int columnIndex) {
                    switch(columnIndex) {
                        case 0: return JCheckBox.class;
                        case 2: return JButton.class;
                        default: return String.class;
                    }
                }
                
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnIndex != 2;
                }
            };
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
                if (col == 2) {
                    ((DefaultTableModel)tableContent.getModel()).removeRow(row);
                }
            }
        };
    }
    
    private void setSizeColumn(int column, int size) {
        tableContent
                .getColumnModel()
                .getColumn(column)
                .setMaxWidth(size);
        
        tableContent
                .getColumnModel()
                .getColumn(column)
                .setMinWidth(size);
    }
    
    private void setRenderColumn(int column, TableCellRenderer renderer) {
        tableContent
                .getColumnModel()
                .getColumn(column)
                .setCellRenderer(renderer);
    }
    
    private void setEditorColumn(int column, TableCellEditor editor)
    {
        tableContent
                .getColumnModel()
                .getColumn(column)
                .setCellEditor(editor);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTask;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableContent;
    // End of variables declaration//GEN-END:variables
    class ButtonRenderTarefa implements TableCellRenderer {
        private final JButton button;
        
        public ButtonRenderTarefa(String title) {
            button = new JButton(title);
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            return button;
        }
    }
    
    public class CheckEditorTarefa extends AbstractCellEditor implements TableCellEditor
    {
        JCheckBox checkBox;
        int editedRow;
        int editedColumn;
        
        CheckEditorTarefa(){
            checkBox = new JCheckBox();
        }
        
        @Override
        public Component getTableCellEditorComponent(JTable table,
                Object value, boolean isSelected, int row, int column) {
            checkBox.setSelected((Boolean) value);
            return checkBox;
        }
        
        @Override
        public Object getCellEditorValue() {
            return checkBox.isSelected();
        }
    }
    
    class CheckBoxRenderTarefa implements TableCellRenderer {
        private final JCheckBox checkbox;
        
        public CheckBoxRenderTarefa() {
            checkbox = new JCheckBox();
        }
        
        @Override
        public Component getTableCellRendererComponent(
                JTable jtable, Object o, boolean bln,
                boolean bln1, int i, int i1) {
            try {
                checkbox.setSelected((Boolean) o);
            } catch (Exception e) {}
            return checkbox;
        }
    }
}
