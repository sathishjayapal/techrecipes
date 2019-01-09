package org.techrecipes.online.springinjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.techrecipes.online.springinjection.musicdomain.Music;
import org.techrecipes.online.springinjection.musicdomain.Piano;
@Configuration
@ComponentScan("org/techrecipes/online/springinjection")
public class MusicConfig {
    @Autowired
    Music rawMusic;
    @Autowired
    Music carnaticMusic;
    @Autowired
    Piano babyPianoMusic;
    @Autowired
    Piano pianoMusic;
    @Bean
    public String identifier(@Value("${genre:Generic}") String genre) {
        return genre;
    }
    @Bean(name = "rawMusic")
    @Value("#{genre}")
    public Music createMusic() {
        Music music = new Music();
        return music;
    }
    @Bean(name = "carnaticMusic")
    public Music createCarnaticMusic() {
        Music music = new Music();
        music.setGenre("Carnatic");
        return music;
    }
    @Bean(name = "pianoMusic")
    public Piano createPiano() {
        Piano piano = new Piano(rawMusic, "108");
        return piano;
    }
    @Bean(name = "babyPianoMusic")
    public Piano createBabyPiano() {
        Piano piano = new Piano(carnaticMusic, "88");
        return piano;
    }
}
