package SJ.EatToday.domain.preference;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Preference2 {
    HOT("뜨거운 음식"), COLD("차가운 음식");

    @Getter
    private final String value;

    Preference2(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Preference2 from(String value) {
        for (Preference2 pre2 : Preference2.values()) {
            if (pre2.getValue().equals(value)) {
                return pre2;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
