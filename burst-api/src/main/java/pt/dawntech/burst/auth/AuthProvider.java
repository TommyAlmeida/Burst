package pt.dawntech.burst.auth;

public interface AuthProvider {

    void field(String field, String value);

    /**
     * Get field value
     * @param field text box or another form box
     * @return value of that field
     */
    String getField(String field);

}
