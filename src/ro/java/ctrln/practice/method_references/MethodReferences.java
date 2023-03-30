package ro.java.ctrln.practice.method_references;

import ro.java.ctrln.practice.PracticeUtils;
import ro.java.ctrln.practice.lambda.Platform;
import ro.java.ctrln.practice.lambda.VideoGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class MethodReferences {
    public static void main(String[] args) {
//        ArrayList<VideoGame> videoGames = PracticeUtils.getVideoGames();
        ArrayList<VideoGame> videoGames = PracticeUtils.getVideoGamesByFactory();

        //Exemplul traditional pentru a face Game_1,Game_2,Game_3,Game_4,Game_5 //exemplul mai lung
        StringBuilder gameNames = new StringBuilder();
        for (VideoGame videoGame : videoGames) {
            gameNames.append(videoGame.getName()).append(",");
        }
        String finalTouchesGameNames = gameNames.substring(0, gameNames.toString().length() - 1);
        System.out.println("Numele jocurilor: " + finalTouchesGameNames);

        //Acelasi lucru de mai sus
        String videoGameNames = videoGames.stream()
                .map(VideoGame::getName)
                .collect(Collectors.joining(", "));//Exemplul cu Collectors pentru a face Game_1, Game_2, Game_3,... Exmplul mai scurt
        System.out.println("Numele jocurilor cu joining() " + videoGameNames);

        HashMap<Integer, VideoGame> videoGameHashMap = new HashMap<>();
        VideoGameFactory videoGameFactory = VideoGame::new;
        double rangeMin = 5;
        double rangeMax = 10;
        for (int i = 0; i < 5; i++) {
            videoGameHashMap.put(i, videoGameFactory.getVideoGame("Game" + (i + 1),
                    rangeMin + (rangeMax - rangeMin) * new Random()
                            .nextDouble(), Platform.PC));

        }
//        System.out.println(videoGameHashMap);

//        for (Map.Entry<Integer, VideoGame> videoGameEntry : videoGameHashMap.entrySet()) {
//            if (videoGameEntry.getValue().getRating() < 9) {
//                videoGameEntry.getValue().setRating(8.5);
//            }
        videoGameHashMap.replaceAll((key, value) -> {
            if (value.getRating() < 9) {
                value.setRating(6);
            }
            return value;
        });
        System.out.println(videoGameHashMap);
        videoGameHashMap.replaceAll((key, value) -> value.getRating() < 7 ? videoGameFactory.getVideoGame(value.getName(), 7, value.getPlatform()) : value);
        System.out.println(videoGameHashMap);

    }
}

