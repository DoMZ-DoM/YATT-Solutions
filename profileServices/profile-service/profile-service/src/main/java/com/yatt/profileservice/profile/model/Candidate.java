package com.yatt.profileservice.profile.model;

public class Candidate {

	private String firstName = null;
	private String lastName = null;;
	private String [] position = null;
	private String [] education = null;
	private String [] skills = null;
	private Experience [] experience = null;
	private String languages[] = null;
	private String courses[] = null;
	private String photo = null;
	
	public Candidate() {}
	public Candidate(String firstName, String lastName, String[] position, String[] education, String[] skills,
			Experience[] experience, String[] languages, String[] courses, String photo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.education = education;
		this.skills = skills;
		this.experience = experience;
		this.languages = languages;
		this.courses = courses;
		this.photo = photo;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the position
	 */
	public String[] getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String[] position) {
		this.position = position;
	}
	/**
	 * @return the education
	 */
	public String[] getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(String[] education) {
		this.education = education;
	}
	/**
	 * @return the skills
	 */
	public String[] getSkills() {
		return skills;
	}
	/**
	 * @param skills the skills to set
	 */
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	/**
	 * @return the experience
	 */
	public Experience[] getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(Experience[] experience) {
		this.experience = experience;
	}
	/**
	 * @return the languages
	 */
	public String[] getLanguages() {
		return languages;
	}
	/**
	 * @param languages the languages to set
	 */
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	/**
	 * @return the courses
	 */
	public String[] getCourses() {
		return courses;
	}
	/**
	 * @param courses the courses to set
	 */
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	
	
}
