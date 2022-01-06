package com.aor.g608.model.menu;

import javax.swing.*;
import java.awt.*;

public class Button extends JPanel{
    private String bgColor;

    public void setBgColor(String bgColor){ this.bgColor = bgColor;}

    public void styleButton(JButton btn, int x1, int x2, int x3, int x4, int size){
        btn.setFont(new Font("Cooper Black", Font.PLAIN, size));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(51, 51, 0));
        btn.setBounds(x1, x2, x3, x4);
        add(btn);
    }
}
