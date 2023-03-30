package ro.java.ctrln.practice.pipelines;

import ro.java.ctrln.practice.PracticeUtils;
import ro.java.ctrln.practice.lambda.Platform;
import ro.java.ctrln.practice.lambda.VideoGame;

import java.util.*;
import java.util.stream.Collectors;

public class Pipelines {
    public static void main(String[] args) {
        ArrayList<VideoGame> videoGames = PracticeUtils.getVideoGames();
        System.out.println("Jocurile mai mari decit 7 ☺");
        videoGames.stream()
                .filter(videoGame -> videoGame.getRating() > 7)
                .forEach(System.out::println);

        Optional<VideoGame> optionalVideoGame1 = videoGames.stream()
                .max(Comparator.comparing(VideoGame::getRating));

        Optional<VideoGame> optionalVideoGame = videoGames.stream()
                .min(Comparator.comparing(VideoGame::getRating));

        if (optionalVideoGame1.isPresent()) {
            System.out.println("Jocul cu cel mai mare rating este: " + optionalVideoGame1.get().getName() + (" cu rating ") + optionalVideoGame1.get().getRating());//get(). intoarce obiectul VideoGame

            //aici este aceasi functie doar ca mai simplificata, mai eleganta// inloc de isPresent este ifPresent
            optionalVideoGame.ifPresent(videoGame -> System.out.println("Jocul cu cel mai mic rating este: " + videoGame.getName() + (" cu rating ") + videoGame.getRating()));
        }
        //Media virstelor studentilor
        double averageRating = videoGames.stream()
//                .filter(student -> student.getRating() < 50)
                .mapToDouble(videoGame -> videoGame.getRating())
                .average()
                .getAsDouble();
        System.out.println("Media ratingului este " + averageRating);

        long count = videoGames.stream().filter(ratingMax -> ratingMax.getRating() > 9).count();
        System.out.println(count + " jocuri au ratingul mai mare decit '9'");
                                                                                //sau//(VideoGame::getRating())//lambda cu referinta la metoda
        DoubleSummaryStatistics statistics = videoGames.stream().mapToDouble(videoGame -> videoGame.getRating()).summaryStatistics();
        System.out.println("Statistics - min rating este: " + statistics.getMin());
        System.out.println("Statistic - max rating este: " + statistics.getMax());
        System.out.println("Statistic - media rating este: " + statistics.getAverage());

        List<String> videoGamesNames = videoGames.stream()
                .filter(videoGame -> videoGame.getPlatform().equals(Platform.PC))
                .map(VideoGame::getName)
                .collect(Collectors.toList());

        System.out.println("Lista cu numele jocurilor:");
        for (String videoGamesName : videoGamesNames) {
            System.out.println("Nume joc PC: " + videoGamesName);
        }

        videoGamesNames = videoGames
                .stream()
                .filter(videoGame -> videoGame.getPlatform().equals(Platform.MOBILE))
                .map(VideoGame::getName)
                .collect(Collectors.toList());
        for (String videoGamesName : videoGamesNames) {
            System.out.println("Nume joc MOBILE: " + videoGamesName);
        }


    }
}

