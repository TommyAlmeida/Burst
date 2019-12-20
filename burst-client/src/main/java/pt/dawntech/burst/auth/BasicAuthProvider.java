package pt.dawntech.burst.auth;

import java.util.LinkedHashMap;
import java.util.Map;

public class BasicAuthProvider implements AuthProvider {

    private Map<String, String> fields;

    public BasicAuthProvider() {
        fields = new LinkedHashMap<>();
    }

    @Override
    public void field(String field, String value) {
        fields.put(field, value);
    }

    @Override
    public String getField(String field) {
        return fields.get(field);
    }
}
