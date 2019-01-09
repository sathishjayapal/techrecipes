package org.techrecipes.online.springinjection.musicdomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Music {
    @Autowired
    private String genre;
    public void setGenre(String genre) {
        this.genre = genre;
    }
    @Override
    public String toString() {
        return "Music{" + "Genre='" + genre + '\'' + '}';
    }
}
