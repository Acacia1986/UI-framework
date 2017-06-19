package acacia.generic.practise;

/**
 * Created by miaomiao on 6/19/2017.
 */
public interface Container<T> {

    T getValues();

    T getEveryValuesFromParameter(T... args);
}
