package lab2;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * HashWrapperByFirstFour extends Instrument that plays Star Wars theme
 */
public class HashWrapperByFirstFour extends Instrument {
    private static final int MAX_NUMBER_OF_CHARS_TO_HASH = 4;
    public static float SAMPLE_RATE = 8000f;
    private final String hashingString;

    public HashWrapperByFirstFour() {
        this("def");
    }

    public HashWrapperByFirstFour(String hashingString) {
        this.hashingString = hashingString;
    }

    public String getHashingString() {
        return hashingString;
    }

    public void play() {
        try {
            for (Object o : addBeeps(parseCodes())) {
                Beep beep = (Beep) o;
                HashWrapperByFirstFour.tone((int) beep.getFrequency(), beep.getLength());
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        int size = hashingString.length() < MAX_NUMBER_OF_CHARS_TO_HASH
                ? hashingString.length()
                : MAX_NUMBER_OF_CHARS_TO_HASH;

        for (int i = 0; i < size; i++) {
            result += Objects.hash(hashingString.charAt(i));
        }
        return result;
    }

    private static void tone(int hz, int msecs)
            throws LineUnavailableException {
        tone(hz, msecs, 1.0);
    }

    private static void tone(int hz, int msecs, double vol)
            throws LineUnavailableException {
        byte[] buf = new byte[1];
        AudioFormat af =
                new AudioFormat(
                        SAMPLE_RATE, // sampleRate
                        8,           // sampleSizeInBits
                        1,           // channels
                        true,        // signed
                        false);      // bigEndian
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        for (int i = 0; i < msecs * 8; i++) {
            double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
            buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
            sdl.write(buf, 0, 1);
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
    }

    private ArrayList addBeeps(Matcher matcher) {
        ArrayList<Beep> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(new Beep(
                    Integer.parseInt(matcher.group(2)),
                    Double.parseDouble(matcher.group(4))));
        }
        return list;
    }

    private Matcher parseCodes() {
        String regExp = "(-l\\s)([0-9]+)(\\s-f\\s)([0-9]*(\\.([0-9]+))?)";
        String codeLine = readFile("beeep.txt");
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(codeLine);
    }

    private String readFile(String filePath) {
        try {
            FileReader beepCode = new FileReader(filePath);
            BufferedReader bufRead = new BufferedReader(beepCode);
            return bufRead.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Beep {
    private double frequency;
    private int length;

    public Beep(int length, double frequency) {
        this.frequency = frequency;
        this.length = length;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getLength() {
        return length;
    }
}