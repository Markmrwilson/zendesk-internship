//Holds the attributes of each ticket, and provides
//getters and setters for them
public class Ticket {

	private String url;
	private Long ID;
	private String createdAt;
	private String subject;
	private String description;
	private String priority;
	private String status;
	private String shortStatus;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long ID) {
		this.ID = ID;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShortStatus(){
		return shortStatus;
	}
	public void setShortStatus(){
		switch(this.status){
		case "open":
			this.shortStatus = "(O)";
			break;
		case "pending":
			this.shortStatus = "(P)";
			break;
		case "solved":
			this.shortStatus = "(S)";
			break;
		default:
			break;
		}
	}
}
