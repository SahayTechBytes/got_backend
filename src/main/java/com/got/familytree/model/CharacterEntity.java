package com.got.familytree.model;

import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "characters")
public class CharacterEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "character_name")
    private String characterName;
    
    @Column(name = "favourite")
    private boolean favourite;

    @ElementCollection
    @CollectionTable(name = "character_house_names", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "house_name")
    private List<String> houseName;

    @Column(name = "character_image_thumb")
    private String characterImageThumb;

    @Column(name = "character_image_full")
    private String characterImageFull;

    @Column(name = "character_link")
    private String characterLink;

    @Column(name = "kingsguard")
    private boolean kingsguard;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "royal")
    private boolean royal;
    
    @Column(name = "actor_name")
    private String actorName;

    @Column(name = "actor_link")
    private String actorLink;

    @ElementCollection
    @CollectionTable(name = "character_parents", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "parent_name")
    private List<String> parents;

    @ElementCollection
    @CollectionTable(name = "character_killed", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "killed_name")
    private List<String> killed;

    @ElementCollection
    @CollectionTable(name = "character_served_by", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "served_by_name")
    private List<String> servedBy;

    @ElementCollection
    @CollectionTable(name = "character_parent_of", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "parent_of_name")
    private List<String> parentOf;

    @ElementCollection
    @CollectionTable(name = "character_siblings", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "sibling_name")
    private List<String> siblings;

    @ElementCollection
    @CollectionTable(name = "character_married_engaged", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "married_engaged_name")
    private List<String> marriedEngaged;

    @ElementCollection
    @CollectionTable(name = "character_guarded_by", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "guarded_by_name")
    private List<String> guardedBy;

    @ElementCollection
    @CollectionTable(name = "character_killed_by", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "killed_by_name")
    private List<String> killedBy;

    @ElementCollection
    @CollectionTable(name = "character_serves", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "serves_name")
    private List<String> serves;
    
    @ElementCollection
    @CollectionTable(name = "character_guardian_of", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "guardian_of")
    private List<String> guardianOf;
    
    @ElementCollection
    @CollectionTable(name = "character_allies", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "allies")
    private List<String> allies;
    
    @ElementCollection
    @CollectionTable(name = "character_abducted_by", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "abducted_by")
    private List<String> abductedBy;
    
    @ElementCollection
    @CollectionTable(name = "character_abducted", joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "abducted")
    private List<String> abducted;

    @OneToMany(cascade = CascadeType.ALL)
    @ElementCollection
    @CollectionTable(name = "character_actors", joinColumns = @JoinColumn(name = "character_id"))
    private List<ActorEntity> actors;

    public CharacterEntity() {
		super();
	}

	public CharacterEntity(String characterName, List<String> houseName, String characterImageThumb,
			String characterImageFull, String characterLink, boolean kingsguard, String nickname, boolean royal,
			String actorName, String actorLink, List<String> parents, List<String> killed, List<String> servedBy,
			List<String> parentOf, List<String> siblings, List<String> marriedEngaged, List<String> guardedBy,
			List<String> killedBy, List<String> serves, List<String> guardianOf, List<ActorEntity> actors, 
			List<String> allies, List<String> abductedBy, List<String> abducted, boolean favourite) {
		super();
		this.characterName = characterName;
		this.houseName = houseName;
		this.characterImageThumb = characterImageThumb;
		this.characterImageFull = characterImageFull;
		this.characterLink = characterLink;
		this.kingsguard = kingsguard;
		this.nickname = nickname;
		this.royal = royal;
		this.actorName = actorName;
		this.actorLink = actorLink;
		this.parents = parents;
		this.killed = killed;
		this.servedBy = servedBy;
		this.parentOf = parentOf;
		this.siblings = siblings;
		this.marriedEngaged = marriedEngaged;
		this.guardedBy = guardedBy;
		this.killedBy = killedBy;
		this.serves = serves;
		this.guardianOf = guardianOf;
		this.actors = actors;
		this.allies = allies;
		this.abductedBy = abductedBy;
		this.abducted = abducted;
		this.favourite = favourite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public List<String> getHouseName() {
		return houseName;
	}

	public void setHouseName(List<String> houseName) {
		this.houseName = houseName;
	}

	public String getCharacterImageThumb() {
		return characterImageThumb;
	}

	public void setCharacterImageThumb(String characterImageThumb) {
		this.characterImageThumb = characterImageThumb;
	}

	public String getCharacterImageFull() {
		return characterImageFull;
	}

	public void setCharacterImageFull(String characterImageFull) {
		this.characterImageFull = characterImageFull;
	}

	public String getCharacterLink() {
		return characterLink;
	}

	public void setCharacterLink(String characterLink) {
		this.characterLink = characterLink;
	}

	public boolean isKingsguard() {
		return kingsguard;
	}

	public void setKingsguard(boolean kingsguard) {
		this.kingsguard = kingsguard;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean isRoyal() {
		return royal;
	}

	public void setRoyal(boolean royal) {
		this.royal = royal;
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

	public List<String> getParents() {
		return parents;
	}

	public void setParents(List<String> parents) {
		this.parents = parents;
	}

	public List<String> getKilled() {
		return killed;
	}

	public void setKilled(List<String> killed) {
		this.killed = killed;
	}

	public List<String> getServedBy() {
		return servedBy;
	}

	public void setServedBy(List<String> servedBy) {
		this.servedBy = servedBy;
	}

	public List<String> getParentOf() {
		return parentOf;
	}

	public void setParentOf(List<String> parentOf) {
		this.parentOf = parentOf;
	}

	public List<String> getSiblings() {
		return siblings;
	}

	public void setSiblings(List<String> siblings) {
		this.siblings = siblings;
	}

	public List<String> getMarriedEngaged() {
		return marriedEngaged;
	}

	public void setMarriedEngaged(List<String> marriedEngaged) {
		this.marriedEngaged = marriedEngaged;
	}

	public List<String> getGuardedBy() {
		return guardedBy;
	}

	public void setGuardedBy(List<String> guardedBy) {
		this.guardedBy = guardedBy;
	}

	public List<String> getKilledBy() {
		return killedBy;
	}

	public void setKilledBy(List<String> killedBy) {
		this.killedBy = killedBy;
	}

	public List<String> getServes() {
		return serves;
	}

	public void setServes(List<String> serves) {
		this.serves = serves;
	}

	public List<String> getGuardianOf() {
		return guardianOf;
	}

	public void setGuardianOf(List<String> guardianOf) {
		this.guardianOf = guardianOf;
	}

	public List<ActorEntity> getActors() {
		return actors;
	}

	public void setActors(List<ActorEntity> actors) {
		this.actors = actors;
	}

	public List<String> getAllies() {
		return allies;
	}

	public void setAllies(List<String> allies) {
		this.allies = allies;
	}

	public List<String> getAbductedBy() {
		return abductedBy;
	}

	public void setAbductedBy(List<String> abductedBy) {
		this.abductedBy = abductedBy;
	}

	public List<String> getAbducted() {
		return abducted;
	}

	public void setAbducted(List<String> abducted) {
		this.abducted = abducted;
	}

	public boolean isFavourite() {
		return favourite;
	}

	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}
    
	

	

}
