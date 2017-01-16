package automation.centre.models;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.LinkedList;

/**
 * Created by jien.huang on 16/01/2017.
 */
public class Loop extends TestScript {
    private String condition;
    @DBRef
    private LinkedList<Variable> variables;
    public Loop() {
        this.setType("Loop");
    }

    @Override
    public boolean run() {
        return false;
    }
}
