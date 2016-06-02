import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class KeyButton {

	private int x, y, w, h;
	private String keyNote;
	public boolean pressed = false;

	private final static int BUFFER_SIZE = 128000;
	private static File soundFile;
	private static AudioInputStream audioStream;
	private static AudioFormat audioFormat;
	private static SourceDataLine sourceLine;

	public KeyButton(int x, int y, int w, int h, String keyNote) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.keyNote = keyNote;
	}

	public boolean hovering(int x, int y){

		//System.out.println(this.x + ", " + this.y + ", " + w + ", " + h);
		//System.out.println(x + ", " + y);

		if((x > this.x) && (x < this.w + this.x) && (y > this.y) && (y < this.h + this.y)){
			return true;
		}

		return false;

	}

	public String getKeyNote(){
		return keyNote;
	}

	public static void playNote(String file){

		String strFilename = file;

		try {
			soundFile = new File(strFilename);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		try {
			audioStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e){
			e.printStackTrace();
			System.exit(1);
		}

		audioFormat = audioStream.getFormat();

		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		try {
			sourceLine = (SourceDataLine) AudioSystem.getLine(info);
			sourceLine.open(audioFormat);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		sourceLine.start();

		int nBytesRead = 0;
		byte[] abData = new byte[BUFFER_SIZE];
		while (nBytesRead != -1) {
			try {
				nBytesRead = audioStream.read(abData, 0, abData.length);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (nBytesRead >= 0) {
				@SuppressWarnings("unused")
				int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
			}
		}

		sourceLine.drain();
		sourceLine.close();
	}
}
