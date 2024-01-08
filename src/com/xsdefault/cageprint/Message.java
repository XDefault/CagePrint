package com.xsdefault.cageprint;

public class Message {

    /**
     * Message to be display on the console
     */
    public Object messageObject;
    /**
     * Alignment of the message relative to the box
     */
    public CagePrint.Align align;
    /**
     * Color of the message to be displayed
     */
    public String Color;

    public Message(Object messageObject, CagePrint.Align align, String color) {
        this.messageObject = messageObject;
        this.align = align;
        this.Color = color;
    }
}
