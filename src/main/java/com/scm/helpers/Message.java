package com.scm.helpers;


import lombok.*;

import java.awt.*;

//@Builder
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Message {
//
//    private String content;
//    @Builder.Default
//    private MessageType type = MessageType.blue;
//}


public class Message {

    private String content;
    private MessageType type;

    // No-argument constructor
    public Message() {
    }

    // Constructor with content and type
    public Message(String content, MessageType type) {
        this.content = content;
        this.type = type;
    }

    // Getter and setter methods
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}