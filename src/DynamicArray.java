public class DynamicArray {

    private Object[] arr;
    private int realLength;

    DynamicArray() {
        arr = new Object[3];
        realLength = 0;
    }

    public void delete(int num) {
        arr[num] = null;
        realLength--;
        shiftElements();
    }

    private void shiftElements() {
        int positionOfFirstEmptyElement = positionOfFirstEmptyElement();
        while (positionOfFirstEmptyElement + 1 < arr.length && arr[positionOfFirstEmptyElement + 1] != null) {
            arr[positionOfFirstEmptyElement] = arr[positionOfFirstEmptyElement + 1];
            arr[positionOfFirstEmptyElement + 1] = null;
            positionOfFirstEmptyElement++;
        }
    }

    //If there is an empty space in arr adds an element, else - doubles the size arr
    public void add(Object object) {
        int positionOfFirstEmptyElement = positionOfFirstEmptyElement();
        if (positionOfFirstEmptyElement == arr.length)
            expandArrCapacity();
        arr[positionOfFirstEmptyElement] = object;
        realLength++;
    }

    private void expandArrCapacity() {
        Object[] tempArr = new Object[arr.length];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        arr = new Object[arr.length * 2];
        System.arraycopy(tempArr, 0, arr, 0, tempArr.length);
    }

    //Returns the position of first empty space in arr, if arr is full - returns arr.length
    private int positionOfFirstEmptyElement() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null)
                return i;
        }
        return arr.length;
    }

    public Object get(int num) {
        while (arr.length <= num) expandArrCapacity();
        return arr[num];
    }

    public Object getElementByName(String name) {
        for (int i = 0; i < realLength; i++) {
            if (arr[i].toString().equals(name)) return arr[i];
        }
        return null;
    }

    public int getRealLength() {
        return realLength;
    }

}
