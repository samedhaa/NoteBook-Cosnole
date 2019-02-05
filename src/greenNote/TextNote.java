package greenNote;


public class TextNote extends NoteTemblate{
	
	private String messageContent = "";

	TextNote(String title, String content, Integer id)
	{
		setId(id);
		
		setTitle(title);

		setContent(messageContent);
	}

	
	public void setContent(String content) {
		this.messageContent = content;
	}
	
	public String getContent()
	{
		return messageContent;
	}
	
	@Override
	public void printNote() {
		System.out.println(id + " : " + title);
		System.out.println(messageContent);

		
	}
	
	

	
}
