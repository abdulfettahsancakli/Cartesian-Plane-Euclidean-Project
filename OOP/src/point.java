

public class point  {
    private int xCoord;
    private int yCoord;
    private int Group;
    private String Symbol;
    public point(int xCoord, int yCoord,int Group) {
        this.setxCoord(xCoord);
        this.setyCoord(yCoord);
        this.setGroup(Group);
        for(Group g:TestClass.groups) {
        	if(g.getGroup()==this.Group)
        	{
        		g.points.add(this);
        		this.Symbol=g.getSymbol();
        	}
        }
    }
    public String toString(){
        return "X:"+this.xCoord+",Y:"+this.yCoord+", Group:"+Group;
    }
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	public int getxCoord() {
		return xCoord;
	}
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
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
