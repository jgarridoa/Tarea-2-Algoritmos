
public class splitaxis {
	
	final protected String x = "x";
	final protected String y = "y";
	protected String actual;
	
	public splitaxis(){
		this.actual = x;
	}
	
	public void changeAxis(){
		actual = actual.equals(x)? y : x;
	}

}
