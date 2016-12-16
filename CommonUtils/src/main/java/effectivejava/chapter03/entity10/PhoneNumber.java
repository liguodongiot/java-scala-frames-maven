package effectivejava.chapter03.entity10;

/**
 * Created by liguodong on 2016/12/16.
 */
public class PhoneNumber {

    private int areaCode;

    private int prefix;

    private int lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    /*@Override
    public String toString() {
        return String.format("(%03d) %03d-%04d",areaCode,prefix,lineNumber);
    }
    */

    @Override
    public String toString() {
        return super.toString();
    }
}
