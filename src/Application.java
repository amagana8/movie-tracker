import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		mainMenu();
	}
	
	public static void mainMenu() {
		
		MovieLink newMovieLink = new MovieLink(new Movie(), null);
		
		System.out.println("Welcome to the Movie Rating App! Select an option below:");
		System.out.println("1) add a movie");
		System.out.println("2) remove a movie");
		System.out.println("3) display movies alphabetically");
		System.out.println("4) display movies >= a certain rating");
		System.out.println("5) display movies in a specified genre");
		System.out.println("6) list all movies with a specified actor/actress");
		System.out.println("7) list all movies the user has yet to see");
		System.out.println("8) quit");
		System.out.println("\nSelect an option above: ");
		
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		if (input == 1) {
			System.out.println("Please type in the name of the movie");
			scanner.nextLine();
			String newMovieTitle = scanner.nextLine();
			
			System.out.println("Please type in a number from 1-5 for your rating of the movie");
			int newMovieRating = scanner.nextInt();
			
			System.out.println("Please type in a description of the movie");
			scanner.nextLine();
			String newMovieDescription = scanner.nextLine();
			
			System.out.println("Have you seen the moive(Y/N)?");
			boolean newMovieSeenhasSeen = scanner.next().charAt(0) == 'Y' ? true : false;
			
			System.out.println("What is the genre of the movie?");
			scanner.nextLine();
			Movie.Genre newMovieGenre = Movie.Genre.valueOf(scanner.nextLine());
			
			System.out.println("What are the name of the actors in the movie?");
			scanner.nextLine();
			String newActors = scanner.nextLine();
	
			Movie newMovie = new Movie(newMovieTitle, newMovieRating, newMovieDescription, newMovieSeenhasSeen, newMovieGenre, newActors);
			
			newMovieLink = newMovieLink.add(newMovie);
			System.out.println(newMovieLink.printMovieLink());
			 mainMenu();
		}
		
		if (input == 2) {
			System.out.println("Please type in the name of the movie you wish to remove");
			scanner.nextLine();
			String oldMovie = scanner.nextLine();
			newMovieLink.remove(oldMovie);
			mainMenu();
		}
		
		if (input == 3) {
			System.out.println("Movies in alphabetical order: " + newMovieLink.printMovieLink());
			mainMenu();
		}
		
		if (input == 4) {
			System.out.println("Please type in the minimum rating for your search");
			int inputRating = scanner.nextInt();
			System.out.println("Movies with ratings greater than or equal to: " + inputRating);
			newMovieLink.findUnseenMovieByRating(inputRating);
			System.out.println(newMovieLink.printMovieLink());
			mainMenu();
		}
		
		if (input == 5) {
			System.out.println("Please type in one of the following genres: ACTION, ROMANCE, COMEDY, DRAMA, DOCUMENTARY, ANIME");
			scanner.nextLine();
			String inputGenre = scanner.nextLine();
			MovieLink genreMovieLink = new MovieLink(new Movie(), null);
			genreMovieLink = genreMovieLink.displayUnseenMoviesOfAGenre(inputGenre);
			System.out.println(genreMovieLink.printMovieLink());
			mainMenu();
		}
		
		if (input == 7) {
			System.out.println("Movies you haven't seen: " + newMovieLink.displayUnseenMovies());
			mainMenu();
		}
		
		boolean quitChoice = false;
		 if (input == 8) {
			System.out.println("Are you sure you want to quit? - all your data will be lost. (Y/N)");
			quitChoice = scanner.next().charAt(0) == 'Y' ? true : false;
			if (quitChoice) {
				System.exit(0);
			}
			mainMenu();
		}
		 scanner.close();
	}
}
