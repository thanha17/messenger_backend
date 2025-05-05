package com.social.messenger.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "friendships")
public class Friendship {
	@Id
	private String ID;
    private String user1Id;
    private String user2Id;
    private String status; // "pending", "accepted", "rejected"
	public Friendship(String user1Id, String user2Id, String status) {
		super();
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.status = status;
	}


}
