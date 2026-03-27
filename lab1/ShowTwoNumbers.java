import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog(null, "Please input the first number:",
                "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        String strNum2 = JOptionPane.showInputDialog(null, "Please input the second number:",
                "Input the second number", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;

        JOptionPane.showMessageDialog(null, "The two numbers are: " + num1 + " and " + num2 + "\nTheir sum is: " + sum,
                "Show Two Numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
