package org.techrecipes.online.springinjection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.techrecipes.online.springinjection.musicdomain.Music;
import org.techrecipes.online.springinjection.musicdomain.Piano;
public class MusicRunner {
    public static void main(String args[]) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MusicConfig.class);
        ctx.refresh();
        Piano piano = ctx.getBean("pianoMusic", Piano.class);
        System.out.println("Sathish Music :" + piano);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                "org/techrecipes/online/springinjection");
        Piano babyPiano = applicationContext.getBean("babyPianoMusic", Piano.class);
        Music rawMusic = applicationContext.getBean("rawMusic", Music.class);
        System.out.println("Sathish Music :" + rawMusic);
        System.out.println("Grand Piano :" + piano);
        System.out.println("Baby Piano :" + babyPiano);
    }
}
