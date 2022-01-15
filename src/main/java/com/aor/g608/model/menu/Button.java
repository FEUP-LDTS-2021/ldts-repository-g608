package com.aor.g608.model.menu;

import com.aor.g608.Element;
import com.aor.g608.model.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Button extends Element{
    private String color;
    private int width;
    private int height;
    private String text;
    private Position textPosition;

    private List<String> colors;

    public Button(Position position, String text, List<String> colors){
        super(position, colors.get(0));
        this.text = text;
        this.textPosition = position;
        this.colors = colors;

    }

    public String Color() {
        return color;
    }

    public Position getTextPosition() {
        return textPosition;
    }

    @Override
    public void draw(TextGraphics screen) {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    

    public void styleButton(JButton btn, int x1, int x2, int x3, int x4, int size){
        btn.setFont(new Font("Cooper Black", Font.PLAIN, size));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(51, 51, 0));
        btn.setBounds(x1, x2, x3, x4);
    }
}
