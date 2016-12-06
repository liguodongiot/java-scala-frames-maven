package design.effectivejava.chapter03.entity08;

/**
 * Created by liguodong on 2016/12/6.
 */
//Broken  违反对称性
public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s){
        if(s == null){
            throw new NullPointerException();
        }
        this.s = s;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof CaseInsensitiveString){
            return s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
        }
        if(o instanceof String){
            return s.equalsIgnoreCase((String)o);
        }
        return false;
    }


}
