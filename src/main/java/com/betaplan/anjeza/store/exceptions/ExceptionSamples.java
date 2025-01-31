package com.betaplan.anjeza.store.exceptions;

import com.betaplan.anjeza.store.dto.CategoryDTO;
import org.slf4j.*;

import java.util.Scanner;

public class ExceptionSamples {

    static Logger log = LoggerFactory.getLogger(ExceptionSamples.class);

    public static void main(String[] args) {
        log.info("----");
        log.warn("----");
        log.error("----");
        // input mismatch exception
//        inputMismatchException();
        // TODO array index out of bound exception
        // null pointer exception
        try {
            nullPointerException();
        } catch (Exception exception) {
            log.error("Nodhi nje problem me exckutimin e programit" + exception.getMessage());
        }
    }

    private static void inputMismatchException() {
        Scanner input = new Scanner(System.in);
        System.out.println("Me jep vitin e lindjes");
        int vitLindje = input.nextInt();
        System.out.println("Viti i lindjes se studentit eshte  " + vitLindje);
        input.close();
    }

    public static void nullPointerException() {// throws Exception {
        CategoryDTO category = null;
        System.out.println("Dua te printoj te dhenat e kategorise");
        System.out.println("Emri i kategorise eshte " + category.getDescription());
        System.out.println("Perfundova me printimin e te dhenave qe kam per kete kategori");

    }
}
