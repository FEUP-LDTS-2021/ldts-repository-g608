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

public class LanternaGUI implements GUI{
    private TerminalScreen screen;
    private int width;
    private int height;


    public LanternaGUI() throws IOException, FontFormatException {
        AWTTerminalFontConfiguration fontConfiguration = loadOverkillFont();
        Terminal terminal = createTerminal(20, 60, fontConfiguration);
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

    public TerminalScreen createScreen(Terminal terminal) throws IOException {
        final TerminalScreen terminalScreen;
        terminalScreen = new TerminalScreen(terminal);

        terminalScreen.setCursorPosition(null);
        terminalScreen.startScreen();
        terminalScreen.doResizeIfNecessary();
        return terminalScreen;
    }

    public AWTTerminalFontConfiguration loadOverkillFont() throws FontFormatException, IOException{
        File fontFile = new File("src/main/resources/fonts/PAC-FONT.TTF");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }


    @Override
    public TextGraphics createTextGraphics() {
        return null;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void clear() throws IOException {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public void drawBackground(TextGraphics textGraphics, String color) {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.width, this.height), ' ');

    }

    @Override
    public void drawRectangle(TextGraphics textGraphics, String color, int width, int height, Position position) {
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(color));
        textGraphics.fillRectangle(new TerminalPosition(position.getX(), position.getY()), new TerminalSize(width, height), ' ');
    }

    @Override
    public void drawButton(Position position, String text, String textColor, int width, int height) {

    }

    @Override
    public void drawGhosts(Position position, String colors) {
        drawText( screen.newTextGraphics() , position, "m", colors);
    }

    @Override
    public void drawPacman(Position position, String color) {
        drawText( screen.newTextGraphics() , position, "m", color);
    }

    @Override
    public void drawWall(Position position, String color) {

    }

    @Override
    public void drawPellet(Position position, String color) {

    }

    @Override
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
