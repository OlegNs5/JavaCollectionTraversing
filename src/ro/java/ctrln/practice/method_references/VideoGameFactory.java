package ro.java.ctrln.practice.method_references;

import ro.java.ctrln.practice.lambda.Platform;
import ro.java.ctrln.practice.lambda.VideoGame;

@FunctionalInterface
public interface VideoGameFactory {
    public VideoGame getVideoGame(String name, double rating, Platform platform);
}
