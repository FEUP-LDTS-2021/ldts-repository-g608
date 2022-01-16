package com.aor.g608.gui;

import com.aor.g608.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LanternaGUI {
    private TerminalScreen screen;
    private int width;
    private int height;


    public LanternaGUI(int width, int height) throws IOException, FontFormatException {
        this.height = height;
        this.width = width;
        AWTTerminalFontConfiguration fontConfiguration = loadOverkillFont();
        Terminal terminal = createTerminal(width, height, fontConfiguration);
        this.screen = createScreen(terminal);
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

    public TerminalScreen getScreen() {
        return screen;
    }

    public TerminalScreen createScreen(Terminal terminal) throws IOException {
        final TerminalScreen terminalScreen;
        terminalScreen = new TerminalScreen(terminal);

        terminalScreen.setCursorPosition(null);
        terminalScreen.startScreen();
        terminalScreen.doResizeIfNecessary();
        return terminalScreen;
    }


    public AWTTerminalFontConfiguration loadOverkillFont() throws FontFormatException, IOException{
        File fontFile = new File("src/main/resources/fonts/square.TTF");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }


    public TextGraphics createTextGraphics() {
        return screen.newTextGraphics();
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void clear() throws IOException {
        screen.clear();
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public void close() throws IOException {
        screen.close();
    }

    public void drawBackground(TextGraphics textGraphics, String color) {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.width, this.height), ' ');

    }

    public void drawRectangle(TextGraphics textGraphics, String color, int width, int height, Position position) {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.fillRectangle(new TerminalPosition(position.getX(), position.getY()), new TerminalSize(width, height), ' ');
    }


    public void drawButton(Position position, String text, String textColor, int width, int height) {
        TextGraphics textGraphics = screen.newTextGraphics();
        drawText(textGraphics, position, text, textColor);
    }

    public void drawGhosts(Position position, String colors) {
        drawText( screen.newTextGraphics() , position, "m", colors);
    }

    public void drawPacman(Position position, String color) {
        drawText( screen.newTextGraphics() , position, "c", color);
    }

    public void drawWall(Position position, String color) {

    }


    public void drawPellet(Position position, String color) {

    }

    public void drawTitle(Position position, String text, String color, String colorText) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        drawText(textGraphics, position, text,colorText);
    }

    private void drawText(TextGraphics textGraphics, Position position, String text, String color) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(position.getX(),position.getY(),text);
    }
}
