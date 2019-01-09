package org.techrecipes.online.springinjection.musicdomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.beans.ConstructorProperties;
@Component
public class Piano {
    @Autowired
    private Music rawMusic;
    private String numberOfKeys;
    @ConstructorProperties({"rawMusic", "pianoKeys"})
    public Piano(Music music, String numberOfKeys) {
        this.rawMusic = music;
        this.numberOfKeys = numberOfKeys;
    }
    @Override
    public String toString() {
        return "Piano{" +
                "pianoMusic=" + rawMusic +
                ", numberOfKeys='" + numberOfKeys + '\'' +
                '}';
    }
}
