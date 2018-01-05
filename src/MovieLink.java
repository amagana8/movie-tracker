public class MovieLink {

	private MovieLink next; 	
	private Movie movie;

	public MovieLink(Movie movie, MovieLink next) {
		this.movie = movie;
		this.next = next;
	}
	
	public MovieLink add(Movie newMovie) {
		if (newMovie.getTitle().toUpperCase().charAt(0) < this.movie.getTitle().toUpperCase().charAt(0)) {
			MovieLink addedToMovieLink = new MovieLink(newMovie, this);
			return addedToMovieLink;
		}
		else if (next == null) {
			MovieLink addedToMovieLink = new MovieLink(newMovie, null);
			next = addedToMovieLink;
			return this;
		}
		else {
			next.add(newMovie);
			return this;
		}
	}
	
	public void remove(String oldMovie) {
		if (this.movie.getTitle() == oldMovie) {
			next = null;
		}
		else if (next == null) {
			return;
		}
		else {
			next.remove(oldMovie);
		}
	}
	
	public String printMovieLink() {
		if (next == null) {
			return this.movie.getTitle() + "\n" + this.movie.getRating() + "\n" + this.movie.getDescription() + "\n" + this.movie.getGenre().toString() + this.movie.getActors();
		}
		else {
			return this.movie.getTitle() + "\n" + this.movie.getRating() + "\n" + this.movie.getDescription() + "\n" + this.movie.getGenre() + "\n" + this.movie.getActors() + "\n\n" + this.next.printMovieLink();
		}
	}
	
	public void append(Movie movie) {
		if (next == null) {
			this.next = new MovieLink(movie, null);
		}
		else {
			this.next.add(movie);
		}
	}
	
	public MovieLink displayUnseenMoviesOfAGenre(String input) {
		if (next == null) {
			MovieLink newMovieLink = new MovieLink(new Movie(), this);
			return newMovieLink;
		}
	    if (this.movie.getGenre().toString() == input && this.movie.getHaveSeen()) {
	       next.add(this.movie);
	    }
	    return next.displayUnseenMoviesOfAGenre(input);
	}
	
	public String displayUnseenMovies() {
		if (next == null) {
			if (!this.movie.getHaveSeen()) {
				return this.movie.getTitle() + "\n" + this.movie.getRating() + "\n" + this.movie.getDescription() + "\n";
			}
			else {
				return "";
			}
		}
		else {
			if (!this.movie.getHaveSeen())
				return this.movie.getTitle() + "\n" + this.movie.getRating() +
						"\n" + this.movie.getDescription() + "\n\n" + next.displayUnseenMovies(); 
			else
				return next.displayUnseenMovies();
		}
	}
	
	public Movie findUnseenMovieByRating(int rating) {
		if (next == null) {
			return this.movie;
		}
		else if (this.movie.getRating() == rating) {
			return this.movie;
		}
		else {
			return next.findUnseenMovieByRating(rating);
		}
	}
	
	public String findHighestRating(int rate) {
		int highestRating = rate;
		if (next == null) {
			return this.findUnseenMovieByRating(highestRating).getTitle();
		}
		if (this.movie.getRating() < highestRating) {
			return next.findHighestRating(highestRating);
		}
		else {
			highestRating = this.movie.getRating();
			return next.findHighestRating(highestRating);
		}
	}
	
	public MovieLink displayMoviesWithActor(String inputActor) {
		if (next == null) {
			MovieLink newMovieLink = new MovieLink(new Movie(), this);
			return newMovieLink;
		}
	    if (this.movie.getActors() == inputActor) {
	       next.add(this.movie);
	    }
	    return next.displayMoviesWithActor(inputActor);
	}
}