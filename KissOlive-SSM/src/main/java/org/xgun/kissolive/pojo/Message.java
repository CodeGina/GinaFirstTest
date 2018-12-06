package org.xgun.kissolive.pojo;

import java.util.Objects;

public class Message {
    private int mid;
    private String title;
    private String content;
    private String receive;

    public Message() {
    }

    public Message(int mid, String title, String content, String receive) {
        this.mid = mid;
        this.title = title;
        this.content = content;
        this.receive = receive;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    @Override
    public String toString() {
        return "Message{" +
                "mid=" + mid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", receive='" + receive + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return getMid() == message.getMid() &&
                Objects.equals(getTitle(), message.getTitle()) &&
                Objects.equals(getContent(), message.getContent()) &&
                Objects.equals(getReceive(), message.getReceive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMid(), getTitle(), getContent(), getReceive());
    }
}
