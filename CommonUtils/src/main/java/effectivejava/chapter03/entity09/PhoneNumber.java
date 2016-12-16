package effectivejava.chapter03.entity09;

/**
 * Created by liguodong on 2016/12/13.
 */
public class PhoneNumber {

    private short areaCode;
    private short prefix;
    private short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode,999,"area code");
        rangeCheck(prefix,999,"prefix");
        rangeCheck(lineNumber,9999,"line number");
        this.areaCode = (short)areaCode;
        this.prefix = (short)prefix;
        this.lineNumber = (short)lineNumber;
    }

    private void rangeCheck(int arg,int max,String name){
        if(arg<0 || arg>max){
            throw new IllegalArgumentException(name+":"+arg);
        }
    }

    //合法，但是不应该被正式使用，因为每一对象都具有相同的散列码，每个对象被映射到
    /*@Override
    public int hashCode() {
        return 42;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumber that = (PhoneNumber) o;

        if (areaCode != that.areaCode) return false;
        if (prefix != that.prefix) return false;
        return lineNumber == that.lineNumber;

    }

    @Override
    public int hashCode() {
        int result = (int) areaCode;
        result = 31 * result + (int) prefix;
        result = 31 * result + (int) lineNumber;
        return result;
    }
}
