package dto;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class ParticipationForm {
  private static final int MINIMUM_COUNT = 1;
  private static final int MAX_NAME_LENGTH = 5;
  private static final String FIELD_MINIMUM_VALUE_NOTIFY_FORMAT = "%s의 최소 값은 %d입니다. 입력 된 값 : %d";
  private static final String NAME_MUST_NOT_NULL_AND_EMPTY = "차량 이름이 빈 문자열일 수 없습니다.";
  private static final String NAME_LENGTH_MUST_LESS_EQUAL_THAN_MAX_LENGTH_FORMAT = "차량 이름은 최대 %d자 입니다.";
  private static final String DUPLICATED_ATTENDEE_NAME = "같은 이름의 참여자가 있습니다. 참여자의 이름은 모두 달라야 합니다.";
  private static final String LAP_COUNT_FIELD_NAME = "시도할 회수";
  private static final String ATTENDEE_COUNT_FIELD_NAME = "참가 대수";

  private final Set<String> attendeeNames;
  private final int lapCount;
  public ParticipationForm(String[] attendeeNames, int lapCount) {
    validateAttendeesCount(attendeeNames);
    validateLapCount(lapCount);
    this.attendeeNames = createValidAttendeeNames(attendeeNames);
    this.lapCount = lapCount;
  }

  private Set<String> createValidAttendeeNames(String[] attendeeNames) {
    Set<String> attendees = new LinkedHashSet<>();
    for (String attendeeName : attendeeNames) {
      throwExceptionIfNameIsBlank(attendeeName);
      throwExceptionIfNameGreaterThanMaxLength(attendeeName);
      addNotDuplicatedName(attendees, attendeeName);
    }
    return attendees;
  }

  private void validateLapCount(int lapCount) {
    if(lapCount < MINIMUM_COUNT) {
      throw new IllegalArgumentException(String.format(FIELD_MINIMUM_VALUE_NOTIFY_FORMAT, LAP_COUNT_FIELD_NAME, MINIMUM_COUNT, lapCount));
    }
  }

  private void addNotDuplicatedName(Set<String> attendees, String attendeeName) {
    if(!attendees.add(attendeeName)) {
      throw new IllegalArgumentException(DUPLICATED_ATTENDEE_NAME);
    }
  }

  private void throwExceptionIfNameGreaterThanMaxLength(String attendeeName) {
    if(attendeeName.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException(String.format(NAME_LENGTH_MUST_LESS_EQUAL_THAN_MAX_LENGTH_FORMAT, MAX_NAME_LENGTH));
    }
  }

  private void throwExceptionIfNameIsBlank(String attendeeName) {
    if(attendeeName.isBlank()) {
      throw new IllegalArgumentException(NAME_MUST_NOT_NULL_AND_EMPTY);
    }
  }

  private void validateAttendeesCount(String[] attendeeNames) {
    int inputLength = attendeeNames.length;
    if(inputLength < MINIMUM_COUNT) {
      throw new IllegalArgumentException(String.format(FIELD_MINIMUM_VALUE_NOTIFY_FORMAT, ATTENDEE_COUNT_FIELD_NAME, MINIMUM_COUNT, inputLength));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ParticipationForm that = (ParticipationForm) o;
    return lapCount == that.lapCount && attendeeNames.equals(that.attendeeNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attendeeNames, lapCount);
  }
}
