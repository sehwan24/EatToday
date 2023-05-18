package SJ.EatToday.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Preference3 {
    SPICY("매운 음식"), SWEET("단 음식"), SALTY("짠 음식");

    @Getter
    private final String value;

    Preference3(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Preference3 from(String value) {
        for (Preference3 pre3 : Preference3.values()) {
            if (pre3.getValue().equals(value)) {
                return pre3;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
