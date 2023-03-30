package ro.java.ctrln.practice.lambda;

import ro.java.ctrln.practice.PracticeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VideoGameSorted {
    public static void main(String[] args) {
        ArrayList<VideoGame> videoGames = PracticeUtils.getVideoGames();

                                       //Comparatorul ca o expresie lamnda//
        videoGames.sort((gameOne, gameTwo) -> Double.compare(gameOne.getRating(),gameTwo.getRating()));

        System.out.println("Sortarea jocurilot prin rating cu o expresie lambda:");
        for (VideoGame videoGame : videoGames) {
            System.out.println(videoGame);
        }
        Collections.shuffle(videoGames);
        System.out.println("Jocurile amestecate cu shuffle0:"+videoGames);

                    //Comparatorul ca referinta "::" catre metoda getRating
        //videoGames.sort(Comparator.comparingDouble(VideoGame::getRating));

                    //Pentru nume nu mai merge cu comparingDouble ci doar cu "comparing"
        videoGames.sort(Comparator.comparing(VideoGame::getName));

        System.out.println("Sortarea jocurilot prin rating cu referinta catre metoda getRating:");
        for (VideoGame videoGame : videoGames) {
            System.out.println(videoGame);
        }
        Collections.shuffle(videoGames);
        System.out.println("Jocurile amestecate cu shuffle1:"+videoGames);

        List<VideoGame> videoGameSorted = videoGames
                .stream()
                .sorted(Comparator.comparing(VideoGame::getName))
                .collect(Collectors.toList());
        for (VideoGame videoGame:videoGameSorted) {
            System.out.println(videoGame);
        }
    }
}