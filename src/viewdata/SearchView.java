/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewdata;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author zhangquan
 */
public class SearchView extends javax.swing.JPanel {

    /**
     * Creates new form SearchView
     */
    private Controller ctr;
    public SearchView() throws SQLException, ClassNotFoundException {
        ctr = new Controller();
        initComponents();
        //jTextArea1.setText(TOOL_TIP_TEXT_KEY);
    }
    
    public boolean ishaveText(){
        if(jTextArea1.getText() == null) {return false;}
        else {return true;}
    }
    
    public String getSearch(String str){
        String s = null;
        try {
            s = ctr.Search(str);
        } catch (SQLException ex) {
            Logger.getLogger(SearchView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public boolean Insert(String s1,String s2,String s3,String s4,String s5){
        try {
            ctr.Insert(s1, s2, s3, s4, s5);
            return true;
        } catch (SQLException ex) {
            //Logger.getLogger(SearchView.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void Del(String Sno){
        try {
            ctr.Del(Sno);
        } catch (SQLException ex) {
            Logger.getLogger(SearchView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Update(String Sno,String Sage) throws SQLException{
        ctr.Update(Sno, Sage);
    }
    public void set(String str) throws SQLException{
           jTextArea1.setText(str);
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
        jTextArea1 = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}