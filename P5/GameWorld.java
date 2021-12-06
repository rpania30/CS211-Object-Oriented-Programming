import java.util.*;
/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class GameWorld {
	/**
	 * fields:
	 * paths: represents a 2D ArrayList of paths
	 * locations: represents a GameLocations object
	 */
	private GameLocations locations;
	private ArrayList<ArrayList<Location>> paths;
	/**
	 * @param locations this is the GameLocations object
	 */
	public GameWorld(GameLocations locations) {
		this.locations = locations;
		this.paths = new ArrayList<ArrayList<Location>>();
	}
	/**
	 * prints all the paths in a GameWorld
	 * marks all locations as unvisited
	 * creates an ArrayList of locations and adds the current location
	 * finds all direct/indirect paths from the current location to a given destination using a recursive method
	 * prints each path found
	 */
	public void printPaths(Location current, Location destination) {
		int counter = 0;
		while (counter < this.locations.getLocations().size()) {
			locations.markAsVisited(this.locations.getLocations().get(counter), false);
			++counter;
		}
		ArrayList<Location> path = new ArrayList<>();
		path.add(current);
		findAllPaths(current, destination, path);
		for (int i = 0; i < this.paths.size(); ++i) {
			System.out.print("Path " + (i + 1) + ": " + paths.get(i).get(0));
			int k = 0;
			while (k < this.paths.get(i).size() - 1) {
				int total = locations.distanceIs(this.paths.get(i).get(k), this.paths.get(i).get(k + 1));
				System.out.print("--" + total + "->" + this.paths.get(i).get(k + 1));
				++k;
			}
			System.out.print("\n");
		}
	}
	/**
	 * finds all the direct/indirect paths in a GameWorld
	 * checks if the current location is the same as the destination, and adds locations to the 2D ArrayList, if true
	 * adds all direct destinations of the current location to a queue
	 * adds a location to the 2D ArrayList if not already in it
	 * repeats all steps until there are no more locations left to look through
	 */
	public void findAllPaths(Location current, Location dest, ArrayList<Location> branch) {
		if (current == dest) {
			ArrayList<Location> temp = new ArrayList<Location>();
			int v = 0;
			while (v < branch.size()) {
				temp.add(branch.get(v));
				++v;
			}
			this.paths.add(temp);
		}
		Queue<Location> next = this.locations.directDestinations(current);
		for (Location d: next) {
			if (branch.contains(d)) {
			}
			else {
				branch.add(d);
				findAllPaths(d, dest, branch);
				branch.remove(d);
			}
		}
		
	}
}