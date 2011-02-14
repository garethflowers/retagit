package garethflowers.retagit.controls;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 *
 * @author Gareth
 */
public class option extends javax.swing.JPanel {

    private JLabel jLabel1;
    private JCheckBox jCheckBox1;



    public option() {
        initComponents();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel1.setText("Test");
        this.jCheckBox1 = new JCheckBox();

        this.add(this.jLabel1);
        this.add(this.jCheckBox1);
        
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 400, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 300, Short.MAX_VALUE)
//        );

    }
}
