package fr.formation.recipes.errors;

public class ValidationError {

    private final String object;

    private final String attribute;

    private final String code;

    private final boolean globalError;

    /**
     * Creates a "field error" with given object name, attribute and error code.
     *
     * @param object    the object name
     * @param attribute the attribute name
     * @param code      the error code
     */
    public ValidationError(String object, String attribute, String code) {
	this.object = object;
	this.attribute = attribute;
	this.code = code;
	globalError = this.attribute == null;
    }

    public ValidationError(String object, String code) {
	this(object, null, code);
    }

    public String getObject() {
	return object;
    }

    public String getAttribute() {
	return attribute;
    }

    public String getCode() {
	return code;
    }

    public boolean isGlobalError() {
	return globalError;
    }
}
