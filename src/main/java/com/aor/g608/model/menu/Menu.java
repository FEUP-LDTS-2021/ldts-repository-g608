package com.aor.g608.model.menu;

import com.aor.g608.Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<Button> options;
    protected int selected;
    protected Game game;

    public Menu(Game game) throws IOException{
        this.game = game;
        options = new ArrayList<>();
        selected = 0;
    }

    public void addOption(Button newButton){
        options.add(newButton);
    }

    public List<Button> getOptions(){
        return this.options;
    }

    public int getNumberOptions(){
        return this.options.size();
    }

    public int getSelected() {
        return selected % options.size();
    }

    public Button getSelectedButton() {
        return this.options.get(getSelected());
    }

    public void nextOption() {
        getSelectedButton().setActive(false);
        selected++;
        getSelectedButton().setActive(true);
    }

    public void previousOption(){
        getSelectedButton().setActive(false);
        selected--;
        if(selected < 0)
            selected = options.size() - 1;
        getSelectedButton().setActive(true);
    }
}
