
public class PreviewPattern {

	private String name;
	private Object video;
	private String description;
	
	public PreviewPattern(String name,Object video, String decsription){
		
		this.name = name;
		this.video = video;
		this.description = description;
		
	}
	
	public String getName(){
		return this.name;
		
	}
	public String getDescription(){
		return this.description;
		
	}
	public Object getVideo(){
		return this.video;
		
	}
	
	
}
