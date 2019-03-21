package com.ua.rozetka.isakov.common;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonMethods {

    public static String jsonFileToString(File file) {
        String json = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static List<HashMap<String, String>> jsonFileToListOfHashMaps(File file) {
        Gson gson = new Gson();
        return gson.fromJson(
                jsonFileToString(file),
                new TypeToken<List<HashMap<String, String>>>() {

                }
                        .getType());
    }

    public static int randIntOfNow() {
        return DateTime.now().getMillisOfDay();
    }

    private static double randDouble() {
        return new Random().nextDouble();
    }

    public static int randInt(Integer bound) {
        return bound != null ? new Random().nextInt(bound) : new Random().nextInt();
    }

    public static List<String> genRandomString(int count, int length, boolean useLetters, boolean useNumbers) {
        return Stream
                .generate(
                        () -> RandomStringUtils
                                .random(length, useLetters, useNumbers))
                .limit(count)
                .collect(Collectors.toList());
    }

    public static String getPhoneString(String phoneOperatorCode) {
        return phoneOperatorCode + getStringFormattedByPattern("0000000");
    }

    private static String getStringFormattedByPattern(String pattern) {
        return new DecimalFormat(pattern).format(randDouble());
    }

    public static String getDateTime(String pattern) {
        DateTime date = DateTime.now();
        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        return date.toString(fmt);
    }
}