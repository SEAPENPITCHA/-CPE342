
package MyUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

   public class Stack_UI extends JFrame 
   {
	
      Stack<Student> stack = new Stack<>();
    
      private JTextArea displayStudent ;
    
         JLabel sizeLabel   = new JLabel("Size:0");
         JTextField idField = new JTextField(5);
         JTextField fField  = new JTextField(5);
         JTextField lField  = new JTextField(5);
         JTextField gpaField = new JTextField(5);
         JButton pushButton  = new JButton("Push");
         JButton popButton   = new JButton("Pop");
         JButton sortButton  = new JButton("Sort");

      public Stack_UI() {
    	  
          displayStudent    = new JTextArea();
          JPanel mainPanel  = new JPanel();
          mainPanel.setLayout(new BorderLayout());
          JPanel inputPanel = new JPanel();
          inputPanel.setLayout(new GridLayout(5,2));
          inputPanel.add(new JLabel("ID : "));
          inputPanel.add(idField);
          
          inputPanel.add(new JLabel("First Name :"));
          inputPanel.add(fField);
          
          inputPanel.add(new JLabel("Last Name :"));
          inputPanel.add(lField);
          
          inputPanel.add(new JLabel("GPA :"));
          inputPanel.add(gpaField);
         
          inputPanel.add(sizeLabel);

          JPanel buttonPanel = new JPanel();
          buttonPanel.add(pushButton);
          buttonPanel.add(popButton);
          buttonPanel.add(sortButton);

          mainPanel.add(inputPanel,BorderLayout.NORTH);
          mainPanel.add(buttonPanel,BorderLayout.CENTER);
          mainPanel.add(displayStudent,BorderLayout.SOUTH);

          setTitle("Stack Display");
          setSize(250, 250);
          setContentPane(mainPanel);
          setVisible(true);

          pushButton.addActionListener(e -> {
        	
              String id = idField.getText();
              String firstName = fField.getText();
              String lastName  = lField.getText();
              double gpa = Double.parseDouble(gpaField.getText());

              Student student = new Student(id,firstName,lastName,gpa);
            stack.push(student);
            updateDisplay();  
            });

          popButton.addActionListener(e -> {
        	  
            stack.pop();
            updateDisplay();
             });

          sortButton.addActionListener(e -> {
        	  
            stack.sort(Comparator.comparing(Student:: getGPA ));
            updateDisplay();
             });
    }
    
         private void updateDisplay() {
    	
            displayStudent.setText("");
            
                  for (int i = stack.size() - 1; i>=0; i--) {
                      Student student = stack.items.get(i);
                      String text = String.format("ID: %s name: %s %s Gpa: %.2f\n",
                      student.getID(),student.getFirstName(),student.getLastName(),student.getGPA());
                    
            displayStudent.append(text);
            
                  int size = stack.size();
                    sizeLabel.setText( "Size: " + size );
                    String x = stack.toString();
                    System.out.println(x);
         }
     }
}