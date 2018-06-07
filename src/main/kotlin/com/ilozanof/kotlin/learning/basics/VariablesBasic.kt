package com.ilozanof.kotlin.learning.basics

/**
 * Examples of variable declaration and initialization in Kotlin.
 * The following variables are IMMUTABLE variables, since we are
 * using the "val" keyword to declare them. they must be initilized
 * only ONCE after (or during) declaration.
 */

// A String variable
val question    = "What is the meaning of life?";

// An Integer variable
val answer      = 42;

// A Double variable
val yearsToCompute = 7.4;

// If you don't initialize the variable, you need to declare its type:
// Example: val number: Int;

// An example of an explicit cast
val word: String = yearsToCompute as String;


