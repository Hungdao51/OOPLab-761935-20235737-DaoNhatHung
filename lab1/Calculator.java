import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog("Enter 1st number:");
        double num1 = Double.parseDouble(strNum1);
        
        String strNum2 = JOptionPane.showInputDialog("Enter 2nd number:");
        double num2 = Double.parseDouble(strNum2);
        
        String operator = JOptionPane.showInputDialog("Choose an operator (+, -, *, /):");
        
        double result = 0;
        boolean validOperation = true;
        
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot divide by zero.", "Error", JOptionPane.ERROR_MESSAGE);
                    validOperation = false;
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid operator!", "Error", JOptionPane.ERROR_MESSAGE);
                validOperation = false;
        }
        
        if (validOperation) {
            String equation = num1 + " " + operator + " " + num2 + " = " + result;
            JOptionPane.showMessageDialog(null, "Result: " + result + "\n" + equation, "Calculation Result", JOptionPane.INFORMATION_MESSAGE);
        }
        
        System.exit(0);
    }
}
