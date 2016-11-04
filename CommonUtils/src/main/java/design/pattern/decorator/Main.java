package design.pattern.decorator;

/**
 *
 * Created by liguodong on 2016/10/14.
 */
public class Main {

    public static void main(String[] args) {
        Voice v = new Voice(20);
        v.say();

        Amplifier am = new Amplifier(v);
        am.say();
    }

}


class Voice {

    private int voice = 10;

    public Voice() {
    }

    public Voice(int voice) {
        super();
        this.voice = voice;
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    public void say()
    {
        System.out.println(voice);
    }
}


class Amplifier {
    private Voice voice;
    public Amplifier() {
    }

    public Amplifier(Voice voice) {
        super();
        this.voice = voice;
    }

    public void say()
    {
        System.out.println(voice.getVoice()*1000);
    }
}
