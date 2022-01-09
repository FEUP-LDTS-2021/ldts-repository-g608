package com.aor.g608.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LanternaGUI{

    public LanternaGUI() throws IOException, FontFormatException {
        createTerminal(20, 60, loadOverkillFont());
    }

    public Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);

        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        ((AWTTerminalFrame)terminal).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        Image image = Toolkit.getDefaultToolkit().getImage("src/main/resources/fonts/cursor.png");
        ((AWTTerminalFrame)terminal).setCursor(Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(32, 22), "img"));
        return terminal;
    }

    public AWTTerminalFontConfiguration loadOverkillFont() throws FontFormatException, IOException{
        File fontFile = new File("src/main/resources/fonts/PAC-FONT.TTF");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }


}
