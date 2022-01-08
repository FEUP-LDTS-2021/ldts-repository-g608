package com.aor.g608.viewer.game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class MusicPlayer {
    private Clip backgroundMusic;

    public MusicPlayer(){
        this.backgroundMusic = loadMusic();
    }

    private Clip loadMusic() throws NullPointerException{
        try{
            File musicFile = new File(MusicPlayer.class.getResource("/music/pacman_beginning.wav").getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return musicClip;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void startMusic() {
        backgroundMusic.setMicrosecondPosition(0);
        backgroundMusic.start();
    }
}

