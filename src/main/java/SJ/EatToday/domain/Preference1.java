package SJ.EatToday.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;


public enum Preference1 {
    KOREAN("한식"), WESTERN("양식"), CHINESE("중식"), JAPANESE("일식");

    @Getter
    private final String value;

    Preference1(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Preference1 from(String value) {
        for (Preference1 pre : Preference1.values()) {
            if (pre.getValue().equals(value)) {
                return pre;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}
