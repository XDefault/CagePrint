package com.xsdefault.cageprint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CagePrint {

    /**
     * @implNote LEFT - align the text on the left side of the box.
     *           MIDDLE - align the text in the middle of the box.
     *           RIGHT - align the text on the right side of the box.
     */
    public enum Align{
        LEFT,
        MIDDLE,
        RIGHT
    }

    /**
     * @implNote Defines the chars that will be used to draw the box.
     * Ceil/Ground and walls respectively.
     */
    public static char[] DrawChars = {'=','|'};

    /**
     * @implNote The current list of messages to render on the console.
     */
    private static final List<Message> itemsToDraw = new ArrayList<>();

    /**
     * @implNote The size of the biggest message to be rendered.
     */
    private static int longestLineLength = 0;

    /**
     * @implNote The color that will be used if none is specified in the message creation.
     */
    public static String defaultTextColor = Colors.WHITE;

    /**
     * @implNote The color that the cage will be drawn in the current render.
     */
    public static String cageColor = Colors.WHITE;

    /**
     * @implNote String Builder for the ceil/ground parts of the cage.
     */
    private static final StringBuilder ceilNGroundStringBuilder = new StringBuilder();

    /**
     * @implNote Adds extra chars to both sides of the text or is added twice in case the message is not centered.
     */
    public static int paddingAmount = 20;

    /**
     * @implNote Gets the biggest message length and add the defined offset(DEFAULT=20).
     */
    private static void getLineSizeOffset(){

        for (Message msg : itemsToDraw){
            int size;
            size = msg.messageObject.toString().length();

            if(size > longestLineLength){
                longestLineLength = size - 1;
            }
        }

        longestLineLength += paddingAmount;
    }

    /**
     * @implNote Builds the ceil/ground of the cage by repeating the char in the first position of the DrawChars array.
     */
    private static void buildTopBottomLines() {
        ceilNGroundStringBuilder.append(String.valueOf(DrawChars[0]).repeat(longestLineLength + 3));
    }

    /**
     * @implNote Render the list of messages with the box cage to the console.
     */
    public static void drawScreen(){
        getLineSizeOffset();
        buildTopBottomLines();

        //Ceil
        System.out.println("\n" + cageColor + ceilNGroundStringBuilder + Colors.WHITE);

        drawItems();

        //Ground
        System.out.println(cageColor + ceilNGroundStringBuilder + Colors.WHITE + "\n");
    }

    /**
     * @implNote Goes through the list of messages while rendering then with the wall char.
     */
    private static void drawItems() {
        for (Message msg : itemsToDraw) {
            printItemInPosition(msg.messageObject, getPadding(msg), msg.align, msg.Color);
        }
    }

    /**
     * @param msg Message to be rendered on the console
     * @return String
     * @implNote Calculate the amount of padding necessary and return a string with the padding created
     */
    private static String getPadding(Message msg) {
        int msgLength;
        int paddingLength;
        String padding;
        msgLength = msg.messageObject.toString().length();
        paddingLength = (int)Math.floor((double) (longestLineLength - msgLength) / 2 + 1);
        if(paddingLength < 0) paddingLength = 0;

        if(msgLength % 2 == 0){
            if(msg.align == Align.RIGHT){
                msg.messageObject = " " + msg.messageObject;
            }
            else msg.messageObject +=" ";
        }
        padding = String.join("", Collections.nCopies(paddingLength, " "));
        return padding;
    }

    /**
     * @param obj message to be rendered
     * @param padding string to padding the message with the walls
     * @param alignment which position relative to the box to render the message
     * @param color which color to render the message
     * @param <T> type of the message to be rendered
     * @implNote Render the item to the console with the alignment specified.
     */
    private static <T> void printItemInPosition(T obj, String padding, Align alignment, String color) {
        String boxWalls = String.valueOf(DrawChars[1]);
        switch (alignment) {
            case LEFT -> System.out.println(cageColor + boxWalls + color + obj + Colors.WHITE + padding + padding + cageColor + boxWalls + Colors.WHITE);
            case MIDDLE -> System.out.println(cageColor + boxWalls + Colors.WHITE + padding + color + obj + Colors.WHITE + padding + cageColor + boxWalls + Colors.WHITE);
            case RIGHT -> System.out.println(cageColor + boxWalls + Colors.WHITE + padding + padding + color + obj + cageColor + boxWalls + Colors.WHITE);
        }

    }

    /**
     * @param item item to add as message to be rendered
     * @param align alignment of the message
     * @param color color of the message
     * @param <T> type of the message item
     * @implNote Create a message to be rendered in the cage.
     */
    @SuppressWarnings("unchecked")
    public static <T> void addItemToDraw(T item, Align align, String color){
        if(item == null){
            item = (T)"null";
        }
        Message message = new Message(item,align,color);
        itemsToDraw.add(message);
    }

    /**
     * @param item item to add as a message to be rendered
     * @param align alignment of the message
     * @param <T> type of the message item
     * @implNote Create a message to be rendered in the cage with the default color configuration.
     */
    @SuppressWarnings("unchecked")
    public static <T> void addItemToDraw(T item, Align align){
        if(item == null){
            item = (T)"null";
        }
        Message message = new Message(item,align, defaultTextColor);
        itemsToDraw.add(message);
    }

    /**
     * @implNote Clears the list of messages to be rendered
     */
    public static void clearItems(){
        itemsToDraw.clear();
    }
}