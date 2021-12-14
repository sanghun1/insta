package com.cos.insta_ui.data;

public class StoryData {

    private int story_image;
    private int story_image_bg;
    private String story_username;

    public StoryData(int story_image, int story_image_bg, String story_username) {
        this.story_image = story_image;
        this.story_image_bg = story_image_bg;
        this.story_username = story_username;
    }

    public int getStory_image() {
        return story_image;
    }

    public void setStory_image(int story_image) {
        this.story_image = story_image;
    }

    public int getStory_image_bg() {
        return story_image_bg;
    }

    public void setStory_image_bg(int story_image_bg) {
        this.story_image_bg = story_image_bg;
    }

    public String getStory_username() {
        return story_username;
    }

    public void setStory_username(String story_username) {
        this.story_username = story_username;
    }
}
