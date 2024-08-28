package com.demo;

public class Java13Features {

    public static void run() {
        textBlocks();
    }

    private static void textBlocks() {
        System.out.println("Text Blocks demo");

        String html = """
                <html>
                    <body>
                        <h1>Hello, World!</h1>
                    </body>
                </html>
                """;

        System.out.println("HTML Content:\n" + html);
    }
}