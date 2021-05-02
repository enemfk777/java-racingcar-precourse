package ui;

import dto.ParticipationForm;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Reception {

  private static final Pattern WHITE_SPACE = Pattern.compile("\\s");
  private static final Pattern COMMA = Pattern.compile(",");
  private static final String PLEASE_INPUT_INTEGER = "자연수로 입력 해 주세요.";
  private static final String PLEASE_INPUT_PARTICIPATION_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분).";
  public static final String HOW_MANY_LAP_COUNT = "시도할 회수는 몇회인가요?";
  private static final String EMPTY_STRING = "";

  private static final Scanner SCANNER = new Scanner(System.in);

  private Reception() {}

  public static ParticipationForm takeParticipationForm() {
    String[] attendeeNames = getAttendeeNames();
    int lapCount = getLapCount();
    return new ParticipationForm(attendeeNames, lapCount);
  }

  private static String[] getAttendeeNames() {
    System.out.println(PLEASE_INPUT_PARTICIPATION_NAME);
    String input = getStringValue();
    return splitByComma(input);
  }
  private static String[] splitByComma(String participationNames) {
    String striped = replaceWhiteSpaces(participationNames);
    return COMMA.split(striped);
  }

  private static String replaceWhiteSpaces(String participationNames) {
    return WHITE_SPACE.matcher(participationNames).replaceAll(EMPTY_STRING);
  }

  private static int getLapCount() {
    System.out.println(HOW_MANY_LAP_COUNT);
    return getIntValue();
  }

  private static int getIntValue() {
    try {
      return SCANNER.nextInt();
    } catch (InputMismatchException e) {
      throw new IllegalArgumentException(PLEASE_INPUT_INTEGER, e);
    } finally {
      SCANNER.nextLine();
    }
  }

  private static String getStringValue() {
    try {
      return SCANNER.next();
    } finally {
      SCANNER.nextLine();
    }
  }
}
