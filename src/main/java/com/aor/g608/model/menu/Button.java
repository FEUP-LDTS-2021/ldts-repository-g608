package com.aor.g608.model.menu;

import com.aor.g608.Element;
import com.aor.g608.command.ButtonCommand;
import com.aor.g608.command.Command;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Button extends Element implements GUI{
    private String color;
    private int width;
    private int height;
    private Command command;
    private boolean active;
    private String text;
    private Position textPosition;
    private ButtonCommand action;

    private List<String> colors;

    public Button(Position position, String text, List<String> colors){
        super(position, colors.get(0));
        this.text = text;
        this.textPosition = position;
        this.colors = colors;
        this.active = false;
    }

    public Button(Position position, String text, Command command, String color){
        super(position, color);
        this.command = command;
        this.position = position;
        this.text = text;
        this.color = color;
    }


    @Override
    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString(color));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), text);
    }

    public String Color() {
        return color;
    }

    public Position getTextPosition() {
        return textPosition;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAction(ButtonCommand action) {
        this.action = action;
    }
    
    /*
    public void styleButton(JButton btn, int x1, int x2, int x3, int x4, int size){
        btn.setFont(new Font("Cooper Black", Font.PLAIN, size));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(51, 51, 0));
        btn.setBounds(x1, x2, x3, x4);
    }
     */
}
