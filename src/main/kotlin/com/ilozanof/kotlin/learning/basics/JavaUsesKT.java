package com.ilozanof.kotlin.learning.basics;

/**
 * This class implements some simple use cases where Kotlin Components are
 * used from Java.
 */
public class JavaUsesKT {

    public static void main(String ...args) {
        PersonKT personKT = new PersonKT("John Kotlin");
        System.out.println("Using the PersonKT " + personKT.getName());

        PersonMore personMore = new PersonMore("John More", false);
        personMore.setMarried(true);
        personMore.setSex("Man");
        System.out.println("Using the PersonMore " + personMore.getName()
                + " sex: " + personMore.getSex()
                + " married:" + personMore.isMarried());
    }
}
