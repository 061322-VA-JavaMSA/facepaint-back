package com.revature.facepaint.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "art")
public class Art{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name="art_name")
	private String name;
	@Column(name="art_year")
	private Date yearMade;
	@Column(name="artist")
	private String artist;
	@Column(name="image_id")
	private int pic_id;
	@ManyToOne
	@JoinColumn(name="showcase")
	private User artAssigned;
	public Art() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the yearMade
	 */
	public Date getYearMade() {
		return yearMade;
	}
	/**
	 * @param yearMade the yearMade to set
	 */
	public void setYearMade(Date yearMade) {
		this.yearMade = yearMade;
	}
	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	/**
	 * @return the pic_id
	 */
	public int getPic_id() {
		return pic_id;
	}
	/**
	 * @param pic_id the pic_id to set
	 */
	public void setPic_id(int pic_id) {
		this.pic_id = pic_id;
	}
	/**
	 * @return the artAssigned
	 */
	public User getArtAssigned() {
		return artAssigned;
	}
	/**
	 * @param artAssigned the artAssigned to set
	 */
	public void setArtAssigned(User artAssigned) {
		this.artAssigned = artAssigned;
	}
	@Override
	public int hashCode() {
		return Objects.hash(artAssigned, artist, id, name, pic_id, yearMade);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Art other = (Art) obj;
		return Objects.equals(artAssigned, other.artAssigned) && Objects.equals(artist, other.artist) && id == other.id
				&& Objects.equals(name, other.name) && pic_id == other.pic_id
				&& Objects.equals(yearMade, other.yearMade);
	}
	@Override
	public String toString() {
		return "Art [id=" + id + ", name=" + name + ", yearMade=" + yearMade + ", artist=" + artist + ", pic_id="
				+ pic_id + ", artAssigned=" + artAssigned + "]";
	}

}
