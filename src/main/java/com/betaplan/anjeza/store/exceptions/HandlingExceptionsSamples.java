package com.betaplan.anjeza.store.exceptions;

public class HandlingExceptionsSamples {

    // try - ekziston mundesia qe te hidhet nje exception
    // catch - handle nje exception te nje tipi specifik
    // finally - ekzekutohet gjithmone(!)

    public static void main(String[] args) {

        System.out.println("Para therritjes se metodes ndihmese");
        try {
            ExceptionSamples.nullPointerException();
//        } catch(NullPointerException e) {
//            System.out.println("Ndodhi nje problem gjate leximit te te dhenave te kategorise");
        }
        finally {
            System.out.println("Ekzekutohet kur hidhet ose jo nje exception");
        }
        // TODO pse nuk ekzekutohet ky statement nese exception nuk behet handle?
        System.out.println("Pas therritjes se metodes ndihmese");
    }
}
