package gromcode.main.lesson25.homework;

public class GeneralDAO <T> {
    private T[] array = (T[]) new Object[10];

    public T save(T t) throws Exception{
        validate(t);
        int index = 0;
        for (T el : array) {
            if (el == null) {
                array[index] = t;
                break;
            }
            index++;
        }
        return array[index];
    }

    private void validate(T t) throws Exception {
        if (t==null)
            throw new NullPointerException("Element is empty");

        for (T el : array) {
            if (t.equals(el))
                throw new Exception("Element already in list");
        }

        if (spaceOfArray())
            throw new Exception("Not enough space");

    }

    public T[] getAll(){
        return array;
    }

    private boolean spaceOfArray(){
        for (T el : array){
            if (el == null)
                return false;
        }
        return true;
    }
}
