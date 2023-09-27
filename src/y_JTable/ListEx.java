package y_JTable;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class ListEx extends JFrame{
    String[] fruits={"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
    ListEx(){
        this.setTitle("리스트 만들기 예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
//        JList strList = new JList(fruits);
//        this.add(strList);
        
        JList scrollList = new JList(fruits);
        this.add(new JScrollPane(scrollList));
        
        this.setLocationRelativeTo(null);
        this.setSize(300,300);
        this.setVisible(true);
    }
}
