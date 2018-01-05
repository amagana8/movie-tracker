public class Movie {

	private String title;
	private int rating;
	private String description;
	private boolean haveSeen;
	public enum Genre {ACTION, ROMANCE, COMEDY, DRAMA, DOCUMENTARY, ANIME};
	public Genre genre; 
	private String actors;
	
	public Movie(String title, int rating, String description, boolean haveSeen, Genre genre, String actors) {
		this.title = title;
		this.rating = rating;
		this.description = description;
		this.haveSeen = haveSeen;
		this.genre = genre;	
		this.actors = actors;
	}
	
	public Movie() {
		this.title = "Sample Title";
		this.rating = 3;
		this.description = "Sample Description";
		this.haveSeen = false;
		this.genre = Movie.Genre.valueOf("ACTION");
		this.actors = "Sample Actor";
	}
	
	public String addActor(String newActor) {
		this.actors += ", " + newActor;
		return actors;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getRating() {
		return rating;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getHaveSeen() {
		return haveSeen;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public String getActors() {
		return actors;
	}
}