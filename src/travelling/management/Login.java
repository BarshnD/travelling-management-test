/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelling.management;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1,b2,b3;


	public Login() {
            
	setBackground(new Color(255, 255, 204));	
        setBounds(475, 250, 700, 400);
		
        panel = new JPanel();
	panel.setBackground(Color.LIGHT_GRAY);
	setContentPane(panel);
	panel.setLayout(null);

	JLabel l1 = new JLabel("User_name: ");
	l1.setBounds(124, 89, 95, 24);
	panel.add(l1);

	JLabel l2 = new JLabel("                               Password : ");
	l2.setBounds(33, 124, 195, 24);
	panel.add(l2);

	textField = new JTextField();
	textField.setBounds(210, 93, 157, 20);
	panel.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(210, 128, 157, 20);
	panel.add(passwordField);

	JLabel l3 = new JLabel("");
	l3.setBounds(377, 79, 46, 34);
	panel.add(l3);

	JLabel l4 = new JLabel("");
	l4.setBounds(377, 124, 46, 34);
	panel.add(l3);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/random2.png"));
        Image i1 = c1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        
        JLabel l6 = new JLabel(i2);
        l6.setBounds(480, 70, 150, 150);
        add(l6);
        
        
	b1 = new JButton("Areh Tui?");
	b1.addActionListener(this);
                
	b1.setForeground(new Color(46, 139, 87));
	b1.setBackground(new Color(176, 224, 230));
	b1.setBounds(149, 181, 113, 25);
	panel.add(b1);
        
        
        b1.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseEntered(MouseEvent e) {
        // Change the JLabel image when the mouse enters the button area
        ImageIcon hoverImage = new ImageIcon(ClassLoader.getSystemResource("icons/random3.png"));
        Image i1 = hoverImage.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon hoverResizeImage = new ImageIcon(i1);
        l6.setIcon(hoverResizeImage);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Change the JLabel image back to the original image when the mouse exits the button area
        ImageIcon originalImage = new ImageIcon(ClassLoader.getSystemResource("icons/random2.png"));
        Image i1 = originalImage.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon originalResizeImage = new ImageIcon(i1);
        l6.setIcon(originalResizeImage);
    }
});
        
		
        b2 = new JButton("Protom bar naki?");
	b2.addActionListener(this);
	
	b2.setForeground(new Color(0, 0, 153));
	b2.setBackground(new Color(255, 235, 205));
	b2.setBounds(289, 181, 113, 25);
	panel.add(b2);

        
             b2.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseEntered(MouseEvent e) {
        // Change the JLabel image when the mouse enters the button area
        ImageIcon hoverImage = new ImageIcon(ClassLoader.getSystemResource("icons/random4.png"));
        Image i1 = hoverImage.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon hoverResizeImage = new ImageIcon(i1);
        l6.setIcon(hoverResizeImage);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Change the JLabel image back to the original image when the mouse exits the button area
        ImageIcon originalImage = new ImageIcon(ClassLoader.getSystemResource("icons/random2.png"));
        Image i1 = originalImage.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon originalResizeImage = new ImageIcon(i1);
        l6.setIcon(originalResizeImage);
    }
});
        
        
	b3 = new JButton("Vule Gesi ");
	b3.addActionListener(this);
	
        b3.setForeground(new Color(205, 92, 92));
	b3.setBackground(new Color(253, 245, 230));
	b3.setBounds(199, 231, 179, 25);
	panel.add(b3);
        
        
             b3.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseEntered(MouseEvent e) {
        // Change the JLabel image when the mouse enters the button area
        ImageIcon hoverImage = new ImageIcon(ClassLoader.getSystemResource("icons/random6.png"));
        Image i1 = hoverImage.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon hoverResizeImage = new ImageIcon(i1);
        l6.setIcon(hoverResizeImage);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Change the JLabel image back to the original image when the mouse exits the button area
        ImageIcon originalImage = new ImageIcon(ClassLoader.getSystemResource("icons/random2.png"));
        Image i1 = originalImage.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon originalResizeImage = new ImageIcon(i1);
        l6.setIcon(originalResizeImage);
    }
});
        

	JLabel l5 = new JLabel("Do not Worry!!!");
	l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	l5.setForeground(new Color(255, 0, 0));
	l5.setBounds(70, 235, 110, 20);
	panel.add(l5);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(255, 255, 204));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);
	}
        
  public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == b1){
        if(textField.getText().isEmpty() || passwordField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Abey Anpar Gavar..");
        } else {
            Boolean status = false;
            try {
                Conn con = new Conn();
                String sql = "select * from account where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new Loading(textField.getText()).setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Incorect data PaglaChoda!");

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
            if(ae.getSource() == b2){
                setVisible(false);
		Signup su = new Signup();
		su.setVisible(true);
            }   
            if(ae.getSource() == b3){
                setVisible(false);
		ForgotPassword forgot = new ForgotPassword();
		forgot.setVisible(true);
            }
        }
        
  	public static void main(String[] args) {
                new Login().setVisible(true);
	}

}