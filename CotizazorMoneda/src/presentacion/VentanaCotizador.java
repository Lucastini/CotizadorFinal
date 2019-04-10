package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import negocio.CalculoCotizacion;

public class VentanaCotizador extends JFrame {
    private JLabel lblCotizacion;
    private JTextField txtValorCotizacion;
    private JLabel lblPesos;
    private JTextField txtValorPesos;
    private JLabel lblDolares;
    private JTextField txtValorDolares;
    private JButton btnConvertir;
    private JButton btnLimpiar;
    private CalculoCotizacion calculo;
    
    public VentanaCotizador(){
        this.setTitle("Cotizador");
        this.setSize(350, 220);
        this.setLayout(null);
        this.setLocation(500, 50);
        this.setResizable(false);
        //this.setEnabled(false);
        //this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        lblCotizacion=new JLabel("Cotizacion:");
        lblCotizacion.setSize(70, 30);
        lblCotizacion.setLocation(20, 20);
        this.getContentPane().add(lblCotizacion);
        txtValorCotizacion=new JTextField();
        txtValorCotizacion.setHorizontalAlignment(JTextField.RIGHT);
        txtValorCotizacion.setSize(60, 30);
        txtValorCotizacion.setLocation(100, 20);
        
        this.getContentPane().add(txtValorCotizacion);
        lblPesos=new JLabel("Pesos:");
        lblPesos.setSize(50, 30);
        lblPesos.setLocation(180, 20);
        this.getContentPane().add(lblPesos);
        
        txtValorPesos=new JTextField();
        txtValorPesos.setHorizontalAlignment(JTextField.RIGHT);
        txtValorPesos.setSize(60, 30);
        txtValorPesos.setLocation(240, 20);
        txtValorPesos.addKeyListener(new EscuchadorValorPesos());
        
        this.getContentPane().add(txtValorPesos);
        lblDolares=new JLabel("Dolares:");
        lblDolares.setSize(60, 30);
        lblDolares.setLocation(180, 70);
        this.getContentPane().add(lblDolares);
        
        txtValorDolares=new JTextField();
        txtValorDolares.setHorizontalAlignment(JTextField.RIGHT);
        txtValorDolares.setSize(60, 30);
        txtValorDolares.setLocation(240, 70);
        txtValorDolares.addKeyListener(new EscuchadorValorDolares());
        
        this.getContentPane().add(txtValorDolares);
        btnConvertir=new JButton("Convertir");
        btnConvertir.setSize(90, 30);
        btnConvertir.setLocation(50, 120);
        this.getContentPane().add(btnConvertir);
        btnConvertir.addActionListener(new EscuchadorConvertir());
        
        btnLimpiar=new JButton("Limpiar");
        btnLimpiar.setSize(90, 30);
        btnLimpiar.setLocation(190, 120);
        this.getContentPane().add(btnLimpiar);
        btnLimpiar.addActionListener(new EscuchadorLimpiar());
        
        calculo=new CalculoCotizacion();
    }
    
    public String siVacioConvACero(String txt){
        String res=txt;
        if(txt.equals(""))
            res="0";
        return res;
    }
    
    
    class EscuchadorValorPesos extends KeyAdapter{
        @Override
        public void keyTyped(KeyEvent ke) {
            txtValorDolares.setEditable(false);
        }
    }
    class EscuchadorValorDolares extends KeyAdapter{
        @Override
        public void keyTyped(KeyEvent ke) {
            txtValorPesos.setEditable(false);
        } 
    }
    
    class EscuchadorConvertir implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                float valorPesos=Float.parseFloat(siVacioConvACero(txtValorPesos.getText()));
                float valorDolares=Float.parseFloat(siVacioConvACero(txtValorDolares.getText()));
                float valorCotizacion=Float.parseFloat(siVacioConvACero(txtValorCotizacion.getText()));
            if(valorCotizacion!=0&&(valorDolares!=0||valorPesos!=0)){
                calculo.setMontoPesos(valorPesos);
                calculo.setMontoDolares(valorDolares);
                calculo.setValorCotizacion(valorCotizacion);
                if(txtValorPesos.isEditable()){
                    txtValorPesos.setEditable(false);
                    txtValorCotizacion.setEditable(false);
                    txtValorDolares.setText(String.valueOf((float)(int)(calculo.calculoPesoADolar()*100)/100f));
                }
                else{
                    txtValorDolares.setEditable(false);
                    txtValorCotizacion.setEditable(false);
                    txtValorPesos.setText(String.valueOf((float)(int)(calculo.calculoDolarAPeso()*100)/100f));
                    
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Debe ingresar el valor de la cotizacion y al menos uno de los 2 valores para pesos o dolares");
        
            }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Debe ingresar solo valores numericos");
            }
        }
    }
    class EscuchadorLimpiar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            txtValorDolares.setText("");
            txtValorPesos.setText("");
            txtValorCotizacion.setText("");
            txtValorDolares.setEditable(true);
            txtValorPesos.setEditable(true);
            txtValorCotizacion.setEditable(true);
        }
        
    }
    
}
    
