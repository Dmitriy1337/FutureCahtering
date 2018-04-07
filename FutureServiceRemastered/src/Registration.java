
public class Registration {

	private String login;
	private String password;
	public Registration (String login,String password){
		this.login=login;
		this.password = password;
	}
	
	public boolean isMatching(String a,String b){
		if(a.equals(this.login)&&b.equals(this.password)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
}
