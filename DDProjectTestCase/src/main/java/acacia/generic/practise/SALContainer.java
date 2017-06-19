package acacia.generic.practise;

/**
 * Created by miaomiao on 6/19/2017.
 */
public class SALContainer implements Container<String> {
    String tu;

    public SALContainer(String t) {
        tu = t;
    }

    public String getValues() {
        return tu;
    }

    public String getEveryValuesFromParameter(String... args) {
        String target = null;
        for (String t : args) {
            target = t;
        }
        return target;
    }




}
