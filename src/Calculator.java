
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    public JFrame frame;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JTextField textField;
    JPanel panel;

    JButton addButton,subButton,mulButton,divButton;
    JButton clrButton, delButton,decButton,eqButton,negButton;

    double num1=0, num2=0, result=0;
    char operator;

    Font font = new Font("Zilla Slab Bold", Font.PLAIN, 30);
    Font funFont = new Font("Zilla Slab Bold", Font.PLAIN, 20);

    Calculator(){
        frame = new JFrame();
        frame.setSize(new Dimension(700,1000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Calculator");
        frame.getContentPane().setBackground(new Color(0x018F9C));

        textField = new JTextField();
        textField.setBounds(50,25,600,150);
        textField.setFont(font);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("/");
        mulButton = new JButton("*");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        clrButton = new JButton("Clear");
        delButton = new JButton("Delete");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = divButton;
        functionButtons[3] = mulButton;
        functionButtons[4] = eqButton;
        functionButtons[5] = decButton;
        functionButtons[6] = clrButton;
        functionButtons[7] = delButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBorder(new RoundedBorder(60));
            functionButtons[i].setBackground(new Color(0x018F9C));
            functionButtons[i].setForeground(new Color(0xFE7B72));
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBorder(new RoundedBorder(60));
            numberButtons[i].setBackground(new Color(0x018F9C));
            numberButtons[i].setForeground(new Color(0xFE7B72));

        }
        negButton.setFont(funFont);
        clrButton.setFont(funFont);
        delButton.setFont(funFont);
        negButton.setBounds(50,850,190,100);
        delButton.setBounds(255,850,190,100);
        clrButton.setBounds(460,850,190,100);

        panel = new JPanel();
        panel.setBounds(50,200,600,600);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(new Color(0x018F9C));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(eqButton);
        panel.add(divButton);

        frame.add(textField);
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource()==negButton){
            double temp = Double.parseDouble(textField.getText());
            temp = temp * -1;
            textField.setText(String.valueOf(temp));
        }

        if (e.getSource()==eqButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource()==clrButton){
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
    }
}
