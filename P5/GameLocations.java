import java.util.*;
/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class GameLocations {
	/**
	 * fields:
	 * total: represents the number of locations in a level
	 * locName: represents a 2D list of distances between locations
	 * locations: represents an LinkedList of all locations
	 * visited: represents a list of visited locations
	 */
	private int total;
	private int[][] distance;
	private LinkedList<Location> locations;
	private boolean[] visited;
	/**
	 * @param total this is the number of locations in a level
	 */
	public GameLocations(int total) {
		this.total = total;
		this.locations = new LinkedList<Location>();
		this.distance = new int[total][total];
		this.visited = new boolean[total]; 
	}
	/**
	 * returns the LinkedList of locations in the object
	 */
	protected LinkedList<Location> getLocations() {
		return this.locations;
	}
	/**
	 * adds a location ot the location LinkedList
	 * finds the index of the new location
	 * sets the distance between the location and other locations to -1
	 */
	public void addLocation(Location location) {
		this.locations.add(location);
		int index = this.locations.indexOf(location);
		for (int i = 0; i < this.distance.length; ++i) {
			this.distance[i][index] = -1;
		}
		for (int i = 0; i < this.distance.length; ++i) {
			this.distance[index][i] = -1;
		}
	}
	/**
	 * adds a distance to the 2D distance array
	 * finds the index of the new location in the locations LinkedList
	 * sets the distance between the givens locations to the passed in integer
	 */
	public void addDistance(Location from, Location to, int dist) {
		int row = this.locations.indexOf(from);
		int col = this.locations.indexOf(to);
		this.distance[row][col] = dist;
	}
	/**
	 * finds the distance between two locations
	 * finds the index of the given locations in the locations LinkedList
	 * finds the distance between the givens locations with the indexes
	 */
	public int distanceIs(Location from, Location to) {
		int row = this.locations.indexOf(from);
		int col = this.locations.indexOf(to);
		return this.distance[row][col];
	}
	/**
	 * marks a location as visited/unvisited
	 */
	public void markAsVisited(Location location, boolean val) {
		int index = this.locations.indexOf(location);
		this.visited[index] = val;
	}
	/**
	 * finds whether a location is visited/unvisited
	 * returns true if visited/false if unvisited
	 */
	public boolean haveVisited(Location location) {
		int index = this.locations.indexOf(location);
		return this.visited[index];
	}
	/**
	 * finds all direct destinations from a given location
	 * determines if the distance between the given location and another is not -1 
	 * adds the location to a Queue if the distance is not -1
	 * returns the queue
	 */
	public Queue<Location> directDestinations(Location location) {
		Queue<Location> queue = new LinkedList<Location>();
		int index = this.locations.indexOf(location);
		for (int i = 0; i < this.distance.length; ++i) {
			if (this.distance[index][i] != -1) {
				queue.add(this.locations.get(i));
			}
		}
		return queue;
	}
}