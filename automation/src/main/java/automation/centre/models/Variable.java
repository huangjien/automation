package automation.centre.models;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jien.huang on 16/01/2017.
 */
@Document(collection = "models")
public class Variable extends Model {
    private Object value;
    private boolean isRequired;

    public Variable() {
        super();
        this.setType("Variable");
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }
}
