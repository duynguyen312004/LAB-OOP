import javax.swing.JOptionPane;
public class HelloNameDialog {
	public static void main(String[] args) {
		String result;
		result = JOptionPane.showInputDialog("Please Enter Your Name:");
		JOptionPane.showMessageDialog(null, "Hello World! How are you?");
		System.exit(0);
	}
}
