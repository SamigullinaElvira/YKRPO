package com.example.myapplication.objects;

public class PostData {
    private String text;
    private String time;

    public PostData(String time, String text) {
        this.time = time;
        this.text = text;
    }
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PostData other = (PostData) obj;
        return text.equals(other.text) && time.equals(other.time);
    }
}
