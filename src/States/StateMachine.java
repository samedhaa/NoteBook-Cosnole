package States;

import java.util.ArrayList;
import java.util.List;

import greenNote.TextNote;
import greenNote.UrlNote;

public class StateMachine extends States{
	
	
	private String title = ""; 
	private String type = "";
	private String content = "";
    
    StateMachine(){
    	NotePosition++;
    }
    

	public void Inserting()
	{
					
		getTitle();
		
		getType();
		
		if(type == "audio")
		{
			insertAudioNote();
		}
		else
		{
			insertTextNote();
		}
	}
	
	
	public void getTextContent()
	{
		
		System.out.println("Please enter the Note : ");
		String Content  = userAction[3];

		editContent(Content);
	}
	
	
	public void getAudioContent()
	{
		
		System.out.println("Please enter the Url for the voice : ");
		content  = userAction[3];
		//get content 
		
	}
	
	
	public void getTitle()
	{
				
		System.out.println("Please enter the title of the note : ");
		String theTitle = userAction[1];

		editTitle(theTitle);
		
	}
	
	public void getType()
	{
		
		System.out.println("Please enter 1 if it's a text");
		System.out.println("Please enter 2 if it's an audio");
		
		String type  = userAction[2];
		
		if(type.equals("1"))
		{
			editType("text");
			getTextContent();
		}
		else if(type.equals("2"))
		{
			editType("audio");
			getAudioContent();
		}
		else
		{
			System.out.println("Type wasn't clarified");
			getType();
		}

	}
	
	
	public void getTags()
	{
		String numberOfTags="0"; // should be integer will be fixed after the input get fixed
		
		System.out.println("How many tags ? ");
		try
		{
			numberOfTags = userAction[5];

		}
		catch(Exception e)
		{
			System.out.println("Yoo! give me that number!");
			getTags();
			return;
		}
		
		String tag;
		for(int i=1;i<=Integer.parseInt(numberOfTags);i++)
		{
			System.out.println("Tag number : " + i);
			tag = userAction[5+i];
			List<Integer> prevData = new ArrayList<Integer>();
			if(tags.containsKey(tag))
			{
				prevData.addAll(tags.get(tag));
			}
			prevData.add(NotePosition);

			tags.put(tag,prevData);

		}

		
	}
	
	private void editTitle(String Title)
	{
		this.title = Title;
	}
	
	private void editType(String Type)
	{
		this.type = Type;
	}

	private void editContent(String Content)
	{
		this.content = Content;
	}
		
	public void insertAudioNote()
	{
		System.out.println("Would you like to add a tag ? yes/no");
		String isTagged  = userAction[4];
			
		if(isTagged.equals("yes") | isTagged.equals("YES") | isTagged.equals("Yes") | isTagged.equals("y") | isTagged.equals("Y"))
		{
			getTags();
		}
		
		
		UrlNote InsertedNotes = new UrlNote(title, content, tags,NotePosition); // content = url
		States.UNotes.add(InsertedNotes);
		InsertedNotes.printNote();
	}
	
	public void insertTextNote()
	{
		TextNote InsertedNotes = new TextNote(title, content,NotePosition);
		States.TNotes.add(InsertedNotes);
		InsertedNotes.printNote();
	}


}
