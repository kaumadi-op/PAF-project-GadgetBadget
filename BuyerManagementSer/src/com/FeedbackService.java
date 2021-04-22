package com;

import javax.ws.rs.*;





import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.Feedback;

public class FeedbackService {

	
	Feedback feedbackObj = new Feedback();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readFeedback()
	{
	return feedbackObj.readFeedback();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertFeedback(@FormParam("fedID") String fedID,
			@FormParam("name") String name,
	 @FormParam("contactNo") String contactNo,
	 @FormParam("email") String email,
	 @FormParam("comment") String comment,
	 @FormParam("ratetype") String ratetype)
	{
	 String output = feedbackObj.insertFeedback(fedID,name,contactNo,email,comment,ratetype);
	return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateFeedback(String feedbackData)
	{
	//Convert the input string to a JSON object
		 JsonObject feedbackObject = new JsonParser().parse(feedbackData).getAsJsonObject(); 
	//Read the values from the JSON object
	 
	 String fedID =feedbackObject.get("fedID").getAsString();
	 String name = feedbackObject.get("name").getAsString();
	 String contactNo = feedbackObject.get("contactNo").getAsString();
	 String email = feedbackObject.get("email").getAsString();
	 String comment = feedbackObject.get("comment").getAsString();
	 String ratetype =feedbackObject.get("ratetype").getAsString();
	 
	 String output =feedbackObj.updateFeedback(fedID,name, contactNo,email,comment,ratetype);
	return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteFeedback(String feedbackData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(feedbackData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String fedID = doc.select("fedID").text();
	 String output = feedbackObj.deleteFeedback(fedID);
	return output;
	}

}
