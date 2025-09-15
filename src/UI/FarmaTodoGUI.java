package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import model.Order;
import model.Product;
import java.util.List;
import model.FilesLoader;
import java.time.LocalDate;


public class FarmaTodoGUI extends JFrame{
    private JList<String> productList;
    private DefaultListModel<String> listModel;
    private JTextArea cartArea;
    private Order order;
    private List<Product>catalog;

    public FarmaTodoGUI(){

        setTitle("Farma Todo - Shopping Cart");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        //Loading Products
        catalog=FilesLoader.LoadProducts("src/catalog.txt");
        order=new Order(101, LocalDate.now());

        //Catalog Panel
        listModel=new DefaultListModel<>();
        for (Product p : catalog) {
            listModel.addElement(p.getPro_id()+" - "+p.getPro_name()+" - "+" Stock: "+p.getPro_stock()+" - "+p.getPro_expirarion()+" - ($"+p.getPro_price()+")");
        }

        productList=new JList<>(listModel);

        JScrollPane scrollCatalog=new JScrollPane(productList);

        JButton addButton=new JButton("Add to cart");
        addButton.addActionListener((ActionEvent e)->{
            int selectProduct=productList.getSelectedIndex();
            if (selectProduct!=-1) {
                Product product=catalog.get(selectProduct);
                order.AddProduct(product);
                cartArea.append(product.getPro_name()+ "- ($"+product.getPro_price()+") \n");
            }
        });


        JPanel leftPanel=new JPanel(new BorderLayout());
        leftPanel.add(new JLabel("Product Catalog: "),BorderLayout.NORTH);
        leftPanel.add(scrollCatalog, BorderLayout.CENTER);
        leftPanel.add(addButton, BorderLayout.SOUTH);
        

        //Cart Panel
        cartArea = new JTextArea();
        cartArea.setEditable(false);
        JScrollPane ScrollCart=new JScrollPane(cartArea);

        JPanel rightPanel=new JPanel(new BorderLayout());
        rightPanel.add(new JLabel("Shopping Cart"), BorderLayout.NORTH);
        rightPanel.add(ScrollCart, BorderLayout.CENTER);

        JButton checkoutButton=new JButton("End Purchase");
        checkoutButton.addActionListener((ActionEvent e)->{
            cartArea.append(order.getOrderDetails());
        });
        rightPanel.add(checkoutButton,BorderLayout.SOUTH);


        JButton backButton=new JButton("Back"); //Back Button
        backButton.addActionListener(e->{
            new MainMenuGUI().setVisible(true);
            this.dispose();
        });
        rightPanel.add(backButton,BorderLayout.SOUTH);

        //Back Panel
        JPanel buttonsPanel=new JPanel(new FlowLayout());
        buttonsPanel.add(checkoutButton);
        buttonsPanel.add(backButton);    

        rightPanel.add(buttonsPanel, BorderLayout.SOUTH);
    
        //Dividir la pantalla en dos
        add(leftPanel,BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    } 

    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            new FarmaTodoGUI().setVisible(true);
        });
    }
}