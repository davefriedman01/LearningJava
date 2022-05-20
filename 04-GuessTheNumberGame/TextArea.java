import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TextArea extends JFrame {
  private final JTextArea ta1;
  private final JTextArea ta2;
  private final JButton c_jb;

  public TextArea () {
    super("TextArea Demo");
    Box b=Box.createHorizontalBox();
    String d="This is a demo string to illustrate copying text from one textarea to another textarea using an external event";
    ta1=new JTextArea(d,10,15);
    b.add(new JScrollPane(ta1));
    c_jb=new JButton("Copy >>>");
    b.add(c_jb);
    c_jb.addActionListener(
      new ActionListener () {
        @Override
        public void actionPerformed (ActionEvent e) {
          ta2.setText(ta1.getSelectedText());
        }
      }
    );
    ta2=new JTextArea(10,15);
    ta2.setEditable(false);
    b.add(new JScrollPane(ta2));
    add(b);
  }

  public static void main (String[] args) {
    TextArea ta=new TextArea();
    ta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ta.setSize(425,200);
    ta.setVisible(true);
  }
}
