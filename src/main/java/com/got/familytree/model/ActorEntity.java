package com.got.familytree.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class ActorEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "actor_name")
    private String actorName;

    @Column(name = "actor_link")
    private String actorLink;

    @ElementCollection
    @CollectionTable(name = "actor_seasons_active", joinColumns = @JoinColumn(name = "actor_id"))
    @Column(name = "season_active")
    private List<Integer> seasonsActive;
    
    

	public ActorEntity(String actorName, String actorLink, List<Integer> seasonsActive) {
		super();
		this.actorName = actorName;
		this.actorLink = actorLink;
		this.seasonsActive = seasonsActive;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActorLink() {
		return actorLink;
	}

	public void setActorLink(String actorLink) {
		this.actorLink = actorLink;
	}

	public List<Integer> getSeasonsActive() {
		return seasonsActive;
	}

	public void setSeasonsActive(List<Integer> seasonsActive) {
		this.seasonsActive = seasonsActive;
	}

	public ActorEntity() {
		super();
	}

}

