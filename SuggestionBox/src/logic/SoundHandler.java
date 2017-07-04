
package logic;

import gui.MainClass;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author Adam Whittaker
 */
public class SoundHandler{
    
    public static void playRandomButtonSound(float f){
        File file = new File("sounds/button" + 
                MainClass.r.nextInt(6) + ".wav");
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            FloatControl gainControl = 
            (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    gainControl.setValue(-f); //Reduce volume by f decibels
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/1000);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public static synchronized void playLoop(float f){
        File file = new File("sounds/Ending.wav");
        new Thread(
                () -> {
                    try{
                        while(true){
                            Clip clip = AudioSystem.getClip();
                            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                                file);
                            clip.open(inputStream);
                            FloatControl gainControl =
                                    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                            gainControl.setValue(-f); //Reduce volume by f decibels
                            clip.start();
                            Thread.sleep(clip.getMicrosecondLength()/1000);
                            clip.close();
                        }
                    }catch(Exception e){
                        System.err.println(e.getMessage());
                    }
        } // The wrapper thread is unnecessary, unless it blocks on the
        // Clip finishing; see comments.
        ).start();
    }
    
}
