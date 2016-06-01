
public class KeyButton {

	private int x, y, w, h;
	private String keyNote;
	public boolean pressed = false;

	public KeyButton(int x, int y, int w, int h, String keyNote) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.keyNote = keyNote;
	}

	public boolean hovering(int x, int y){

		if((x > this.x) && (x < this.w) && (y > this.y) && (y < this.h)){
			return true;
		}

		return false;

	}
	
	public String getKeyNote(){
		return keyNote;
	}
}
