import java.util.ArrayList;

public class Group {
    public ArrayList<point> points = new ArrayList<point>();
    private int Group;
    private String Symbol;
    public Group(int Group,String Symbol){
        this.setGroup(Group);
        this.setSymbol(Symbol);
    }
	public int getGroup() {
		return Group;
	}
	public void setGroup(int group) {
		Group = group;
	}
	public String getSymbol() {
		return Symbol;
	}
	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

}
