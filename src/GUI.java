/**
 * Created by IntelliJ IDEA.
 * User: shanehudson
 * Date: 03/07/2012
 * Time: 14:32
 * To change this template use File | Settings | File Templates.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.border.MatteBorder;

public class GUI {
    JFrame frame;
    Container pane;

    public GUI()  {
        
        final Logic logic = new Logic();
        
        frame = new JFrame("Algorithms");
        pane = frame.getContentPane();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        final JTextArea data = new JTextArea(25, 25);
        data.setLineWrap(true);
        data.setMargin(new Insets(10, 10, 10, 10));

        final JScrollPane scrollPane = new JScrollPane(data);
        c.fill = GridBagConstraints.VERTICAL;
        pane.add(scrollPane, c);

        final JTextArea result = new JTextArea(25, 25);
        result.setEditable(false);
        result.setBorder(BorderFactory.createMatteBorder(0,1,0,0, Color.lightGray));
        result.setLineWrap(true);
        result.setMargin(new Insets(10, 10, 10, 10));
        final JScrollPane resultScrollPane = new JScrollPane(result);
        c.fill = GridBagConstraints.VERTICAL;
        pane.add(resultScrollPane, c);


        String[] algorithms =
                {   "Insertion Sort - jdb",
                        "Quick Sort - Shane Hudson",
                        "Quick Sort - jdb",
                        "Quick Sort - Blackcompe"
                };
        final JComboBox algoList = new JComboBox(algorithms);
        c.gridx = 1;
        c.gridy = 1;
        pane.add(algoList, c);

        JButton btnStart = new JButton("Start");
        c.gridx = 0;
        c.gridy = 1;
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logic.setData(data.getText());
                logic.setAlgorithm(algoList.getSelectedItem().toString());
                logic.start();
                result.setText(result.getText() + Arrays.toString(logic.getSorted()) + "\n");
            }
        });
        pane.add(btnStart, c);

        
        frame.pack();
        frame.setVisible(true);
    }
}
